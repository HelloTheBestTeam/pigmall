package com.pigmall.core.balance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * 随机算法
 * @author chrilwe
 *
 */
public class WeightRandomBalancer {
	
	/**
	 * key : ip
	 * value : weight
	 */
	private Map<String,Integer> map = new LinkedHashMap<>();
	/**
	 * 每个ip的范围区间[from,to)
	 * @return
	 */
	private List<Integer> list = new ArrayList<Integer>();
	/**
	 * 权重之和
	 */
	private int total = 0;
	
	
	public synchronized String getServer() {
		if(map.size() == 0) {
			throw new RuntimeException("为初始化服务器地址和权重");
		}
		
		Random r = new Random();
		int num = r.nextInt(total);
		
		//判断随机数落在哪个区间
		int index = 0;
		for (int i=0; i<list.size(); i++) {
			if(num <= list.get(i)) {
				index = i;
			}
		}
		
		int a = 0;
		String ip = "";
		for(Iterator i = map.entrySet().iterator();i.hasNext();) {
			String ipAdd = (String) i.next();
			if(a == index) {
				ip = ipAdd;
			}
			a++;
		}
		return ip;
	}
	
	private static class Singleton {
		private static WeightRandomBalancer wrb = null;
		static {
			wrb = new WeightRandomBalancer();
		}
		
		private static WeightRandomBalancer getInstance() {
			return wrb;
		}
	}
	
	public static WeightRandomBalancer getInstance() {
		return Singleton.getInstance();
	}
	
	public void init(Map<String,Integer> map1) {
		
	}
}
