package com.example.e_commerce.Adaptors

import android.content.Context
import android.content.SharedPreferences

class PrefManager(context: Context) {

    val PRIVATE_MODE = 0

    private var PREF_NAME = "SharedPreference"
    private val Is_LOGIN = "Is_Login"


    var pref : SharedPreferences ? = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE)
    val editor : SharedPreferences.Editor?= pref?.edit()

    fun setLogin(isLogin:Boolean){
        editor?.putBoolean(Is_LOGIN,isLogin)
        editor?.commit()

    }

    fun setUsername(username:String){
        editor?.putString("username",username)
        editor?.commit()

    }


    fun isLogin():Boolean?{
        return pref?.getBoolean(Is_LOGIN,false)
    }

    fun getUsername():String?{
        return  pref?.getString("username","")
    }
    fun removeData(){
        editor?.clear()
        editor?.commit()
    }
}
