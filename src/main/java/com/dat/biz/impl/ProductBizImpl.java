package com.dat.biz.impl;

import com.dat.biz.ProductBiz;
import com.dat.common.pager.Pager;
import com.dat.common.pager.PagerFactory;
import com.dat.dao.ProductDao;
import com.dat.vo.ProductListVO;
import com.dat.vo.ProductSearchVO;
import com.dat.vo.ProductVO;

public class ProductBizImpl implements ProductBiz{
	
	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	public ProductListVO getAllProduct(ProductSearchVO productSearchVO) {
		
		int count = productDao.getProductCount(productSearchVO);
		
		Pager pager = PagerFactory.getPager(Pager.ORACLE);
		pager.setPageNumber(productSearchVO.getPageNumber());
		pager.setTotalArticleCount(count);
		productSearchVO.setStartNumber(pager.getStartArticleNumber());
		productSearchVO.setEndNumber(pager.getEndArticleNumber());
		
		ProductListVO productList = new ProductListVO();
		productList.setProductList(productDao.getAllProduct(productSearchVO));
		productList.setPager(pager);
		
		return productList;
	}
	
	@Override
	public boolean addNewProduct(ProductVO productVO) {
		return productDao.addNewProduct(productVO) > 0;
	}
	
	@Override
	public ProductVO getProductById(String productId) {
		return productDao.getProductById(productId);
	}
	
	@Override
	public boolean doModifyProduct(ProductVO productVO) {
		return productDao.doModifyProduct(productVO) > 0;
	}

	@Override
	public boolean deleteProductById(String productId) {
		return productDao.deleteProductById(productId) > 0;
	}
	
	@Override
	public ProductListVO getHighPriceProduct(ProductSearchVO productSearchVO) {
		int count = productDao.getProductCount(productSearchVO);
		
		Pager pager = PagerFactory.getPager(Pager.ORACLE);
		pager.setPageNumber(productSearchVO.getPageNumber());
		pager.setTotalArticleCount(count);
		productSearchVO.setStartNumber(pager.getStartArticleNumber());
		productSearchVO.setEndNumber(pager.getEndArticleNumber());
		
		ProductListVO productList = new ProductListVO();
		productList.setProductList(productDao.getHighPriceProduct(productSearchVO));
		productList.setPager(pager);
		
		return productList;
	}
	
	@Override
	public ProductListVO getLowPriceProduct(ProductSearchVO productSearchVO) {
		int count = productDao.getProductCount(productSearchVO);
		
		Pager pager = PagerFactory.getPager(Pager.ORACLE);
		pager.setPageNumber(productSearchVO.getPageNumber());
		pager.setTotalArticleCount(count);
		productSearchVO.setStartNumber(pager.getStartArticleNumber());
		productSearchVO.setEndNumber(pager.getEndArticleNumber());
		
		ProductListVO productList = new ProductListVO();
		productList.setProductList(productDao.getLowPriceProduct(productSearchVO));
		productList.setPager(pager);
		
		return productList;
	}

}
