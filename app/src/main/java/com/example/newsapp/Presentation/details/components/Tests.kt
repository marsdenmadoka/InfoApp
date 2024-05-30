//package com.example.newsapp.Presentation.details.components
//
//
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalDensity
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.constraintlayout.compose.ChainStyle
//import androidx.constraintlayout.compose.ConstraintLayout
//import androidx.constraintlayout.compose.Dimension
//import com.one.pharma.consumer.resources.ConsumerTheme
//import com.one.pharma.consumer.resources.DashedDivider
//import com.one.pharma.consumer.resources.LoadingDialog
//import com.one.pharma.consumer.resources.PoppinsFonts
//import com.one.pharma.consumer.resources.Screen
//import com.one.pharma.consumer.resources.expanadable.ExpandableCard
//import com.one.pharmacy.warehouse.picklist.impl.R
//import design.andromedacompose.components.BackButton
//import design.andromedacompose.components.Divider
//import design.andromedacompose.components.buttons.Button
//import design.andromedacompose.components.buttons.ButtonDefaults
//import design.andromedacompose.components.navbar.AndromedaNavBar
//import design.andromedacompose.foundation.colors.parse
//
//
//
//
//@Composable
//fun MyOrdersScreen()
//{
//    Screen(
//        navbar = {
//            Column {
//                AndromedaNavBar(
//                    backgroundColor = Color.parse("#FFFFFF"),
//                    titleView = {
//                        Text(
//                            text = "My Orders",
//                        )
//                    },
//                    menuView = {
//
//                    },
//                    navigationIcon = {
//                        BackButton(
//                            onBackPressed = { },
//                            painter = painterResource(id = R.drawable.back_icon)
//                        )
//                    }
//                )
//                Divider(
//                    modifier = Modifier
//                        .height(10.dp)
//                )
//            }
//        }
//    ) { paddingValues ->
//
//        MyOrdersInner(
//            modifier = Modifier.padding(paddingValues),
//        )
//    }
//}
//
//
//@Composable
//fun MyOrdersInner(
//    modifier: Modifier,
//) {
//    val currentExpandedPosition = remember {
//        mutableStateOf(-1)
//    }
//
//    LazyColumn(
//        modifier = modifier
//            .background(Color.White),
//        verticalArrangement = Arrangement.spacedBy(15.dp),
//        contentPadding = PaddingValues(15.dp)
//    ) {
//        items(count = 3) { index ->
//            val expanded = remember {
//                mutableStateOf(index == currentExpandedPosition.value)
//            }
//            ExpandableCard(
//                expanded = expanded,
//                headingContent = @Composable { headingModifier ->
//                    OrderHeader(
//                        modifier = headingModifier
//                            .padding(start = 16.dp)
//                            .fillMaxWidth(),
//                    )
//                },
//                onExpandCallback = {
//                    currentExpandedPosition.value = index
//                },
//                expandedContent = @Composable {
//                    OrderContent(
//                        modifier = Modifier
//                            .padding(16.dp)
//                            .fillMaxWidth()
//                    )
//                },
//                border = if (expanded.value)
//                    BorderStroke(1.dp, color = Color.parse("#2E6ACF"))
//                else
//                    BorderStroke(1.dp, color = Color.parse("#0D000000")),
//                elevation = 1.dp
//            )
//        }
//    }
//}
//
//@Preview()
//@Composable
//fun OrderContent(modifier: Modifier = Modifier) {
//    Column(
//        modifier = modifier
//            .background(Color.White)
//    ) {
//        OrderItemRow(
//            index = 2,
//            size = 4,
//            modifier = Modifier.fillMaxWidth()
//        )
//
//    }
//}
//
//@Composable
//fun OrderHeader(
//    modifier: Modifier = Modifier,
//) {
//    ConstraintLayout(modifier = modifier.padding(vertical = 8.dp)) {
//        val (statusRef, trackButtonRef, idHeaderRef, orderNoRef, dividerRef, dateHeaderRef, dateRef) = createRefs()
//
//        Text(
//            text = "status name",
//            fontSize = with(LocalDensity.current) {
//                (12 / fontScale).sp
//            },
//            fontFamily = PoppinsFonts,
//            textAlign = TextAlign.Start,
//            fontWeight = FontWeight.W500,
//            color = Color.parse("#FED704"),
//            overflow = TextOverflow.Ellipsis,
//            modifier = Modifier
//                .constrainAs(statusRef) {
//                    top.linkTo(parent.top)
//                    start.linkTo(parent.start)
//                }
//                .clickable {
////                    onTrackClick(order.orderId)
//                }
//        )
//
//
//        Text(
//            text = "order header",//stringResource(R.string.order_id_heading),
//            fontSize = with(LocalDensity.current) {
//                (12 / fontScale).sp
//            },
//            fontFamily = PoppinsFonts,
//            textAlign = TextAlign.Start,
//            fontWeight = FontWeight.W500,
//            color = Color.parse("#808080"),
//            overflow = TextOverflow.Ellipsis,
//            modifier = Modifier.constrainAs(idHeaderRef) {
//                top.linkTo(statusRef.bottom, 15.dp)
//                start.linkTo(statusRef.start)
//            }
//        )
//
//        Text(
//            text = "order no",//order.orderNo,
//            fontSize = with(LocalDensity.current) {
//                (14 / fontScale).sp
//            },
//            fontFamily = PoppinsFonts,
//            textAlign = TextAlign.Start,
//            fontWeight = FontWeight.W600,
//            color = Color.parse("#3A3A3A"),
//            overflow = TextOverflow.Ellipsis,
//            modifier = Modifier.constrainAs(orderNoRef) {
//                top.linkTo(idHeaderRef.bottom, 8.dp)
//                start.linkTo(idHeaderRef.start)
//                bottom.linkTo(trackButtonRef.top, 4.dp)
//            }
//        )
//
//        Text(
//            text = "shipping type",// order.shippingType.title,
//            fontSize = with(LocalDensity.current) {
//                (12 / fontScale).sp
//            },
//            fontFamily = PoppinsFonts,
//            textAlign = TextAlign.Start,
//            fontWeight = FontWeight.W500,
//            color = Color.parse("#808080"),
//            overflow = TextOverflow.Ellipsis,
//            modifier = Modifier.constrainAs(dateHeaderRef) {
//                bottom.linkTo(dateRef.top, 8.dp)
//                end.linkTo(dateRef.end)
//            }
//        )
//
//        Text(
//            text = "expected time",// order.shippingType.expectedTime,
//            fontSize = with(LocalDensity.current) {
//                (14 / fontScale).sp
//            },
//            fontFamily = PoppinsFonts,
//            textAlign = TextAlign.Start,
//            fontWeight = FontWeight.W400,
//            color = Color.parse("#3A3A3A"),
//            maxLines = 1,
//            overflow = TextOverflow.Ellipsis,
//            modifier = Modifier.constrainAs(dateRef) {
//                top.linkTo(orderNoRef.top)
//                start.linkTo(orderNoRef.end, 20.dp)
//                end.linkTo(parent.end)
//            }
//        )
//
//        DashedDivider(
//            modifier = Modifier.constrainAs(dividerRef) {
//                top.linkTo(dateRef.bottom, 8.dp)
//                centerHorizontallyTo(parent)
//                width = Dimension.fillToConstraints
//            }
//        )
//
//        Button(
//            onClick = { },
//            elevation = ButtonDefaults.elevation(
//                defaultElevation = 0.dp,
//                disabledElevation = 0.dp,
//                pressedElevation = 0.dp,
//            ),
//            modifier = Modifier
//                .constrainAs(trackButtonRef) {
//                    top.linkTo(dividerRef.bottom)
//                    centerHorizontallyTo(parent)
//                    width = Dimension.fillToConstraints
//                    bottom.linkTo(parent.bottom)
//                },
//            backgroundColor = Color.Transparent
//        ) {
//            Text(
//                text = "track",//stringResource(R.string.track_cta),
//                fontFamily = PoppinsFonts,
//                fontWeight = FontWeight.W600,
//                fontSize = with(LocalDensity.current) {
//                    (12 / fontScale).sp
//                },
//                color = Color.parse("#2364C8"),
//                textAlign = TextAlign.Start,
//            )
//        }
//        createHorizontalChain(orderNoRef, dateRef, chainStyle = ChainStyle.SpreadInside)
//    }
//}
//
//@Preview
//@Composable
//fun OrderHeaderPreview() {
//    ConsumerTheme {
//        OrderHeader(
////            orderNo = "test",
////            items = listOf(OrderItemUIModel(name = "Test product", qty = 1, category = "rts")),
////            shippingType = DeliveryType("Delivery Date", "hjbhjbhjbhjb"),
//            modifier = Modifier.fillMaxWidth()
//        )
//    }
//}
//
//@Composable
//fun OrderItemRow(
//    //orderItem: OrderItemUIModel,
//    index: Int,
//    size: Int,
//    modifier: Modifier = Modifier,
//) {
//    ConstraintLayout(modifier = modifier) {
//        val (imageRef, nameRef, qtyRef, categoryRef, dividerRef) = createRefs()
//
//        //val imagePainter = rememberAsyncImagePainter(model = orderItem.imageUrl)
//        Image(
//            painterResource(id = com.one.pharma.consumer.resources.R.drawable.placeholder),
//            contentDescription = "",
//            modifier = Modifier.constrainAs(imageRef) {
//                start.linkTo(parent.start)
//                top.linkTo(parent.top)
//                bottom.linkTo(dividerRef.top, 5.dp)
//                width = Dimension.value(60.dp)
//                height = Dimension.value(60.dp)
//            }
//        )
//
//        Text(
//            text = "order item",//orderItem.name,
//            fontSize = with(LocalDensity.current) {
//                (14 / fontScale).sp
//            },
//            fontFamily = PoppinsFonts,
//            textAlign = TextAlign.Start,
//            fontWeight = FontWeight.W400,
//            color = Color.Black,
//            maxLines = 1,
//            overflow = TextOverflow.Ellipsis,
//            modifier = Modifier.constrainAs(nameRef) {
//                top.linkTo(parent.top, 2.dp)
//                start.linkTo(imageRef.end, 10.dp)
//            }
//        )
//
//        Text(
//            text = "QTY : 1",
//            fontSize = with(LocalDensity.current) {
//                (14 / fontScale).sp
//            },
//            fontFamily = PoppinsFonts,
//            textAlign = TextAlign.Start,
//            fontWeight = FontWeight.W400,
//            color = Color.parse("#3A3A3A"),
//            maxLines = 1,
//            overflow = TextOverflow.Ellipsis,
//            modifier = Modifier.constrainAs(qtyRef) {
//                top.linkTo(nameRef.bottom, 3.dp)
//                bottom.linkTo(dividerRef.top, 5.dp)
//                start.linkTo(imageRef.end, 10.dp)
//            }
//        )
//
//        Text(
//            text = "Category",  //orderItem.category,
//            fontSize = with(LocalDensity.current) {
//                (12 / fontScale).sp
//            },
//            fontFamily = PoppinsFonts,
//            textAlign = TextAlign.Start,
//            fontWeight = FontWeight.W400,
//            color = Color.parse("#7A869A"),
//            maxLines = 1,
//            overflow = TextOverflow.Ellipsis,
//            modifier = Modifier.constrainAs(categoryRef) {
//                top.linkTo(nameRef.bottom, 3.dp)
//                bottom.linkTo(dividerRef.top, 5.dp)
//                start.linkTo(qtyRef.end, 5.dp)
//                end.linkTo(parent.end, 5.dp)
//            }
//        )
//
//        if (index != size - 1)
//            Divider(
//                modifier = Modifier
//                    .height(1.dp)
//                    .constrainAs(dividerRef) {
//                        start.linkTo(parent.start, 16.dp)
//                        end.linkTo(parent.end, 16.dp)
//                        bottom.linkTo(parent.bottom, 6.dp)
//                    }
//            )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun showOrderScreen(){
//    ConsumerTheme {
//        MyOrdersScreen()
//    }
//}