package com.neveray0932.fengchai.common.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PageDto {

    private Long total;
    private List<?> records;
}
