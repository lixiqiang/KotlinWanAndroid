package com.qiang.baselib.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

/**
 * @author lixiqiang
 * @date：2021/1/28 0028
 */
abstract class BaseVmActivity<VM : BaseViewModel> : BaseActivity() {

    lateinit var vm: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        vm = createViewModel()
        super.onCreate(savedInstanceState)
        createObserver()
    }

    abstract fun createObserver()

    private fun createViewModel(): VM = ViewModelProvider(this).get(getVmClass(this))
}