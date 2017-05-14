package com.zhihu.mlw.dao;

import com.zhihu.mlw.entity.ZhProblem;

/**
 * Created by pc on 17-5-13.
 */
public interface ZhProblemDao {
    /**
     * 保存提交的问题信息
     */
    void saveProblem_add(ZhProblem zhProblem);
}
