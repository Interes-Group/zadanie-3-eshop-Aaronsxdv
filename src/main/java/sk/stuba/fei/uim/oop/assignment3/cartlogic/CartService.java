package sk.stuba.fei.uim.oop.assignment3.cartlogic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sk.stuba.fei.uim.oop.assignment3.productlogic.IProductService;
import sk.stuba.fei.uim.oop.assignment3.productlogic.Product;
import sk.stuba.fei.uim.oop.assignment3.productlogic.ProductRepository;
import sk.stuba.fei.uim.oop.assignment3.productlogic.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements ICartService {



    private CartRepository repository;

    @Autowired
    private IProductService servicex;

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

    /*@Override
    public Cart addToCart(long id,ProductInCart request){
        Product productToAdd= productRepository.findById(request.getProdid())
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));
        Cart CartToAdd = repository.findById(id)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));

        if(CartToAdd.isPayed()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if(productToAdd.getAmount() < request.getAmount()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if(!CartToAdd.getShoppingList().isEmpty()){
            for(ProductInCart p: CartToAdd.getShoppingList()){
                if(p.getProdid() == request.getProdid()){
                    p.setAmount(p.getAmount() + request.getAmount());
                    productToAdd.setAmount(productToAdd.getAmount() - request.getAmount());
                    return repository.save(CartToAdd);
                }
            }
        }

        ProductInCart ansp = new ProductInCart(request.getProdid(), request.getAmount());
        if(CartToAdd.getShoppingList().isEmpty()){
            ArrayList<ProductInCart> x = new ArrayList<ProductInCart>();
            x.add(ansp);
            productToAdd.setAmount(productToAdd.getAmount() - request.getAmount());
            CartToAdd.setShoppingList(x);

        }
        else{
            ArrayList<ProductInCart> x = CartToAdd.getShoppingList();
            x.add(ansp);
            productToAdd.setAmount(productToAdd.getAmount() - request.getAmount());
            CartToAdd.setShoppingList(x);
        }
        repository.save(CartToAdd);
        return CartToAdd;

    }*/
    @Override
    public ResponseEntity<Cart> addToCart(long id, ProductInCart request) throws Exception{

        Cart CartToAdd = getCart(id);
        Product productToAdd= servicex.getProduct(request.getProductId());


        if(CartToAdd.isPayed()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        if(productToAdd.getAmount() < request.getAmount()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!CartToAdd.getShoppingList().isEmpty()){
            for(ProductInCart p: CartToAdd.getShoppingList()){
                if(p.getProductId() == request.getProductId()){
                    p.setAmount(p.getAmount() + request.getAmount());
                    productToAdd.setAmount(productToAdd.getAmount() - request.getAmount());
                    System.out.printf("\nProduct id: %d\n",CartToAdd.getShoppingList().get(0).productId);
                    System.out.printf("Product amount: %d\n",CartToAdd.getShoppingList().get(0).amount);
                    return new ResponseEntity<>(repository.save(CartToAdd),HttpStatus.OK);
                }
            }
        }

        ProductInCart ansp = new ProductInCart(request.getProductId(), request.getAmount());
        if(CartToAdd.getShoppingList().isEmpty()){
            ArrayList<ProductInCart> x = new ArrayList<ProductInCart>();
            x.add(ansp);
            productToAdd.setAmount(productToAdd.getAmount() - request.getAmount());
            CartToAdd.setShoppingList(x);
            return new ResponseEntity<>(repository.save(CartToAdd),HttpStatus.OK);

        }
        else{
            ArrayList<ProductInCart> x = CartToAdd.getShoppingList();
            x.add(ansp);
            productToAdd.setAmount(productToAdd.getAmount() - request.getAmount());
            CartToAdd.setShoppingList(x);
            return new ResponseEntity<>(repository.save(CartToAdd),HttpStatus.OK);
        }


    }

    /*@Override
    public ResponseEntity<>*/

}
