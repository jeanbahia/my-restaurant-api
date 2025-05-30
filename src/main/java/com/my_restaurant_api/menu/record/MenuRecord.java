package com.my_restaurant_api.menu.record;

import java.util.List;

public record MenuRecord(String name, String description, List<CategoryRecord> categories) {
}
