package com.example.springmvc.dao.api.base;

import com.example.springmvc.exception.ApiException;

public interface ApiExecutable<R> {
    R execute() throws ApiException;
}
