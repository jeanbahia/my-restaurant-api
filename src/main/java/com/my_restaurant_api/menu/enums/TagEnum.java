package com.my_restaurant_api.menu.enums;

public enum TagEnum {

	VEGAN(1L, "Vegan", "No animal products"),
	SPICY(2L, "Spicy", "Hot and spicy"),
	GLUTEN_FREE(3L, "Gluten-Free", "No gluten"),
	KIDS(4L, "Kids", "Suitable for children"),
	SPECIAL(5L, "Special", "Chefs special");

	private Long id;
	private String name;
	private String description;

	private TagEnum(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public static TagEnum findById(Long id) {
		for (TagEnum tagEnum : values()) {
			if(id.equals(tagEnum.id)){
				return tagEnum;
			}
		}
		throw new RuntimeException("Tag not found");
	}
}
