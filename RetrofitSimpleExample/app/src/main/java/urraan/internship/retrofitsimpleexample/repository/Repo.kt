package urraan.internship.retrofitsimpleexample.repository

import urraan.internship.retrofitsimpleexample.api.UserApiInstance

class Repo {
    suspend fun getUserData() = UserApiInstance.retrofitApi.getUser()
}