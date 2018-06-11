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

	private Integer total;
}
