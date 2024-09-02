package com.entity.view;

import com.entity.DianyingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

@TableName("dianying")
public class DianyingView  extends DianyingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DianyingView(){
	}
 
 	public DianyingView(DianyingEntity dianyingEntity){
 	try {
			BeanUtils.copyProperties(this, dianyingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
