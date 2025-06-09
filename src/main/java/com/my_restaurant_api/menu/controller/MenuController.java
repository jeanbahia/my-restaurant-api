package com.my_restaurant_api.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my_restaurant_api.menu.dto.MenuDto;
import com.my_restaurant_api.menu.mapper.MenuMapper;
import com.my_restaurant_api.menu.service.MenuService;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public MenuDto findById(@PathVariable("id") Long id) {
		return MenuMapper.toDto(menuService.findById(id));
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MenuDto> list() {
		return MenuMapper.toDtoList(menuService.list());
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public MenuDto save(@RequestBody MenuDto dto) {
		return MenuMapper.toDto(menuService.save(MenuMapper.toRecord(dto)));
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public MenuDto put(@RequestBody MenuDto dto) {
		return MenuMapper.toDto(menuService.put(MenuMapper.toRecord(dto)));
	}
	
	@RequestMapping(path = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("id") Long id) {
		menuService.delete(id);
	}
}
