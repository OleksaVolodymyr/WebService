package com.epam.lab;

import javax.jws.WebService;

@WebService(endpointInterface = "com.epam.lab.BookShealService")
public class BookShealServiceImp implements BookShealService {

	public String insertBook(Book book) {
		// TODO Auto-generated method stub
		return book.toString();
	}

	public Book getBook(String title) {
		// TODO Auto-generated method stub
		return new Book();
	}

}
