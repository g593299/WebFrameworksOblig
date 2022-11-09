package oblig.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import oblig.model.Item;
import oblig.repositories.ItemDAOMemorySingleton;

@RestController
public class ItemController {
	
	@Autowired
	ItemDAOMemorySingleton repo;
	
	
	@GetMapping("/items")
	public ResponseEntity<List<Item>> getAllItems(){
		//return repo.findAllItems();
		List<Item> l = repo.findAllItems();
		return new ResponseEntity<List<Item>>(l,HttpStatus.OK);
	}
	
	@PostMapping("/items")
	public ResponseEntity<Item> addItem(@RequestBody Item item) {
		
		try {
			repo.createItem(item);
			return ResponseEntity.ok(item);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@GetMapping("/items/{id}")
	public ResponseEntity<Item> getItem( @PathVariable("id") String id){
		Item item = repo.findItem(id);
		return new ResponseEntity<>(item, HttpStatus.OK);
		
	}
	
	@PutMapping("/item/{id}")
	public ResponseEntity<Item> updateItem( @PathVariable("id") String id, @RequestBody Item item){
		repo.updateItem(id, item);
		return new ResponseEntity<>(item, HttpStatus.OK);
	}
	
	

	

}
