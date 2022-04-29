package com.client.controller;

import com.client.model.Delivery;
import com.client.service.DeliveryService;
import com.common.util.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 前端控制器
 *
 * @author MaybeBin
 * @since 2022-04-29
 */
@RestController
@RequestMapping("/client/delivery")
@Api(tags = "用户-岗位")
public class DeliveryController {
  @Autowired DeliveryService deliveryService;

  @ApiOperation("查找所有")
  @GetMapping("/List")
  public DataResult getList() {
    return DataResult.success(deliveryService.list());
  }

  @ApiOperation("添加")
  @PostMapping("/save")
  public DataResult add(@RequestBody Delivery testEntity) {
    deliveryService.save(testEntity);
    return DataResult.success();
  }

  @ApiOperation("修改")
  @PostMapping("/update")
  public DataResult update(@RequestBody Delivery testEntity) {
    deliveryService.updateById(testEntity);
    return DataResult.success();
  }

  @ApiOperation("删除")
  @DeleteMapping("/remove/{id}")
  public DataResult deleteOne(@PathVariable("id") String id) {
    deliveryService.removeById(id);
    return DataResult.success();
  }
}