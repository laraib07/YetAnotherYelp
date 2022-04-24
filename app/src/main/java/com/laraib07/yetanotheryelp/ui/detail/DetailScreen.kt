package com.laraib07.yetanotheryelp.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.laraib07.yetanotheryelp.model.YelpBusiness
import com.laraib07.yetanotheryelp.ui.SharedViewModel
import com.laraib07.yetanotheryelp.ui.result.BusinessImage

@ExperimentalCoilApi
@Composable
fun DetailScreen(
    sharedViewModel: SharedViewModel,
    navController: NavHostController
) {
    val business = sharedViewModel.business

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Details") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "ArrowBack"
                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.primary
            )
        },
    ) {
        if (business != null) {
            Details(business = business)
        }
    }
}

@Composable
fun Details(business: YelpBusiness) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        BusinessImage(
            imageUrl = business.imageUrl ?: "N/A",
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            roundedCornerRadius = 25f
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = business.name ?: "N/A",
            style = MaterialTheme.typography.h4,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Column {
            DetailRow(
                descriptor = "Rating",
                description = "${business.rating}/5"
            )
            DetailRow(
                descriptor = "No. of Reviews",
                description = business.numReviews.toString()
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
                descriptor = "Phone",
                description = business.phone ?: "N?A"
            )
            DetailRow(
                descriptor = "Address",
                description = business.location?.address ?: "N/A"
            )
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
        Text(
            text = descriptor,
            style = MaterialTheme.typography.body2
        )
        Text(
            text = description,
            style = MaterialTheme.typography.body2
        )
    }
}

@Composable
@Preview(showBackground = true)
fun DetailScreenPreview() {
    DetailScreen(
        sharedViewModel = viewModel(),
        rememberNavController()
    )
}