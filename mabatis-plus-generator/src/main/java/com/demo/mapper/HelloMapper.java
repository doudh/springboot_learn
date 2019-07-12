package com.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.Hello;
import com.demo.entity.HelloDto;
import org.apache.ibatis.annotations.Param;

public interface HelloMapper extends BaseMapper<Hello> {
    IPage<HelloDto> selectList(Page page, @Param("hello") Hello hello);
}
