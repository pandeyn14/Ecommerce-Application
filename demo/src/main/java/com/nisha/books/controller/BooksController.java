package com.nisha.books.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nisha.books.model.entity.BooksEntity;
import com.nisha.books.service.BooksService;

@RestController
public class BooksController {
	
	@Autowired
	private BooksService bookService;

/*	@GetMapping("/getBooks")
	public String allBooks(){
		System.out.println(bookService.findAll().toString());
		return bookService.findAll().toString();
	}
	
	@PostMapping("/insert")
	@PutMapping("/save")
	@GetMapping("/save")
	public String saveBooks(@RequestParam String name, @RequestParam String description){
		
		BooksEntity booksEntity = new BooksEntity(name, description, new Date(), false);
		bookService.save(booksEntity);  
		return "saved";
	}
	
	@GetMapping("/delete")
	public String saveBooks(@RequestParam int id){

		bookService.delete(id);  
		return "deleted";
	}*/

}
