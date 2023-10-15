package com.example.devmuscles

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.devmuscles.ui.theme.AppGreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SlideScreenUI(){
   var pagerState = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize()){
        HorizontalPager(pageCount = 3, state = pagerState, pageSize = PageSize.Fill, modifier = Modifier.fillMaxSize()) {index ->
            when(index){
                0 -> SlideScreenOne()
                1 -> SlideScreenTwo()
                2 -> SlideScreenThree()
            }
        }
        Row(
            Modifier
                .height(40.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(3) { iteration ->
                val color = if (pagerState.currentPage == iteration) AppGreen else Color.DarkGray
                val width = if(pagerState.currentPage == iteration) 40.dp else 15.dp
                Box(
                    modifier = Modifier
                        .padding(3.dp)
                        .clip(CircleShape)
                        .background(color)
                        .width(width)
                        .height(4.dp)

                )
            }
        }
    }
}

@Composable
fun SlideScreenOne(){
    InitialScreen(imageId = R.drawable.slide1, heading = "MEET YOUR COACH,", subHeading = "START YOUR JOURNEY", sidx=0)
}

@Composable
fun SlideScreenTwo(){
    InitialScreen(imageId = R.drawable.slide2, heading = "CREATE A WORKOUT PLAN", subHeading = "TO STAY FIT", sidx=1)
}

@Composable
fun SlideScreenThree(){
    InitialScreen(imageId = R.drawable.slide3, heading = "ACTION IS THE", subHeading = "KEY TO ALL SUCCESS",sidx=2)
}

@Composable
fun InitialScreen(imageId: Int, heading: String, subHeading: String,sidx:Int){
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = imageId), contentDescription = "", modifier = Modifier
            .padding(horizontal = 0.dp)
            .fillMaxSize(), alignment = Alignment.TopCenter,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0.5f) })
            )
        BoxWithConstraints(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.TopCenter)){
            val trianglePath = Path().apply {
                // Moves to top center position
                moveTo( 0f, constraints.maxHeight/1.65f)

                // 2)
                lineTo(constraints.maxWidth*1f, constraints.maxHeight/1.65f)

                // 3)
                lineTo(constraints.maxWidth*1f, constraints.maxHeight/2f)
            }
            Canvas(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
            ) {
                drawPath(path = trianglePath, color = Color.Black)
            }
        }
        Box(modifier = Modifier
            .align(Alignment.BottomCenter)
            .background(Color.Black)
            .fillMaxWidth()
            .fillMaxHeight(0.394f), contentAlignment = Alignment.TopCenter){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(40.dp))
                Text(text = heading, color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 30.sp)
                Text(text = subHeading, color = Color.White, fontWeight = FontWeight.Black, fontSize = 32.sp)
                if(sidx==2){
                    Spacer(modifier = Modifier.height(40.dp))
                    Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = AppGreen, contentColor = Color.Black)) {
                        Row(horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Start Now")
                            Spacer(modifier = Modifier.width(5.dp))
                            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "")
                        }
                    }
                }
            }
        }
    }
}