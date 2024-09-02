package com.entity.model;

import com.entity.YonghuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

public class YonghuModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	private String mima;

	private String yonghuxingming;

	private String xingbie;

	private String nianling;

	private String touxiang;

	private String yonghushouji;

	public void setMima(String mima) {
		this.mima = mima;
	}

	public String getMima() {
		return mima;
	}

	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}

	public String getYonghuxingming() {
		return yonghuxingming;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}

	public String getXingbie() {
		return xingbie;
	}

	public void setNianling(String nianling) {
		this.nianling = nianling;
	}

	public String getNianling() {
		return nianling;
	}

	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}

	public String getTouxiang() {
		return touxiang;
	}

	public void setYonghushouji(String yonghushouji) {
		this.yonghushouji = yonghushouji;
	}

	public String getYonghushouji() {
		return yonghushouji;
	}
			
}
