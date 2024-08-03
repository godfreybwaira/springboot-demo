package com.example.demo.utils;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ObjectMapper<S,D> {
     ObjectMapper mapper = Mappers.getMapper(ObjectMapper.class);
    D map(S source);
}
