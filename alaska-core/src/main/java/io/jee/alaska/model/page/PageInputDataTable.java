package io.jee.alaska.model.page;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

public class PageInputDataTable {

	private int start;
	private int length;

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

	public PageRequest toPageRequest(HttpServletRequest request){
		String order = request.getParameter("order[0][column]");//排序的列号
        String orderDir = request.getParameter("order[0][dir]");//排序的顺序asc or desc
        String orderColumn = request.getParameter("columns["+order+"][data]");//排序的列。注意，我认为页面上的列的名字要和表中列的名字一致，否则，会导致SQL拼接错误
		Direction direction = Direction.ASC;
		if(StringUtils.isNotBlank(orderDir) && orderDir.equalsIgnoreCase("desc")){
			direction = Direction.DESC;
		}
		if(StringUtils.isBlank(orderColumn)) {
			return PageRequest.of(start/length, length);
		}
		return PageRequest.of(start/length, length, direction, orderColumn);
	}

}
