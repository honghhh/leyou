package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionEnum {

    BRAND_NOT_FOUND(404, "品牌不存在"),
    CATEGORY_NOT_FOUND(404, "商品分类没查到"),
    SPEC_GROUP_NOT_FOUND(404, "商品规格组不存在"),
    SPEC_GROUP_SAVE_ERROR(500, "商品规格组新增失败"),
    SPEC_GROUP_DELETE_ERROR(500, "商品规格组删除失败"),
    SPEC_PARAM_NOT_FOUND(404, "商品规格参数不存在"),
    GOODS_NOT_FOUND(404, "商品不存在"),
    GOODS_DETAIL_NOT_FOUND(404, "商品详情不存在"),
    GOODS_SKU_NOT_FOUND(404, "商品SKU不存在"),
    GOODS_STOCK_NOT_FOUND(404, "商品库存不存在"),
    BRAND_SAVE_ERROR(500, "新增品牌失败"),
    INVAILD_FILE_TYPE(400, "无效图片类型"),
    UPLOAD_FILE_ERROR(500, "上传图片失败"),
    GOODS_SAVE_ERROR(500, "新增商品失败"),
    GOODS_EDIT_ERROR(500, "修改商品失败"),
    GOODS_ID_CANNOT_BE_NULL(400, "商品id不能为空"),
    INVALID_USER_DATA_TYPE(400, "用户数据类型无效"),
    INVALID_VERIFY_CODE(400, "无效的验证码"),
    INVALID_USERNAME_PASSWORD(400, "用户名或密码错误"),
    NO_AUTHORIZED(403, "未授权"),
    CREATE_ORDER_ERROR(500, "创建订单失败"),
    STOCK_NOT_ENOUGH(400,"库存不足！" ),
    ORDER_NOT_FOUND(404,"订单不存在！" ),
    ORDER_DETAIL_NOT_FOUNT(404,"订单详情不存在！" ),
    ORDER_STATUS_NOT_FOUND(404,"订单状态不存在！" ),
    WX_PAY_ORDER_FAIL(500,"微信下单失败！" ),
    ORDER_STATUS_ERROE(500,"订单状态异常！" ),
    INVALID_ORDER_PARAM(400,"订单参数异常！" ),
    UPDATE_ORDER_STATUS_ERROR(400,"订单状态更新失败！" );;

    private int code;
    private String msg;
}
