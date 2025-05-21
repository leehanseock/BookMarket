package kr.ac.kopo.leehanseock.bookmarket.domain;

import jakarta.validation.constraints.*;
import kr.ac.kopo.leehanseock.bookmarket.validator.BookId;
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
    @Pattern(regexp = "ISBN[0-9]+", message="{Pattern.book.bookId}") //정규표현식
    @BookId //도서ID
    private String bookId; //도서ID

    @Size(min = 4, max = 50, message="{Size.book.name}")
    private String name; //도서명

    @Min(value=0, message="{Min.book.UnitPrice}")
    @Digits(integer = 8, fraction = 2, message="{Digits.book.UnitPrice}")
    @NotNull(message="{NotNull.book.UnitPrice}")
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
