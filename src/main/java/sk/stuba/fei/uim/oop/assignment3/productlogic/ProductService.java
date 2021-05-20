package sk.stuba.fei.uim.oop.assignment3.productlogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService implements IProductService{


    ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAllProducts() {
        return this.repository.findAll();
    }

    @Override
    public Product addProduct(ProductRequest request){
        Product newProduct = new Product();
        newProduct.setName(request.getName());
        newProduct.setAmount(request.getAmount());
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
    public ProductAmountResponse getProductamount(long id){
        Product CustomProduct  = repository.findById(id)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));
        ProductAmountResponse ans = new ProductAmountResponse(CustomProduct.getAmount());
        return ans;
    }

    @Override
    public ProductAmountResponse addProductamount(long id,ProductAmountRequest request){
        Product CustomProduct  = repository.findById(id)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));
        int a = CustomProduct.getAmount();
        int b = request.getAmount();
        CustomProduct.setAmount(a+b);
        repository.save(CustomProduct);
        ProductAmountResponse ans = new ProductAmountResponse(CustomProduct.getAmount());
        return ans;
    }
    
    @Override
    public ProductResponse updateProduct(long id,ProductRequest request){
        Product CustomProduct  = repository.findById(id)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));
        CustomProduct.setName(request.getName());
        CustomProduct.setAmount(request.getAmount());
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
