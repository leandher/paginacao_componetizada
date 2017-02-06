package br.com.paginacao.entity;
import java.util.List;


public class Pageable {
	private List<Object> objects;
	private Integer currentPage;
	private Integer allRows;
	
	public List<Object> getObjects() {
		return objects;
	}
	
	public void setObjects(List<Object> objects) {
		this.objects = objects;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	public Integer getAllRows() {
		return allRows;
	}
	
	public void setAllRows(Integer allRows) {
		this.allRows = allRows;
	}
	
	
}
