package com.bms.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.book.dao.IBookDao;
import com.bms.book.domain.Book;
import com.bms.book.service.IBookService;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookDao dao;
	
	@Override
	public List<Book> findList() {
		return dao.findList();
	}

}
