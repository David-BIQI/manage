package com.common.result;


import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageDto<T> {

	private List<T> data;

	private Integer total;
}
