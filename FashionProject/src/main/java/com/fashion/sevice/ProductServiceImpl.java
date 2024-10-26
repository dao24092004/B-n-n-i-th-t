package com.fashion.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fashion.model.ImageProduct;
import com.fashion.model.Product;
import com.fashion.repository.CategoryRepository;
import com.fashion.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ImageProductService imageProductService;

	@Autowired
	private FileSystemStorageService fileSystemStorageService;

	@Override
	public List<Product> getAll() {

		return this.productRepository.findAll();
	}

	@Override
	public Boolean create(Product product) {
		try {
			this.productRepository.save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return this.productRepository.findById(id).get();
	}

	@Override
	public Boolean update(Product product) {
		try {
			// Kiểm tra nếu sản phẩm đã tồn tại thì mới cập nhật
			if (product.getId() == null || !this.productRepository.existsById(product.getId())) {
				throw new Exception("Không tìm thấy sản phẩm để cập nhật với ID: " + product.getId());
			}

			// Lưu sản phẩm vào cơ sở dữ liệu
			this.productRepository.save(product);
			return true;
		} catch (Exception e) {
			// Ghi lỗi ra console để dễ dàng theo dõi
			e.printStackTrace();
			throw new RuntimeException("Lỗi trong quá trình cập nhật sản phẩm: " + e.getMessage());
		}
	}

	

	@Override
	public Boolean delete(Integer id) {
		try {
			this.imageProductService.deleteByProductId(id);
			this.productRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public List<Product> getProductNew() {
		Pageable pageable = PageRequest.of(0, 3); // Lấy 5 sản phẩm mới nhất
	    return productRepository.getProductNew(pageable);
	}

}
