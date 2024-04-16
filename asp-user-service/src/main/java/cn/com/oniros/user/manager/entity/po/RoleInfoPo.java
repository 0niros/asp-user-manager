package cn.com.oniros.user.manager.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * cn.com.oniros.user.manager.entity.po.RoleInfoPo
 *
 * @author Li Xiaoxu
 * 2024/4/14 17:20
 */
@Data
@TableName("role_info")
public class RoleInfoPo {

    @TableId
    private Long id;

    private String roleName;

}
