package cn.com.oniros.user.manager.api.provider;

import cn.com.oniros.user.manager.api.dto.AddUserDto;
import cn.com.oniros.user.manager.api.dto.UserInfoDto;

/**
 * cn.com.oniros.user.manager.api.provider.UserService
 *
 * @author Li Xiaoxu
 * 2024/4/14 17:16
 */
public interface IUserManagerApi {

    UserInfoDto getUserByUsername(String username);

    void addUser(AddUserDto addUserDto);

}
