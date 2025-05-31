package com.my_restaurant_api.menu.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MenuDto {

	private String name;

	private String description;

	private List<CategoryDto> categories;
}
