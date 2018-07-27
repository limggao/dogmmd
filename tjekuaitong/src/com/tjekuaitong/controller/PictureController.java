package com.tjekuaitong.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.tjekuaitong.entity.Express;
import com.tjekuaitong.entity.Picture;
import com.tjekuaitong.entity.Product;
import com.tjekuaitong.entity.ProductType;
import com.tjekuaitong.entity.ViewProductGradeType;
import com.tjekuaitong.service.ExpressService;
import com.tjekuaitong.service.PictureService;
import com.tjekuaitong.service.ProductService;
import com.tjekuaitong.uitls.OutString;

@Controller
@RequestMapping("/PictureController")
public class PictureController {
	@Resource
	private PictureService pictureService;
	@Resource
	private ProductService productService;
	@Resource
	private ExpressService expressService;
	@RequestMapping(value="selectList")
	public void selectList(HttpServletRequest request,HttpServletResponse response,Picture picture) {
		
		try {
			Product product=new Product();
			product.setProduct_id(picture.getProduct_id());
			ViewProductGradeType<Picture> gradeType =new ViewProductGradeType<>();
			List<Product> productList=productService.selectList(product);
			List<Picture> pictureList=pictureService.selectList(picture);
			Express express=new Express();
			express.setId(productList.get(0).getSpec_id());
			List<Express> expressList=expressService.selectList(new Express());
			if(productList !=null) {
				gradeType.setChildren(pictureList);			
				gradeType.setProduct_id(productList.get(0).getProduct_id());
				gradeType.setProduct_name(productList.get(0).getProduct_name());
				gradeType.setProduct_desc(productList.get(0).getProduct_desc());
				gradeType.setProduct_grade(Integer.parseInt(productList.get(0).getProduct_grade()));
				gradeType.setProduct_num(productList.get(0).getProduct_num());
				gradeType.setProduct_price(productList.get(0).getProduct_price());
				gradeType.setProduct_type(Integer.parseInt(productList.get(0).getProduct_type()));
				gradeType.setCommon_id(productList.get(0).getCommon_id());
				gradeType.setSpec(expressList.get(expressList.size()-1).getSpec());
				if(productList.get(0).getCommon_id()==0) {
					gradeType.setPrice("包邮");
				}else {
					gradeType.setPrice(expressList.get(expressList.size()-1).getPrice());
				}
			}
			OutString.outString(response, JSON.toJSON(gradeType));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="spec")
	public void spec(HttpServletRequest request,HttpServletResponse response,Integer id) {
		
		try {
			List<Express> expressList=expressService.selectList(new Express());
			OutString.outString(response, JSON.toJSON(expressList));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
