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
    BRAND_SAVE_ERROR(500, "新增品牌失败"),
    INVAILD_FILE_TYPE(500, "无效图片类型"),
    UPLOAD_FILE_ERROR(500, "上传图片失败");

    private int code;
    private String msg;
}
