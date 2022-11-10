package oblig.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
		try {
			List<Item> l = repo.getInstance().findAllItems();
			return new ResponseEntity<List<Item>>(l,HttpStatus.OK);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/items")
	public ResponseEntity<Item> addItem(@RequestBody Item item) {
		
		try {
			repo.getInstance().createItem(item);
			return ResponseEntity.ok(item);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@GetMapping("/items/{id}")
	public ResponseEntity<Item> getItem( @PathVariable("id") String id){
		
		try {
			Item item = repo.getInstance().findItem(id);
			return new ResponseEntity<>(item, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/item/{id}")
	public ResponseEntity<Item> updateItem( @PathVariable("id") String id, @RequestBody Item item){
		
		try {
			repo.getInstance().updateItem(id, item);
			return new ResponseEntity<>(item, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/item/{id}")
	public ResponseEntity<Item> deleteItem( @PathVariable("id") String id){
		try {
			repo.getInstance().deleteItem(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	

}
