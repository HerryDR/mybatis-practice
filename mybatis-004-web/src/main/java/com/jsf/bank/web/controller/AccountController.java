package com.jsf.bank.web.controller;

import com.jsf.bank.exception.AppException;
import com.jsf.bank.exception.MoneyNotEnoughException;
import com.jsf.bank.service.AccountService;
import com.jsf.bank.service.impl.AccountServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description
 * @FileName AccountController
 * @Author JSF
 * @date 2024-10-25
 **/
@WebServlet("/transfer")
public class AccountController extends HttpServlet {
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String toActno=request.getParameter("toActno");
        String fromActno=request.getParameter("fromActno");
        double money=Integer.parseInt(request.getParameter("money"));
        try {
            accountService.transfer(fromActno,toActno,money);
            out.print("<h1>转账成功！！！</h1>");
        } catch (MoneyNotEnoughException e) {
            out.print(e.getMessage());
        } catch (AppException e) {
            out.print(e.getMessage());
        }
    }
}
