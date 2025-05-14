package kr.ac.kopo.leehanseock.bookmarket.domain;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

//@Getter
//@Setter
//@NoArgsConstructor //생성자 추가
@Data
public class Book {
    @Pattern(regexp = "ISBN[0-9]+") //정규표현식
    private String bookId; //도서번호
    @Size(min = 4, max = 50)
    private String name; //도서명
    @Min(0)
    @Digits(integer = 8, fraction = 2)
    @NotNull
    private BigDecimal unitPrice; //단가
    private String author; //저자명
    private String description; //설명
    private String publisher; //출판사
    private String category; //분류
    private long unitsInStock; //재고량
    private String releaseDate; //출판일
    private String condition; //신규도서 or 중고도서 or eBook
    private String fileName; //도서 이미지 파일명
    private MultipartFile bookImage; //도서 이미지 파일
}
