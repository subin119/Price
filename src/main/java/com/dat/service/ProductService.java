package com.dat.service;

import com.dat.vo.ProductListVO;
import com.dat.vo.ProductSearchVO;
import com.dat.vo.ProductVO;

public interface ProductService {

	public ProductListVO getAllProduct(ProductSearchVO productSearchVO);

	public boolean addNewProduct(ProductVO productVO);

	public ProductVO getProductById(String productId);

	public boolean doModifyProduct(ProductVO productVO);

	public boolean deleteProductById(String productId);

	public ProductListVO getHighPriceProduct(ProductSearchVO productSearchVO);

	public ProductListVO getLowPriceProduct(ProductSearchVO productSearchVO);
}
