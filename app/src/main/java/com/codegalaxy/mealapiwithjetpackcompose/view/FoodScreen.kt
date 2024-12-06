package com.codegalaxy.mealapiwithjetpackcompose.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.codegalaxy.mealapiwithjetpackcompose.model.FoodResponse
import com.codegalaxy.mealapiwithjetpackcompose.viewmodel.FoodViewModel

@Composable
fun FoodScreen(viewModel: FoodViewModel) {
    val foodList by viewModel.categoryData.observeAsState(emptyList())

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Food Categories",
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            items(foodList) { food2 ->
                FoodItem(food = food2)
            }
        }
    }
}

// Single food item display
@Composable
fun FoodItem(food: FoodResponse) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(food.image),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp),
            contentScale = ContentScale.Crop
        )

        Column {
            Text(
                text = food.category,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = food.desc,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp),
                maxLines = 2
            )
        }
    }
}
