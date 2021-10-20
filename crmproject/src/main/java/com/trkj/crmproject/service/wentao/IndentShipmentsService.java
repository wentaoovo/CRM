package com.trkj.crmproject.service.wentao;

import com.trkj.crmproject.entity.wentao.IndentShipments;

public interface IndentShipmentsService {
    boolean insert(IndentShipments record);

    IndentShipments selectByIid(String id);
}
