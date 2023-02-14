package com.store.Controller;

import com.store.Model.Options;
import com.store.Repository.OptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/options")
public class OptionsController {

    private final OptionsRepository optionsRepository;

    @Autowired
    public OptionsController(OptionsRepository optionsRepository)   {
        this.optionsRepository = optionsRepository;
    }

    @GetMapping
    public List<Options> getAllOptions()    {
        return optionsRepository.findAll();
    }

    @GetMapping("{id}")
    public Options getOption(@PathVariable("id") Options option)  {
        return option;
    }
}
