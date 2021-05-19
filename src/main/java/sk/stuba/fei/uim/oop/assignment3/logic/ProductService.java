package sk.stuba.fei.uim.oop.assignment3.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
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

    @Override
    public Product getProduct(long id){
        return repository.findById(id)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public ProductAmmountResponse getProductAmmount(long id){
        Product CustomProduct  = repository.findById(id)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));
        ProductAmmountResponse ans = new ProductAmmountResponse(CustomProduct.getAmmount());
        return ans;
    }

    @Override
    public ProductAmmountResponse addProductAmmount(long id,ProductAmountRequest request){
        Product CustomProduct  = repository.findById(id)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));
        int a = CustomProduct.getAmmount();
        int b = request.getAmount();
        CustomProduct.setAmmount(a+b);
        repository.save(CustomProduct);
        ProductAmmountResponse ans = new ProductAmmountResponse(CustomProduct.getAmmount());
        return ans;
    }
    
    @Override
    public ProductResponse updateProduct(long id,ProductRequest request){
        Product CustomProduct  = repository.findById(id)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));
        CustomProduct.setName(request.getName());
        CustomProduct.setAmmount(request.getAmmount());
        CustomProduct.setDescription(request.getDescription());
        CustomProduct.setUnit(request.getUnit());
        CustomProduct.setPrice(request.getPrice());
        repository.save(CustomProduct);
        ProductResponse ans = new ProductResponse(CustomProduct);
        return ans;
    }

    @Override
    public void deleteProduct(long id){
        Product CustomProduct  = repository.findById(id)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));
        repository.delete(CustomProduct);
    }



}
