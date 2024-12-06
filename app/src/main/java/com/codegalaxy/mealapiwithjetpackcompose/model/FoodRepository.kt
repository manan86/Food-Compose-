package com.codegalaxy.mealapiwithjetpackcompose.model

import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FoodRepository @Inject constructor(private val apiService: APIService){
    suspend fun fetchCategory() : Response<FoodListResponse>{
        return apiService.getAllCategory()
    }
}