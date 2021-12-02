package urraan.internship.retrofitsimpleexample.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import urraan.internship.retrofitsimpleexample.utils.Constants.BASE_URL

object UserApiInstance {
    val retrofitApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }
}