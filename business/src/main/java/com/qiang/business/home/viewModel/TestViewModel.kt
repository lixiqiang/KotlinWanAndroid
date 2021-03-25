package com.qiang.business.home.viewModel

import androidx.lifecycle.MutableLiveData
import com.qiang.baselib.base.BaseResponse
import com.qiang.baselib.base.BaseViewModel
import com.qiang.business.data.Banner
import com.qiang.business.home.repository.TestRepository

/**
 * @author lixiqiang
 * @date：2021/2/22 0022
 */
class TestViewModel : BaseViewModel() {

    private val repository by lazy {
        TestRepository()
    }
    val bannerLiveData = MutableLiveData<BaseResponse<List<Banner>>>()


    fun getBanner() {
        launchResponse({ repository.getBanner() }, bannerLiveData)
    }


}