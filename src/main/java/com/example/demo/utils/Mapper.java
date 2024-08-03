package com.example.demo.utils;

public class Mapper implements MapperInterface {

    @Override
    public <S, D> D map(S sourceObject, Class<D> destinationClass) {
       ObjectMapper<S, D> mapper = ObjectMapper.mapper;
       return mapper.map(sourceObject);
    }
}
