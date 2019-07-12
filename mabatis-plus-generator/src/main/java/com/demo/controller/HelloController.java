package com.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.Hello;
import com.demo.entity.HelloDto;
import com.demo.mapper.HelloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 多表查询+分页+条件查询 demo
 */
public class HelloController {
    @Autowired
    private HelloMapper helloMapper;
    
    public IPage<HelloDto> test(Page page, @RequestBody Hello hello){
        IPage<HelloDto> list = helloMapper.selectList(page, hello);
        return list;
    }
}
