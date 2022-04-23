package com.laraib07.yetanotheryelp.ui.result

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.laraib07.yetanotheryelp.R
import com.laraib07.yetanotheryelp.model.YelpCategories
import com.laraib07.yetanotheryelp.model.YelpLocation
import com.laraib07.yetanotheryelp.model.YelpBusiness
import com.laraib07.yetanotheryelp.ui.Screen
import com.laraib07.yetanotheryelp.ui.SharedViewModel

@ExperimentalCoilApi
@Composable
fun BusinessItem(
    business: YelpBusiness?,
    sharedViewModel: SharedViewModel,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp, 4.dp)
            .clickable {
                sharedViewModel.addBusiness(newBusiness = business)
                navController.navigate(Screen.Detail.route)
            },
        elevation = 5.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            if(business?.imageUrl != null) {
                BusinessImage(
                    imageUrl = business.imageUrl,
                    modifier = Modifier.size(100.dp)
                )
            }
            Column {
                val textPaddingValues = PaddingValues(
                    start = 16.dp,
                    end = 8.dp,
                    bottom = 8.dp
                )
                Text(
                    text = business?.name ?: "N/A",
                    style = MaterialTheme.typography.h6,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    modifier = Modifier.padding(textPaddingValues)

                )
                Text(
                    text = business?.location?.address ?: "N/A",
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.padding(textPaddingValues)
                )

                Text(
                    text = business?.categories?.get(0)?.title ?: "N/A",
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.padding(textPaddingValues)
                )
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun BusinessImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    roundedCornerRadius: Float = 25f
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        val painter = rememberImagePainter(
            data = imageUrl,
            builder = {
                placeholder(R.drawable.ic_placeholder)
                error(R.drawable.ic_error)
                scale(Scale.FILL)
                transformations(
                    RoundedCornersTransformation(roundedCornerRadius)
                )
            }
        )
        Image(
            painter = painter,
            modifier = modifier,
            contentDescription = "Business Image"
            //contentScale = ContentScale.FillBounds
        )
    }
}

@ExperimentalCoilApi
@Preview(showBackground = false)
@Composable
fun BusinessItemPreview() {
    BusinessItem(
        business = YelpBusiness(
            name = "Name",
            rating = 4.5,
            categories = listOf(YelpCategories("coffee")),
            price = "$$",
            phone = "+91123456789",
            location = YelpLocation("New York"),
            imageUrl = "",
            numReviews = 39
        ),
        navController = NavHostController(LocalContext.current),
        sharedViewModel = viewModel()
    )
}