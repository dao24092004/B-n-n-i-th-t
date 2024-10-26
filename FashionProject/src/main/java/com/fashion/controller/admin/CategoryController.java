package com.fashion.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fashion.model.Category;
import com.fashion.sevice.CategoryService;


@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@GetMapping("")
	public String index(Model model, @Param("keyword") String keyword, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
	    Page<Category> lst = this.categoryService.getAll(pageNo);
	    
	     if(keyword != null) {
	         lst = this.categoryService.searchCategory(keyword,pageNo);
	         model.addAttribute("keyword", keyword);
	     }
	    
	    model.addAttribute("totalPage", lst.getTotalPages());
	    model.addAttribute("currentPage", pageNo);
	    model.addAttribute("lst", lst);
	    return "admin/category/index";
	}

	@GetMapping("/add-category")
	public String add_category(Model model) {
		Category category = new Category();
		category.setStatus(true);
		model.addAttribute("category", category);
		return "admin/category/add-menu";
	}
	
	@PostMapping("/add-category")
	public String save(@ModelAttribute("category") Category category) {
		
		if(this.categoryService.create(category)) {
			return "redirect:/admin/category";
		}else {
			return "redirect:/admin/category/add-category";
		}
		
	}
	
	@GetMapping("/edit-category/{id}")
	public String edit(Model model,@PathVariable("id") Integer id) {
		Category category = this.categoryService.findById(id);
		model.addAttribute("category", category);
		
		return "admin/category/edit";
	}
	
	@PostMapping("/edit-category")
	public String update(@ModelAttribute("category") Category category) {
		
		if(this.categoryService.create(category)) {
			return "redirect:/admin/category";
		}else {
			return "redirect:/admin/category/add-category";
		}
		
	}
	
	@GetMapping("/delete-category/{id}")
	public String delete(Model model,@PathVariable("id") Integer id) {
		if(this.categoryService.delete(id)) {
			return "redirect:/admin/category";
		}else {
			return "redirect:/admin/category";
		}
	}

}
