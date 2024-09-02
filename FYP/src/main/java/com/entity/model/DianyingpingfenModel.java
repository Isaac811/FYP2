package com.entity.model;

import com.entity.DianyingpingfenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

public class DianyingpingfenModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	private String dianyingmingcheng;

	private String dianyingfenlei;

	private String haibao;

	private String dianyingpingfen;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date pingfenriqi;

	private String pingfenneirong;

	private String yonghuzhanghao;

	private String yonghuxingming;

	public void setDianyingmingcheng(String dianyingmingcheng) {
		this.dianyingmingcheng = dianyingmingcheng;
	}

	public String getDianyingmingcheng() {
		return dianyingmingcheng;
	}

	public void setDianyingfenlei(String dianyingfenlei) {
		this.dianyingfenlei = dianyingfenlei;
	}

	public String getDianyingfenlei() {
		return dianyingfenlei;
	}

	 
	public void setHaibao(String haibao) {
		this.haibao = haibao;
	}

	public String getHaibao() {
		return haibao;
	}

	 
	public void setDianyingpingfen(String dianyingpingfen) {
		this.dianyingpingfen = dianyingpingfen;
	}

	public String getDianyingpingfen() {
		return dianyingpingfen;
	}

	 
	public void setPingfenriqi(Date pingfenriqi) {
		this.pingfenriqi = pingfenriqi;
	}

	public Date getPingfenriqi() {
		return pingfenriqi;
	}

	 
	public void setPingfenneirong(String pingfenneirong) {
		this.pingfenneirong = pingfenneirong;
	}

	public String getPingfenneirong() {
		return pingfenneirong;
	}

	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}

	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}

	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}

	public String getYonghuxingming() {
		return yonghuxingming;
	}
			
}
