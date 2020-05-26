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
    BRAND_SAVE_ERROR(500, "新增品牌失败"),
    INVAILD_FILE_TYPE(400, "无效图片类型"),
    UPLOAD_FILE_ERROR(500, "上传图片失败");

    private int code;
    private String msg;
}
