package com.example.firecoinapi.model;

import lombok.Data;

import java.util.List;

/**
 * Notice:
 *
 * @author xuxu
 * @version 1.0
 * @date 2021/5/17
 * @since 1.0
 */
@Data
public class KLinkKlineModel {
    private String ch;
    private List<KDetailModel> data;
}
