package com.natan.startup;

import com.natan.startup.exceptions.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class MathController {
    private  final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(@PathVariable(value="numberOne") String numberOne,
                      @PathVariable(value="numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsuportedMathOperationException("Please set a numeric value");

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sub(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsuportedMathOperationException("Please set a numeric value");

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double div(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsuportedMathOperationException("Please set a numeric value");

        return (convertToDouble(numberOne) / convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double mult(@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsuportedMathOperationException("Please set a numeric value");

        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/avg/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double avg(@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsuportedMathOperationException("Please set a numeric value");

        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    @RequestMapping(value = "/sqrt/{number}", method=RequestMethod.GET)
    public Double sqrt(@PathVariable(value = "number") String number) throws Exception {
        if(!isNumeric(number))
            throw new UnsuportedMathOperationException("Please set a numeric value");

        return Math.sqrt(convertToDouble(number));
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null ) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) {
            return Double.parseDouble(number);
        }
        return 0D;
    }

    private boolean isNumeric (String strNumber) {
        if (strNumber == null ) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
