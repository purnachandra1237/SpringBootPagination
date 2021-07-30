package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookDTO;
import com.example.demo.service.BookService;

@RestController
//@RequestMapping (value = "/books")
public class BookController {

	@Autowired
	private BookService bookService;


	/*
	 * 
	 * Simple Get Books from H2 database book table. Find schema.sql in source code.
	 * 
	 */
	@GetMapping( value = "/books")
	public List<BookDTO> getBooksDetails(){
		return bookService.getBookDetail();
	}
	
	
	
	/*
	 * 
	 * 
	 * Get Books with Paging and sorting. Paging - page num & size , Sorting - sortBy and direction , all are defaulted.
	 * 
	 * 
	 */

	@GetMapping(value = "/booksWithPaging")
	public Page<BookDTO> getBookDetailsWithPagingAndSorting( @RequestParam final Optional <Integer> size,
			@RequestParam final Optional <Integer> page , 
			@RequestParam (defaultValue = "bookName") final String sortBy,
			@RequestParam (defaultValue = "ASC") final Sort.Direction direction
			) {


		final Sort sorting = Sort.by(new Sort.Order(direction, sortBy));
		Pageable paging = PageRequest.of(page.orElse(0), size.orElse(100), sorting);
		return bookService.getBookDetailsWithPaging(paging );

	}
	
	
	/*
	 * 
	 * 
	 * Get List of books with Paging/Sorting/Filtering
	 * 
	 * 
	 */
	@PostMapping(value = "/bookDetailsWithPageSortAndFilter")
	public Page<BookDTO> getBooksWithPagingSortingAndFiltering( 
			@RequestBody @Nullable final Map<String, Object> filterCriteria,
			@PageableDefault ( page = 0 , size = 100)  
			@SortDefault.SortDefaults({
				@SortDefault(sort = "bookName", direction = Sort.Direction.ASC),
				@SortDefault(sort = "author", direction = Sort.Direction.ASC)}) Pageable pageable
			
			){
		
		
		return bookService.getBookDetailsWithPagingAndFiltering( filterCriteria , pageable );
	}
	


}
