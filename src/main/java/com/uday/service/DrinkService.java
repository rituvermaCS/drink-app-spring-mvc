package com.uday.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uday.model.Drink;

@Service
public class DrinkService {
	
private static List<Drink> drinks = new ArrayList<Drink>();
	
	static {
		Drink d1 = new Drink(1, "Virgin Pina Colada", "Cold Beverage");
		Drink d2 = new Drink(2, "Cappi Nirvana", "Cold Beverage");
		Drink d3 = new Drink(3, "Ginger Tea", "Hot Beverage");
		Drink d4 = new Drink(4, "Cafe Latte", "Hot Beverage");
		drinks.add(d1);
		drinks.add(d2);
		drinks.add(d3);
		drinks.add(d4);
	}
	
	public List<Drink> displayDrink(){
		return drinks;
	}

	public List<Drink> addDrink(Drink drink) {
		drinks.add(drink);
		return drinks;
		
	}
	

	public Drink getDrinkId(int id) {
		 for (int i = 0; i <= (drinks.size()-1); i++) {
	            if (drinks.get(i).getId() == (id)) {
	                return drinks.get(i);
	            }
	        }
		 return null;
	}
	public Drink update(Drink drink) {
		 int idx = 0;
	        int id = 0;
	        for (int i = 0; i <= (drinks.size()-1); i++) {
	            if (drinks.get(i).getId() == (drink.getId())) {
	                id = drink.getId();
	                idx = i;
	                break;
	            }
	        }
	        Drink drink1 = new Drink();
	        drink1.setId(id);
	        drink1.setName(drink.getName());
	        drink1.setType(drink.getType());
	        drinks.set(idx, drink1);
	        return drink;
	}

	public String delete(int id) {
		for (int i = 0; i <= (drinks.size()-1); i++) {
            if (drinks.get(i).getId() == (id)) {
            	drinks.remove(i);
            }
	}
        return null;
}
}
