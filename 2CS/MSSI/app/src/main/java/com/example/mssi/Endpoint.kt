package com.example.carenta

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface Endpoint {

    @POST("login/")
    suspend fun login(@Body data: LoginCreds): Response<user?>

    @POST("updateuser")
    suspend fun updateuser(@Body data: ModifyUserCreds): Response<user>

    @POST("updatecar")
    suspend fun updatecar(@Body data: ModifyCreds): Response<affectedRows>

    @GET("getcar")
    suspend fun getCar(): Response<List<Car>>

    @GET("getreservation")
    suspend fun getReservation():Response<List<reservation>>

    @Multipart
    @POST("adduser")
    suspend fun addPDV(@Part image: MultipartBody.Part,
                       @Part user:MultipartBody.Part):Response<String>

    @POST("addreservation")
    suspend fun addRES(@Body data: reservation):Response<reservation?>

}