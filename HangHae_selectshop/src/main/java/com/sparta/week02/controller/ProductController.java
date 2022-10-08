package com.sparta.week02.controller;

import com.sparta.week02.dto.ProductMyPriceRequestDto;
import com.sparta.week02.dto.ProductRequestDto;
import com.sparta.week02.model.Product;
import com.sparta.week02.security.UserDetailsImpl;
import com.sparta.week02.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductService productService;

    // 신규 상품 등록
    @PostMapping("/api/products")
    public Product createproduct(@RequestBody ProductRequestDto requestDto
            , @AuthenticationPrincipal UserDetailsImpl userDetails){
        int userId = userDetails.getUser().getId();
        return productService.createProduct(requestDto, userId);
    }

    // 설정 가격 변경
    @PutMapping("/api/products/{id}")
    public int updateproduct(@PathVariable int id, @RequestBody ProductMyPriceRequestDto requestDto){
        Product product = productService.updateProduct(id, requestDto);
        return product.getId(); // 업데이트된 상품의 id
    }

    // 로그인한 회원이 등록한 관심 상품 조회
    @GetMapping("/api/products")
    public List<Product> getProducts(@AuthenticationPrincipal UserDetailsImpl userDetails){
        int userId = userDetails.getUser().getId();
        return productService.getProducts(userId);
    }
}
