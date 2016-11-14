package com.dat.service.impl;

import com.dat.biz.ProductBiz;
import com.dat.service.ProductService;
import com.dat.vo.ProductListVO;
import com.dat.vo.ProductSearchVO;
import com.dat.vo.ProductVO;

public class ProductServiceImpl implements ProductService{

	private ProductBiz productBiz;
	
	public void setProductBiz(ProductBiz productBiz) {
		this.productBiz = productBiz;
	}
	
	@Override
	public ProductListVO getAllProduct(ProductSearchVO productSearchVO) {
		return productBiz.getAllProduct(productSearchVO);
	}
	
	@Override
	public boolean addNewProduct(ProductVO productVO) {
		return productBiz.addNewProduct(productVO);
	}
	
	@Override
	public ProductVO getProductById(String productId) {
		return productBiz.getProductById(productId);
	}
	
	@Override
	public boolean doModifyProduct(ProductVO productVO) {
		return productBiz.doModifyProduct(productVO);
	}
	
	@Override
	public boolean deleteProductById(String productId) {
		return productBiz.deleteProductById(productId);
	}
	
	@Override
	public ProductListVO getHighPriceProduct(ProductSearchVO productSearchVO) {
		return productBiz.getHighPriceProduct(productSearchVO);
	}
	
	@Override
	public ProductListVO getLowPriceProduct(ProductSearchVO productSearchVO) {
		return productBiz.getLowPriceProduct(productSearchVO);
	}
}
