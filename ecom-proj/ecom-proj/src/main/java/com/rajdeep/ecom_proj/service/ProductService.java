package com.rajdeep.ecom_proj.service;

import com.rajdeep.ecom_proj.model.Product;
import com.rajdeep.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductRepo repo;
    public List<Product> getAllProducts() {
         return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        if(imageFile != null && !imageFile.isEmpty()){
            product.setImageName(imageFile.getOriginalFilename());
            product.setImageType(imageFile.getContentType());
            product.setImageDate(imageFile.getBytes());
        }
        return repo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        Product existingProduct = repo.findById(id).orElse(null);
        if(existingProduct == null){
            return null;
        }
        
        // Update product fields
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setReleaseDate(product.getReleaseDate());
        existingProduct.setProductAvailable(product.isProductAvailable());
        existingProduct.setStockQuantity(product.getStockQuantity());
        
        if(imageFile != null && !imageFile.isEmpty()){
            existingProduct.setImageDate(imageFile.getBytes());
            existingProduct.setImageName(imageFile.getOriginalFilename());
            existingProduct.setImageType(imageFile.getContentType());
        }
        
        return repo.save(existingProduct);
    }

    public ResponseEntity<String> deleteProduct(int id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return ResponseEntity.ok("Product deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }


    public List<Product> searchProducts(String keyword) {
         return repo.searchProducts(keyword);
    }
}
