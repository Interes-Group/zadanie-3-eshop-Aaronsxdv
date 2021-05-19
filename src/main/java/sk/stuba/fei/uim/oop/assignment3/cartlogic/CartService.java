package sk.stuba.fei.uim.oop.assignment3.cartlogic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sk.stuba.fei.uim.oop.assignment3.productlogic.Product;

import java.util.List;

@Service
public class CartService implements ICartService {
    
    private CartRepository repository;

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
}
