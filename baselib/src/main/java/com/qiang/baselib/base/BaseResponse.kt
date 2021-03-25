package com.qiang.baselib.base

/**
 * @author lixiqiang
 * @date：2021/2/20 0020
 */
class BaseResponse<T>(val data: T, val errorCode: Int = -1, val errorMsg: String = "") {
}