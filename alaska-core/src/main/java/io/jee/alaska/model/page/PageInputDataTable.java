package io.jee.alaska.model.page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

public class PageInputDataTable {

	private int start;
	private int length;
	private String storeName;
	private String storeType;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	
	public PageRequest toPageRequest(){
		Direction direction = Direction.ASC;
		if(storeType.equalsIgnoreCase("desc")){
			direction = Direction.DESC;
		}
		return PageRequest.of(start/length, length, direction, storeName);
	}

}
