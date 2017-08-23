package com.epam.lab;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface BookShealService {
	@WebMethod
	public String insertBook(Book book);
	@WebMethod
	public Book getBook(String title);
}
