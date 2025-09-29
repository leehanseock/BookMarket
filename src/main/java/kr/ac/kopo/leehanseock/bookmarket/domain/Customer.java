package kr.ac.kopo.leehanseock.bookmarket.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Customer {
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue
    private long id;
    private String CustomerId; // 고객ID
    private String name; // 이름
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address; // 주소
    private String phone; // 전화번호
}
