package sk.stuba.fei.uim.oop.assignment3.productlogic;


import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();
    Product getProduct(long id);
    ProductAmountResponse getProductamount(long id);
    ProductAmountResponse addProductamount(long id,ProductAmountRequest request);
    ProductResponse updateProduct(long id,ProductRequest request);
    Product addProduct(ProductRequest request);
    void deleteProduct(long id);
}
