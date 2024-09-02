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

@TableName("dianying")
public class DianyingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DianyingEntity() {
		
	}
	
	public DianyingEntity(T t) {
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

	private String daoyan;

	private String bianju;

	private String shizhang;

	private String shipin;

	private String zhuyan;

	private String zhipiandiqu;

	private String dianyingxiangqing;

	private Integer zonghepingfen;

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;

	private Integer clicknum;
	
	
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

	public void setDaoyan(String daoyan) {
		this.daoyan = daoyan;
	}

	public String getDaoyan() {
		return daoyan;
	}

	public void setBianju(String bianju) {
		this.bianju = bianju;
	}

	public String getBianju() {
		return bianju;
	}

	public void setShizhang(String shizhang) {
		this.shizhang = shizhang;
	}

	public String getShizhang() {
		return shizhang;
	}

	public void setShipin(String shipin) {
		this.shipin = shipin;
	}

	public String getShipin() {
		return shipin;
	}

	public void setZhuyan(String zhuyan) {
		this.zhuyan = zhuyan;
	}

	public String getZhuyan() {
		return zhuyan;
	}

	public void setZhipiandiqu(String zhipiandiqu) {
		this.zhipiandiqu = zhipiandiqu;
	}

	public String getZhipiandiqu() {
		return zhipiandiqu;
	}

	public void setDianyingxiangqing(String dianyingxiangqing) {
		this.dianyingxiangqing = dianyingxiangqing;
	}

	public String getDianyingxiangqing() {
		return dianyingxiangqing;
	}

	public void setZonghepingfen(Integer zonghepingfen) {
		this.zonghepingfen = zonghepingfen;
	}

	public Integer getZonghepingfen() {
		return zonghepingfen;
	}

	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}

	public Date getClicktime() {
		return clicktime;
	}

	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}

	public Integer getClicknum() {
		return clicknum;
	}

}
