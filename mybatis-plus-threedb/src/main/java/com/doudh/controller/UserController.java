package com.doudh.controller;


import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import com.doudh.common.utils.Result;
import com.doudh.common.utils.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.doudh.service.UserService;
import com.doudh.model.entity.User;


/**
 * @desc 用户 前端控制器
 * @author doudh
 * @time 2019-07-11
 */
@Api(value="UserController",tags={"用户接口"})
@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @ApiOperation(value="分页信息")
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result page(Page<User> page,@RequestBody User entity) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //wrapper.orderByDesc("create_date");
        userService.page(page,wrapper);
        return Result.ok().put("page",page);
    }
    @ApiOperation(value="新增")
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody User entity){
        entity.setId(new IdWorker(1).nextId());
        userService.save(entity);
        return Result.ok();
    }
    @ApiOperation(value="修改")
    @RequestMapping(method = RequestMethod.PUT)
    public Result update(@RequestBody User entity){
        userService.updateById(entity);
        return Result.ok();
    }
    @ApiOperation(value="删除")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        userService.removeById(id);
        return Result.ok();
    }

}

