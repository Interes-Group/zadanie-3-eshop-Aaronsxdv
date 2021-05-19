package sk.stuba.fei.uim.oop.assignment3.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public ProductResponse addProduct(@RequestBody ProductRequest request){
        return new ProductResponse(this.service.addProduct(request));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") long id){
        return this.service.getProduct(id);
    }

    @RequestMapping(value = "/{id}/ammount", method = RequestMethod.GET)
    public ProductAmmountResponse getProductAmount(@PathVariable("id") long id){
        return this.service.getProductAmmount(id);
    }

    @RequestMapping(value = "/{id}/ammount", method = RequestMethod.POST)
    public ProductAmmountResponse addProductAmount(@PathVariable("id") long id,@RequestBody ProductAmountRequest request){
        return this.service.addProductAmmount(id,request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ProductResponse updateProduct(@PathVariable("id") long id,@RequestBody ProductRequest request){
        return this.service.updateProduct(id,request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") long id){
        this.service.deleteProduct(id);
    }
}
