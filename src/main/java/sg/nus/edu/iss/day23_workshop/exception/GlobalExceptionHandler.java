package sg.nus.edu.iss.day23_workshop.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler(HttpServerErrorException.class) // captures server exceptions
    // public ModelAndView handleHttpServerErrorException(HttpServerErrorException ex,
    //         HttpServletRequest request) {

    //     return new ModelAndView("error.html").addObject("errorMessage",
    //             new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), ex.getMessage(), request.getRequestURI())
    //             );
    // }

    // @ExceptionHandler(IncorrectResultSizeDataAccessException.class) // captures server exceptions
    // public ModelAndView handleIncorrectResultSizeDataAccessException(IncorrectResultSizeDataAccessException ex,
    //         HttpServletRequest request) {

    //     return new ModelAndView("error.html").addObject("errorMessage",
    //             new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), ex.getMessage(), request.getRequestURI())
    //             );
    // }

    // @ExceptionHandler(DataAccessException.class)
    // public ModelAndView handleDataAccessException(DataAccessException ex,
    //         HttpServletRequest request) {

    //     return new ModelAndView("error.html").addObject("errorMessage",
    //             new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), ex.getMessage(), request.getRequestURI())
    //             );
    // }

    @ExceptionHandler(OrderNotFoundException.class)
    public ModelAndView handleOrderNotFoundException(OrderNotFoundException ex, HttpServletRequest request) {
        return new ModelAndView("error.html").addObject("errorMessage", 
        new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), ex.getMessage(), request.getRequestURI()));
    }
}
