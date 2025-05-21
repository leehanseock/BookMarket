package kr.ac.kopo.leehanseock.bookmarket.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kr.ac.kopo.leehanseock.bookmarket.domain.Book;
import kr.ac.kopo.leehanseock.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookIdValidator implements ConstraintValidator<BookId, String> {

    @Autowired
    private BookService bookService;

    @Override
    public void initialize(BookId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String bookId, ConstraintValidatorContext context) {
        Book book = null;
        try{
            book = bookService.getBookById(bookId);
        }catch (RuntimeException e){
            return true;
        }

        if (book != null) {
            return false; // 유효하지 않은 경우
        }

        return true; // 유효한 경우
    }
}
