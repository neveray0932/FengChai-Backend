package com.neveray0932.fengchai.common.utils;

import com.neveray0932.fengchai.common.dto.DTOEntity;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CADTECH
 */
public class DtoUtils {

    public DTOEntity convertToDto(Object obj, DTOEntity mapper) {
        return new ModelMapper().map(obj, mapper.getClass());
    }

    public Object convertToEntity(Object obj, DTOEntity mapper) {
        return new ModelMapper().map(mapper, obj.getClass());
    }

    public List<DTOEntity> convertToDtoList(List<?> obj, DTOEntity dtoEntity){
        List<DTOEntity> list = new ArrayList<>();

        obj.stream().forEach(res->{
            DTOEntity dtoEntity1 = convertToDto(res, dtoEntity);


            list.add(dtoEntity1);
        });
        return list;
    }

}
