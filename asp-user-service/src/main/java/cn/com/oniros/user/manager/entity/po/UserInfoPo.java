package cn.com.oniros.user.manager.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * cn.com.oniros.user.manager.entity.po.UserInfoPo
 *
 * @author Li Xiaoxu
 * 2024/4/14 17:19
 */
@Data
@TableName("user_info")
@Accessors(chain = true)
public class UserInfoPo {

    @TableId
    private Long id;

    private String username;

    private String password;

    private Long roleId;

    private String avatarPath;

}
