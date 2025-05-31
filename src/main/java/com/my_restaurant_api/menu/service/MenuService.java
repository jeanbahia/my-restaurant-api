package com.my_restaurant_api.menu.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.my_restaurant_api.menu.dto.CategoryDto;
import com.my_restaurant_api.menu.dto.MenuDto;
import com.my_restaurant_api.menu.dto.MenuItemDto;
import com.my_restaurant_api.menu.enums.TagEnum;

@Service
public class MenuService {

	public MenuDto findById(@PathVariable("id") Long id) {
		//TODO repository call...
		return getMockedMenu();
	}
	
	public List<MenuDto> list() {
		//TODO repository call...
		return Arrays.asList(getMockedMenu(), getMockedMenu(), getMockedMenu());
	}
	
	public MenuDto save(@RequestBody MenuDto dto) {
		//TODO repository call...
		return null;
	}
	
	public MenuDto put(@RequestBody MenuDto dto) {
		//TODO repository call...
		return null;
	}
	
	public void delete(@PathVariable("id") Long id) {
		//TODO repository call...
	}
	
	private MenuDto getMockedMenu() {
		
		var menuItem = MenuItemDto.builder().name("Grilled Ribeye Steak")
											.description("12 oz prime ribeye, flame-grilled and topped with rosemary garlic butter. Served with roasted baby potatoes and grilled asparagus.")
											.isAvailable(Boolean.TRUE)
											.price(60)
											.tags(Arrays.asList(TagEnum.CHEF_SPECIAL))
											.build();
		
		var category = CategoryDto.builder().name("Grilled Ribeye Steak")
						     				.description("A cut of beef taken from the rib section of a cow, specifically the \"eye of the rib,\" which is highly marbled with fat.")
				     						.items(Arrays.asList(menuItem))
			     							.build();
		
		var menu = MenuDto.builder().name("Dinner Menu")
						 			.description("Served with roasted baby potatoes and grilled asparagus.")
					 				.categories(Arrays.asList(category))
					 				.build();
		return menu;
	}

}
