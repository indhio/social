package com.indhio.architecture.pager;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vinicius Nascimento
 *
 * @param <T>
 */
@XmlRootElement
public class Pager<T> {

	private Long page;
	private Long count;
	private Long total;
	private String filter;
	private List<T> list;

	public Pager() {
	}

	public Pager(Long page, Long count, Long total) {
		this.setPage(page);
		this.setCount(count);
		this.setTotal(total);
	}

	public Long getPage() {
		if (page == null) {
			setPage(1L);
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<T> getList() {
		if (list == null) {
			list = new ArrayList<T>();
		}
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

}