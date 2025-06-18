package kr.ac.kopo.leehanseock.bookmarket.domain;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class Cart {
    private String cartId;
    private Map<String, CartItem> cartItems;
    private BigDecimal grandTotal;

    public Cart(){
        cartItems = new HashMap<String, CartItem>();
        grandTotal = new BigDecimal(0);

    }

    public Cart(String cartId) {
        this();
        this.cartId = cartId;
    }

    public void addCartItem(CartItem item) {
        String bookId = item.getBook().getBookId();
        if (cartItems.containsKey(bookId)) {
            CartItem existingItem = cartItems.get(bookId);
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
            cartItems.put(bookId, existingItem);
        } else {
            cartItems.put(bookId, item);
        }
        updateGrandTotal();
    }

    //(총계) 전체 주문총액을 업데이트하는 메소드
    public void updateGrandTotal() {
        grandTotal = BigDecimal.ZERO;
        for (CartItem cartItem : cartItems.values()) {
            grandTotal = grandTotal.add(cartItem.getTotalPrice());
        }
    }

}
