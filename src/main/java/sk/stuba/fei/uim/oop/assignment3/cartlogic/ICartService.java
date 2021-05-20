package sk.stuba.fei.uim.oop.assignment3.cartlogic;



import org.springframework.http.ResponseEntity;
import sk.stuba.fei.uim.oop.assignment3.productlogic.Product;

import java.util.List;

public interface ICartService {
    List<Cart> getAllCarts();
    Cart getCart(long cid);
    Cart addCart();
    void deleteCart(long cid);
    ResponseEntity<Cart> addToCart(long cid, ProductInCart request) throws Exception;
}
