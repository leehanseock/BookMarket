package kr.ac.kopo.leehanseock.bookmarket.exception;


public class BookIdException extends RuntimeException {
    private String bookId;
    private String errorMessage;
    public BookIdException(String bookId) {
        super();
        errorMessage = "요청한 도서 카테고리를 찾을 수 없습니다.";
        this.bookId = bookId;
    }
    public String getBookId() {
        this.bookId= bookId;
        return bookId;
    }
}
