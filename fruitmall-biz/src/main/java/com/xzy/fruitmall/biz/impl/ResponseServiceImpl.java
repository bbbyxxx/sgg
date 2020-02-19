package com.xzy.fruitmall.biz.impl;

import com.xzy.fruitmall.biz.ResponseService;
import com.xzy.fruitmall.entity.ResponseInfo;
import com.xzy.fruitmall.mapper.ResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    private ResponseMapper responseMapper;
    @Override
    public List<ResponseInfo> findAllResponse() {
        return responseMapper.findAllResponse();
    }

    @Override
    public Boolean addResponse(ResponseInfo responseInfo) {
        return responseMapper.addResponse(responseInfo)>0?true:false;
    }

    @Override
    public ResponseInfo getResponseByAualuateId(Integer evaluateId) {
        return responseMapper.getResponseByAualuateId(evaluateId);
    }
}
