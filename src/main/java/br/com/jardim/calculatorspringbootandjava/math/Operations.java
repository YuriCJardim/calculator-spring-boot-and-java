package br.com.jardim.calculatorspringbootandjava.math;

import org.springframework.stereotype.Service;

@Service
public class Operations {

    public Double sum(Double numberOne, Double numberTwo) {
        Double result = (numberOne) + (numberTwo);
        return result;
    }

    public Double sub(Double numberOne, Double numberTwo) {
        Double result = numberOne - numberTwo;
        return result;
    }

    public Double mult(Double numberOne, Double numberTwo) {
        Double result = numberOne * numberTwo;
        return result;
    }

    public Double div(Double numberOne, Double numberTwo) {
        Double result = numberOne / numberTwo;
        return result;
    }

    public Double mean(Double numberOne, Double numberTwo) {
        Double result = (numberOne + numberTwo)/2;
        return result;
    }

    public Double sqr(Double numberOne){            
        Double result = Math.sqrt(numberOne);
        return result;
    }

}
