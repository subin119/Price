package com.dat.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.dat.dao.ProductDao;
import com.dat.vo.ProductSearchVO;
import com.dat.vo.ProductVO;

public class ProductDaoImpl extends SqlSessionDaoSupport implements ProductDao{

	@Override
	public List<ProductVO> getAllProduct(ProductSearchVO productSearchVO) {
		return getSqlSession().selectList("productDao.getAllProduct", productSearchVO);
	}
	
	@Override
	public int addNewProduct(ProductVO productVO) {
		return getSqlSession().insert("productDao.addNewProduct", productVO);
	}
	
	@Override
	public ProductVO getProductById(String productId) {
		return getSqlSession().selectOne("productDao.getProductById", productId);
	}
	
	@Override
	public int doModifyProduct(ProductVO productVO) {
		return getSqlSession().update("productDao.doModifyProduct", productVO);
	}

	@Override
	public int deleteProductById(String productId) {
		return getSqlSession().delete("productDao.deleteProductById", productId);
	}
	
	@Override
	public int getProductCount(ProductSearchVO productSearchVO) {
		return getSqlSession().selectOne("productDao.getProductCount", productSearchVO);
	}
	
	@Override
	public List<ProductVO> getHighPriceProduct(ProductSearchVO productSearchVO) {
		return getSqlSession().selectList("productDao.getHighPriceProduct", productSearchVO);
	}
	
	@Override
	public List<ProductVO> getLowPriceProduct(ProductSearchVO productSearchVO) {
		return getSqlSession().selectList("productDao.getLowPriceProduct", productSearchVO);
	}
}
