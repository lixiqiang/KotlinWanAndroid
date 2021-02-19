package com.qiang.baselib.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author lixiqiang
 * @date：2021/1/28 0028
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(setLayoutId())
        initView(savedInstanceState)
    }

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun setLayoutId(): Int

}