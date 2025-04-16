package kr.ac.kopo.leehanseock.bookmarket.service;

import kr.ac.kopo.leehanseock.bookmarket.domain.Book;
import kr.ac.kopo.leehanseock.bookmarket.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService{

    @Autowired //BookRepository 객체를 new로 생성하지 않더라도 자동으로 만들어놓았던걸 주입받을 수 있도록 하는 어노테이션
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBookList() {
        return bookRepository.getAllBookList();
    }

    @Override
    public Book getBookById(String bookId) {
        Book book = bookRepository.getBookById(bookId);
        return book;
    }

    @Override
    public List<Book> getBookListByCategory(String category) {
        List<Book> booksByCategory = bookRepository.getBookListByCategory(category);
        return booksByCategory;
    }

}
