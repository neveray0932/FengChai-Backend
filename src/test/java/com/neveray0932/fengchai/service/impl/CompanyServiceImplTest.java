package com.neveray0932.fengchai.service.impl;

import com.neveray0932.fengchai.common.Vo.ResultVO;
import com.neveray0932.fengchai.entity.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class CompanyServiceImplTest {
    @Autowired
    CompanyServiceImpl companyService;

    @Test
    public void method(){
        Company company = new Company();

        company.setCompName("尚義4");
        company.setCompContact("廉恥4");
        company.setCompAddress("台中市南區寒冰路9999333號");
        company.setCompCharge("禮義4");
        company.setCompMail("abcdef@gmail.com");
        company.setCompTaxNumber("12345678");

        ResultVO resultVO = companyService.compCreate(company);
        System.out.println(resultVO);
    }

    @Test
    public void method2(){
        Company company = new Company();
        company.setCompId(2);
        company.setCompName("尚義");
        company.setCompContact("廉恥1234567");

        company.setCompTaxNumber("12345678");
        ResultVO resultVO = companyService.compUpdate(company);
        System.out.println(resultVO);
    }

    @Test
    public void method3(){
        ResultVO resultVO = companyService.compDelete(1);
        System.out.println(resultVO);
    }

    @Test
    public void method4(){
        ResultVO resultVO = companyService.compFindAll();
        System.out.println(resultVO);
    }

}