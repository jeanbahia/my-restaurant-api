package com.my_restaurant_api.menu.mapper;

import java.util.List;

import com.my_restaurant_api.menu.dto.CategoryDto;
import com.my_restaurant_api.menu.dto.MenuDto;
import com.my_restaurant_api.menu.dto.MenuItemDto;
import com.my_restaurant_api.menu.enums.TagEnum;
import com.my_restaurant_api.menu.model.Category;
import com.my_restaurant_api.menu.model.Menu;
import com.my_restaurant_api.menu.model.MenuItem;
import com.my_restaurant_api.menu.record.CategoryRecord;
import com.my_restaurant_api.menu.record.MenuItemRecord;
import com.my_restaurant_api.menu.record.MenuRecord;

public class MenuMapper {
	
	public static MenuRecord toRecord(Menu menu) {
		return new MenuRecord(menu.getName(),
							  menu.getDescription(),
							  categoryEntityToRecordList(menu));
	}
	
	public static List<MenuRecord> toRecordList(List<Menu> menuList) {
		return menuList.stream().map(menu -> toRecord(menu)).toList();
	}

	public static MenuDto toDto(MenuRecord menu) {
		return MenuDto.builder()
				      .name(menu.name())
				      .description(menu.description())
					  .categories(categoryRecordToDtoList(menu)).build();
	}
	
	public static List<MenuDto> toDtoList(List<MenuRecord> menuList) {
		return menuList.stream().map(menu -> toDto(menu)).toList();
	}
	
	private static List<CategoryRecord> categoryEntityToRecordList(Menu menu) {
		return menu.getCategories().stream()
								   .map(category -> new CategoryRecord(category.getName(), 
										category.getDescription(), 
										menuItemEntityToRecordList(category))).toList();
	}

	private static List<MenuItemRecord> menuItemEntityToRecordList(Category category) {
		return category.getItems().stream()
		               			  .map(item -> new MenuItemRecord(item.getName(), 
		               				   item.getDescription(),
			 						   item.getPrice(),
			 						   item.getIsAvailable(),
			 						   tagEntityToEnumList(item))).toList();
	}

	private static List<TagEnum> tagEntityToEnumList(MenuItem item) {
		return item.getTags().stream()
		 			         .map(tag -> TagEnum.findById(tag.getId()))
		 			         .toList();
	}

	private static List<CategoryDto> categoryRecordToDtoList(MenuRecord menu) {
		return menu.categories()
				   .stream()
				   .map(category -> CategoryDto.builder()
					 		 				   .name(category.name())
					 			 			   .description(category.description())
					 			 			   .items(ItemRecordToDtoList(category)).build()).toList();
	}

	private static List<MenuItemDto> ItemRecordToDtoList(CategoryRecord category) {
		return category.items()
				       .stream()
				       .map(item -> MenuItemDto.builder()
			        						   .name(item.name())
			        						   .description(item.description())
			        						   .price(item.price())
			        						   .isAvailable(item.isAvailable())
			        						   .tags(item.tags()).build()).toList();
	}
}
