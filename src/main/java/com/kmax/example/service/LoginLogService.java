package com.kmax.example.service;

import com.kmax.example.common.DeleteIds;
import com.kmax.example.common.Page;
import com.kmax.example.error.AppError;
import com.kmax.example.error.AppException;
import com.kmax.example.mapper.LoginLogMapper;
import com.kmax.example.model.LoginLog;
import com.kmax.example.param.req.LoginLogQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * 登录日志
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:23
 */
@Service
public class LoginLogService {

    @Resource
    private LoginLogMapper loginLogMapper;

    public Page<LoginLog> search(LoginLogQuery query) {
        List<LoginLog> results = loginLogMapper.search(query);
        return new Page<>(results);
    }

    @Transactional(rollbackFor = Exception.class)
    public LoginLog add(LoginLog loginLog) {
        int result = loginLogMapper.insert(loginLog);
        if (result == 0) {
            throw new AppException(AppError.ADD_FAILED);
        }
        return loginLogMapper.selectById(loginLog.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    public LoginLog update(LoginLog loginLog) {
        int result = loginLogMapper.update(loginLog);
        if (result == 0) {
            throw new AppException(AppError.UPDATE_FAILED);
        }
        return loginLogMapper.selectById(loginLog.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(DeleteIds deleteIds) {
        int result = loginLogMapper.deleteById(deleteIds.getIds());
        if (result == 0) {
            throw new AppException(AppError.DELETE_FAILED);
        }
    }
}
