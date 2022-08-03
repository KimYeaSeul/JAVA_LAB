package com.sparta.week02.service;

import com.sparta.week02.dto.ProductMyPriceRequestDto;
import com.sparta.week02.dto.ProductRequestDto;
import com.sparta.week02.model.Product;
import com.sparta.week02.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    public Product createProduct(ProductRequestDto requestDto, int userId) {
        Product product = new Product(requestDto, userId);
        productRepository.save(product);
        return product;
    }

    public Product updateProduct(int id, ProductMyPriceRequestDto requestsDto){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));
        int myprice = requestsDto.getMyprice();
        product.setMyprice(myprice);
        productRepository.save(product);
        return product;
    }

    public List<Product> getProducts(int id){
        return productRepository.findAllByUserId(id);
    }

}
