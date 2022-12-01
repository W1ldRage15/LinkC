package com.project.LinkC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.project.LinkC.model.Consumer;
import com.project.LinkC.service.ConsumerService;

import java.util.List;
import java.util.Map;

@Controller

public class ConsumerController {

    private ConsumerService consumerService;

    @Autowired
    public void setClientService(ConsumerService consumerService) {

        this.consumerService = consumerService;
    }

    @RequestMapping(value = "/consumer",method = RequestMethod.GET)
    public ModelAndView allClients() {
        ModelAndView modelAndView = new ModelAndView();
        List<Consumer> consumers=consumerService.getAll();
        modelAndView.setViewName("consumer");
        modelAndView.addObject("consumerList", consumers);
        return modelAndView;
    }

    @RequestMapping(value = "/editConsumer",method = RequestMethod.GET)
    public ModelAndView editPage(@RequestParam int id){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("editConsumer");
        modelAndView.addObject("consumer", consumerService.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/saveConsumer", method =RequestMethod.POST)
    public String save(@ModelAttribute("consumer") Consumer consumer){
        consumerService.edit(consumer);
        return "redirect:/consumer";
    }

    @RequestMapping("/deleteConsumer")
    public String deleteCustomerForm(@RequestParam int id) {
        consumerService.delete(id);
        return "redirect:/consumer";
    }

    @RequestMapping("/addConsumer")
    public String newCustomerForm(Map<String, Object> model) {
        Consumer consumer = new Consumer();
        model.put("consumer", consumer);
        return "addConsumer";
    }
    @RequestMapping(value = "/bySort2",method = RequestMethod.GET)
    public ModelAndView bySort2() {
        ModelAndView modelAndView = new ModelAndView();
        List<Consumer> consumers= consumerService.gerBySort2();
        modelAndView.setViewName("consumer");
        modelAndView.addObject("consumerList", consumers);
        return modelAndView;
    }
}
