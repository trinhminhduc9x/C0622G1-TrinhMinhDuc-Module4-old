package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvertServiceImpl implements ConvertService {
    @Override
    public float convert(float rate, float usd) {
        float vnd = rate * usd;
        return vnd ;
    }

    @Override
    public float convert(float usd) {
        float vnd = 22000 * usd;
        return vnd ;
    }


}
