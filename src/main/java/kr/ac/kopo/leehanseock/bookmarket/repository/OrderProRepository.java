package kr.ac.kopo.leehanseock.bookmarket.repository;

import kr.ac.kopo.leehanseock.bookmarket.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProRepository extends JpaRepository<Order, Long> {

}
