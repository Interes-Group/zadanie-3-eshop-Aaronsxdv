package sk.stuba.fei.uim.oop.assignment3.logic;


import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();
    Product getProduct(long id);
    ProductAmmountResponse getProductAmmount(long id);
    ProductAmmountResponse addProductAmmount(long id,ProductAmountRequest request);
    ProductResponse updateProduct(long id,ProductRequest request);
    Product addProduct(ProductRequest request);
    void deleteProduct(long id);
}
