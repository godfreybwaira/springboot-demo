package com.example.demo.utils;

public interface MapperInterface {
    <S, D> D map(S sourceObject, Class<D> destinationClass);
}
