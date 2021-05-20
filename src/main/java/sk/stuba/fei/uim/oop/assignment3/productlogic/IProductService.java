package sk.stuba.fei.uim.oop.assignment3.productlogic;


import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();
    Product getProduct(long id);
    ProductAmountResponse getProductamount(long id);
    ProductAmountResponse addProductamount(long id,ProductAmountRequest request);
    Product updateProduct(long id,UpdateProductRequest request);
    Product addProduct(ProductRequest request);
    void deleteProduct(long id);
}
