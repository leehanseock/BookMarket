package kr.ac.kopo.leehanseock.bookmarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//카테고리를 찾을 수 없을 때 발생하는 예외를 처리하기 위한 클래스
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CategoryException extends RuntimeException{

    private String errorMessage;

    public CategoryException() {
        super();
        errorMessage = "요청한 도서 카테고리를 찾을 수 없습니다.";
        System.out.println(errorMessage);
    }
}
