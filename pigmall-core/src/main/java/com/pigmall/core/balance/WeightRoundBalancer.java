package com.pigmall.core.balance;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.pigmall.core.model.RoundWeight;

/**
 * 权重加权平滑轮询算法
 * @author chrilwe
 *
 */
public class WeightRoundBalancer {
	
	private List<RoundWeight> roundWeightList;
	private int totalStaticWeight;
	
	private WeightRoundBalancer() {
		
	}
	
	private static class Singleton {
		private static WeightRoundBalancer wrb = null;
		static {
			wrb = new WeightRoundBalancer();
		}
		
		private static WeightRoundBalancer getInstance() {
			return wrb;
		}
	}
	
	public static WeightRoundBalancer getInstance() {
		return Singleton.getInstance();
	}
	
	public synchronized String getServer() {
		//判断是否已经完成初始化
		if(roundWeightList == null || roundWeightList.size() == 0) {
			throw new RuntimeException("roundWeightList不能为空");
		}
		
		for (RoundWeight roundWeight : roundWeightList) {
			long a = roundWeight.getChangeWeight();
			long b = roundWeight.getStaticWeight();
			roundWeight.setChangeWeight(a + b);
		}
		
		int maxIndex = 0;
		long max = 0;
		for(int i=0; i<roundWeightList.size(); i++) {
			long cw = roundWeightList.get(i).getChangeWeight();
			if(roundWeightList.get(i).getChangeWeight() > max) {
				max = cw;
				maxIndex = i;
			} 
		}
		
		long currentWeight = roundWeightList.get(maxIndex).getChangeWeight() - totalStaticWeight;
		roundWeightList.get(maxIndex).setChangeWeight(currentWeight);
		
		return roundWeightList.get(maxIndex).getIp();
	}
	
	public void init(List<RoundWeight> roundWeightList) {
		if(roundWeightList == null || roundWeightList.size() <= 0) {
			throw new RuntimeException("roundWeightList不能为空");
		}
		for (RoundWeight roundWeight : roundWeightList) {
			String ip = roundWeight.getIp();
			if(StringUtils.isEmpty(ip)) {
				throw new RuntimeException("服务器ip不能为空");
			}
		}
		
		this.roundWeightList = roundWeightList;
		
		int total = 0;
		for (RoundWeight roundWeight : roundWeightList) {
			int staticWeight = roundWeight.getStaticWeight();
			total += staticWeight;
		}
		this.totalStaticWeight = total;
	}
}
