package cn.com.oniros.user.manager.service.impl;

import cn.com.oniros.user.manager.api.dto.RoleInfoDto;
import cn.com.oniros.user.manager.api.provider.IRoleManagerApi;
import cn.com.oniros.user.manager.dao.IRoleInfoDao;
import cn.com.oniros.user.manager.entity.po.RoleInfoPo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * cn.com.oniros.user.manager.service.impl.RoleServiceImpl
 *
 * @author Li Xiaoxu
 * 2024/4/14 22:42
 */
@DubboService
public class RoleServiceImpl implements IRoleManagerApi {

    @Resource
    private IRoleInfoDao roleInfoDao;

    @Override
    public RoleInfoDto getDefaultUserRole() {
        QueryWrapper<RoleInfoPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", 1);
        RoleInfoPo roleInfoPo = roleInfoDao.selectOne(queryWrapper);

        return new RoleInfoDto(roleInfoPo.getId(), roleInfoPo.getRoleName());
    }

    @Override
    public RoleInfoDto getRole(Long id) {
        QueryWrapper<RoleInfoPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", id);
        RoleInfoPo roleInfoPo = roleInfoDao.selectOne(queryWrapper);

        return new RoleInfoDto(roleInfoPo.getId(), roleInfoPo.getRoleName());
    }
}
