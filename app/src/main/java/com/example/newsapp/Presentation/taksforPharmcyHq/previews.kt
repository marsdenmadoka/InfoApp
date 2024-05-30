package com.example.newsapp.Presentation.taksforPharmcyHq



import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.ui.theme.color3
//import com.one.pharma.consumer.resources.PoppinsFonts
//import design.andromedacompose.components.Text
//import design.andromedacompose.foundation.colors.parse

private val BottomBarHeight = 60.dp

@Preview(showBackground = true)
@Composable
fun DashboardBottomBar(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 8.dp)
    ) {
        repeat(4) {
            DashboardBottomBarItem()
        }
    }
}

@Preview
@Composable
private fun DashboardBottomBarItem(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    bounded = true, color = color3   //Color("#8F2196F3")
                ),
                onClick = { }
            )
            .padding(vertical = 12.dp, horizontal = 8.dp)

    ) {
        Icon(
            imageVector = Icons.Rounded.AccountBox,//Adjust
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = "Title",
            fontWeight = FontWeight.Normal,
           // fontFamily = PoppinsFonts,
            fontSize = with(LocalDensity.current) {
                (12 / fontScale).sp
            }
        )

    }
}