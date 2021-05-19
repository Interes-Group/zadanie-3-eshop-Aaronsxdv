package sk.stuba.fei.uim.oop.assignment3.cartlogic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.productlogic.Product;
import sk.stuba.fei.uim.oop.assignment3.productlogic.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.productlogic.ProductResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {


    @Autowired
    private ICartService service;

    @GetMapping()
    public List<CartResponse> getAllCarts(){
        //return this.service.getAllProducts().stream().map(Product -> new ProductResponse(Product)).collect(Collectors.toList());
        var result = new ArrayList<CartResponse>();
        for(Cart c: this.service.getAllCarts()){
            result.add(new CartResponse(c));
        }
        return result;
    }

    @PostMapping()
    public CartResponse addCart(){
        return new CartResponse(this.service.addCart());
    }

    @RequestMapping(value = "/{cid}", method = RequestMethod.GET)
    public Cart getCart(@PathVariable("cid") long cid){
        return this.service.getCart(cid);
    }

    @RequestMapping(value = "/{cid}", method = RequestMethod.DELETE)
    public void deleteCart(@PathVariable("cid") long cid){
        this.service.deleteCart(cid);
    }
}
