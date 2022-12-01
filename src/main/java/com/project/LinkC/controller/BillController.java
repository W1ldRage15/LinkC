package com.project.LinkC.controller;

import com.project.LinkC.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.project.LinkC.model.Bill;
import com.project.LinkC.service.BillService;
import com.project.LinkC.service.ConsumerService;

import java.util.List;
import java.util.Map;

@Controller
public class BillController {


    private BillService billService;

    @Autowired
    public void setBillService(BillService billService) {
        this.billService = billService;
    }


    private ConsumerService consumerService;


    @Autowired
    public void setConsumerService(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/bill",method = RequestMethod.GET)
    public ModelAndView all() {
        ModelAndView modelAndView = new ModelAndView();
        List<Bill> bills= billService.getAll();
        modelAndView.setViewName("bill");
        modelAndView.addObject("billList", bills);
        return modelAndView;
    }

    @RequestMapping(value = "/editBill",method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam int id){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("editBill");
        modelAndView.addObject("bill", billService.getById(id));
        modelAndView.addObject("products",productService.getAll());
        modelAndView.addObject("consumers",consumerService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/saveBill", method =RequestMethod.POST)
    public String save(@ModelAttribute("bill") Bill bill){
        billService.edit(bill);
        return "redirect:/bill";
    }

    @RequestMapping("/deleteBill")
    public String delete(@RequestParam int id) {
        billService.delete(id);
        return "redirect:/bill";
    }

    @RequestMapping("/addBill")
    public String add(Map<String, Object> model) {
        Bill bill = new Bill();
        model.put("bill", bill);
        model.put("products",productService.getAll());
        model.put("consumers",consumerService.getAll());
        return "addBill";
    }
    @RequestMapping(value = "/bySort3",method = RequestMethod.GET)
    public ModelAndView bySort3() {
        ModelAndView modelAndView = new ModelAndView();
        List<Bill> bills= billService.getBySort3();
        modelAndView.setViewName("bill");
        modelAndView.addObject("billList", bills);
        return modelAndView;
    }
}
