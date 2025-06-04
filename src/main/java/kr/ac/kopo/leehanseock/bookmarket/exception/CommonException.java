package kr.ac.kopo.leehanseock.bookmarket.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonException {
    @ExceptionHandler(value = CategoryException.class)
    private ModelAndView handleException(CategoryException e, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e.toString());
        modelAndView.setViewName("errorCommon");
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.addObject("category", e.getCategory());
        modelAndView.addObject("errorMessage", e.getErrorMessage());
        return modelAndView;

    }
}
