package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;

import java.util.List;

public interface PromotionAdService {

    /*
        分页查询广告信息
     */
//    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO);

    /*
        添加广告
     */

    public void savePromotionAd(PromotionAd promotionAd);

    /*
        更新广告
     */

    public void updatePromotionAd(PromotionAd promotionAd);

    /*
        广告动态上下线
     */
    public void updatePromotionAdStatus(int id,int status);


}
