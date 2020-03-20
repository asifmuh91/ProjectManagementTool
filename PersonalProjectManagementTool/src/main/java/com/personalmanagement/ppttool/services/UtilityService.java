package com.personalmanagement.ppttool.services;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

@Service
public class UtilityService {

    public Map<String, String> fieldErrorValidation(BindingResult result){
        Map<String, String> err = new HashMap<>();
        result.getFieldErrors().forEach(x -> {
            err.put(x.getField(),x.getDefaultMessage());
        });

        return err;
    }


}
