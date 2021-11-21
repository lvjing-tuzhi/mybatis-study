package com.tuzhi.dao;

import com.tuzhi.pojo.Bill;

import java.util.List;

/**
 * @program: MybatisStudy
 * @description: 账单dao层接口
 * @author: 兔子
 * @create: 2021-11-20 22:20
 **/

public interface BillMapper {
    /**
     * 增加订单
     */
    public int addBill(Bill bill)throws Exception;

    /**
     * 通过查询条件获取供应商列表-模糊查询-getBillList
     */
    public List<Bill> getBillList(Bill bill)throws Exception;

    /**
     * 通过delId删除Bill
     */
    public int deleteBillById(int delId)throws Exception;

    /**
     * 通过billId获取Bill
     */
    public Bill getBillById(int id)throws Exception;

    /**
     * 修改订单信息
     */
    public int modify(Bill bill)throws Exception;

    /**
     * 根据供应商ID查询订单数量
     */
    public int getBillCountByProviderId(int providerId)throws Exception;
}
