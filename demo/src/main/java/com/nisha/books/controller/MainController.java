package com.nisha.books.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nisha.books.model.entity.BooksEntity;
import com.nisha.books.service.BooksService;

//using spring mvc here
@Controller
public class MainController {	
	
	@Autowired
	BooksService booksService;
	@GetMapping("/")
	public String home( HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");		
		return "index";
	}
	
	@GetMapping("/getBooks")
	public String allBooks( HttpServletRequest request){
		request.setAttribute("books", booksService.findAll());
		request.setAttribute("mode", "MODE_TASKS");		
		return "index";
	}
	
	@GetMapping("/insert")
	public String newBooks( HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");		
		return "index";
	}
	
	@PostMapping("/save")
	public String SaveBooks(@ModelAttribute BooksEntity booksentity,BindingResult bindingResult, HttpServletRequest request){
		booksentity.setDate_created(new Date());
		booksService.save(booksentity);
		request.setAttribute("books", booksService.findAll());
		request.setAttribute("mode", "MODE_TASKS");		
		return "index";
	}	
	
	@GetMapping("/update")
	public String UpdateBooks(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("books", booksService.findBook(id));
		request.setAttribute("mode", "MODE_UPDATE");		
		return "index";
	}
	
	@GetMapping("/delete")
	public String DeleteBooks(@RequestParam int id, HttpServletRequest request){
		booksService.delete(id);
		request.setAttribute("books", booksService.findAll());
		request.setAttribute("mode", "MODE_TASKS");		
		return "index";
	}


}
