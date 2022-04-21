package com.laraib07.yetanotheryelp.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import com.laraib07.yetanotheryelp.ui.SharedViewModel
import com.laraib07.yetanotheryelp.ui.result.BusinessImage

@ExperimentalCoilApi
@Composable
fun DetailScreen(sharedViewModel: SharedViewModel) {
    val business = sharedViewModel.business

    if (business != null) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            BusinessImage(
                imageUrl = business.imageUrl ?: "N/A",
                modifier = Modifier.fillMaxSize(),
                roundedCornerRadius = 0f
            )

            Spacer(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 1200f
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 16.dp)
            ) {
                DetailRow(
                    descriptor = "Rating",
                    description = "${business.rating}/5"
                )
                DetailRow(
                    descriptor = "Price",
                    description = business.price.toString()
                )
                DetailRow(
                    descriptor = "Categories",
                    description = business.categories[0]?.title ?: "N/A"
                )
                DetailRow(
                    descriptor = "Address",
                    description = business.location?.address ?: "N/A"
                )
            }
        }
    }
}

@Composable
fun DetailRow(
    descriptor: String,
    description: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = descriptor, color = Color.White)
        Text(text = description, color = Color.White)
    }
}

@Composable
@Preview(showBackground = true)
fun DetailScreenPreview() {
    DetailScreen(sharedViewModel = viewModel())
}