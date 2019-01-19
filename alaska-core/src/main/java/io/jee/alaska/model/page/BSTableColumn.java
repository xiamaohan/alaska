package io.jee.alaska.model.page;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BSTableColumn {

	private String field;
	private String title;
	private Integer rowspan, colspan;
	private Boolean visible, switchable, sortable;
	
	public BSTableColumn(String field, String title, Integer rowspan, Integer colspan) {
		this.field = field;
		this.title = title;
		this.rowspan = rowspan;
		this.colspan = colspan;
	}
	
	public BSTableColumn(String field, String title, Integer rowspan, Integer colspan, Boolean visible) {
		this.field = field;
		this.title = title;
		this.rowspan = rowspan;
		this.colspan = colspan;
		this.visible = visible;
	}
	
	public BSTableColumn(String field, String title, Boolean sortable) {
		this.field = field;
		this.title = title;
		this.sortable = sortable;
	}
	
	public BSTableColumn(String field, String title, Boolean visible, Boolean switchable) {
		this.field = field;
		this.title = title;
		this.visible = visible;
		this.switchable = switchable;
	}
	
	public BSTableColumn(String field, String title, Integer rowspan, Boolean visible) {
		this.field = field;
		this.title = title;
		this.rowspan = rowspan;
		this.visible = visible;
	}
	
	public BSTableColumn(String field, String title, Integer rowspan, Boolean visible, Boolean switchable) {
		this.field = field;
		this.title = title;
		this.rowspan = rowspan;
		this.visible = visible;
		this.switchable = switchable;
	}
	
	public BSTableColumn(String title, Integer colspan) {
		this.title = title;
		this.colspan = colspan;
	}
	
	public BSTableColumn(String field, String title, Boolean visible, Boolean switchable, Boolean sortable) {
		this.field = field;
		this.title = title;
		this.visible = visible;
		this.switchable = switchable;
		this.sortable = sortable;
	}
	
	public BSTableColumn(String field, String title, Boolean sortable, Integer rowspan) {
		this.field = field;
		this.title = title;
		this.sortable = sortable;
		this.rowspan = rowspan;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getRowspan() {
		return rowspan;
	}

	public void setRowspan(Integer rowspan) {
		this.rowspan = rowspan;
	}

	public Integer getColspan() {
		return colspan;
	}

	public void setColspan(Integer colspan) {
		this.colspan = colspan;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Boolean getSwitchable() {
		return switchable;
	}

	public void setSwitchable(Boolean switchable) {
		this.switchable = switchable;
	}

	public Boolean getSortable() {
		return sortable;
	}

	public void setSortable(Boolean sortable) {
		this.sortable = sortable;
	}

}
