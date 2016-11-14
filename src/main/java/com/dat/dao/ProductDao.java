package com.dat.dao;

import java.util.List;

import com.dat.vo.ProductSearchVO;
import com.dat.vo.ProductVO;

public interface ProductDao {

	public List<ProductVO> getAllProduct(ProductSearchVO productSearchVO);

	public int addNewProduct(ProductVO productVO);

	public ProductVO getProductById(String productId);

	public int doModifyProduct(ProductVO productVO);

	public int deleteProductById(String productId);

	public int getProductCount(ProductSearchVO productSearchVO);

	public List<ProductVO> getHighPriceProduct(ProductSearchVO productSearchVO);

	public List<ProductVO> getLowPriceProduct(ProductSearchVO productSearchVO);

}
