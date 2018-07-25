package com.biqi.dao;

import com.biqi.model.RoleToPermission;
import com.biqi.model.UserToRole;
import com.common.mybatis.MyMapper;
import org.apache.ibatis.annotations.Mapper;

/**   
 * @Package com.biqi.dao 
 * @author  xiebq @date
 */
@Mapper
public interface UserToRoleDao extends MyMapper<UserToRole> {
	
}
