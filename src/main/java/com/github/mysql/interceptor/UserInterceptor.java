package com.github.mysql.interceptor;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author 石少东
 * @date 2020-08-13 23:49
 * @since 1.0
 */


@Component
public class UserInterceptor extends EmptyInterceptor {

    private static final long serialVersionUID = -8754510349349646880L;

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        return super.onSave(entity, id, state, propertyNames, types);
    }
}
