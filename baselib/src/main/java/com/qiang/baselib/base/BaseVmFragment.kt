package com.qiang.baselib.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

/**
 * @author lixiqiang
 * @date：2021/2/20 0020
 */
abstract class BaseVmFragment<VM : BaseViewModel> : BaseFragment() {

    lateinit var vm: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        vm = createViewModel()
        super.onCreate(savedInstanceState)
        setObserver()
    }

    private fun createViewModel(): VM = ViewModelProvider(this).get(getVmClass(this))

    abstract fun setObserver()

}