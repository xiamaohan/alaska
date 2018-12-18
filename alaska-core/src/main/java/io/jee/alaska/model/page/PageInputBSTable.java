package io.jee.alaska.model.page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.StringUtils;

public class PageInputBSTable {

	private int offset = 0;
	private int limit = 10;
	private String sort;
	private String order;
	private String search;
	
	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public PageRequest toPageRequest(){
		if(StringUtils.hasText(order)&&StringUtils.hasText(sort)){
			Direction direction = Direction.fromString(order);
			return PageRequest.of(offset/limit, limit, direction, sort);
		}else{
			return PageRequest.of(offset/limit, limit);
		}
		
	}

}
