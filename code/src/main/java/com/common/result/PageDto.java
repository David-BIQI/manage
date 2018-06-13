package com.common.result;


import lombok.*;

import java.util.List;

/**
 * @author xiebq
 *
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageDto<T> {

	private List<T> data;

	/**
	 * 总数类型有Integer和Long，接口的拓展性，使用Object作为接受对象
	 */
	private Object total;
}
