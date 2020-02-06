package com.pigmall.core.model;

import lombok.Data;
import lombok.ToString;

/**
 * 
 * @author chrilwe
 *
 */
@Data
@ToString
public class RoundWeight {
	//服务器地址
	private String ip;
	//静态权重
	private int staticWeight;
	//动态权重
	private long changeWeight;
}
