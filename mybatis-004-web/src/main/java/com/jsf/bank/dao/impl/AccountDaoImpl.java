package com.jsf.bank.dao.impl;

import com.jsf.bank.dao.AccountDao;
import com.jsf.bank.pojo.Account;
import com.jsf.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @Description
 * @FileName AccountDaoImpl
 * @Author JSF
 * @date 2024-10-25
 **/
public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account act = (Account) sqlSession.selectOne("selectByActno", actno);
        return act;
    }

    @Override
    public int update(Account act) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count=sqlSession.update("update", act);
        return count;
    }
}
