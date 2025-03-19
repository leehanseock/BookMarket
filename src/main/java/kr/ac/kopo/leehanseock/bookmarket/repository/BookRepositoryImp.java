package kr.ac.kopo.leehanseock.bookmarket.repository;

import kr.ac.kopo.leehanseock.bookmarket.domain.Book;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImp implements BookRepository/*인터페이스 상속*/ {
    private List<Book> listOfBooks = new ArrayList<Book>();

    public BookRepositoryImp() {
        Book book1 = new Book();
        book1.setBookId("ISBN1140711962");
        book1.setName("스프링 부트 완전정복");
        book1.setUnitPrice(new BigDecimal(35000));
        book1.setAuthor("송미영");
        book1.setDescription("스프링 부트는 스프링을 기반으로 쉽고 빠르게 웹 애플리케이션을 개발할 수 있는 도구이다. " +
                        "이 책에서는 스프링 부트의 기본 개념을 쉽게 이해하고 다양한 실습 예제로 빠르게 익힐 수 있다. " +
                        "그리고 단계별 실습을 따라 하다 보면 도서 쇼핑몰 구축 프로젝트를 완성할 수 있다. " +
                        "개념-실습-프로젝트의 3단계 학습으로 스프링 부트를 제대로 익힌다면 개발 시간을 단축하고 생산성을 높일 수 있는 개발자로 성장할 수 있다.");
        book1.setPublisher("길벗캠퍼스");
        book1.setCategory("IT 모바일");
        book1.setUnitsInStock(21);
        book1.setReleaseDate("2024/12/31");
        book1.setCondition("신규도서");

        Book book2 = new Book();
        book2.setBookId("ISBN1130661768");
        book2.setName("최고의 상술");
        book2.setUnitPrice(new BigDecimal(18000));
        book2.setAuthor("권원강");
        book2.setDescription("대한민국에서 폐점율이 가장 낮은 요식업 프랜차이즈, 가맹점 매출 1위 브랜드, " +
                "프랜차이즈 업계 최초로 코스피에 직상장한 기업, 안 먹어본 사람은 없고 한 번 먹어본 사람도 없는 국민 단골 브랜드… " +
                "바로 ‘간장치킨’의 원조이자 ‘허니콤보’의 신화 ‘교촌치킨’ 이야기다. 이 책은 교촌치킨 창업주 권원강 회장이 최초로 직접 공개한 교촌의 성공 비결을 낱낱이 담아냈다.");
        book2.setPublisher("다산북스");
        book2.setCategory("경제 경영");
        book2.setUnitsInStock(22);
        book2.setReleaseDate("2025/03/03");
        book2.setCondition("중고도서");

        Book book3 = new Book();
        book3.setBookId("ISBN9791162243077");
        book3.setName("모던 자바 인 액션");
        book3.setUnitPrice(new BigDecimal(42000));
        book3.setAuthor("라울-가브리엘 우르마");
        book3.setDescription("이 책은 최신 자바 기능과 실무에서 자주 사용하는 패턴을 중심으로, 자바를 현대적으로 활용하는 방법을 안내한다. "
                + "스트림 API, 람다 표현식, 병렬 프로그래밍 등 최신 기법을 풍부한 예제와 함께 설명하여 실무에서 바로 활용할 수 있는 통찰을 제공한다.");
        book3.setPublisher("한빛미디어");
        book3.setCategory("IT 모바일");
        book3.setUnitsInStock(10);
        book3.setReleaseDate("2023/08/15");
        book3.setCondition("신규도서");

        listOfBooks.add(book1);
        listOfBooks.add(book2);
        listOfBooks.add(book3);
    }

    @Override
    public List<Book> getAllBookList() {
        return listOfBooks;
    }
}
