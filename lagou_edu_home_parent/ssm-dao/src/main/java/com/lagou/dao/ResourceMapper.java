package com.lagou.dao;

import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVO;

import java.util.List;

public interface ResourceMapper {

    /*
        资源分类&多条件查询
     */
    public List<Resource> findAllResourceByPage(ResourceVO resourceVO);

}
