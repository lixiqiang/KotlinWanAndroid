package com.qiang.baselib.base.net

import com.qiang.baselib.base.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author lixiqiang
 * @date：2021/2/20 0020
 */

class RetrofitFactory private constructor() {

    private val timeOut = 30L

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(initOkHttpClient())
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun initOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
//        .addInterceptor(initHeadInterceptor())
        .connectTimeout(timeOut, TimeUnit.SECONDS)
        .readTimeout(timeOut, TimeUnit.SECONDS)
        .writeTimeout(timeOut, TimeUnit.SECONDS)
        .build()


    fun <T> create(clz: Class<T>) = retrofit.create(clz)

    companion object {
        val instance by lazy {
            RetrofitFactory()
        }
    }
}