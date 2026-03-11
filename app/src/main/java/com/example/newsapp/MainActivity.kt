package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.newsapp.ui.theme.NewsAPPTheme




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAPPTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NewsScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun NewsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        CategoryTabs()
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Ultimas noticias",
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black
        )


        Spacer(modifier = Modifier.height(16.dp))

        LatestNewsSection()

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Alrededor del mundo",
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))
        WorldNewsSection()
        Spacer(modifier = Modifier.height(16.dp))
    }


}
@Composable
fun LatestNewsSection() {

    androidx.compose.foundation.lazy.LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(3) {
            NewsCard()
        }
    }
}

@Composable
fun NewsCard() {
    Card(
        modifier = Modifier
            .width(280.dp)
            .height(200.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF6B4DFF))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "El presidente de EE.UU. no muestra signos de arrepentimiento...",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 28.sp
            )

            Text(
                text = "febrero 08 - 2024",
                color = Color.LightGray,
                fontSize = 14.sp
            )


        }


    }

}
@Composable
fun WorldNewsSection() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            WorldNewsItem(
                modifier = Modifier.weight(1f),
                title = "El presidente de EE.UU. no muestra signos de arrepentimiento...",
                imageUrl = "https://ca-times.brightspotcdn.com/dims4/default/dcde335/2147483647/strip/true/crop/5091x3394+0+5/resize/2400x1600!/format/webp/quality/75/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2Fde%2F48%2F8991d3b543c589f47ed6ed2ecc1d%2Felection-2024-trump-37817.jpg"
            )
            WorldNewsItem(
                modifier = Modifier.weight(1f),
                title = "Bañarse en la piscina del desierto de Cleopatra",
                imageUrl = "https://static.wikia.nocookie.net/amor-de-otro-mundo/images/b/b0/Cleopatra.png/revision/latest?cb=20221211124811&path-prefix=es"
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            WorldNewsItem(
                modifier = Modifier.weight(1f),
                title = "Gigantes tecnológicos" ,
                imageUrl = "https://www.gaceta.unam.mx/wp-content/uploads/2023/04/230424-aca4-des-f1-gigantes-tecnologicos-internet.jpg"
            )
            WorldNewsItem(
                modifier = Modifier.weight(1f),
                title = "El rover de Marte envía",
                imageUrl = "https://images.milenio.com/y6f13VWXehk5Q7TYwsF-xzEtYtc=/942x532/uploads/media/2021/08/09/rover-curiosity-de-la-nasa.jpg"
            )
        }
    }
}

@Composable
fun WorldNewsItem(modifier: Modifier = Modifier, title: String, imageUrl: String) {
    Card(
        modifier = modifier.height(180.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Card(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFD9D9D9).copy(alpha = 0.9f))
            ) {
                Text(
                    text = title,
                    modifier = Modifier.padding(8.dp),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 16.sp,
                    maxLines = 3,
                    color = Color.Black
                )
            }
        }
    }
}
@Composable
fun SearchBar() {
    OutlinedCard(
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = CardDefaults.outlinedCardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home",
                tint = Color.Black
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Buscar",
                color = Color.Gray,
                fontSize = 18.sp,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.Gray
            )
        }
    }
}

@Composable
fun CategoryTabs() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CategoryItem("Noticias", isSelected = true)
        CategoryItem("Eventos", isSelected = false)
        CategoryItem("Clima", isSelected = false)
    }
}

@Composable
fun CategoryItem(name: String, isSelected: Boolean) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = if (isSelected) Color.Black else Color.LightGray
        )
        if (isSelected) {
            Box(
                modifier = Modifier
                    .height(3.dp)
                    .width(40.dp)
                    .background(Color(0xFF6200EE), RoundedCornerShape(2.dp))
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NewsScreenPreview() {
    NewsAPPTheme {
        NewsScreen()
    }
}