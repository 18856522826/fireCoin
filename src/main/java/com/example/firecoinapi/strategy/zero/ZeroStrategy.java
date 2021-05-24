package com.example.firecoinapi.strategy.zero;

import com.example.firecoinapi.common.FireCoinRest;
import com.example.firecoinapi.model.Kmodel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Notice:0号策略
 *
 * @author xuxu
 * @version 1.0
 * @date 2021/5/17
 * @since 1.0
 */
@Service
public class ZeroStrategy {

    final FireCoinRest fireCoinRest;
    private static LinkedHashMap<String,Kmodel> kLinkList=new LinkedHashMap<>();

    public ZeroStrategy(FireCoinRest fireCoinRest) {
        this.fireCoinRest = fireCoinRest;
    }

    public void content(){

        fireCoinRest.getKline();
    }

    /**
     * 添加属性
     * @param kmodel
     */
    public static void setkLinkList(Kmodel kmodel){
        kLinkList.put(kmodel.getKLineId(),kmodel);
    }

    /**
     *
     * @return k线list
     */
    public static LinkedHashMap<String,Kmodel> getkLinkList(){
        return kLinkList;
    }
}
