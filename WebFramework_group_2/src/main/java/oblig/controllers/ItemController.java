package oblig.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import oblig.model.Item;
import oblig.repositories.ItemDAOMemorySingleton;

@RestController
public class ItemController {
	
	@Autowired
	ItemDAOMemorySingleton repo;
	
	@GetMapping("/items")
	private List<Item> getAllItems(){
		return repo.findAllItems();	
	}
	

	

}
