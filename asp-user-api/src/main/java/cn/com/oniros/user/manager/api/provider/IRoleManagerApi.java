package cn.com.oniros.user.manager.api.provider;

import cn.com.oniros.user.manager.api.dto.RoleInfoDto;

/**
 * cn.com.oniros.user.manager.api.provider.IRoleManagerApi
 *
 * @author Li Xiaoxu
 * 2024/4/14 22:40
 */
public interface IRoleManagerApi {

    RoleInfoDto getDefaultUserRole();

    RoleInfoDto getRole(Long id);

}
