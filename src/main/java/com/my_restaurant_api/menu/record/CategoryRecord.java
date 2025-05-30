package com.my_restaurant_api.menu.record;

import java.util.List;

public record CategoryRecord (String name, String description, List<MenuItemRecord> items) {
}
