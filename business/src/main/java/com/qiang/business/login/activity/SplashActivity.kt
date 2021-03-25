package com.qiang.business.login.activity

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.viewModelScope
import com.qiang.baselib.base.BaseViewModel
import com.qiang.baselib.base.BaseVmActivity
import com.qiang.baselib.base.Constant.IMAGE_4
import com.qiang.baselib.base.utils.GlideUtils
import com.qiang.business.R
import com.qiang.business.home.activity.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author lixiqiang
 * @date：2021/3/22 0022
 */
class SplashActivity : BaseVmActivity<BaseViewModel>() {


    override fun setLayoutId(): Int = R.layout.activity_splash


    override fun initView(savedInstanceState: Bundle?) {
//        GlideUtils.load(this, IMAGE_4, 0, imageView)

        viewModel.viewModelScope.launch {
            delay(3000)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }
    }

    override fun createObserver() {

    }
}