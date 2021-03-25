package com.qiang.baselib.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hjq.toast.ToastUtils
import com.qiang.baselib.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 * @author lixiqiang
 * @date：2021/1/28 0028
 */
open class BaseViewModel : ViewModel() {


    fun <T> launch(
        block: suspend CoroutineScope.() -> BaseResponse<T>,
        liveData: MutableLiveData<T>,
        isShowLoading: Boolean = false,
        isShowError: Boolean = false
    ) {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    block()
                }
                if (result.errorCode == 0) {
                    liveData.value = result.data
                } else if (isShowError) {
                    ToastUtils.show(if (result.errorMsg.isEmpty()) R.string.error_msg else result.errorMsg)
                }
            } catch (e: Exception) {
                ToastUtils.show(R.string.error_msg)
            } finally {

            }
        }
    }

    fun <T> launchResponse(
        block: suspend CoroutineScope.() -> BaseResponse<T>,
        liveData: MutableLiveData<BaseResponse<T>>,
        isShowLoading: Boolean = false,
        isShowError: Boolean = false
    ) {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    block()
                }
                liveData.value = result
                if (isShowError) {
                    ToastUtils.show(if (result.errorMsg.isEmpty()) R.string.error_msg else result.errorMsg)
                }
            } catch (e: Exception) {
                ToastUtils.show(R.string.error_msg)
            } finally {

            }
        }
    }

}