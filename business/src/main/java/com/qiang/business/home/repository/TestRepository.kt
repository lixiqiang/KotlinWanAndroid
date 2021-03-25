package com.qiang.business.home.repository

import com.qiang.business.Api

/**
 * @author lixiqiang
 * @date：2021/2/22 0022
 */
class TestRepository {


   suspend fun getBanner() = Api.api.getBanner()


}