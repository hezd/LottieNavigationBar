package com.hezd.lottiedemo.view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.hezd.lottiedemo.R
import kotlinx.android.synthetic.main.navigation_bar.view.*


/**
 * Created by hezd on 20-7-15 上午11:36
 */
class NavigationBarView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs),
    View.OnClickListener {
    private var index:Int = -1
    private var onNavigationBarClickListener: OnNavigationBarClickListener? = null

    init {
        initView()
    }

    private fun initView() {
        LayoutInflater.from(context).inflate(R.layout.navigation_bar, this)
        rl_first_tab.setOnClickListener(this)
        rl_second_tab.setOnClickListener(this)
        rl_third_tab.setOnClickListener(this)
        rl_fourth_tab.setOnClickListener(this)
        onClick(rl_first_tab)
    }

    fun setNavigationBarClickListener(onNavigationBarClickListener: OnNavigationBarClickListener) {
        this.onNavigationBarClickListener = onNavigationBarClickListener
    }

    interface OnNavigationBarClickListener {
        fun onClick(index: Int)
    }

    override fun onClick(v: View?) {
        when (v) {
            rl_first_tab -> {
                if(index!=0) {
                    resetViews()
                    iv_first_icon.playAnimation()
                    tv_first.setTextColor(Color.RED)
                    onNavigationBarClickListener?.onClick(0)
                    index = 0
                }
            }
            rl_second_tab -> {
                if(index!=1) {
                    resetViews()
                    iv_second_icon.playAnimation()
                    tv_second.setTextColor(Color.RED)
                    onNavigationBarClickListener?.onClick(1)
                    index = 1
                }
            }
            rl_third_tab -> {
                if(index!=2) {
                    resetViews()
                    iv_third_icon.playAnimation()
                    tv_third.setTextColor(Color.RED)
                    onNavigationBarClickListener?.onClick(2)
                    index = 2
                }
            }
            rl_fourth_tab -> {
                if(index!=3) {
                    resetViews()
                    iv_fourth_icon.playAnimation()
                    tv_fourth.setTextColor(Color.RED)
                    onNavigationBarClickListener?.onClick(3)
                    index = 3
                }
            }
        }
    }

    private fun resetViews() {
        iv_first_icon.cancelAnimation()
        iv_first_icon.progress = 0.0f

        iv_third_icon.cancelAnimation()
        iv_third_icon.progress = 0f

        iv_second_icon.cancelAnimation()
        iv_second_icon.progress = 0f

        iv_fourth_icon.cancelAnimation()
        iv_fourth_icon.progress = 0f

        tv_first.setTextColor(Color.BLACK)
        tv_second.setTextColor(Color.BLACK)
        tv_third.setTextColor(Color.BLACK)
        tv_fourth.setTextColor(Color.BLACK)
    }
}