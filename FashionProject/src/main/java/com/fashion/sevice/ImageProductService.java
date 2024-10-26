package com.fashion.sevice;

import com.fashion.model.ImageProduct;

public interface ImageProductService {
	Boolean create(ImageProduct imageProduct);
	Boolean deleteByProductId(Integer idProduct);

}
