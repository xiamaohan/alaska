package io.jee.alaska.model.page;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class PageOutputLinked<T> extends PageImpl<T>{
	
	private static final long serialVersionUID = -7189009351423414059L;
	
	private int page;
	private Set<Integer> pageLinked = new LinkedHashSet<>();
	
	public PageOutputLinked(Page<T> page, Pageable pageable) {
		this(page, pageable, 0);
	}
	
	public PageOutputLinked(Page<T> page, Pageable pageable, int maxLinkedPage) {
		super(page.getContent(), pageable, page.getTotalElements());
		if(maxLinkedPage==0) {
			maxLinkedPage = 9;
		}
		this.page = super.getNumber() + 1;
		int firstLinkedPage = Math.max(1, this.page - (maxLinkedPage/2));
		for (int i = 0; i < maxLinkedPage; i++) {
			if(firstLinkedPage <= super.getTotalPages()){
				pageLinked.add(firstLinkedPage++);
			}
		}
	}

	public int getPage() {
		return page;
	}

	public Set<Integer> getPageLinked() {
		return pageLinked;
	}

}
