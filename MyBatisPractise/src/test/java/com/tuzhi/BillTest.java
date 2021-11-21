package com.tuzhi;

import com.tuzhi.pojo.Bill;
import com.tuzhi.service.bill.BillServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @program: MybatisStudy
 * @description: 账单测试类
 * @author: 兔子
 * @create: 2021-11-21 16:23
 **/

public class BillTest {

    @Test
    public void addBill() {
        BillServiceImpl billService = new BillServiceImpl();
        Bill bill = new Bill();
        bill.setBillCode("BILL2016_018");
        bill.setProductName("lv");
        bill.setProductDesc("lvlv");
        bill.setProductUnit("帅");
        bill.setProductCount(new BigDecimal(1));
        bill.setTotalPrice(new BigDecimal(10));
        bill.setIsPayment(1);
        bill.setCreatedBy(1);
        bill.setCreationDate(new Date());
        bill.setProviderId(1);
        int i = billService.addBill(bill);
        System.out.println(i);
    }

    @Test
    public void getBillList() {
        BillServiceImpl billService = new BillServiceImpl();
        Bill bill = new Bill();
        bill.setProductName("皂");
        bill.setProviderId(1);
        bill.setIsPayment(1);
        List<Bill> billList = billService.getBillList(bill);
        for (Bill bill1 : billList) {
            System.out.println(bill1);
        }
    }

    @Test
    public void deleteBillById() {
        BillServiceImpl billService = new BillServiceImpl();
        int i = billService.deleteBillById(18);
        System.out.println(i);
    }

    @Test
    public void getBillById() {
        BillServiceImpl billService = new BillServiceImpl();
        Bill billById = billService.getBillById(20);
        System.out.println(billById);
    }

    @Test
    public void modify() {
        BillServiceImpl billService = new BillServiceImpl();
        Bill bill = new Bill();
        bill.setId(20);
        bill.setProductName("jing");
        int modify = billService.modify(bill);
        System.out.println(modify);
    }

    @Test
    public void getBillCountByProviderId() {
        BillServiceImpl billService = new BillServiceImpl();
        int billCountByProviderId = billService.getBillCountByProviderId(1);
        System.out.println(billCountByProviderId);
    }

}

