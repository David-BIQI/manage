package com.biqi.model;
/**   
 * Description: 用户表
 * @Package com.biqi.model 
 * @author  xiebq @date    2018年6月6日 下午10:52:00 
 */

import java.util.Date;
import lombok.Data;

@Data
public class User {
	
	
	private Integer id;

	private String name;

	private String passWord;

	private String Phone;

	private Integer sex;

	private Date created;

	private Integer createBy;

	private Date updated;

	private Integer updateBy;

}
