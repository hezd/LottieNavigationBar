package com.hezd.lottiedemo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


/**
 * Created by hezd on 20-7-15 下午2:59
 */
abstract class BaseActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        initViews()
        initData()
    }

    abstract fun getLayoutId():Int
    abstract fun initViews()
    abstract fun initData()
}