package com.tt.controller;

import com.tt.service.Orchestration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.tt.util.Constants.*;

@RestController
@RequestMapping(CAS)
public class CASApiResource {

    @Autowired
    private Orchestration orchestration;
    @PostMapping
    public Object create(@RequestBody Object request){
        return orchestration.orchestrate(request, POST);
    }

    @PatchMapping
    public Object update(@RequestBody Object request){
        return orchestration.orchestrate(request,PATCH);
    }
}
