package com.github.mysql.pojo.converter;

import com.github.mysql.pojo.orm.RoleInfoDO;
import com.github.mysql.pojo.vo.RoleInfoVO;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * <p>
 * 创建时间为 下午11:27 2020/5/21
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public class RoleConverter implements Converter<RoleInfoDO, RoleInfoVO> {

    @Override
    public RoleInfoVO convert(@NotNull RoleInfoDO source) {
        RoleInfoVO vo = new RoleInfoVO();
        BeanUtils.copyProperties(source, vo);
        return vo;
    }
}
