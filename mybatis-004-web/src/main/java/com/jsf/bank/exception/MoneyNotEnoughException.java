package com.jsf.bank.exception;

/**
 * @Description
 * @FileName MoneyNotEnoughException
 * @Author JSF
 * @date 2024-10-25
 **/
public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException(){}
    public MoneyNotEnoughException(String msg){ super(msg); }
}
