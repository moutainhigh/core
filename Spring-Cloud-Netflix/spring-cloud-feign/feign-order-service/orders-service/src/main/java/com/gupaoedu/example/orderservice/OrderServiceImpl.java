package com.gupaoedu.example.orderservice;

import com.gupaoedu.example.OrderService;
import com.gupaoedu.example.dto.OrderDto;
import org.springframework.web.bind.annotation.RestController;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@RestController
public class OrderServiceImpl implements OrderService{

    @Override
    public String orders() {
        return "Return All Orders";
    }

    @Override
    public int insert(OrderDto dto) {
        return 0;
    }
}
