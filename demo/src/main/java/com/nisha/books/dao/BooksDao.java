package com.nisha.books.dao;
import org.springframework.data.repository.CrudRepository;

import com.nisha.books.model.entity.BooksEntity;

//spring data doesn't require impl for this interface
public interface BooksDao extends CrudRepository<BooksEntity, Integer>{

}
