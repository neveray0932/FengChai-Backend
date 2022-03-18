package com.neveray0932.fengchai.service.impl;

import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    CustomerServiceImpl customerService;

    @Test
    public void method(){
        Customer customer = new Customer();
        customer.setCustName("阿軌");
        customer.setCustCharge("阿董");
        customer.setCustContact("阿狗");
        customer.setCustAddress("胎北市");
        customer.setCustMail("aertfg@gmail.com");
        customer.setCustPhone("1234567890");
        customer.setCustTaxNumber("12345678");
        customer.setCustContact("阿8");
        ResultVO resultVO = customerService.custCreate(customer);
        System.out.println("resultVO = " + resultVO);
    }

    @Test
    public void method2(){
        Customer customer = new Customer();
        customer.setCustId(1);
        customer.setCustName("阿軌111");
        customer.setCustCharge("阿董123");
        customer.setCustContact("阿狗1");
        customer.setCustAddress("胎北市4");
        customer.setCustMail("aertfg242@gmail.com");
        customer.setCustPhone("1234567890");
        customer.setCustTaxNumber("12345678");
        customer.setCustContact("阿888");
        ResultVO resultVO = customerService.custUpdate(customer);
        System.out.println("resultVO = " + resultVO);
    }

    @Test
    public void method3(){
        ResultVO resultVO = customerService.custDelete(1);
        System.out.println("resultVO = " + resultVO);
    }
    @Test
    public void method4(){
        ResultVO resultVO = customerService.custFindAll();
        System.out.println(resultVO);
    }

    @Test
    void custPagination() {
        ResultVO resultVO = customerService.custPagination(1, 4, "");
        System.out.println("resultVO = " + resultVO);
    }
}