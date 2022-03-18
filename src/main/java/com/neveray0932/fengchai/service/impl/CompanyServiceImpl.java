package com.neveray0932.fengchai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neveray0932.fengchai.common.dto.company.CompanyCreateDto;
import com.neveray0932.fengchai.common.dto.company.CompanyFindOneDto;
import com.neveray0932.fengchai.common.dto.company.CompanyUpdateDto;
import com.neveray0932.fengchai.common.dto.DTOEntity;
import com.neveray0932.fengchai.common.vo.ResultMsg;
import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.common.utils.DtoUtils;
import com.neveray0932.fengchai.entity.Company;
import com.neveray0932.fengchai.mapper.CompanyMapper;
import com.neveray0932.fengchai.service.ICompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {


    @Override
    public ResultVO compCreate(Company company) {



        boolean save = save(company);

//        QueryWrapper<Company> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(Company::getCompName,company.getCompName());
//        Company one = getOne(queryWrapper);

        DTOEntity dtoEntity = new DtoUtils().convertToDto(company, new CompanyCreateDto());

        if(save){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_INSERT, dtoEntity);
        }
            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_INSERT, false);


    }

    @Override
    public ResultVO compUpdate(Company company) {
        boolean update = false;
        if (company.getCompId()!=null){
            update = updateById(company);
        }
        DTOEntity dtoEntity = new DtoUtils().convertToDto(company, new CompanyUpdateDto());


        if (update){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_UPDATED, dtoEntity);
        }
            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_UPDATED, null);


    }

    @Override
    public ResultVO compDelete(Integer compId) {
        boolean remove = false;
        if(compId!=null){
            remove = removeById(compId);
        }

        if(remove){
            return new ResultVO(HttpStatus.OK.value(),ResultMsg.SUCCESS_DELETED,true );
        }

            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_DELETED,false);


    }

    @Override
    public ResultVO compFindAll() {
        List<Company> companies = list();
        List<DTOEntity> list = new DtoUtils().convertToDtoList(companies, new CompanyFindOneDto());


        if(!companies.isEmpty()){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_QUERY,list);
        }

            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_QUERY,null);


    }

    @Override
    public Integer compGetId(String compName) {
        QueryWrapper<Company> queryWrapper =new QueryWrapper<>();
        queryWrapper.lambda().eq(Company::getCompName,compName);
        Company company = getOne(queryWrapper);

        return company.getCompId();
    }
}
