package cn.rpm.goods.provider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by renpiming on 2017/12/14.
 */
@RestController
@RequestMapping(value = "goods")
public class BooksController {

    @RequestMapping(value = "book")
    public String Books(){

        return "this book";
    }

}
