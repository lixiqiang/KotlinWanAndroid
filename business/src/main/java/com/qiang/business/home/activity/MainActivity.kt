package com.qiang.business.home.activity

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.qiang.baselib.base.BaseActivity
import com.qiang.baselib.base.BaseViewModel
import com.qiang.baselib.base.BaseVmActivity
import com.qiang.baselib.base.BaseVmFragment
import com.qiang.business.R
import com.qiang.business.home.fragment.HomeFragment
import com.qiang.business.home.fragment.MessageFragment
import com.qiang.business.home.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseVmActivity<BaseViewModel>() {


    private val fragments = arrayListOf(HomeFragment(), MessageFragment(), MineFragment())


    override fun setLayoutId(): Int = R.layout.activity_main


    override fun initView(savedInstanceState: Bundle?) {

        val transaction = supportFragmentManager.beginTransaction()
        fragments.forEach {
            transaction.add(R.id.frameLayout, it, it::class.java.simpleName)
        }
        transaction.commitAllowingStateLoss()

        showFragment(0)

        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    showFragment(0)
                }
                R.id.message -> {
                    showFragment(1)
                }

                R.id.mine -> {
                    showFragment(2)
                }
            }
            true
        }
    }


    private fun showFragment(index: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        fragments.indices.forEach {
            if (it == index) {
                transaction.show(fragments[it])
            }else{
                transaction.hide(fragments[it])
            }
        }
        transaction.commitAllowingStateLoss()
    }

    override fun createObserver() {
    }

}