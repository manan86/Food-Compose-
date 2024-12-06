package com.codegalaxy.mealapiwithjetpackcompose.model

import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("categories.php")
    suspend fun getAllCategory() : Response<FoodListResponse>
}