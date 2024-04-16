package cn.com.oniros.user.manager.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cn.com.oniros.user.manager.api.dto.RoleInfoDto
 *
 * @author Li Xiaoxu
 * 2024/4/14 22:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleInfoDto {

    private Long roleId;

    private String roleName;

}
