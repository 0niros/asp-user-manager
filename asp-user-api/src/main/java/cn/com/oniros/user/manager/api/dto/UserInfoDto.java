package cn.com.oniros.user.manager.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * cn.com.oniros.user.manager.api.dto.UserInfoDto
 *
 * @author Li Xiaoxu
 * 2024/4/14 17:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {

    private String username;

    private String password;

    private String avatarPath;

    private List<String> authorities;

}
