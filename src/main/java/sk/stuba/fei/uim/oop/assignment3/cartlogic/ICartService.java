package sk.stuba.fei.uim.oop.assignment3.cartlogic;



import java.util.List;

public interface ICartService {
    List<Cart> getAllCarts();
    Cart getCart(long cid);
    Cart addCart();
    void deleteCart(long cid);
}
