package kr.ac.kopo.leehanseock.bookmarket.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import kr.ac.kopo.leehanseock.bookmarket.domain.Book;
import kr.ac.kopo.leehanseock.bookmarket.exception.BookIdException;
import kr.ac.kopo.leehanseock.bookmarket.exception.CategoryException;
import kr.ac.kopo.leehanseock.bookmarket.service.BookService;
import kr.ac.kopo.leehanseock.bookmarket.validator.BookValidator;
import kr.ac.kopo.leehanseock.bookmarket.validator.UnitsInStockValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Value("${file.uploadDir}")
    String fileDir;

//    @Autowired
//    private UnitsInStockValidator unitsInStockValidator;

    @Autowired
    private BookValidator bookValidator;

    @GetMapping
    public String requestBookList(Model model) {
        List<Book> bookList = bookService.getAllBookList();
        model.addAttribute("bookList",bookList);
        return "Books";
    }

    @GetMapping(value = "/all")
    public ModelAndView requestAllBookList() {
        ModelAndView modelV = new ModelAndView();
        modelV.setViewName("Books");
        List<Book> bookList = bookService.getAllBookList();
        modelV.addObject("bookList",bookList);
        return modelV;
    }

    @GetMapping("/book")
    public String requestBookById(@RequestParam("id") String bookId, Model model) {
        Book book = bookService.getBookById(bookId);
        model.addAttribute("book",book);
        return "Book";
    }

    @GetMapping("/{category}")
    public String requestBookByCategory(@PathVariable String category, Model model) {
        List<Book> booksByCategory = bookService.getBookListByCategory(category);
        if( booksByCategory == null || booksByCategory.isEmpty() ) {
            throw new CategoryException(category);
        }
        model.addAttribute("bookList",booksByCategory);
        return "Books";
    }

    @GetMapping("/filter/{bookFilter}")
    public String requestBookByFilter(@MatrixVariable(pathVar = "bookFilter") Map<String, List<String>> bookFilter, Model model) {
        Set <Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
        model.addAttribute("bookList",booksByFilter);
        return "Books";
    }

    @GetMapping("/add")
    public String requestAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/add")
    public String requestSubmitNewBook(@Valid @ModelAttribute Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addBook";
        }

        try {
            System.out.println("===== 파일 업로드 디버깅 =====");
            System.out.println("파일 디렉토리 경로: " + fileDir);

            // 디렉토리 존재 여부 확인
            File directory = new File(fileDir);
            System.out.println("디렉토리 절대 경로: " + directory.getAbsolutePath());
            System.out.println("디렉토리 존재 여부: " + directory.exists());
            System.out.println("디렉토리 쓰기 권한: " + directory.canWrite());

            // 디렉토리 생성 시도
            if (!directory.exists()) {
                boolean created = directory.mkdirs();
                System.out.println("디렉토리 생성 결과: " + created);
            }

            // 파일 정보 확인
            MultipartFile bookImage = book.getBookImage();
            if (bookImage == null) {
                System.out.println("업로드된 파일이 없습니다.");
                book.setFileName("no_image.jpg");
                bookService.setNewBook(book);
                return "redirect:/books";
            }

            System.out.println("파일 이름: " + bookImage.getOriginalFilename());
            System.out.println("파일 크기: " + bookImage.getSize() + " bytes");
            System.out.println("파일 타입: " + bookImage.getContentType());

            // 고유한 파일명 생성
            String originalFilename = bookImage.getOriginalFilename();
            String uniqueFileName = System.currentTimeMillis() + "_" + originalFilename;
            File saveFile = new File(directory, uniqueFileName);

            System.out.println("저장할 파일 경로: " + saveFile.getAbsolutePath());
            System.out.println("파일 저장 시도...");

            // 파일 저장
            bookImage.transferTo(saveFile);
            System.out.println("파일 저장 성공!");

            book.setFileName(uniqueFileName);
            bookService.setNewBook(book);
            return "redirect:/books";

        } catch (Exception e) {
            System.out.println("===== 오류 발생 =====");
            System.out.println("오류 메시지: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("도서 이미지 업로드가 실패했습니다: " + e.getMessage(), e);
        }
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("addTitle", "신규 도서 등록");
    }

    @GetMapping("/download")
    public void downloadBookImage(@RequestParam("file") String paramKey, HttpServletResponse response) throws IOException {
        File imageFile = new File(fileDir, paramKey);  // 자동으로 디렉토리 경로 + 파일명으로 합쳐줌
        response.setContentType("application/download");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + imageFile.getName() + "\"");
        response.setContentLength((int) imageFile.length());
        OutputStream os = response.getOutputStream();
        FileInputStream fis = new FileInputStream(imageFile);
        FileCopyUtils.copy(fis, os);
        fis.close();
        os.close();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        binder.setValidator(unitsInStockValidator);
        binder.setValidator(bookValidator);
        binder.setAllowedFields("bookId", "name", "unitPrice", "author", "description","publisher",
                "category", "unitsInStock", "releaseDate", "condition","bookImage");
    }

    @ExceptionHandler(value = {BookIdException.class})
    public ModelAndView handleException(HttpServletRequest request, BookIdException ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidBookId", ex.getBookId());
        mav.addObject("exception", ex.toString());
        mav.addObject("url", request.getRequestURL()+"?"+request.getQueryString());
        mav.setViewName("errorBook");
        return mav;
    }


}