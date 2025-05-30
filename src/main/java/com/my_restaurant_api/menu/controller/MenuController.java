package com.my_restaurant_api.menu.controller;

import java.util.Arrays;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my_restaurant_api.menu.enums.TagEnum;
import com.my_restaurant_api.menu.record.CategoryRecord;
import com.my_restaurant_api.menu.record.MenuItemRecord;
import com.my_restaurant_api.menu.record.MenuRecord;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

	@RequestMapping(path = "/test", method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
    public MenuRecord getTestMenu() {
		
		var item = new MenuItemRecord("Menu 1", "Description", 1, true, Arrays.asList(TagEnum.CHEF_SPECIAL));
		var category = new CategoryRecord("First category item", "Category Description", Arrays.asList(item));
		var menu = new MenuRecord("My first menu", "Menu description", Arrays.asList(category));
        return menu;
    }
}
