package sk.stuba.fei.uim.oop.assignment3.logic;


import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();
    Product addProduct(ProductRequest request);
}
