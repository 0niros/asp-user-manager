package cn.com.oniros.user.manager.service.impl;

import cn.com.oniros.http.CustomException;
import cn.com.oniros.user.manager.api.dto.AddUserDto;
import cn.com.oniros.user.manager.api.dto.RoleInfoDto;
import cn.com.oniros.user.manager.api.dto.UserInfoDto;
import cn.com.oniros.user.manager.api.provider.IRoleManagerApi;
import cn.com.oniros.user.manager.api.provider.IUserManagerApi;
import cn.com.oniros.user.manager.constant.UserErrorCodes;
import cn.com.oniros.user.manager.dao.IUserInfoDao;
import cn.com.oniros.user.manager.entity.po.UserInfoPo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Collections;

/**
 * cn.com.oniros.user.manager.service.impl.UserServiceImpl
 *
 * @author Li Xiaoxu
 * 2024/4/14 17:31
 */
@Slf4j
@DubboService
public class UserServiceImpl implements IUserManagerApi {

    @Resource
    private IUserInfoDao userInfoDao;

    @Resource
    private IRoleManagerApi roleService;

    @Override
    public UserInfoDto getUserByUsername(String username) {
        QueryWrapper<UserInfoPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        UserInfoPo userInfoPo = userInfoDao.selectOne(queryWrapper);
        if (userInfoPo == null) {
            log.info("[DUBBO] Get user by username error: {}", UserErrorCodes.UNKNOWN_USER);
            return null;
        }

        RoleInfoDto role = roleService.getRole(userInfoPo.getRoleId());

        return new UserInfoDto(userInfoPo.getUsername(), userInfoPo.getPassword(),
                userInfoPo.getAvatarPath(), Collections.singletonList(role.getRoleName()));
    }

    @Override
    public void addUser(AddUserDto addUserDto) {
        // 0. Try to get user via username.
        QueryWrapper<UserInfoPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", addUserDto.getUserName());
        UserInfoPo userInfoPo = userInfoDao.selectOne(queryWrapper);

        // 1. Case exists, throw exception.
        if (userInfoPo == null) {
            throw new CustomException(UserErrorCodes.USER_EXISTS);
        }

        // 2. Add user.
        userInfoPo = new UserInfoPo();
        userInfoPo.setUsername(addUserDto.getUserName());
        userInfoPo.setPassword(addUserDto.getPassword());
        userInfoPo.setRoleId(roleService.getDefaultUserRole().getRoleId());

        // 3. Save to db.
        userInfoDao.insert(userInfoPo);
    }
}
