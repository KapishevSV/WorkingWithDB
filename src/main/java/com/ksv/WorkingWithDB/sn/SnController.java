package com.ksv.WorkingWithDB.sn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SnController {
    @Autowired
    private SnRepo snRepo;

    public SnController(SnRepo snRepo) {
        this.snRepo = snRepo;
    }

    @GetMapping("main_")
    public String main(@RequestParam(required = false, defaultValue = "") String name, Model model){
        Iterable<SnModel> snModels;

        if(name != null && !name.isEmpty()){
            snModels = snRepo.findByName(name);
        } else {
            snModels = snRepo.findAll();
        }

        model.addAttribute("snModels", snModels);
        model.addAttribute("name", name);

        return "main_";
    }

    @GetMapping("main")
    public String main1(@RequestParam(required = false, defaultValue = "") String sn, Model model){
        Iterable<SnModel> snModels;

        if(sn != null && !sn.isEmpty()){
            snModels = snRepo.findBySn(Integer.valueOf(sn));
        } else {
            snModels = snRepo.findAll();
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
            snModels = snRepo.findByNameAndSn(name, Integer.valueOf(sn));
        } catch(NumberFormatException e){
            snModels = snRepo.findByNameContaining(name);
        }

        model.addAttribute("snModels", snModels);
        model.addAttribute("name", name);
        model.addAttribute("sn", sn);

        return "search_count";
    }
}
