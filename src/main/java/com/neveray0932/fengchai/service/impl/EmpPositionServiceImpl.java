package com.neveray0932.fengchai.service.impl;

import com.neveray0932.fengchai.common.Vo.ResultMsg;
import com.neveray0932.fengchai.common.Vo.ResultVO;
import com.neveray0932.fengchai.entity.EmpPosition;
import com.neveray0932.fengchai.mapper.EmpPositionMapper;
import com.neveray0932.fengchai.service.IEmpPositionService;
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
 * @since 2022-03-15
 */
@Service
public class EmpPositionServiceImpl extends ServiceImpl<EmpPositionMapper, EmpPosition> implements IEmpPositionService {

    @Override
    public ResultVO empPositionCreate(EmpPosition empPosition) {
        boolean save = save(empPosition);
        if (save){
            return new ResultVO(HttpStatus.OK.value(),ResultMsg.SUCCESS_INSERT,empPosition);
        }
        return new ResultVO(HttpStatus.NO_CONTENT.value(),ResultMsg.FAILED_INSERT,empPosition);
    }

    @Override
    public ResultVO empPositionUpdate(EmpPosition empPosition) {
        boolean update = false;
        if(empPosition.getEmpPositionId()!=null){
            update = updateById(empPosition);
        }
        if (update){
            return new ResultVO(HttpStatus.OK.value(),ResultMsg.SUCCESS_UPDATED,empPosition);
        }

        return new ResultVO(HttpStatus.NO_CONTENT.value(),ResultMsg.FAILED_UPDATED,null);
    }

    @Override
    public ResultVO empPositionDelete(Integer empPositionId) {
        boolean result = false;
        if(empPositionId!=null){
            result = removeById(empPositionId);
        }
        if (result){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_DELETED,true);
        }

        return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_DELETED,false);
    }

    @Override
    public ResultVO empPositionFindAll() {
        List<EmpPosition> list = list();
        return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_QUERY,list);
    }
}
