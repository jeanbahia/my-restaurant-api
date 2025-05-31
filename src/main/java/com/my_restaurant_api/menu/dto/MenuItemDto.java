package com.my_restaurant_api.menu.dto;

import java.util.List;

import com.my_restaurant_api.menu.enums.TagEnum;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MenuItemDto {

	private String name;

	private String description;

	private Integer price;

	private Boolean isAvailable;

	private List<TagEnum> tags;
}
