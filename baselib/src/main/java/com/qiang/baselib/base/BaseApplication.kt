package com.qiang.baselib.base

import android.app.Application
import android.content.Context
import com.hjq.toast.ToastUtils

/**
 * @author lixiqiang
 * @date：2021/3/15 0015
 */
open class BaseApplication : Application() {

    override fun onCreate() {
        context = this
        super.onCreate()
        ToastUtils.init(this)
    }

    companion object {

        lateinit var context: Context

    }
}