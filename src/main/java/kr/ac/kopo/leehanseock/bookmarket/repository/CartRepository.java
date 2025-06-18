package kr.ac.kopo.leehanseock.bookmarket.repository;

import kr.ac.kopo.leehanseock.bookmarket.domain.Cart;

public interface CartRepository {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);//전체 카트 삭제
}
