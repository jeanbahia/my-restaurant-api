package com.my_restaurant_api.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_restaurant_api.menu.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{

}
