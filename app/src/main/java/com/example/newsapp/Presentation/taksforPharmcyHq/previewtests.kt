package com.example.newsapp.Presentation.taksforPharmcyHq


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.Presentation.Dimes
import com.example.newsapp.Presentation.commons.ArticleCard
import com.example.newsapp.R
import com.example.newsapp.ui.theme.Blue
import com.example.newsapp.ui.theme.LightBlack1


@Preview(showBackground = true)
@Composable
fun PreviewTest() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            TopBar()
            TopPart()
            QuantityTasks()
        }

        ResumeButton()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TopBar(){
    TopAppBar(
        title = {},
        modifier = Modifier.fillMaxWidth(),

        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor = colorResource(id = R.color.body),
            navigationIconContentColor = colorResource(id = R.color.body)
        ),
        navigationIcon = {
            Row(modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource
                            (id = R.drawable.ic_back_arrow),
                        contentDescription = null
                    )

                }

                Text(
                    text = "P037",
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                )
            }

        },

    )
}


@Composable
fun TopPart() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(5.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {

        Box(
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color.White, Color.White),
                    )

                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(18.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
//

            ) {
                repeat(5) {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {

                        Text(
                            text = "Zone :",
                            fontSize = 16.sp,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                        )
                        Text(
                            text = " In-progress", //card.cardNumber
                            fontSize = 16.sp,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.SemiBold,
                            color = LightBlack1 //colorResource(id = R.color.body)
                        )


                    }
                }
            }

        }

    }
}


@Composable
fun QuantityTasks() {
    Column(
        modifier = Modifier.padding(5.dp)
    ) {
        Text(
            text = "Items",
            fontSize = 16.sp,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
        )

        LazyColumn(
            //  modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            contentPadding = PaddingValues(all = Dimes.ExtraSmallpadding)
        ) {

            items(count = 2) {
                quantityCardItem()
            }
        }
    }
}

@Composable
fun quantityCardItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
//            .height(200.dp)
            .fillMaxHeight()
            .padding(2.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {

        Box(
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color.White, Color.White),
//                        tileMode = TileMode.Mirror
                    )

                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(10.dp)
//

            ) {

                Text(
                    text = "MONTEKFXTAB 15S",
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
                Text(
                    text = "QUANTITY 1", //card.cardNumber
                    fontSize = 13.sp,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Light,
                    color = colorResource(id = R.color.body)
                )
            }


        }

    }
}


@Preview(showBackground = true)
@Composable
fun ResumeButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(Blue)

    )
    {
        Text(
            text = "Resume",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun previewTestsPreview() {
    TopPart()
}

@Preview(showBackground = true)
@Composable
fun previewQuantityPreviews() {
    QuantityTasks()
}



