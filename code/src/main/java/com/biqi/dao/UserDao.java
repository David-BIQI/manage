package com.biqi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.biqi.model.User;
import com.common.mybatis.MyMapper;

/**   
 * @Package com.biqi.dao 
 * @author  xiebq @date    2018年6月7日 上午9:55:30 
 */
@Mapper
public interface UserDao extends MyMapper<User> {
	
    /**
     * 测试数据库连接
     * @return
     */
    @Select("SELECT count(*) FROM User ")
    Integer countUser();


    /**
     * 使用xml统计用户数
     * @return
     */
    int countUser2();
    

}
