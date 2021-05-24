package com.example.firecoinapi.common;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Notice:
 *
 * @author xuxu
 * @version 1.0
 * @date 2021/5/5
 * @since 1.0
 */
@Component
public class FireCoinRest {

    private String baseUrl="https://api.hbdm.vn";
    private String onePeriod="1min";
    private String fivePeriod="5min";


    /**
     * 获取指数信息
     * @return 响应
     */
    public  String getLatestIndex() {
        String url = baseUrl + FireApiConstant.latestIndex;
        Map<String, Object> map = new HashMap<>();
        map.put(MapParam.contractCode, ContractCode.ETH);
        return HttpUtil.get(url,map);
    }

    /**
     * 获取K线数据
     * @return 响应
     */
    public  String getKline() {
        String url = baseUrl + FireApiConstant.Kline;
        Map<String, Object> map = new HashMap<>();
        map.put(MapParam.contractCode, "ETH-USDT");
        map.put(MapParam.period,onePeriod);
        map.put(MapParam.size,1);
        return HttpUtil.get(url,map);
    }

    /**
     * 获取多空比例
     * @return 多空比例
     */
    public String getPosition(){
        String url = baseUrl + FireApiConstant.position;
        Map<String, Object> map = new HashMap<>();
        map.put(MapParam.contractCode, "ETH-USDT");
        map.put(MapParam.period,fivePeriod);
        return HttpUtil.get(url,map);
    }
}
