package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


import com.core.DianYing;
import com.core.Recommend;
import com.core.UserRecord;
import com.entity.YonghujiluEntity;
import com.service.YonghujiluService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DianyingEntity;
import com.entity.view.DianyingView;

import com.service.DianyingService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

import java.util.stream.Collectors;

import com.service.StoreupService;

@RestController
@RequestMapping("/dianying")
public class DianyingController {
    @Autowired
    private DianyingService dianyingService;

    @Autowired
    private StoreupService storeupService;


    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DianyingEntity dianying,
		HttpServletRequest request){
        EntityWrapper<DianyingEntity> ew = new EntityWrapper<DianyingEntity>();

		PageUtils page = dianyingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianying), params), params));

        return R.ok().put("data", page);
    }

	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DianyingEntity dianying, 
		HttpServletRequest request){
        EntityWrapper<DianyingEntity> ew = new EntityWrapper<DianyingEntity>();

		PageUtils page = dianyingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianying), params), params));
        return R.ok().put("data", page);
    }

    @RequestMapping("/lists")
    public R list( DianyingEntity dianying){
       	EntityWrapper<DianyingEntity> ew = new EntityWrapper<DianyingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dianying, "dianying")); 
        return R.ok().put("data", dianyingService.selectListView(ew));
    }

    @RequestMapping("/query")
    public R query(DianyingEntity dianying){
        EntityWrapper< DianyingEntity> ew = new EntityWrapper< DianyingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dianying, "dianying")); 
		DianyingView dianyingView =  dianyingService.selectView(ew);
		return R.ok("查询电影成功").put("data", dianyingView);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DianyingEntity dianying = dianyingService.selectById(id);
		dianying.setClicknum(dianying.getClicknum()+1);
		dianying.setClicktime(new Date());
		dianyingService.updateById(dianying);
        return R.ok().put("data", dianying);
    }
    @Autowired
    YonghujiluService yonghujiluService;

	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        DianyingEntity dianying = dianyingService.selectById(id);
		dianying.setClicknum(dianying.getClicknum()+1);
		dianying.setClicktime(new Date());
		dianyingService.updateById(dianying);

        if (request.getSession().getAttribute("userId") != null) {
            String userId = request.getSession().getAttribute("userId").toString();

            Wrapper<YonghujiluEntity> wrapper = new EntityWrapper<YonghujiluEntity>();
            wrapper.eq("userid", userId);
            wrapper.eq("dianyingid", id);
            YonghujiluEntity yonghujilu = yonghujiluService.selectOne(wrapper);

            if (yonghujilu == null) {
                yonghujilu = new YonghujiluEntity();
                yonghujilu.setUserid(Long.parseLong(userId));
                yonghujilu.setDianyingid(id);
                yonghujilu.setJilu(1);
                yonghujiluService.insert(yonghujilu);
            } else {
                yonghujilu.setJilu(yonghujilu.getJilu() + 1);
                yonghujiluService.updateById(yonghujilu);
            }
        }


        return R.ok().put("data", dianying);
    }

    @RequestMapping("/save")
    public R save(@RequestBody DianyingEntity dianying, HttpServletRequest request){
    	dianying.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianying);
        dianyingService.insert(dianying);
        return R.ok();
    }

    @RequestMapping("/add")
    public R add(@RequestBody DianyingEntity dianying, HttpServletRequest request){
    	dianying.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianying);
        dianyingService.insert(dianying);
        return R.ok();
    }

    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DianyingEntity dianying, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dianying);
        dianyingService.updateById(dianying);//全部更新
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dianyingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DianyingEntity dianying, HttpServletRequest request,String pre){
        EntityWrapper<DianyingEntity> ew = new EntityWrapper<DianyingEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = dianyingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianying), params), params));
        return R.ok().put("data", page);
    }

    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,DianyingEntity dianying, HttpServletRequest request){

        String userId = request.getSession().getAttribute("userId").toString();
        YonghujiluEntity yonghujilu = yonghujiluService.selectOne(new EntityWrapper<YonghujiluEntity>().eq("userid", userId));
        if (yonghujilu == null) {
            EntityWrapper<DianyingEntity> ew = new EntityWrapper<>();
            PageUtils page = dianyingService.queryPage(params);
            return R.ok().put("data", page);
        }


        List<YonghujiluEntity> yonghujiluEntityList = yonghujiluService.selectList(new EntityWrapper<>());

        Map<Long, List<YonghujiluEntity>> usersByGender = yonghujiluEntityList.stream()
                .collect(Collectors.groupingBy(YonghujiluEntity::getUserid));

        List<UserRecord> users = new ArrayList<>();

        for (Map.Entry<Long, List<YonghujiluEntity>> entry : usersByGender.entrySet()) {
            Long entryKey = entry.getKey();
            List<YonghujiluEntity> usersInGroup = entry.getValue();

            UserRecord userRecord = new UserRecord(entryKey.toString());
            System.out.println("user: " + entryKey);
            for (YonghujiluEntity user : usersInGroup) {
                users.add(userRecord.set(user.getDianyingid().toString(), user.getJilu()));
            }
        }

        Recommend recommend = new Recommend();
        List<DianYing> recommendationCaiPins = recommend.recommend(userId, users);

        if (recommendationCaiPins == null || recommendationCaiPins.isEmpty()) {
            EntityWrapper<DianyingEntity> ew = new EntityWrapper<>();
            PageUtils page = dianyingService.queryPage(params);
            return R.ok().put("data", page);
        }
        EntityWrapper<DianyingEntity> ew = new EntityWrapper<>();
        ew.in("id", recommendationCaiPins.stream().map(DianYing::getMovieId).collect(Collectors.toList()));
        PageUtils page = dianyingService.queryPage(params, ew);
        return R.ok().put("data", page);

    }







}
