package com.project.LinkC.controller;

import com.project.LinkC.model.Earnings;
import com.project.LinkC.service.EarningsService;
import com.project.LinkC.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class EarningsController {


    private EarningsService earningsService;

    @Autowired
    public void setEarningsService(EarningsService earningsService) {
        this.earningsService = earningsService;
    }

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this. productService =  productService;
    }


    @RequestMapping(value = "/earnings",method = RequestMethod.GET)
    public ModelAndView all() {
        ModelAndView modelAndView = new ModelAndView();
        List<Earnings> earnings = earningsService.getAll();
        modelAndView.setViewName("earnings");
        modelAndView.addObject("earningsList", earnings);
        return modelAndView;
    }

    @RequestMapping(value = "/editEarnings",method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam int id){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("editEarnings");
        modelAndView.addObject("earnings", earningsService.getById(id));
        modelAndView.addObject("products", productService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/saveEarnings", method =RequestMethod.POST)
    public String save(@ModelAttribute("earnings") Earnings earnings){
        earningsService.edit(earnings);
        return "redirect:/earnings";
    }

    @RequestMapping("/deleteEarnings")
    public String delete(@RequestParam int id) {
        earningsService.delete(id);
        return "redirect:/earnings";
    }

    @RequestMapping("/addEarnings")
    public String newCustomerForm(Map<String, Object> model) {
        Earnings earnings = new Earnings();
        model.put("earnings", earnings);
        model.put("products", productService.getAll());
        return "addEarnings";
    }
    @RequestMapping(value = "/bySort4",method = RequestMethod.GET)
    public ModelAndView bySort4() {
        ModelAndView modelAndView = new ModelAndView();
        List<Earnings> earnings = earningsService.getBySort4();
        modelAndView.setViewName("earnings");
        modelAndView.addObject("earningsList", earnings);
        return modelAndView;
    }
}
