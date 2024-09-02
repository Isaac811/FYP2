package com.entity.view;

import com.entity.AboutusEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

@TableName("aboutus")
public class AboutusView  extends AboutusEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public AboutusView(){
	}
 
 	public AboutusView(AboutusEntity aboutusEntity){
 	try {
			BeanUtils.copyProperties(this, aboutusEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
