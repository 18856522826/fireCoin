package com.example.firecoinapi.strategy.zero.job;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.firecoinapi.common.FireCoinRest;
import com.example.firecoinapi.model.KDetailModel;
import com.example.firecoinapi.model.KLinkKlineModel;
import com.example.firecoinapi.model.Kmodel;
import com.example.firecoinapi.strategy.zero.ZeroStrategy;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Notice:
 *
 * @author xuxu
 * @version 1.0
 * @date 2021/5/23
 * @since 1.0
 */
@Component
public class HandelKineJob  {
    private final FireCoinRest fireCoinRest;


    public HandelKineJob(FireCoinRest fireCoinRest) {
        this.fireCoinRest = fireCoinRest;
    }

    @XxlJob("handelKine")
    public void handelKine(){
        String result= fireCoinRest.getKline();
        Kmodel kmodel= getKm(result);
        ZeroStrategy.setkLinkList(kmodel);
    }

    private Kmodel getKm(String result){
        KLinkKlineModel kLinkKlineModel= JSONObject.parseObject(result,new TypeReference<KLinkKlineModel>(){});
        KDetailModel detailModel= kLinkKlineModel.getData().get(0);
        Kmodel kmodel=new Kmodel();
        kmodel.setKLineId(detailModel.getId());
        kmodel.setAmount(detailModel.getClose());
        return kmodel;
    }
    private void setStatus(String lineId){
        LinkedHashMap<String,Kmodel>  linked=  ZeroStrategy.getkLinkList();
        long line=Long.valueOf(lineId);
        LocalDateTime localDateTime= LocalDateTimeUtil.ofUTC(line);
        localDateTime= LocalDateTimeUtil.offset(localDateTime,1, ChronoUnit.MILLIS);
        line = localDateTime.toEpochSecond(ZoneOffset.UTC);
        linked.get();
    }
}
