package com.project.LinkC.controller;

import com.project.LinkC.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.project.LinkC.model.Stock;
import com.project.LinkC.service.StockService;
import com.project.LinkC.service.ProducerService;
import com.project.LinkC.model.Product;

import java.util.List;
import java.util.Map;

@Controller

public class StockController {
    private ProductService productService;



    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    private StockService stockService;

    @Autowired
    public void setComponentService(StockService stockService) {
        this.stockService = stockService;
    }

    @RequestMapping(value = "/stock",method = RequestMethod.GET)
    public ModelAndView all() {
        ModelAndView modelAndView = new ModelAndView();
        List<Stock> stocks=stockService.getAll();
        modelAndView.setViewName("stock");
        modelAndView.addObject("stockList", stocks);
        modelAndView.addObject ("sum",productService.getQuanBySum());
        return modelAndView;
    }

    @RequestMapping(value = "/editStock",method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam int id){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("editStock");
        modelAndView.addObject("stock", stockService.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/saveStock", method =RequestMethod.POST)
    public String save(@ModelAttribute("stock") Stock stock){
        stockService.edit(stock);
        return "redirect:/stock";
    }

    @RequestMapping("/deleteStock")
    public String delete(@RequestParam int id) {
        stockService.delete(id);
        return "redirect:/stock";
    }

    @RequestMapping(value = "/maxQuan",method = RequestMethod.GET)
    public ModelAndView maxQuan(){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("maxQuan");
        modelAndView.addObject("product",productService.getProductByMaxQuantity());
        return modelAndView;
    }
    @RequestMapping(value = "/minQuan",method = RequestMethod.GET)
    public ModelAndView minQuan(){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("minQuan");
        modelAndView.addObject("product",productService.getProductByMinQuantity());
        return modelAndView;
    }
    @RequestMapping("/addStock")
    public String add(Map<String, Object> model) {
        Stock stocks = new Stock();
        model.put("stocks", stocks);
        return "addStock";
    }
    @RequestMapping(value = "/bySort6",method = RequestMethod.GET)
    public ModelAndView bySort6() {
        ModelAndView modelAndView = new ModelAndView();
        List<Stock> stocks=stockService.getBySort6();
        modelAndView.setViewName("stock");
        modelAndView.addObject("stockList", stocks);
        modelAndView.addObject ("sum",productService.getQuanBySum());
        return modelAndView;
    }
}
