package com.fashion.sevice;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.model.ImageProduct;
import com.fashion.repository.ImageRepository;

@Service
public class ImageProductServiceImpl implements ImageProductService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Boolean create(ImageProduct imageProduct) {
        try {
            this.imageRepository.save(imageProduct);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

	@Override
	public Boolean deleteByProductId(Integer idProduct) {
		try {
            this.imageRepository.deleteByProductId(idProduct);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
	}


    }

