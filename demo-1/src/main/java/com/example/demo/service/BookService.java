package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.criteria.Predicate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.dto.BookDTO;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;

	@Autowired 
	ModelMapper mapper;


	/*
	 * 
	 * Gets list of books and converts to DTOs using modelMapper. need to maintain same field name in dto  as in entity.
	 * 
	 */
	public List<BookDTO> getBookDetail(){


		return bookRepo.findAll().stream()
				.map(book -> mapper.map(book, BookDTO.class))
				.collect(Collectors.toList());
	}


	/*
	 * 
	 * 
	 * Gets bookPage from data JPA. Converts to DTO list and then makes it back to page of DTOs.
	 * 
	 * 
	 */
	public Page<BookDTO> getBookDetailsWithPaging(Pageable paging ) {

		Page<Book> bookPage = bookRepo.findAll(paging);
		List<BookDTO> bookList = bookPage.getContent()
				.stream().map( book -> mapper.map(book, BookDTO.class))
				.collect(Collectors.toList());

		return new PageImpl<>(bookList , bookPage.getPageable() , bookPage.getNumberOfElements());
	}


	/*
	 * 
	 * 
	 * Gets bookPage from data JPA. Converts to DTO list and then makes it back to page of DTOs.
	 * 
	 * 
	 */
	public Page<BookDTO> getBookDetailsWithPagingAndFiltering(Map<String,Object> filterData , Pageable paging){

		@SuppressWarnings("deprecation")
		Specification<Book> bookSpecification = (root, query, cb)-> {

			Predicate p = cb.conjunction();
			if(!StringUtils.isEmpty(filterData.get("bookName"))) {
				p = cb.and(p , cb.like(root.get("bookName"), "%"+ filterData.get("bookName") +"%"));
				// cb.and(p1, p2) -> SO predicate gets appended to the existing predicate.
			}
			if(!StringUtils.isEmpty(filterData.get("author"))) {
				p = cb.and(p , cb.like(root.get("author"), "%"+ filterData.get("author") +"%"));
			}

			return p;
		};
		Page<Book> bookPage =  bookRepo.findAll( bookSpecification, paging);
		List<BookDTO> bookList = bookPage.getContent()
				.stream().map( book -> mapper.map(book, BookDTO.class))
				.collect(Collectors.toList());
		return new PageImpl<>(bookList , bookPage.getPageable() , bookPage.getNumberOfElements());
	}

}
