package com.liudao51.test.pojo.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("mp_user")
public class User {
    // 对应数据库中的主键 (uuid、自增id、雪花算法、redis、zookeeper！)
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    // 字段添加填充内容
    @TableField(fill = FieldFill.INSERT)
    private Long createdTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updatedTime;

    @TableLogic //逻辑删除
    private Integer deleted;

    @Version //乐观锁version注解
    private Integer version;
}
