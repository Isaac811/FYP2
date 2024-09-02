package com.entity.view;

import com.entity.DiscussdianyingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

@TableName("discussdianying")
public class DiscussdianyingView  extends DiscussdianyingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussdianyingView(){
	}
 
 	public DiscussdianyingView(DiscussdianyingEntity discussdianyingEntity){
 	try {
			BeanUtils.copyProperties(this, discussdianyingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
