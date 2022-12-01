package com.project.LinkC.controller;

import com.project.LinkC.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.project.LinkC.model.Product;
import com.project.LinkC.service.ConsumerService;
import com.project.LinkC.service.ProductService;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    private ProductService productService;

    private ProducerService producerService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setClientService(ProducerService producerService) {
        this.producerService = producerService;
    }

    @RequestMapping(value = "/product",method = RequestMethod.GET)
    public ModelAndView allProducts() {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products= productService.getAll();
        modelAndView.setViewName("product");
        modelAndView.addObject("productList", products);
        return modelAndView;
    }

    @RequestMapping(value = "/editProduct",method = RequestMethod.GET)
    public ModelAndView editProduct(@RequestParam int id){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("editProduct");
        modelAndView.addObject("product", productService.getById(id));
        modelAndView.addObject("producers",producerService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/saveProduct", method =RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.edit(product);
        return "redirect:/product";
    }

    @RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestParam int id) {
       productService.delete(id);
        return "redirect:/product";
    }

    @RequestMapping("/addProduct")
    public String addProduct(Map<String, Object> model) {
        Product product = new Product();
        model.put("product", product);
        model.put("producers",producerService.getAll());
        return "addProduct";
    }
    @RequestMapping(value = "/bySort",method = RequestMethod.GET)
    public ModelAndView bySort() {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products= productService.getBySort();
        modelAndView.setViewName("product");
        modelAndView.addObject("productList", products);
        return modelAndView;
    }
}
