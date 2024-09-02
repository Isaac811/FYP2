package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("dianyingpingfen")
public class DianyingpingfenEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DianyingpingfenEntity() {
		
	}
	
	public DianyingpingfenEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@TableId
	private Long id;

	private String dianyingbianhao;

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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDianyingbianhao(String dianyingbianhao) {
		this.dianyingbianhao = dianyingbianhao;
	}

	public String getDianyingbianhao() {
		return dianyingbianhao;
	}

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
