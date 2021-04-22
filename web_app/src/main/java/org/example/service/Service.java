package org.example.service;

import org.example.exception.InputException;
import org.example.exception.ServerException;

public interface Service<T, E> {
    T doService (E entity) throws InputException, ServerException;
}