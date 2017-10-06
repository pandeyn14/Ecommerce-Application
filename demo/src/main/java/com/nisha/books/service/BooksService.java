package com.nisha.books.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nisha.books.model.entity.BooksEntity;

import com.nisha.books.dao.BooksDao;

@Service
@Transactional
public class BooksService {
	
	private final BooksDao BooksDaoRepository;

	public BooksService(BooksDao booksDaoRepository) {
		super();
		this.BooksDaoRepository = booksDaoRepository;
	}
	
	public ArrayList<BooksEntity> findAll(){
		ArrayList<BooksEntity> booksList = new ArrayList<BooksEntity>();
		
		for(BooksEntity books: BooksDaoRepository.findAll())
		{
			booksList.add(books);
		}
		return booksList;
	}
	
	public void save(BooksEntity booksentity){
		BooksDaoRepository.save(booksentity);
	}
	
	public BooksEntity findBook(int id){
		return BooksDaoRepository.findOne(id);
	}
	
	public void delete(int id){
		BooksDaoRepository.delete(id);
	}
	
	

}
