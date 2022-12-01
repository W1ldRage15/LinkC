package com.project.LinkC.controller;

import com.project.LinkC.model.Bill;
import com.project.LinkC.model.Earnings;
import com.project.LinkC.model.Transport;
import com.project.LinkC.repository.TransportRepository;
import com.project.LinkC.service.BillService;
import com.project.LinkC.service.EarningsService;
import com.project.LinkC.service.ProductService;
import com.project.LinkC.service.TransportService;
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
public class TransportController {

    private BillService billService;

    @Autowired
    public void setBillService(BillService billService) {
        this.billService = billService;
    }

    private TransportService transportService;

    @Autowired
    public void setTransportService(TransportService transportService) {
        this.transportService = transportService;
    }

    @RequestMapping(value = "/transport",method = RequestMethod.GET)
    public ModelAndView all() {
        ModelAndView modelAndView = new ModelAndView();
        List<Transport> transports = transportService.getAll();
        modelAndView.setViewName("transport");
        modelAndView.addObject("transportList", transports);
        modelAndView.addObject ("total",billService.getBySumTotal());
        return modelAndView;
    }

    @RequestMapping(value = "/editTransport",method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam int id){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("editTransport");
        modelAndView.addObject("transport", transportService.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/saveTransport", method =RequestMethod.POST)
    public String save(@ModelAttribute("transport") Transport transport){
        transportService.edit(transport);
        return "redirect:/transport";
    }

    @RequestMapping("/deleteTransport")
    public String delete(@RequestParam int id) {
        transportService.delete(id);
        return "redirect:/transport";
    }

    @RequestMapping("/addTransport")
    public String newCustomerForm(Map<String, Object> model) {
        Transport transport = new Transport();
        model.put("transport", transport);
        return "addTransport";
    }
    @RequestMapping(value = "/bySort7",method = RequestMethod.GET)
    public ModelAndView bySort7() {
        ModelAndView modelAndView = new ModelAndView();
        List<Transport> transports = transportService.getBySort7();
        modelAndView.setViewName("transport");
        modelAndView.addObject("transportList", transports);
        modelAndView.addObject ("total",billService.getBySumTotal());
        return modelAndView;
    }
}
