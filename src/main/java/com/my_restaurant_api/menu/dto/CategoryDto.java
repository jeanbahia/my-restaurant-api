package com.my_restaurant_api.menu.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoryDto {

	private String name;

	private String description;

	private List<MenuItemDto> items;
}
