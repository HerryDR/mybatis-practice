package com.jsf.bank.service;

import com.jsf.bank.exception.AppException;
import com.jsf.bank.exception.MoneyNotEnoughException;

/**
 * @Description
 * @FileName AccountService
 * @Author JSF
 * @date 2024-10-25
 **/
public interface AccountService {
    void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, AppException;
}
