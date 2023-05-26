/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codelab.basiclayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelab.basiclayouts.ui.theme.MySootheTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MySootheApp() }
    }
}

// Step: Search bar - Modifiers
@Composable
fun SearchBar( //검색 바 만들기
    modifier: Modifier = Modifier
) {
    TextField(
        //입력 가능한 텍스트 요소
        value = "",//초기값 지정
        onValueChange = {},//값 바뀔때 호출
        leadingIcon = { //앞쪽 아이콘
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
            )
        },
        colors = androidx.compose.material3.TextFieldDefaults.colors(//m3요소에 m1요소 특성 넣으면 빨간줄됨
            unfocusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(stringResource(id = R.string.placeholder_search))
        },
        modifier = modifier
            .fillMaxWidth() //상위요소의 전체 가로 공간 차지하도록 설정
            .heightIn(min = 56.dp), //요소의 높이를 고정 높이가 아닌 최소높이로 지정하여 내용물에 따라 크기 변할 수 있도록 설정(권장)

    )
}

// Step: Align your body - Alignment
@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text:Int,
    modifier: Modifier = Modifier
) {
    // Implement composable here
    Column(
       // modifier=modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally // 내용물의 정렬설정
    ){
        Image(
            painter= painterResource(id = drawable), //이미지 리소스
            contentDescription = null, //해당요소에 대한 설명
            modifier= Modifier
                .size(88.dp) //요소의 사이즈 지정
                .clip(CircleShape), //이미지를 원형으로 자르기
            contentScale= ContentScale.Crop // 내용물을 자른 모양에 맞춰 스케일링
        )
        Text(
            text= stringResource(id = text),
            style=MaterialTheme.typography.labelMedium,// 글꼴 설정
            modifier=Modifier.paddingFromBaseline(
                top=24.dp,
                bottom=8.dp
            )//이 요소의 베이스라인인 글씨 아래선을 기준해서 위쪽으로 24dp, 아래쪽으로 8dp만큼 패딩 설정

        )
    }
}

// Step: Favorite collection card - Material Surface
@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable:Int,
    @StringRes text:Int,
    modifier: Modifier = Modifier
) {
    Surface(//내용물과 통째로 잘린 모서리를 표현하기 위해 Surface요소사용
        //modifier=modifier.clip(RoundedCornerShape(3.dp)) //둥근 모서리 적용
        shape=MaterialTheme.shapes.small, //m3에 정의된 둥근 모서리 적용
        modifier = modifier
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically, //내용물을 정렬
            modifier=Modifier.width(192.dp)//너비 지정
        ){
            Image(
                painter = painterResource(drawable),
                contentDescription =null,
                modifier=Modifier.size(56.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text= stringResource(text),
                style=MaterialTheme.typography.labelMedium,
                modifier=Modifier.padding(horizontal=16.dp),


            )

        }
    }
}

// Step: Align your body row - Arrangements
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    //import androidx.compose.foundation.lazy.items 이것 필요
    LazyRow(
        modifier=Modifier, //패딩으로 양옆 간격 벌릴시 스크롤이 잘림
        contentPadding= PaddingValues(horizontal = 16.dp), // 컨텐츠가 잘리지 않게 패딩추가
        horizontalArrangement = Arrangement.spacedBy(8.dp), //각 아이템 사이의 간격 설정
    ){
        items(alignYourBodyData) {item ->
            AlignYourBodyElement(drawable = item.drawable, text = item.text)
        }
    }
}

// Step: Favorite collections grid - LazyGrid
@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        modifier=Modifier.height(120.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement=Arrangement.spacedBy(8.dp),
        contentPadding= PaddingValues(horizontal=16.dp),
        rows = GridCells.Fixed(2) //열 개수 지정
    ){
        //androidx.compose.foundation.lazy.graid.items 임포트 필요
        items(favoriteCollectionsData) {item->
            FavoriteCollectionCard(
                drawable = item.drawable,
                text = item.text,
                modifier=Modifier.height(56.dp)
            )
        }
    }

}

// Step: Home section - Slot APIs
@Composable
fun HomeSection(
    @StringRes title:Int,
    modifier: Modifier = Modifier,
    content: @Composable ()->Unit

) {
    Column(modifier){
        Text(
            text=stringResource(title).uppercase(),//모두 대문자로 표기
            style=MaterialTheme.typography.headlineSmall,
            modifier= Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

// Step: Home screen - Scrolling
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier
            .verticalScroll(rememberScrollState()) //스크롤 기능 추가
            .padding(vertical = 16.dp)
    ){
       // Spacer(modifier =Modifier.height(16.dp)) // 빈공간 생성
        SearchBar(modifier=Modifier.padding(horizontal=16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid()
        }
        //Spacer(modifier=Modifier.height(16.dp))
    }
}

// Step: Bottom navigation - Material
@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(
        modifier,
        backgroundColor = MaterialTheme.colorScheme.background//배경색 설정
    ) {
        BottomNavigationItem(
            icon = { // 해당 버튼의 아이콘
                Icon(
                    imageVector = Icons.Default.Spa,
                    contentDescription = null
                )
            },
            label={ //해당 버튼의 텍스트
                Text(stringResource(id = R.string.bottom_navigation_home))
            },
            selected = true, //눌러진 상태로 설정할건지
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label={
                Text(stringResource(id = R.string.bottom_navigation_profile))
            },
            selected = false,
            onClick = {}
        )
    }
}

// Step: MySoothe App - Scaffold
@Composable
fun MySootheApp() {
    // Implement composable here
}

private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun SearchBarPreview() {
    MySootheTheme { SearchBar(Modifier.padding(8.dp)) }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AlignYourBodyElementPreview() {
    MySootheTheme {
        AlignYourBodyElement(
            drawable=R.drawable.ab1_inversions,
            text=R.string.ab1_inversions,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun FavoriteCollectionCardPreview() {
    MySootheTheme {
        FavoriteCollectionCard(
            R.drawable.fc2_nature_meditations,
            R.string.fc2_nature_meditations,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun FavoriteCollectionsGridPreview() {
    MySootheTheme { FavoriteCollectionsGrid() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AlignYourBodyRowPreview() {
    MySootheTheme { AlignYourBodyRow() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HomeSectionPreview() {
    MySootheTheme {
        HomeSection(R.string.align_your_body){AlignYourBodyRow()}

    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2, heightDp = 180)
@Composable
fun ScreenContentPreview() {
    MySootheTheme { HomeScreen() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun BottomNavigationPreview() {
    MySootheTheme { SootheBottomNavigation(Modifier.padding(top = 24.dp)) }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun MySoothePreview() {
    MySootheApp()
}
