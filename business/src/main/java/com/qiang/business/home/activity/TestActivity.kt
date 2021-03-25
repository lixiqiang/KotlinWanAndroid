package com.qiang.business.home.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import com.qiang.baselib.base.BaseVmActivity
import com.qiang.business.R
import com.qiang.business.home.viewModel.TestViewModel
import kotlinx.android.synthetic.main.activity_test.*

/**
 * @author lixiqiang
 * @date：2021/2/22 0022
 */
class TestActivity : BaseVmActivity<TestViewModel>() {

    override fun setLayoutId(): Int = R.layout.activity_test


    override fun initView(savedInstanceState: Bundle?) {

        tvGet.setOnClickListener {
            viewModel.getBanner()
        }
    }



    override fun createObserver() {
        viewModel.bannerLiveData.observe(this, Observer {
            tvRes.text = it.toString()

        })



    }
}