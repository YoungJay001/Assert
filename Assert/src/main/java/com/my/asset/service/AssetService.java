package com.my.asset.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.my.asset.Bean.AssetBeen;
import com.my.asset.Bean.Result;
import com.my.asset.util.WeBASEUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Component
@Service
public class AssetService {


    public Result Issue(AssetBeen assetBeen , String address) {
        log.info(address);
        ArrayList<String> funcParam = new ArrayList<>();
        funcParam.add(assetBeen.getUserAddress());
        funcParam.add(String.valueOf(assetBeen.getAmount()));
        String result = WeBASEUtils.commonReq(address, "issue", funcParam);
        JSONObject jsonObject = JSON.parseObject(result);
        log.info(String.valueOf(jsonObject));
        String msg = jsonObject.getString("message");
        if (msg.equals("Success")) {
            log.info("添加数据:{}",assetBeen );
            return Result.success(jsonObject);
        } else {
            return Result.error(401,msg);
        }

    }

    public Result send(AssetBeen assetBeen , String address) {
        log.info(address);
        ArrayList<String> funcParam = new ArrayList<>();
        funcParam.add(assetBeen.getUserAddress());
        funcParam.add(String.valueOf(assetBeen.getAmount()));
        String result = WeBASEUtils.commonReq(address, "send", funcParam);
        JSONObject jsonObject = JSON.parseObject(result);
        log.info(String.valueOf(jsonObject));
        String msg = jsonObject.getString("message");
        if (msg.equals("Success")) {
            log.info("添加数据:{}",assetBeen );
            return Result.success(jsonObject);
        } else {
            return Result.error(401,msg);
        }

    }
    public Result getBalance(AssetBeen assetBeen, String address) {
        log.info("当前用户地址：address:{}", address);
        ArrayList<String> funcParam = new ArrayList<>();
        funcParam.add(assetBeen.getUserAddress());

        String result = WeBASEUtils.commonReq(address, "getBalance", funcParam);

        JSONArray jsonArray = JSON.parseArray(result);
        String resultString = jsonArray.getString(0);

        log.info(resultString);
        return Result.success(resultString);
    }






}
