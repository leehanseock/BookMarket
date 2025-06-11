package kr.ac.kopo.leehanseock.bookmarket.repository;

import kr.ac.kopo.leehanseock.bookmarket.domain.Cart;

public interface CartRepository {
    Cart create(Cart cart);
    Cart read(String cartId);

}
