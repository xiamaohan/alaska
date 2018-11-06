package io.jee.alaska.model.page;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class PageOutput<T> {
	
	private List<T> content;
	private long total;
	
	public PageOutput() {}

	public PageOutput(List<T> content, long total) {
		this.content = content;
		this.total = total;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
	public Page<T> toPage(Pageable pageable){
		return new PageImpl<>(content, pageable, total);
	}
}
