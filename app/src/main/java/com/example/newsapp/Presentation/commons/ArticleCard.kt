package com.example.newsapp.Presentation.commons

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.graphics.drawable.Icon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.request.ImageRequest
import com.example.newsapp.Presentation.Dimes.ArticleCardSize
import com.example.newsapp.Presentation.Dimes.ExtraSmallpadding
import com.example.newsapp.Presentation.Dimes.ExtraSmallpadding2
import com.example.newsapp.Presentation.Dimes.smallIconSize
import com.example.newsapp.R
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.model.Source
import com.example.newsapp.ui.theme.NewsAppTheme


@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    Row(modifier = modifier.clickable { onClick }) {

        AsyncImage(
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallpadding) //from dimens
                .height(
                    ArticleCardSize //from dimens
                )

        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )

                Spacer(modifier = Modifier.width(ExtraSmallpadding2))
                Icon( painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(smallIconSize),
                    tint = colorResource(id = R.color.body))

                Spacer(modifier = Modifier.width(ExtraSmallpadding2))
                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )
            }

        }
    }

}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview() {
    NewsAppTheme {
        ArticleCard(
            article = Article(
                author = "",
                content = "",
                description = "",
                publishedAt = "2 hours",
                source = Source(id = "", name = "BBC"),
                title = "heloooo heloo hekki",
                url = "",
                urlToImage = ""

            )
        ) {

        }
    }

}
















