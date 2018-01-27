package cn.rpm.goods.provider;

import cn.rpm.goods.bean.Goods;
import cn.rpm.goods.exception.IlegalParamsException;
//import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by renpiming on 2018/1/1.
 */
@Controller
@RequestMapping(value = "/goods")
public class PageController {
    //实验freemarker模版
//    @ApiOperation(value = "page1", notes = "使用ModelMap绑定返回数据的页面",httpMethod = "GET")
    @RequestMapping(value = "/page1")
    public String page1(HttpServletRequest request,ModelMap modelMap) {
        request.getSession().setAttribute("session","value");
        String session = request.getSession().getAttribute("session").toString();
        Goods goods = new Goods();
        goods.setId(365);
        goods.setType("图书");
        modelMap.addAttribute("goods",goods);
        modelMap.addAttribute("session",session);
        return "goods/goods";
    }
//    @ApiOperation(value = "page2", notes = "使用ModelAndView绑定返回数据的页面",httpMethod = "GET")
    @RequestMapping(value = "/page2")
    public ModelAndView page2(ModelAndView modelAndView) {

        Goods goods = new Goods();
        goods.setId(365);
        goods.setType("图书");
        modelAndView.addObject("goods",goods);
        modelAndView.setViewName("goods/goods");
        return modelAndView;
    }
//    @ApiOperation(value = "page3", notes = "验证统一异常处理的方法",httpMethod = "GET")
    @RequestMapping(value = "/page3")
    public String page3(@RequestParam String ex, ModelMap modelMap) throws IlegalParamsException{

        if(ex.equals("ex")){
            throw new IlegalParamsException("page3 params ilegal");
        }
        Goods goods = new Goods();
        goods.setId(876);
        goods.setType("图书");
        modelMap.addAttribute("goods",goods);
        return "goods/goods";
    }
}
