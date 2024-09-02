package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

@TableName("yonghujilu")
public class YonghujiluEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;


    private Long userid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getDianyingid() {
        return dianyingid;
    }

    public void setDianyingid(Long dianyingid) {
        this.dianyingid = dianyingid;
    }

    public int getJilu() {
        return jilu;
    }

    public void setJilu(int jilu) {
        this.jilu = jilu;
    }

    private Long dianyingid;
    private int jilu;



}
