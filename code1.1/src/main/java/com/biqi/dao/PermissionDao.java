package com.biqi.dao;

import com.biqi.model.Permission;
import com.common.mybatis.MyMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Package com.biqi.dao
 * @author  xiebq @date
 */
@Mapper
public interface PermissionDao extends MyMapper<Permission> {

}
