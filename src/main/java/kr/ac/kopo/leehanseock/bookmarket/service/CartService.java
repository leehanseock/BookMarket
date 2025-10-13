package kr.ac.kopo.leehanseock.bookmarket.service;

import kr.ac.kopo.leehanseock.bookmarket.domain.Cart;

public interface CartService {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId); // 카트에 들어있는 전체 항목 삭제
    Cart validateCart(String cartId); // 해당 카트 id에 해당하는 카트의 유효성 검사
}
