package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void reduceNumber() {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1L,killTime);
        System.out.println(updateCount);
    }

    @Test
    public void queryById() {
        long id = 1;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill);
    }

    @Test
    public void queryAll() {
        List<Seckill> seckills = seckillDao.queryAll(0,100);
        System.out.println(seckills);
    }
}