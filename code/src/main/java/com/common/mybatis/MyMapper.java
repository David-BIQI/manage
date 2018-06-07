package com.common.mybatis;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**   
 * Description: 实现增删改查的基本sql功能
 * @Package com.common.mybatis 
 * @author  xiebq @date    2018年6月7日 上午9:53:34 
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}
