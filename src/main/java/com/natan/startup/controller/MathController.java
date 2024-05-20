package com.natan.startup.controller;
import com.natan.startup.util.converter.NumberConverter;
import com.natan.startup.exception.ResourceNotFoundException;
import com.natan.startup.util.math.MathOps;

import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(@PathVariable(value="numberOne") String numberOne,
                      @PathVariable(value="numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new ResourceNotFoundException("Please set a numeric value");
        Double[] arrNumbers = {
                NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo)
        };
        return MathOps.sum(arrNumbers);
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sub(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new ResourceNotFoundException("Please set a numeric value");
        Double[] arrNumbers = {
                NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo)
        };
        return MathOps.sub(arrNumbers);
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double div(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new ResourceNotFoundException("Please set a numeric value");
        Double[] arrNumbers = {
                NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo)
        };
        return MathOps.div(arrNumbers);
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double mult(@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new ResourceNotFoundException("Please set a numeric value");
        Double[] arrNumbers = {
                NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo)
        };
        return MathOps.mtp(arrNumbers);
    }

    @RequestMapping(value = "/avg/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double avg(@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new ResourceNotFoundException("Please set a numeric value");
        Double[] arrNumbers = {
                NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo)
        };
        return MathOps.avg(arrNumbers);
    }

    @RequestMapping(value = "/sqrt/{number}", method=RequestMethod.GET)
    public Double sqrt(@PathVariable(value = "number") String number) throws Exception {
        if(!NumberConverter.isNumeric(number))
            throw new ResourceNotFoundException("Please set a numeric value");

        return Math.sqrt(NumberConverter.convertToDouble(number));
    }
}
