package com.biqi.dao;

import com.biqi.model.Role;
import com.biqi.model.RoleToPermission;
import com.common.mybatis.MyMapper;
import org.apache.ibatis.annotations.Mapper;

/**   
 * @Package com.biqi.dao 
 * @author  xiebq @date
 */
@Mapper
public interface RoleToPermissionDao extends MyMapper<RoleToPermission> {
	

}
