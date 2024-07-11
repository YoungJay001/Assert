package com.my.asset.controller;


import com.my.asset.Bean.AssetBeen;
import com.my.asset.Bean.Result;
import com.my.asset.service.AssetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
@RestController
@RequestMapping("/asset")
public class AssetController {
    @Autowired
    private UserController userController;
    @Autowired
    private AssetService assetService;

    @PostMapping("/issue")
    public Result Issue(@RequestBody AssetBeen assetBeen, HttpServletRequest request) {
        String address = userController.getAddress(request);
        return assetService.Issue(assetBeen, address);
    }
    @PostMapping("/send")
    public Result send(@RequestBody AssetBeen assetBeen, HttpServletRequest request) {
        String address = userController.getAddress(request);
        return assetService.send(assetBeen, address);
    }
    @PostMapping("/getBalance")
    public Result getBalance(@RequestBody AssetBeen assetBeen, HttpServletRequest request) {
        String address = userController.getAddress(request);
        return assetService.getBalance(assetBeen,address);
    }



}
