package com.lizhivscaomei.jes.common.view;

import java.util.List;

/**
 * Created by lizhi on 2017/12/5.
 * DTO的视图数据转化
 */
public interface ViewService<VO,DTO> {
    VO dto2vo(DTO dto);
    List<VO> dtoList2voList(List<DTO> dtoList);
}
