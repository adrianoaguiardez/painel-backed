package br.com.simconsult.painel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

public class PageRequestModel {
	private int page;
	private int size;
	private String sort = "";

	

	public PageRequestModel() {
		super();
	}

	public PageRequestModel(int page, int size, String sort) {
		super();
		this.page = page;
		this.size = size;
		this.sort = sort;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public PageRequestModel(Map<String, String> params) {
		if (params.containsKey("page"))
			page = Integer.parseInt(params.get("page"));
		if (params.containsKey("size"))
			size = Integer.parseInt(params.get("size"));

		if (params.containsKey("sort"))
			sort = params.get("sort");
	}

	public PageRequest toSpringPageRequest() {
		List<Order> orders = new ArrayList<>();

		String[] properties = sort.split(",");
		for (String prop : properties) {
			String column = prop.trim();
			if (prop.trim().length() > 0) {

				column = column.replace("-", "").trim();
				orders.add(Order.desc(column));
			} else
				if(!column.isEmpty())
					orders.add(Order.asc(column));
		}

		return PageRequest.of(page, size, Sort.by(orders));
	}

}
