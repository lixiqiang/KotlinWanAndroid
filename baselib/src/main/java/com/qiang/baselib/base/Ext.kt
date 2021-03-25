package com.qiang.baselib.base

import java.lang.reflect.ParameterizedType

/**
 * @author lixiqiang
 * @date：2021/1/30 0030
 */

fun <VM> getVmClass(obj: Any): VM =
    (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM