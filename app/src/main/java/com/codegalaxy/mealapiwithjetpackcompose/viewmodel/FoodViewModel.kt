package com.codegalaxy.mealapiwithjetpackcompose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codegalaxy.mealapiwithjetpackcompose.model.FoodRepository
import com.codegalaxy.mealapiwithjetpackcompose.model.FoodResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(
    private val repository: FoodRepository
) : ViewModel() {

    private val _categoryData = MutableLiveData<List<FoodResponse>>()
    val categoryData: LiveData<List<FoodResponse>> = _categoryData

    fun getCategoryFromViewModel(){
        viewModelScope.launch {
            try {
                val response = repository.fetchCategory()
                if (response.isSuccessful){
                    _categoryData.value = response.body()?.category
                }
                else{
                    print("Data not found ${response.message()}")
                }
            }
            catch (e : Exception){
                e.printStackTrace()
                println("Error : ${e.message}")
            }
        }
    }
}