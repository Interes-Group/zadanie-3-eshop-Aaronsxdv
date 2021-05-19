package sk.stuba.fei.uim.oop.assignment3.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{


    private ProductPepository repository;

    @Autowired
    public ProductService(ProductPepository repository) {
        this.repository = repository;
        Product pr = new Product();
        pr.setName("Computer");
        pr.setAmmount(10);
        pr.setDescription("A normal Computer.");
        this.repository.save(pr);
        Product pr2 = new Product();
        pr2.setName("Mouse");
        pr2.setAmmount(5);
        pr2.setDescription("A normal Mouse.");
        this.repository.save(pr2);
    }

    @Override
    public List<Product> getAllProducts() {
        return this.repository.findAll();
    }

    @Override
    public Product addProduct(ProductRequest request){
        Product newProduct = new Product();
        newProduct.setName(request.getName());
        newProduct.setAmmount(request.getAmmount());
        newProduct.setDescription(request.getDescription());
        newProduct.setUnit(request.getUnit());
        newProduct.setPrice(request.getPrice());
        return this.repository.save(newProduct);
    }
}
