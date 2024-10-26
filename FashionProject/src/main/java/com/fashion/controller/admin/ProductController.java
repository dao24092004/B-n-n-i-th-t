package com.fashion.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fashion.model.Category;
import com.fashion.model.ImageProduct;
import com.fashion.model.Product;
import com.fashion.repository.ProductRepository;
import com.fashion.sevice.CategoryService;
import com.fashion.sevice.ImageProductService;
import com.fashion.sevice.ProductService;
import com.fashion.sevice.StorageService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private StorageService storageService;
	@Autowired
	private ImageProductService imageProductService;

	@GetMapping("")
	public String index(Model model) {
		List<Product> lst = this.productService.getAll();
		model.addAttribute("lst", lst);
		return "admin/product/index";
	}

	@GetMapping("/add-product")
	public String showAddProductForm(Model model) {
		Product product = new Product();
		product.setStatus(true); // Set default status
		model.addAttribute("product", product);
		List<Category> lstCategories = this.categoryService.getAll();
		model.addAttribute("lstCategories", lstCategories); // Pass the list of categories
		return "admin/product/add-product"; // View for adding a product
	}

	@PostMapping("/add-product")
	public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result,
			@RequestParam("fileImage") MultipartFile file, @RequestParam("fileImages") MultipartFile[] files,
			Model model) {
		if (result.hasErrors()) {
			System.out.println("Có lỗi trong form: " + result.getAllErrors());

			// Nếu có lỗi, trả về form với danh sách lỗi và danh mục
			List<Category> lstCategories = this.categoryService.getAll();
			model.addAttribute("lstCategories", lstCategories);
			return "admin/product/add-product";
		}

		// Upload file
		this.storageService.store(file);
		String fileName = file.getOriginalFilename();
		product.setImage(fileName);

		// Lưu sản phẩm nếu không có lỗi
		if (this.productService.create(product)) {
			// Upload ảnh mô tả nếu sản phẩm được lưu thành công
			for (MultipartFile multipartFile : files) {
				ImageProduct imageProduct = new ImageProduct();
				imageProduct.setImage(multipartFile.getOriginalFilename());
				imageProduct.setProduct(product);
				this.imageProductService.create(imageProduct);
				this.storageService.store(multipartFile);
			}
			return "redirect:/admin/product";
		}

		// Nếu không thể lưu sản phẩm, trả về form thêm sản phẩm
		return "redirect:/admin/product/add-product";
	}

	@GetMapping("/edit-product/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Product product = this.productService.findById(id);
		model.addAttribute("product", product);
		List<Category> lstCategories = this.categoryService.getAll();
		model.addAttribute("lstCategories", lstCategories);
		List<String> imgDetail = new ArrayList<>();
		for (ImageProduct imageProduct : product.getImageProducts()) {
			imgDetail.add(imageProduct.getImage());
		}
		model.addAttribute("imgDetail", imgDetail);
		return "admin/product/edit-product";
	}

	@PostMapping("/edit-product")
	public String updateProduct(@ModelAttribute("product") Product product, 
	                            @RequestParam("fileImage") MultipartFile file,
	                            @RequestParam("fileImages") MultipartFile[] files) {
	    // Xử lý ảnh đại diện (fileImage)
	    String fileName = file.getOriginalFilename();
	    boolean isEmpty = fileName == null || fileName.trim().length() == 0;
	    
	    if (!isEmpty) {
	        // Nếu người dùng tải lên ảnh mới thì lưu và cập nhật ảnh
	        this.storageService.store(file);
	        product.setImage(fileName);
	    } else {
	        // Nếu không tải lên ảnh mới, giữ nguyên ảnh cũ
	        Product existingProduct = this.productService.findById(product.getId());
	        if (existingProduct != null) {
	            product.setImage(existingProduct.getImage());
	        }
	    }

	    // Xử lý ảnh chi tiết sản phẩm (fileImages)
	    String fileName1 = files.length > 0 ? files[0].getOriginalFilename() : null;
	    boolean isEmpty1 = fileName1 == null || fileName1.trim().length() == 0;

	    if (!isEmpty1) {
	        // Nếu có tải lên ảnh chi tiết, thì xóa ảnh chi tiết cũ và lưu ảnh mới
	        this.imageProductService.deleteByProductId(product.getId());
	        for (MultipartFile multipartFile : files) {
	            ImageProduct imageProduct = new ImageProduct();
	            imageProduct.setImage(multipartFile.getOriginalFilename());
	            imageProduct.setProduct(product);
	            this.storageService.store(multipartFile);
	            this.imageProductService.create(imageProduct);
	        }
	    }

	    // Cập nhật sản phẩm
	    if (this.productService.update(product)) {
	        return "redirect:/admin/product";
	    }

	    return "admin/product/edit-product";
	}


	@GetMapping("/delete-product/{id}")
	public String delete(Model model, @PathVariable("id") Integer id) {
		if (this.productService.delete(id)) {
			return "redirect:/admin/product";
		} else {
			return "redirect:/admin/product";
		}
	}

}
