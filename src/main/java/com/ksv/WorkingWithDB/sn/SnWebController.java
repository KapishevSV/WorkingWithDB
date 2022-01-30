package com.ksv.WorkingWithDB.sn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class SnWebController {
    @Autowired
    private final SnService snService;

    public SnWebController(SnService snService) {
        this.snService = snService;
    }

    @GetMapping("main_")
    public String main(@RequestParam(required = false, defaultValue = "") String name, Model model){
        Iterable<SnModel> snModels;

        if(name != null && !name.isEmpty()){
            snModels = snService.findByName(name);
        } else {
            snModels = snService.findAll();
        }

        model.addAttribute("snModels", snModels);
        model.addAttribute("name", name);

        return "main_";
    }

    @GetMapping("main")
    public String main1(@RequestParam(required = false, defaultValue = "") String sn, Model model){
        Iterable<SnModel> snModels;

        if(sn != null && !sn.isEmpty()){
            snModels = snService.findBySn(Integer.valueOf(sn));
        } else {
            snModels = snService.findAll();
        }

        model.addAttribute("snModels", snModels);
        model.addAttribute("sn", sn);

        return "main";
    }

    @GetMapping("search_count")
    public String searchCount(@RequestParam(required = false, defaultValue = "") String name,
                              @RequestParam(required = false, defaultValue = "") String sn,
                              Model model){
        Iterable<SnModel> snModels;

        try {
            snModels = snService.findByNameAndSn(name, Integer.valueOf(sn));
        } catch(NumberFormatException e){
            snModels = snService.findByNameContaining(name);
        }

        model.addAttribute("snModels", snModels);
        model.addAttribute("name", name);
        model.addAttribute("sn", sn);

        return "search_count";
    }

    @PostMapping("search_count")
    public String add(
            @RequestParam String addSn,
            @RequestParam String addName,
            Map<String, Object> model){
        //SnModel snModel = new SnModel(Integer.valueOf(addSn), addName);
        //snRepo.save(snModel);
        snService.insertNewCounter(Integer.valueOf(addSn), addName);

        Iterable<SnModel> snModels = snService.findAll();
        model.put("snModels", snModels);

        return "search_count";
    }
}
