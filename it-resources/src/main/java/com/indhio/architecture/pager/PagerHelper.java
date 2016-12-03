package com.indhio.architecture.pager;

import java.util.List;

import javax.persistence.Query;

/**
 * @author Vinicius Nascimento
 *
 */
public class PagerHelper {

	private Long page;
	private Long count;

	public PagerHelper(Long page, Long count) {
		this.page = page;
		this.count = count;
	}

	public Long maxResults() {
		return count;
	}

	public Long firstResult() {
		return (page - 1) * count;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Pager query(Query query, Query totalQuery) {
		List<?> list = query.setMaxResults(maxResults().intValue()).setFirstResult(firstResult().intValue()).getResultList();
		Long total = ((Number) totalQuery.getSingleResult()).longValue();

		Pager ret = new Pager();
		ret.setPage(page);
		ret.setList(list);
		ret.setCount(count);
		ret.setTotal(total);

		return ret;
	}
}