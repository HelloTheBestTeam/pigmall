package com.pigmall.core.balance;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.pigmall.core.model.RoundWeight;

public class TestWeightRound {
	public static void main(String[] args) {
		
		/*WeightRoundBalancer instance = WeightRoundBalancer.getInstance();
		List<RoundWeight> roundWeightList = new ArrayList<>();
		RoundWeight e = new RoundWeight();
		e.setChangeWeight(0);
		e.setIp("A");
		e.setStaticWeight(1);
		roundWeightList.add(e);
		RoundWeight e1 = new RoundWeight();
		e1.setChangeWeight(0);
		e1.setIp("B");
		e1.setStaticWeight(1);
		roundWeightList.add(e1);
		RoundWeight e2 = new RoundWeight();
		e2.setChangeWeight(0);
		e2.setIp("C");
		e2.setStaticWeight(1);
		roundWeightList.add(e2);
		instance.init(roundWeightList);
		*/
		
		Map<String, Integer> map = new LinkedHashMap<String,Integer>();
		map.put("A", 5);
		map.put("B", 1);
		map.put("C", 1);
		WeightRandomBalancer instance = WeightRandomBalancer.getInstance();
		instance
		.init(map);
		for(int i=0; i<15; i++) {
			String server = instance.getServer();
			System.out.println(server);
		}
	}
}
