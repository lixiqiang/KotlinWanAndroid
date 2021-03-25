package com.qiang.business

import com.qiang.baselib.base.BaseResponse
import com.qiang.baselib.base.net.RetrofitFactory
import com.qiang.business.data.Banner
import retrofit2.http.GET

/**
 * @author lixiqiang
 * @date：2021/2/20 0020
 */
interface Api {

    companion object {
        val api = RetrofitFactory.instance.create(Api::class.java)
    }


    @GET("banner/json")
    suspend fun getBanner(): BaseResponse<List<Banner>>


}