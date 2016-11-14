package com.dat.vo;

import java.util.List;

import com.dat.common.pager.Pager;

public class ProductListVO {

	private List<ProductVO> productList;

	private Pager pager;

	public List<ProductVO> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductVO> productList) {
		this.productList = productList;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

}
