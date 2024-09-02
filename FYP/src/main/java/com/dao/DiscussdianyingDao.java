package com.dao;

import com.entity.DiscussdianyingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussdianyingVO;
import com.entity.view.DiscussdianyingView;

public interface DiscussdianyingDao extends BaseMapper<DiscussdianyingEntity> {
	
	List<DiscussdianyingVO> selectListVO(@Param("ew") Wrapper<DiscussdianyingEntity> wrapper);
	
	DiscussdianyingVO selectVO(@Param("ew") Wrapper<DiscussdianyingEntity> wrapper);
	
	List<DiscussdianyingView> selectListView(@Param("ew") Wrapper<DiscussdianyingEntity> wrapper);

	List<DiscussdianyingView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussdianyingEntity> wrapper);
	
	DiscussdianyingView selectView(@Param("ew") Wrapper<DiscussdianyingEntity> wrapper);
	

}
