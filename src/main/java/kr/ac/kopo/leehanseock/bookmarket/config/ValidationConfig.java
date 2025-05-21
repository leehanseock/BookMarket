package kr.ac.kopo.leehanseock.bookmarket.config;

import kr.ac.kopo.leehanseock.bookmarket.validator.BookValidator;
import kr.ac.kopo.leehanseock.bookmarket.validator.UnitsInStockValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationConfig {
    @Autowired
    UnitsInStockValidator unitsInStockValidator;
    @Bean
    public BookValidator bookValidator(){
        BookValidator bookValidator = new BookValidator();
        bookValidator.springValidators.add(unitsInStockValidator);
        return bookValidator;
    }
}
