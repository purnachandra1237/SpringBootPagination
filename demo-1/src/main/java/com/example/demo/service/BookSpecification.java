package com.example.demo.service;

import javax.persistence.criteria.*;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.model.Book;

public class BookSpecification implements Specification<Book> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SearchCriteria criteria;

   
	public BookSpecification(SearchCriteria searchCriteria) {
		this.criteria = searchCriteria;
		// TODO Auto-generated constructor stub
	}


	@Override
	public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		if (criteria.getOperation().equalsIgnoreCase(">")) {
            return builder.greaterThanOrEqualTo(
              root.<String> get(criteria.getKey()), criteria.getValue().toString());
        } 
        else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(
              root.<String> get(criteria.getKey()), criteria.getValue().toString());
        } 
        else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return builder.like(
                  root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
            } else {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }
        return null;
	}
    
   
}

 class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
	public SearchCriteria(String key, String operation, String value) {
		// TODO Auto-generated constructor stub
		this.key = key;
		this.operation = operation;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
}