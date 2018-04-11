package com.lizhivscaomei.jes.common.view;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhi on 2018/1/9.
 */
public abstract class ViewServiceImpl<VO,DTO> implements ViewService<VO,DTO> {
    @Override
    public List<VO> dtoList2voList(List<DTO> dtos) {
        List<VO> voList=new ArrayList<VO>();
        for(DTO dto:dtos){
            VO vo = this.dto2vo(dto);
            voList.add(vo);
        }
        return voList;
    }
}
