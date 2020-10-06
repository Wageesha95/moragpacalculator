package com.myapps.moragpacalculatorserver.controller;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import com.myapps.moragpacalculatorserver.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AdminController {

    @Autowired
    private  ModuleService moduleService;

    @PostMapping("/modules")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<Module> addNewModule(@RequestBody Module module) {
        return moduleService.addNewModule(module);
    }

}
