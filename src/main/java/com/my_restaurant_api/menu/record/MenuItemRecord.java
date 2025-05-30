package com.my_restaurant_api.menu.record;

import java.util.List;

import com.my_restaurant_api.menu.enums.TagEnum;

public record MenuItemRecord(String name, String description, Integer price, Boolean isAvailable, List<TagEnum> tags) {
}
