package com.my_restaurant_api.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.my_restaurant_api.menu.dto.MenuDto;
import com.my_restaurant_api.menu.mapper.MenuMapper;
import com.my_restaurant_api.menu.record.MenuRecord;
import com.my_restaurant_api.menu.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;

	public MenuRecord findById(@PathVariable("id") Long id) {
		return MenuMapper.toRecord(menuRepository.findById(id).orElse(null));
	}
	
	public List<MenuRecord> list() {
		return MenuMapper.toRecordList(menuRepository.findAll());
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
}
