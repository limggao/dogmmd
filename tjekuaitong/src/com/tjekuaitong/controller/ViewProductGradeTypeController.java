package com.tjekuaitong.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.tjekuaitong.entity.Picture;
import com.tjekuaitong.entity.Product;
import com.tjekuaitong.entity.ProductType;
import com.tjekuaitong.entity.ViewProductGradeType;
import com.tjekuaitong.service.PictureService;
import com.tjekuaitong.service.ProductService;
import com.tjekuaitong.service.ProductTypeService;
import com.tjekuaitong.service.ViewProductGradeTypeService;
import com.tjekuaitong.uitls.CommonUtils;
import com.tjekuaitong.uitls.OutString;

@Controller
@RequestMapping("/viewProductGradeTypeController")
public class ViewProductGradeTypeController extends BaseController{

	@Resource
	private ViewProductGradeTypeService gradeTypeService;
	@Resource
	private PictureService picService;
	@Resource
	private ProductTypeService ductTypeService;
	
	@Resource
	private ProductService ductService;
	@SuppressWarnings("null")
	@RequestMapping(value="selectList")
	public void selectList(HttpServletRequest request,HttpServletResponse response){
		List<ProductType> productTypeList=null;
		List<ViewProductGradeType<Product>> productGradeType=new ArrayList<ViewProductGradeType<Product>>();
		try {
			productTypeList = ductTypeService.selectList(new ProductType());
			for (ProductType productType : productTypeList) {
				ViewProductGradeType<Product> ductGrade =new ViewProductGradeType<Product>();
				ductGrade.setProduct_type(productType.getId());
				ductGrade.setType_name(productType.getType_name());
				Product product =new Product();
				product.setProduct_type(productType.getId().toString());
				List<Product> ductList=ductService.selectList(product);
				ductGrade.setChildren(ductList);
				productGradeType.add(ductGrade);
			}
			
			OutString.outString(response, JSON.toJSON(productGradeType));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
