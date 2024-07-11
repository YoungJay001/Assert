package com.my.asset.util;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 节点前置接口工具类
 */
@Component
public class WeBASEUtils {

    /**
     * 已部署合约的基本信息
     * 1.合约地址
     * 2.合约ABI
     * 3.合约名称
     * 4.合约Bin
     */
    private static final String contractAddress = "";//合约地址
    private static final String ABI = "";//合约API
    private static final String contractName = "Asset";
    private static final String BASE_URL = "http://IP:5002/WeBASE-Front/";//你的虚拟机IP
    /**
     * 交易处理接口（本地签名）
     * 此接口为WeBASE-Front使用本地私钥（页面中的测试用户）进行签名
     *
     * @param userAddress 用户地址
     * @param funcName    函数名称
     * @param funcParam   函数参数列表
     * @return 返回交易处理结果
     */
    public static String commonReq(String userAddress,
                                   String funcName,
                                   List funcParam) {
        JSONObject data = new JSONObject();
        JSONArray abiJSON = JSON.parseArray(ABI);
        data.put("user", userAddress);
        data.put("contractName", contractName);
        data.put("contractAddress", contractAddress);
        data.put("funcName", funcName);
        data.put("contractAbi", abiJSON);
        data.put("groupId", 1);
        data.put("funcParam", funcParam);
        data.put("useCns", false);
        data.put("useCns", false);
        data.put("cnsName", "");
        String dataString = data.toString();

        String response = HttpRequest.post(BASE_URL + "trans/handle")
                .header(Header.CONTENT_TYPE, "application/json")
                .body(dataString)
                .execute()
                .body();
        return response;
    }

}
