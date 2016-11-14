package com.dat.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dat.common.pager.ClassicPageExplorer;
import com.dat.common.pager.PageExplorer;
import com.dat.service.ProductService;
import com.dat.vo.ProductListVO;
import com.dat.vo.ProductSearchVO;
import com.dat.vo.ProductVO;

@Controller
public class ProductController {
	
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/product")
	public ModelAndView viewProductListPage(ProductSearchVO productSearchVO) {
		
		ProductListVO productList = productService.getAllProduct(productSearchVO);
		
		PageExplorer pageExplorer = new ClassicPageExplorer(productList.getPager());
		String page = pageExplorer.getPagingList("pageNumber", "[@]", "이전", "다음", "searchForm");
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/list");
		view.addObject("productList", productList);
		view.addObject("page", page);
		view.addObject("productSearchVO", productSearchVO);
		return view;
	}
	
	@RequestMapping("/write")
	public String viewWriteProductPage() {
		return "write";
	}
	
	@RequestMapping("/doWrite")
	public ModelAndView doWriteProduct(@Valid ProductVO productVO, Errors errors ) {
		ModelAndView view = new ModelAndView();
		
		if(errors.hasErrors()) {
			view.setViewName("/write");
		}
		else {
			boolean isSuccess = productService.addNewProduct(productVO);
			view.setViewName("redirect:/product");
		}
		return view;
	}
	
	@RequestMapping("/detail/{productId}")
	public ModelAndView viewDetailProductPage(@PathVariable String productId) {
		ModelAndView view = new ModelAndView();
		
		ProductVO productVO = productService.getProductById(productId);
		
		view.setViewName("/list");
		view.addObject("productVO", productVO);
		return view;
	}
	
	@RequestMapping("/modify/{productId}")
	public ModelAndView viewModifyProductPage(@PathVariable String productId) {
		ModelAndView view = new ModelAndView();
		
		ProductVO productVO = productService.getProductById(productId);
		
		view.setViewName("/modify");
		view.addObject("productVO", productVO);
		return view;
	}
	
	@RequestMapping("/doModify")
	public ModelAndView doModifyProduct(@Valid ProductVO productVO, Errors errors) {
		ModelAndView view = new ModelAndView();
		
		if(errors.hasErrors()) {
			view.setViewName("/modify");
		}
		else {
			boolean isSuccess = productService.doModifyProduct(productVO);
			view.setViewName("redirect:/product");			
		}
		return view;
	}
	
	@RequestMapping("/delete/{productId}")
	public ModelAndView doDeleteProduct(@PathVariable String productId) {
		ModelAndView view = new ModelAndView();
		
		boolean isSuccess = productService.deleteProductById(productId);
		
		view.setViewName("redirect:/product");
		return view;
	}
	
	@RequestMapping("/highPrice")
	public ModelAndView viewHighPrice(ProductSearchVO productSearchVO) {
		
		ProductListVO productList = productService.getHighPriceProduct(productSearchVO);
		
		PageExplorer pageExplorer = new ClassicPageExplorer(productList.getPager());
		String page = pageExplorer.getPagingList("pageNumber", "[@]", "이전", "다음", "searchForm");
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/list");
		view.addObject("productList", productList);
		view.addObject("page", page);
		view.addObject("productSearchVO", productSearchVO);
		return view;
	}
	
	@RequestMapping("/lowPrice")
	public ModelAndView viewLowPrice(ProductSearchVO productSearchVO) {
		
		ProductListVO productList = productService.getLowPriceProduct(productSearchVO);
		
		PageExplorer pageExplorer = new ClassicPageExplorer(productList.getPager());
		String page = pageExplorer.getPagingList("pageNumber", "[@]", "이전", "다음", "searchForm");
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/list");
		view.addObject("productList", productList);
		view.addObject("page", page);
		view.addObject("productSearchVO", productSearchVO);
		return view;
	}
}
