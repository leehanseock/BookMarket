package kr.ac.kopo.leehanseock.bookmarket.domain;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Data
public class CartItem {
    private Book book;
    private int quantity;
    private BigDecimal totalPrice;

    public CartItem(Book book) {
        this.book = book;
        quantity = 1;
        totalPrice = book.getUnitPrice();
    }

    public void setBook(Book book) {
        this.book = book;
        updateTotalPrice();
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.updateTotalPrice();
    }

    public void updateTotalPrice() {
        this.totalPrice = book.getUnitPrice().multiply(new BigDecimal(quantity));
    }
}
