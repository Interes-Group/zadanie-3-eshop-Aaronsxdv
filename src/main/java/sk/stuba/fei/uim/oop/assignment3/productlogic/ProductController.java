package sk.stuba.fei.uim.oop.assignment3.productlogic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping()
    public List<ProductResponse> getAllProducts(){
        //return this.service.getAllProducts().stream().map(Product -> new ProductResponse(Product)).collect(Collectors.toList());
        var result = new ArrayList<ProductResponse>();
        for(Product a: this.service.getAllProducts()){
            result.add(new ProductResponse(a));
        }
        return result;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse addProduct(@RequestBody ProductRequest request){
        return new ProductResponse(this.service.addProduct(request));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") long id){
        return this.service.getProduct(id);
    }

    @RequestMapping(value = "/{id}/amount", method = RequestMethod.GET)
    public ProductAmountResponse getProductAmount(@PathVariable("id") long id){
        return this.service.getProductamount(id);
    }

    @RequestMapping(value = "/{id}/amount", method = RequestMethod.POST)
    public ProductAmountResponse addProductAmount(@PathVariable("id") long id,@RequestBody ProductAmountRequest request){
        return this.service.addProductamount(id,request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Product updateProduct(@PathVariable("id") long id,@RequestBody UpdateProductRequest request){
        return this.service.updateProduct(id,request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") long id){
        this.service.deleteProduct(id);
    }
}
