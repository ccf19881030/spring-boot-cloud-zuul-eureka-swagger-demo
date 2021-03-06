package cn.xuhao.demo.orderserver.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ResponseMessage;

/**
 * @author: xuhao
 * @Description:
 * @Date：Created on 2018/3/15 18:14.
 */
@RestController
@Api(tags = "订单系统接口", description = "订单系统模块相关接口")
public class OrderServerController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/orderSomething/{name}")
    @ApiOperation(value = "下单")
    public ResponseMessage order(@PathVariable String name) {
        String resule = "hi "+name+",i am from port:" +port;
        return new ResponseMessageBuilder().code(200).message("OrderService2-下单成功"+resule).build();
    }
    
    @RequestMapping("/testVoid")
    @ApiOperation(value = "测试不返回信息的")
    public void test(){
    	try {
			throw new Exception("测试不返回信息的服务");
		} catch (Exception e) {
			e.printStackTrace();
		}
//        new Throwable("测试不返回信息的服务");
    }
}
