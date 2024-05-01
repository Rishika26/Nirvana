package com.rishika.nirvana

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import kotlinx.coroutines.launch

data class Badge(
    val text: String,
    val color: Color
)

data class ExType(
    val title: String,
    val duration: String,
    val image: Int,
    val badges: List<Badge>,
    val gif: Int = R.drawable.frogcrunches_motion,
)

val exTypes = listOf(
    //belly
    ExType(
        title = "CROSS CRUNCHES",
        duration = "00:30",
        image = R.drawable.crosscrunches,
        badges = listOf(
            Badge("Abs", Color.Red), // Example badge with green color
            Badge("Core", Color.Yellow)  // Example badge with blue color
        ),
        gif = R.drawable.crosscrunches_motion
    ),
    ExType(
        title = "JUMPING ROPE",
        duration = "00:30",
        image = R.drawable.jumpingrope,
        gif = R.drawable.jumpingrope_motion,
        badges = listOf(
            Badge("Cardio", Color.Green), // Example badge with green color
            Badge("Endurance", Color.Blue)  // Example badge with blue color
        )
    ),
    ExType(
        title = "FROG CRUNCHES",
        duration = "00:30",
        image = R.drawable.frogcrunches,
        gif = R.drawable.frogcrunches_motion,
        badges = listOf(
            Badge("Core", Color.Yellow), // Example badge with green color
            Badge("Flexibilty", Color.Magenta)  // Example badge with blue color
        )
    ),
    ExType(
        title = "HIGH KNEES",
        duration = "00:30",
        image = R.drawable.highknees,
        gif = R.drawable.highknees_motion,
        badges = listOf(
            Badge("Cardio", Color.Green), // Example badge with green color
            Badge("Lower Body", Color.White)  // Example badge with blue color
        )
    ),

    ExType(
        title = "PLANK",
        duration = "00:30",
        image = R.drawable.plank,
        gif = R.drawable.plank_motion,
        badges = listOf(
            Badge("Core", Color.Yellow), // Example badge with green color
            Badge("Stability", Color.Gray)  // Example badge with blue color
        )
    ),
//
//    //arm
    ExType(
        title = "PUSH-UPS",
        duration = "00:30",
        image = R.drawable.pushup,
        gif = R.drawable.pushup_motion,
        badges = listOf(
            Badge("Upper Body", Color.Black), // Example badge with green color
            Badge("Endurance", Color.Blue)  // Example badge with blue color
        )
    ),
    ExType(
        title = "STANDING SIDE BEND",
        duration = "00:30",
        image = R.drawable.standingsidebend,
        gif = R.drawable.standingsidebend_motion,
        badges = listOf(
            Badge("Core", Color.Yellow), // Example badge with green color
            Badge("Flexibility", Color.Magenta)  // Example badge with blue color
        )

    ),
    ExType(
        title = "ARM CIRCLES",
        duration = "00:30",
        image = R.drawable.armcircle,
        gif = R.drawable.armcircle_motion,
        badges = listOf(
            Badge("Shoulder Strength", Color.Red), // Example badge with green color
            Badge("Flexibility", Color.Magenta)  // Example badge with blue color
        )
    ),
    ExType(
        title = "BIG ARM CIRCLES",
        duration = "00:30",
        image = R.drawable.bigarmcircles,
        gif = R.drawable.bigarmcircles_motion,
        badges = listOf(
            Badge("Shoulder Strength", Color.Red), // Example badge with green color
            Badge("Flexibility", Color.Magenta)  // Example badge with blue color
        )
    ),
    ExType(
        title = "PLANK SHOULDER TAPS",
        duration = "00:30",
        image = R.drawable.plankshouldertaps,
        gif = R.drawable.plankshouldertaps_motion,
        badges = listOf(
            Badge("Core", Color.Yellow), // Example badge with green color
            Badge("Stability", Color.Gray)  // Example badge with blue color
        )
    ),
//    //leg
    ExType(
        title = "WALKING LUNGES",
        duration = "00:30",
        image = R.drawable.walkinglunges,
        gif = R.drawable.walkinglunges_motion,
        badges = listOf(
            Badge("Lower Body", Color.White), // Example badge with green color
            Badge("Endurance", Color.Blue)  // Example badge with blue color
        )
    ),
    ExType(
        title = "COSSACK SQUATS",
        duration = "00:30",
        image = R.drawable.cossacksquat,
        gif = R.drawable.cossacksquat_motion,
        badges = listOf(
            Badge("Lower Body", Color.White), // Example badge with green color
            Badge("Flexibility", Color.Magenta)  // Example badge with blue color
        )
    ),
    ExType(
        title = "CRAB KICKS",
        duration = "00:30",
        image = R.drawable.crabkicks,
        gif = R.drawable.crabkicks_motion,
        badges = listOf(
            Badge("Lower Body", Color.White), // Example badge with green color
            Badge("Cardio", Color.Green)  // Example badge with blue color
        )
    ),
    ExType(
        title = "MARCH IN PLACE",
        duration = "00:30",
        image = R.drawable.marchinplace,
        gif = R.drawable.marchinplace_motion,
        badges = listOf(
            Badge("Lower Body", Color.White), // Example badge with green color
            Badge("Cardio", Color.Green)  // Example badge with blue color
        )
    ),
    ExType(
        title = "SHRIMP SQUATS",
        duration = "00:30",
        image = R.drawable.shrimpsquat,
        gif = R.drawable.shrimpsquat_motion,
        badges = listOf(
            Badge("Lower Body", Color.White), // Example badge with green color
            Badge("Flexibility", Color.Magenta)  // Example badge with blue color
        )
    ),
//
//    //chest
    ExType(
        title = "ASYMMETRIC PUSH-UPS",
        duration = "00:30",
        image = R.drawable.asymmetricpushup,
        gif = R.drawable.asymmetricpushup_motion,
        badges = listOf(
            Badge("Upper Body", Color.Black), // Example badge with green color
            Badge("Endurance", Color.Blue)  // Example badge with blue color
        )
    ),
    ExType(
        title = "PIKE PUSH-UPS",
        duration = "00:30",
        image = R.drawable.pikepushup,
        badges = listOf(
            Badge("Upper Body", Color.Black), // Example badge with green color
            Badge("Endurance", Color.Blue)  // Example badge with blue color
        )
    ),
//
    ExType(
        title = "SIDE PLANK",
        duration = "00:30",
        image = R.drawable.sideplank,
        badges = listOf(
            Badge("Core", Color.Yellow), // Example badge with green color
            Badge("Stability", Color.Gray)  // Example badge with blue color
        )
    ),
    ExType(
        title = "SIT-UPS",
        duration = "00:30",
        image = R.drawable.situp,
        badges = listOf(
            Badge("Abs", Color.Red), // Example badge with green color
            Badge("Core", Color.Yellow)  // Example badge with blue color
        )
    ),

    )

@Composable
fun ExerciseDetail(
    exType: ExType
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val imageLoader = ImageLoader.Builder(LocalContext.current)
            .components {
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder.Factory())
                } else {
                    add(GifDecoder.Factory())
                }
            }
            .build()
        val painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current).data(data = exType.gif)
                .apply(block = {
                    size(Size.ORIGINAL)
                }).build(), imageLoader = imageLoader
        )
        Image(
            painter = painter,
            contentDescription = "Exercise",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = exType.title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = exType.duration,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.height(8.dp))

            exType.badges.forEach { badge ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .background(badge.color, RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = badge.text,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Exercise() {

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    val selectedEx = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {

            }) {
                Icon(
                    Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.primary,
                )
            }
            Text(
                text = "Exercise",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(16.dp)
            )
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(exTypes.size) { index ->
                ExerciseCard(
                    index = index
                ) {
                    selectedEx.value = index
                    showBottomSheet = true
                }
            }
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState
            ) {
                ExerciseDetail(exTypes[selectedEx.value])
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ExerciseDetailPreview() {
    ExerciseDetail(exTypes[0])
}

@Composable
fun ExerciseCard(
    index: Int,
    onClick: (index: Int) -> Unit = {}
) {
    val ex = exTypes[index]
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(10.dp))
            .clickable {
                onClick(index)
            }
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
//            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = ex.image),
                contentScale = ContentScale.FillBounds,
                contentDescription = "Meditation",
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(10.dp)),
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column {
                Text(
                    text = ex.title,
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = ex.duration,
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    // Display rounded colored badges beside duration
                    ex.badges.forEach { badge ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(end = 14.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(12.dp)
                                    .background(badge.color, RoundedCornerShape(8.dp))
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = badge.text,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }

                }
            }
        }
    }
}




