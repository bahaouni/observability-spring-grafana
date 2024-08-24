package com.example.observabilityspringgrafana.web;

import com.example.observabilityspringgrafana.entities.Product;
import com.example.observabilityspringgrafana.model.Post;
import com.example.observabilityspringgrafana.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;
@RestController  // Add this annotation


public class ProductController {

    private ProductRepo productRepo;
    private RestClient restClient;

    public ProductController(ProductRepo productRepository,
                             RestClient.Builder restClient) {
        this.productRepo = productRepository;
        this.restClient = restClient
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }


    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
    @GetMapping("/posts")
    public List<Post> allPosts(){
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {});
    }

}
