package sk.stuba.fei.uim.oop.assignment3.cartlogic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sk.stuba.fei.uim.oop.assignment3.productlogic.Product;
import sk.stuba.fei.uim.oop.assignment3.productlogic.ProductRepository;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements ICartService {

    @Autowired
    private CartRepository repository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cart> getAllCarts() {
        return this.repository.findAll();
    }

    @Override
    public Cart getCart(long id){
        return repository.findById(id)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Cart addCart(){
        Cart newCart = new Cart();
        return this.repository.save(newCart);
    }

    @Override
    public void deleteCart(long id){
        Cart CustomCart  = repository.findById(id)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));
        repository.delete(CustomCart);
    }

    @Override
    public Cart addToCart(long id,ProductInCart request){
        Product productToAdd= productRepository.findById(request.getProdid())
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));
        Cart CartToAdd = repository.findById(id)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));

        if(CartToAdd.isPayed()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if(productToAdd.getAmmount() < request.getAmount()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if(CartToAdd.getCartProducts() != null){
            for(ProductInCart p: CartToAdd.getCartProducts()){
                if(p.getProdid() == request.getProdid()){
                    p.setAmount(p.getAmount() + request.getAmount());
                    productToAdd.setAmmount(productToAdd.getAmmount() - request.getAmount());
                    return repository.save(CartToAdd);
                }
            }
        }

        ProductInCart ansp = new ProductInCart(request.getProdid(), request.getAmount());
        if(CartToAdd.getCartProducts() == null){
            ArrayList<ProductInCart> x = new ArrayList<ProductInCart>();
            x.add(ansp);
            productToAdd.setAmmount(productToAdd.getAmmount() - request.getAmount());
            CartToAdd.setCartProducts(x);

        }
        else{
            ArrayList<ProductInCart> x = CartToAdd.getCartProducts();
            x.add(ansp);
            productToAdd.setAmmount(productToAdd.getAmmount() - request.getAmount());
            CartToAdd.setCartProducts(x);
        }
        repository.save(CartToAdd);
        return CartToAdd;

    }


}
