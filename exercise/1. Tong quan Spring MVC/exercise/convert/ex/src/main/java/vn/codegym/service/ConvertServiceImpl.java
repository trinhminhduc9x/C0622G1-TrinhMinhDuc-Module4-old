package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvertServiceImpl implements ConvertService {
    @Override
    public double convert(double rate, double usd) {
        return rate*usd ;
    }

    @Override
    public double convert(double usd) {
        return usd*22000 ;
    }


}
