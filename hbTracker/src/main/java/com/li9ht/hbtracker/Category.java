package com.li9ht.hbtracker;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

@Table(name = "Categories")
public class Category extends Model {

	@Column(name = "Name")
	public String name;
	
	public List<Item> items(){
		return getMany(Item.class, "Category");
	}
	
	public static Category getSingle(String Name) {
		return new Select()
				.from(Category.class)
				.where("Name = ? ", Name)
				.executeSingle();
	}

}
