package com.hezd.lottiedemo.activity

import androidx.fragment.app.Fragment
import com.hezd.lottiedemo.R
import com.hezd.lottiedemo.fragment.CartFragment
import com.hezd.lottiedemo.fragment.CategoryFragment
import com.hezd.lottiedemo.fragment.HomeFragment
import com.hezd.lottiedemo.fragment.MineFragment
import com.hezd.lottiedemo.view.NavigationBarView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.min

class MainActivity : BaseActivity() {
    lateinit var homeFragment:HomeFragment
    lateinit var categoryFragment: CategoryFragment
    lateinit var cartFragment: CartFragment
    lateinit var mineFragment: MineFragment
    lateinit var currentFragment:Fragment

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initViews() {
        homeFragment = HomeFragment()
        categoryFragment = CategoryFragment()
        cartFragment = CartFragment()
        mineFragment = MineFragment()

        supportFragmentManager.beginTransaction().add(R.id.fl_content,homeFragment).commitAllowingStateLoss()
        currentFragment = homeFragment
        navigation_bar.setNavigationBarClickListener(object :NavigationBarView.OnNavigationBarClickListener{
            override fun onClick(index: Int) {
                when(index){
                    0->{
                        showFragment(homeFragment)
                    }
                    1->{
                        showFragment(categoryFragment)
                    }
                    2->{
                        showFragment(cartFragment)
                    }
                    3->{
                        showFragment(mineFragment)
                    }
                }
            }

        })
    }

    private fun showFragment(fragment: Fragment) {
        if(fragment !=currentFragment) {
            resetFragmentState()
            if(!fragment.isAdded){
                supportFragmentManager.beginTransaction().add(R.id.fl_content,fragment).commitAllowingStateLoss()
            }else{
                supportFragmentManager.beginTransaction().show(fragment).commitAllowingStateLoss()
            }
            currentFragment = fragment
        }
    }

    private fun resetFragmentState() {
        supportFragmentManager.beginTransaction().hide(currentFragment).commitAllowingStateLoss()
    }

    override fun initData() {
    }


}
