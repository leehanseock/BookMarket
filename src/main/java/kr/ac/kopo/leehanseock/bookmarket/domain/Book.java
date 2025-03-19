package kr.ac.kopo.leehanseock.bookmarket.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor //생성자 추가
public class Book {
    private String bookId; //도서번호
    private String name; //도서명
    private BigDecimal unitPrice; //단가
    private String author; //저자명
    private String description; //설명
    private String publisher; //출판사
    private String category; //분류
    private long unitsInStock; //재고량
    private String releaseDate; //출판일
    private String condition; //신규도서 or 중고도서 or eBook
}
