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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		List<Item> list = null;
		
		try {
			list = repo.getInstance().findAllItems();
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<List<Item>>(list,HttpStatus.OK);
		
	}
	
	@PostMapping("/items")
	public ResponseEntity<Item> addItem(@RequestBody Item item) {
		
		try {
			repo.getInstance().createItem(item);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(item);
		
	}
	
	@GetMapping("/items/{id}")
	public ResponseEntity<Item> getItem( @PathVariable("id") String id){
		Item item = null;
		
		try {
			item = repo.getInstance().findItem(id);
			if(item == null) {
				return new ResponseEntity<>(new Item(), HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>(new Item(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(item, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/items/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Item> updateItem( @PathVariable("id") String id, @RequestBody Item item){
		
		try {
			Item i = repo.getInstance().findItem(id);
			repo.getInstance().updateItem(i.getId(), item);
			
		} catch (Exception e) {			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(item, HttpStatus.OK);
	}
	
	@RequestMapping(value="/items/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteItem( @PathVariable("id") String id){
		
		try {
			Item i = repo.getInstance().findItem(id);
			repo.getInstance().deleteItem(i.getId());
			
			return ResponseEntity.noContent().build();
		} catch (Exception e) {			
			return ResponseEntity.notFound().build();
		}
		
	}

	

}
