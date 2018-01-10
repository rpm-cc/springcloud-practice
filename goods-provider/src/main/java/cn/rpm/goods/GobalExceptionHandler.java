package cn.rpm.goods;

import cn.rpm.goods.exception.IlegalParamsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by renpiming on 2018/1/1.
 */

@ControllerAdvice
public class GobalExceptionHandler {

    @ExceptionHandler(value = IlegalParamsException.class)
    public ModelAndView pageNotFound(HttpServletRequest request,IlegalParamsException e){

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName("errorpage");
        return mav;

    }
}
