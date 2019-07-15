package com.doudh.controller;


import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import com.doudh.utils.Result;
import com.doudh.utils.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.doudh.service.UserService;
import com.doudh.model.entity.User;

import java.util.Date;
import java.util.List;


/**
 * @desc  前端控制器
 * @author doudh
 * @time 2019-07-15
 */
@Api(value="UserController",tags={"接口"})
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
        entity.setCreateTime(new Date());
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

    @ApiOperation(value="列表")
    @RequestMapping(method = RequestMethod.GET)
    public Result list() {
        List<User> list = userService.list();
        return Result.ok().put("list",list);
    }

    @ApiOperation(value="单个对象")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result getById(@RequestParam String id) {
        List<User> list = userService.list();
        return Result.ok().put("list",list);
    }

}

