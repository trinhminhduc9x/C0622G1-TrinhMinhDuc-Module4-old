package vn.codegym.service;

import org.springframework.stereotype.Service;


@Service
public class CalculatorServiceImpl implements CalculatorService {


    @Override
    public int calculate(int firstOperand, int secondOperand, char operator) {

        switch (operator){
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '/':
                if(secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can't divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }


}
