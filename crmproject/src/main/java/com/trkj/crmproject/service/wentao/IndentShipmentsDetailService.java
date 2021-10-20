package com.trkj.crmproject.service.wentao;

import com.trkj.crmproject.entity.wentao.IndentShipmentsDetail;

import java.util.List;

public interface IndentShipmentsDetailService {
    boolean insert(List<IndentShipmentsDetail> list,String pid);
}
