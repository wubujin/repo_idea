package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.PromotionAdMapper;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PromotionAdServiceImpl implements PromotionAdService {

    @Autowired
    private PromotionAdMapper promotionAdMapper;


//    @Override
//    public  PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO) {
//
//        PageHelper.startPage(promotionAdVO.getCurrentPage(),promotionAdVO.getPageSize());
//        List<PromotionAd> allPromotionAdByPage = promotionAdMapper.findAllPromotionAdByPage();
//        PageInfo<PromotionAd> pageInfo = new PageInfo<>(allPromotionAdByPage);
//
//        return pageInfo;
//    }

    @Override
    public void savePromotionAd(PromotionAd promotionAd) {
        //1.封装数据
        Date date = new Date();
        promotionAd.setCreateTime(date);
        promotionAd.setUpdateTime(date);

        //2.调用mapper
        promotionAdMapper.savePromotionAd(promotionAd);
    }

    @Override
    public void updatePromotionAd(PromotionAd promotionAd) {
        //1.封装数据
        Date date = new Date();
        promotionAd.setUpdateTime(date);

        //2.调用mapper
        promotionAdMapper.updatePromotionAd(promotionAd);

    }

    @Override
    public void updatePromotionAdStatus(int id,int status) {

        //1.封装数据
        PromotionAd promotionAd = new PromotionAd();
        Date date = new Date();
        promotionAd.setId(id);
        promotionAd.setStatus(status);
        promotionAd.setUpdateTime(date);

        //2.调用mapper
        promotionAdMapper.updatePromotionAdStatus(promotionAd);

    }
}
