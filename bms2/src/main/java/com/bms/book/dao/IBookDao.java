package com.bms.book.dao;

import java.util.List;

import com.bms.book.domain.Book;

public interface IBookDao {
	List<Book> findList();
}
