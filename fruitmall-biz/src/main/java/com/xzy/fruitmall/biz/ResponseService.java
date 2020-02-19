package com.xzy.fruitmall.biz;

import com.xzy.fruitmall.entity.ResponseInfo;

import java.util.List;

public interface ResponseService {
    List<ResponseInfo>findAllResponse();
    Boolean addResponse(ResponseInfo responseInfo);
    ResponseInfo getResponseByAualuateId(Integer avaluateId);
}
