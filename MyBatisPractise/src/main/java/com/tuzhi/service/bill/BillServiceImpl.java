package com.tuzhi.service.bill;

import com.tuzhi.dao.BillMapper;
import com.tuzhi.pojo.Bill;
import com.tuzhi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @program: MybatisStudy
 * @description: 账单业务实现层
 * @author: 兔子
 * @create: 2021-11-20 22:43
 **/

public class BillServiceImpl implements BillService{

    @Override
    public int addBill(Bill bill) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int i = 0;
        try {
            i = mapper.addBill(bill);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return i;
    }

    @Override
    public List<Bill> getBillList(Bill bill) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        List<Bill> billList = null;
        try {
            billList = mapper.getBillList(bill);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return billList;
    }

    @Override
    public int deleteBillById(int delId) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int i = 0;
        try {
            i = mapper.deleteBillById(delId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return i;
    }

    @Override
    public Bill getBillById(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        Bill billById = null;
        try {
            billById = mapper.getBillById(20);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return billById;
    }

    @Override
    public int modify(Bill bill) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int modify = 0;
        try {
            modify = mapper.modify(bill);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return modify;
    }

    @Override
    public int getBillCountByProviderId(int providerId) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int billCountByProviderId = 0;
        try {
            billCountByProviderId = mapper.getBillCountByProviderId(providerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return billCountByProviderId;
    }
}
