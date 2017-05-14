package com.zhihu.mlw.dao;

import com.zhihu.mlw.entity.ZhUser;

import java.util.List;

/**
 * Created by pc on 17-5-13.
 */
public interface ZhUserDao {
    List<ZhUser> findByUserName(ZhUser zhUser) throws Exception;

    boolean saveUser(ZhUser zhUser);
}
