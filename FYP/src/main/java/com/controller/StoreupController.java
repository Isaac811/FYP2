package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.StoreupEntity;
import com.entity.view.StoreupView;

import com.service.StoreupService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

@RestController
@RequestMapping("/storeup")
public class StoreupController {
    @Autowired
    private StoreupService storeupService;

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,StoreupEntity storeup,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		storeup.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<StoreupEntity> ew = new EntityWrapper<StoreupEntity>();

		PageUtils page = storeupService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, storeup), params), params));

        return R.ok().put("data", page);
    }

	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,StoreupEntity storeup, 
		HttpServletRequest request){
        EntityWrapper<StoreupEntity> ew = new EntityWrapper<StoreupEntity>();

		PageUtils page = storeupService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, storeup), params), params));
        return R.ok().put("data", page);
    }

    @RequestMapping("/lists")
    public R list( StoreupEntity storeup){
       	EntityWrapper<StoreupEntity> ew = new EntityWrapper<StoreupEntity>();
      	ew.allEq(MPUtil.allEQMapPre( storeup, "storeup")); 
        return R.ok().put("data", storeupService.selectListView(ew));
    }

    @RequestMapping("/query")
    public R query(StoreupEntity storeup){
        EntityWrapper< StoreupEntity> ew = new EntityWrapper< StoreupEntity>();
 		ew.allEq(MPUtil.allEQMapPre( storeup, "storeup")); 
		StoreupView storeupView =  storeupService.selectView(ew);
		return R.ok("Success!").put("data", storeupView);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        StoreupEntity storeup = storeupService.selectById(id);
        return R.ok().put("data", storeup);
    }

	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        StoreupEntity storeup = storeupService.selectById(id);
        return R.ok().put("data", storeup);
    }

    @RequestMapping("/save")
    public R save(@RequestBody StoreupEntity storeup, HttpServletRequest request){
    	storeup.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(storeup);
    	storeup.setUserid((Long)request.getSession().getAttribute("userId"));
        storeupService.insert(storeup);
        return R.ok();
    }

    @RequestMapping("/add")
    public R add(@RequestBody StoreupEntity storeup, HttpServletRequest request){
    	storeup.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(storeup);
        storeupService.insert(storeup);
        return R.ok();
    }

    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody StoreupEntity storeup, HttpServletRequest request){
        //ValidatorUtils.validateEntity(storeup);
        storeupService.updateById(storeup);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        storeupService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
