package com.jsf.bank.service.impl;

import com.jsf.bank.dao.AccountDao;
import com.jsf.bank.dao.impl.AccountDaoImpl;
import com.jsf.bank.exception.AppException;
import com.jsf.bank.exception.MoneyNotEnoughException;
import com.jsf.bank.pojo.Account;
import com.jsf.bank.service.AccountService;
import com.jsf.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @Description
 * @FileName AccountServiceImpl
 * @Author JSF
 * @date 2024-10-25
 **/
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao= (AccountDao) SqlSessionUtil.openSession().getMapper(AccountDao.class);
    @Override
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, AppException {
        Account fromAct = accountDao.selectByActno(fromActno);
        if(fromAct.getBalance()<money){
            throw new MoneyNotEnoughException("余额不足");
        }
        try {
            Account toAct = accountDao.selectByActno(toActno);
            fromAct.setBalance(fromAct.getBalance()-money);
            toAct.setBalance(toAct.getBalance()+money);
            SqlSession sqlSession = SqlSessionUtil.openSession();
            accountDao.update(fromAct);

            /*// 模拟异常
            String s = null;
            s.toString();*/

            accountDao.update(toAct);
            sqlSession.commit();
            SqlSessionUtil.close(sqlSession);
        } catch (Exception e) {
            throw new AppException("转账异常");
        }
    }
}
