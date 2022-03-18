package com.neveray0932.fengchai.service.impl;

import com.neveray0932.fengchai.common.vo.ResultMsg;
import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.entity.Depository;
import com.neveray0932.fengchai.mapper.DepositoryMapper;
import com.neveray0932.fengchai.service.IDepositoryService;
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
public class DepositoryServiceImpl extends ServiceImpl<DepositoryMapper, Depository> implements IDepositoryService {

    @Override
    public ResultVO depositoryCreate(Depository depository) {
        boolean save = save(depository);
        if (save){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_INSERT,depository);
        }

            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_INSERT,null);

    }

    @Override
    public ResultVO depositoryUpdate(Depository depository) {
        boolean update = updateById(depository);
        if (update){
            return new ResultVO(HttpStatus.OK.value(),ResultMsg.SUCCESS_UPDATED,depository );
        }
            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_UPDATED,null );

    }

    @Override
    public ResultVO depositoryDelete(String depId) {
        boolean remove = removeById(depId);
        if (remove){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_DELETED,true);
        }
            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.SUCCESS_DELETED,false);

    }

    @Override
    public ResultVO depositoryFindAll() {
        List<Depository> depositories = list();
        if (!depositories.isEmpty()){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_QUERY,depositories);
        }

            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_QUERY,null);

    }
}
