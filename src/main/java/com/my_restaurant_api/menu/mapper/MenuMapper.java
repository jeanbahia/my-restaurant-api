package com.my_restaurant_api.menu.mapper;

import java.util.List;

import com.my_restaurant_api.menu.dto.CategoryDto;
import com.my_restaurant_api.menu.dto.MenuDto;
import com.my_restaurant_api.menu.dto.MenuItemDto;
import com.my_restaurant_api.menu.enums.TagEnum;
import com.my_restaurant_api.menu.model.Category;
import com.my_restaurant_api.menu.model.Menu;
import com.my_restaurant_api.menu.model.MenuItem;
import com.my_restaurant_api.menu.model.Tag;
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
	

	public static Menu toEntity(MenuRecord menuRecord) {
		Menu menu = new Menu();
		menu.setName(menuRecord.name());
		menu.setDescription(menuRecord.description());
		menu.setCategories(categoryRecordToEntityList(menuRecord, menu));
		return menu;
	}
	
	public static MenuRecord toRecord(MenuDto menuDto) {
		return new MenuRecord(
			menuDto.getName(),
			menuDto.getDescription(),
			categoryDtoToRecordList(menuDto.getCategories())
		);
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
	
	private static List<Category> categoryRecordToEntityList(MenuRecord menuRecord, Menu parentMenu) {
		return menuRecord.categories().stream().map(categoryRecord -> {
			Category category = new Category();
			category.setName(categoryRecord.name());
			category.setDescription(categoryRecord.description());
			category.setItems(menuItemRecordToEntityList(categoryRecord, category));
			return category;
		}).toList();
	}

	private static List<MenuItem> menuItemRecordToEntityList(CategoryRecord categoryRecord, Category parentCategory) {
		return categoryRecord.items().stream().map(itemRecord -> {
			MenuItem item = new MenuItem();
			item.setName(itemRecord.name());
			item.setDescription(itemRecord.description());
			item.setPrice(itemRecord.price());
			item.setIsAvailable(itemRecord.isAvailable());
			item.setCategory(parentCategory);
			item.setTags(tagEnumListToEntity(itemRecord.tags()));
			return item;
		}).toList();
	}

	private static List<Tag> tagEnumListToEntity(List<TagEnum> tagEnums) {
		return tagEnums.stream()
		               .map(tagEnum -> {
						   Tag tag = new Tag();
						   tag.setId(tagEnum.getId());
						   return tag;
					   }).toList();
	}
	
	private static List<CategoryRecord> categoryDtoToRecordList(List<CategoryDto> categories) {
		return categories.stream().map(categoryDto ->
			new CategoryRecord(
				categoryDto.getName(),
				categoryDto.getDescription(),
				menuItemDtoToRecordList(categoryDto.getItems())
			)
		).toList();
	}
	
	private static List<MenuItemRecord> menuItemDtoToRecordList(List<MenuItemDto> items) {
		return items.stream().map(itemDto ->
			new MenuItemRecord(
				itemDto.getName(),
				itemDto.getDescription(),
				itemDto.getPrice(),
				itemDto.getIsAvailable(),
				itemDto.getTags()
			)
		).toList();
	}
}
