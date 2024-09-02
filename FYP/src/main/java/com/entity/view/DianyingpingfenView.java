package com.entity.view;

import com.entity.DianyingpingfenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

@TableName("dianyingpingfen")
public class DianyingpingfenView  extends DianyingpingfenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DianyingpingfenView(){
	}
 
 	public DianyingpingfenView(DianyingpingfenEntity dianyingpingfenEntity){
 	try {
			BeanUtils.copyProperties(this, dianyingpingfenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
