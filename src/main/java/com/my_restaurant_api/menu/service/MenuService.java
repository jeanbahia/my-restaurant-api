package com.my_restaurant_api.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.my_restaurant_api.menu.mapper.MenuMapper;
import com.my_restaurant_api.menu.record.MenuRecord;
import com.my_restaurant_api.menu.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;

	public MenuRecord findById(@PathVariable("id") Long id) {
		return MenuMapper.toRecord(menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu not found!")));
	}
	
	public List<MenuRecord> list() {
		return MenuMapper.toRecordList(menuRepository.findAll());
	}
	
	public MenuRecord save(MenuRecord menuRecord) { //TODO Fix mapping error and 'not found' error
		var menu = MenuMapper.toEntity(menuRecord);
		return MenuMapper.toRecord(menuRepository.save(menu));
	}
	
	public MenuRecord put(MenuRecord menuRecord) { //TODO Fix mapping error and 'not found' error
		var menu = MenuMapper.toEntity(menuRecord);
		return MenuMapper.toRecord(menuRepository.save(menu));
	}
	
	public void delete(@PathVariable("id") Long id) {
		var menu = menuRepository.findById(id);
		menuRepository.delete(menu.orElseThrow(() -> new RuntimeException("Menu not found!")));
	}
}
