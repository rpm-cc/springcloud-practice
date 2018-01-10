package cn.rpm.goods;

import cn.rpm.goods.exception.IlegalParamsException;
import cn.rpm.goods.exception.RestIlegalParamsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by renpiming on 2018/1/1.
 */

@RestControllerAdvice
public class GobalRestExceptionHandler {
    @ExceptionHandler(value = RestIlegalParamsException.class)
    public String pageNotFound(HttpServletRequest request,RestIlegalParamsException e){


        return e.getMessage();

    }
}
