package com.example.firecoinapi.common;

import org.springframework.beans.factory.BeanFactoryUtils;

/**
 * Notice:
 *
 * @author xuxu
 * @version 1.0
 * @date 2021/5/5
 * @since 1.0
 */

public class TestThread extends Thread {
    @Override
    public void run() {
       FireCoinRest rest= new FireCoinRest();
       int count =0;
       while(true){
           count++;
           System.out.println("COUNT:"+count+rest.getLatestIndex());
       }
    }
}
