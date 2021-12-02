package urraan.internship.retrofitsimpleexample.api

import retrofit2.Response
import retrofit2.http.GET
import urraan.internship.retrofitsimpleexample.model.UserData

interface UserApi {
    @GET("/users")
    suspend fun getUser() : Response<List<UserData>>
}