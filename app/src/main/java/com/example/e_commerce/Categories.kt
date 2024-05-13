package com.example.e_commerce

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStateManagerControl
import androidx.fragment.app.FragmentStatePagerAdapter

class Categories(fm : FragmentManager): FragmentStatePagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    val fragmentList : ArrayList<Fragment> = ArrayList()
    val fragmenttitle:ArrayList<String> = ArrayList()
    override fun getCount(): Int {
      return fragmentList.size

    }

    override fun getItem(position: Int): Fragment {
            return fragmentList[position]
    }
    override fun getPageTitle(position: Int):CharSequence?{
        return fragmenttitle[position]
    }

    fun addfragment(fragment: Fragment,title:String){
        fragmentList.add(fragment)

    }

}