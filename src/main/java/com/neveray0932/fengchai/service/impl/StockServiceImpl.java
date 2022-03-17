package com.neveray0932.fengchai.service.impl;

import com.neveray0932.fengchai.entity.Stock;
import com.neveray0932.fengchai.mapper.StockMapper;
import com.neveray0932.fengchai.service.IStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements IStockService {

}
