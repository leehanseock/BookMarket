package kr.ac.kopo.leehanseock.bookmarket.repository;

import kr.ac.kopo.leehanseock.bookmarket.domain.Book;

import java.util.List;


public interface BookRepository {
    List<Book> getAllBookList();
}
