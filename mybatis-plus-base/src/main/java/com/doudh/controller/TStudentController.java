package com.doudh.controller;


import com.doudh.utils.IdWorker;
import com.doudh.utils.Result;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.doudh.service.TStudentService;
import com.doudh.model.entity.TStudent;


/**
 * @desc  前端控制器
 * @author doudh
 * @time 2019-07-11
 */
@Api(value="TStudentController",tags={"接口"})
@RestController
@RequestMapping("/tStudent")
public class TStudentController {

    private final Logger logger = LoggerFactory.getLogger(TStudentController.class);
    @Autowired
    private TStudentService tStudentService;

    @ApiOperation(value="分页信息")
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result page(Page<TStudent> page, @RequestBody TStudent entity) {
        QueryWrapper<TStudent> wrapper = new QueryWrapper<>();
        //wrapper.orderByDesc("create_date");
        tStudentService.page(page,wrapper);
        return Result.ok().put("page",page);
    }
    @ApiOperation(value="新增")
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody TStudent entity){
        entity.setId(new IdWorker(1).nextId());
        tStudentService.save(entity);
        return Result.ok();
    }
    @ApiOperation(value="修改")
    @RequestMapping(method = RequestMethod.PUT)
    public Result update(@RequestBody TStudent entity){
        tStudentService.updateById(entity);
        return Result.ok();
    }
    @ApiOperation(value="删除")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        tStudentService.removeById(id);
        return Result.ok();
    }

}

