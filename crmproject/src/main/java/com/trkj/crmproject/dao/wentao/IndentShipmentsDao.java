package com.trkj.crmproject.dao.wentao;

import com.trkj.crmproject.entity.wentao.IndentShipments;

public interface IndentShipmentsDao {

    int insert(IndentShipments record);

    IndentShipments selectByIid(String id);
}