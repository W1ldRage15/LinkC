package com.project.LinkC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.project.LinkC.model.Producer;
import com.project.LinkC.service.ProducerService;

import java.util.List;
import java.util.Map;

@Controller
public class ProducerController {

    private ProducerService producerService;

    @Autowired
    public void setClientService(ProducerService producerService) {
        this.producerService = producerService;
    }

    @RequestMapping(value = "/producer",method = RequestMethod.GET)
    public ModelAndView allProducers() {
        ModelAndView modelAndView = new ModelAndView();
        List<Producer> producers=producerService.getAll();
        modelAndView.setViewName("producer");
        modelAndView.addObject("producerList", producers);
        return modelAndView;
    }

    @RequestMapping(value = "/editProducer",method = RequestMethod.GET)
    public ModelAndView editPage(@RequestParam int id){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("editProducer");
        modelAndView.addObject("producer", producerService.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/saveProducer", method =RequestMethod.POST)
    public String save(@ModelAttribute("producer") Producer producer){
        producerService.edit(producer);
        return "redirect:/producer";
    }

    @RequestMapping("/deleteProducer")
    public String deleteCustomerForm(@RequestParam int id) {
        producerService.delete(id);
        return "redirect:/producer";
    }


    @RequestMapping("/addProducer")
    public String newCustomerForm(Map<String, Object> model) {
        Producer producer = new Producer();
        model.put("producer", producer);
        return "addProducer";
    }
    @RequestMapping(value = "/bySort1",method = RequestMethod.GET)
    public ModelAndView bySort1() {
        ModelAndView modelAndView = new ModelAndView();
        List<Producer> producers= producerService.getBySort1();
        modelAndView.setViewName("producer");
        modelAndView.addObject("producerList", producers);
        return modelAndView;
    }
}
