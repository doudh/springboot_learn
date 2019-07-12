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

import com.doudh.service.TTeacherService;
import com.doudh.model.entity.TTeacher;


/**
 * @desc  前端控制器
 * @author doudh
 * @time 2019-07-11
 */
@Api(value="TTeacherController",tags={"接口"})
@RestController
@RequestMapping("/tTeacher")
public class TTeacherController {

    private final Logger logger = LoggerFactory.getLogger(TTeacherController.class);
    @Autowired
    private TTeacherService tTeacherService;

    @ApiOperation(value="分页信息")
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result page(Page<TTeacher> page, @RequestBody TTeacher entity) {
        QueryWrapper<TTeacher> wrapper = new QueryWrapper<>();
        //wrapper.orderByDesc("create_date");
        tTeacherService.page(page,wrapper);
        return Result.ok().put("page",page);
    }
    @ApiOperation(value="新增")
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody TTeacher entity){
        entity.setId(new IdWorker(1).nextId());
        tTeacherService.save(entity);
        return Result.ok();
    }
    @ApiOperation(value="修改")
    @RequestMapping(method = RequestMethod.PUT)
    public Result update(@RequestBody TTeacher entity){
        tTeacherService.updateById(entity);
        return Result.ok();
    }
    @ApiOperation(value="删除")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        tTeacherService.removeById(id);
        return Result.ok();
    }

}

