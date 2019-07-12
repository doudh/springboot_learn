package com.doudh.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.doudh.common.annotation.DataSource;
import com.doudh.common.enums.DataSourceEnum;
import com.doudh.model.entity.User;
import com.doudh.mapper.UserMapper;
import com.doudh.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @desc 用户 服务实现类
 * @author doudh
 * @time 2019-07-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    @DataSource(DataSourceEnum.DB2)
    public User getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    @DataSource(DataSourceEnum.DB2)
    public Collection<User> listByMap(Map<String, Object> columnMap) {
        return super.listByMap(columnMap);
    }

    @Override
    @DataSource(DataSourceEnum.DB2)
    public User getOne(Wrapper<User> queryWrapper, boolean throwEx) {
        return super.getOne(queryWrapper,throwEx);
    }
    @Override
    @DataSource(DataSourceEnum.DB2)
    public Map<String, Object> getMap(Wrapper<User> queryWrapper) {
        return super.getMap(queryWrapper);
    }

    @Override
    @DataSource(DataSourceEnum.DB2)
    public int count(Wrapper<User> queryWrapper) {
        return super.count(queryWrapper);
    }

    @Override
    @DataSource(DataSourceEnum.DB2)
    public List<User> list(Wrapper<User> queryWrapper) {
        return super.list(queryWrapper);
    }

    @Override
    @DataSource(DataSourceEnum.DB2)
    public IPage<User> page(IPage<User> page, Wrapper<User> queryWrapper) {
        return super.page(page,queryWrapper);
    }

    @Override
    @DataSource(DataSourceEnum.DB2)
    public List<Map<String, Object>> listMaps(Wrapper<User> queryWrapper) {
        return super.listMaps(queryWrapper);
    }
    
    @Override
    @DataSource(DataSourceEnum.DB2)
    public IPage<Map<String, Object>> pageMaps(IPage<User> page, Wrapper<User> queryWrapper) {
        return super.pageMaps(page,queryWrapper);
    }
}

