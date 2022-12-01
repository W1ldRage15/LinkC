package com.project.LinkC.controller;

import com.project.LinkC.model.Incoming;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.project.LinkC.service.IncomingService;
import com.project.LinkC.service.ConsumerService;
import com.project.LinkC.service.ProductService;

import java.util.List;
import java.util.Map;

@Controller
public class IncomingController {


    private IncomingService incomingService;

    @Autowired
    public void setApplicationService(IncomingService incomingService) {
        this.incomingService = incomingService;
    }

    private ProductService productService;

    @Autowired
    public void setRefrigeratorService(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping(value = "/incoming",method = RequestMethod.GET)
    public ModelAndView all() {
        ModelAndView modelAndView = new ModelAndView();
        List<Incoming> incomings = incomingService.getAll();
        modelAndView.setViewName("incoming");
        modelAndView.addObject("incomingList", incomings);
        return modelAndView;
    }

    @RequestMapping(value = "/editIncoming",method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam int id){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("editIncoming");
        modelAndView.addObject("incoming", incomingService.getById(id));
        modelAndView.addObject("products",productService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/saveIncoming", method =RequestMethod.POST)
    public String save(@ModelAttribute("incoming") Incoming incoming){
        incomingService.edit(incoming);
        return "redirect:/incoming";
    }

    @RequestMapping("/deleteIncoming")
    public String delete(@RequestParam int id) {
        incomingService.delete(id);
        return "redirect:/incoming";
    }

    @RequestMapping("/addIncoming")
    public String newCustomerForm(Map<String, Object> model) {
        Incoming incoming = new Incoming();
        model.put("incoming", incoming);
        model.put("products",productService.getAll());
        return "addIncoming";
    }
    @RequestMapping(value = "/bySort5",method = RequestMethod.GET)
    public ModelAndView bySort5() {
        ModelAndView modelAndView = new ModelAndView();
        List<Incoming> incomings = incomingService.getBySort5();
        modelAndView.setViewName("incoming");
        modelAndView.addObject("incomingList", incomings);
        return modelAndView;
    }
}
