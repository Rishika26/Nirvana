package com.rishika.nirvana

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
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rishika.nirvana.data.MedType

data class Badge(
    val text: String,
    val color: Color
)
data class ExType(
    val title: String,
    val duration: String,
    val image: Int,
    val badges: List<Badge>
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
        )
    ),
    ExType(
        title = "JUMPING ROPE",
        duration = "00:30",
        image = R.drawable.jumpingrope,
        badges = listOf(
            Badge("Cardio", Color.Green), // Example badge with green color
            Badge("Endurance", Color.Blue)  // Example badge with blue color
        )
    ),
    ExType(
        title = "FROG CRUNCHES",
        duration = "00:30",
        image = R.drawable.frogcrunches,
        badges = listOf(
            Badge("Core", Color.Yellow), // Example badge with green color
            Badge("Flexibilty", Color.Magenta)  // Example badge with blue color
        )
    ),
    ExType(
        title = "HIGH KNEES",
        duration = "00:30",
        image = R.drawable.highknees,
        badges = listOf(
            Badge("Cardio", Color.Green), // Example badge with green color
            Badge("Lower Body", Color.White)  // Example badge with blue color
        )
    ),

    ExType(
        title = "PLANK",
        duration = "00:30",
        image = R.drawable.plank,
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
        badges = listOf(
            Badge("Upper Body", Color.Black), // Example badge with green color
            Badge("Endurance", Color.Blue)  // Example badge with blue color
        )
    ),
    ExType(
        title = "STANDING SIDE BEND",
        duration = "00:30",
        image = R.drawable.standingsidebend,
        badges = listOf(
            Badge("Core", Color.Yellow), // Example badge with green color
            Badge("Flexibility", Color.Magenta)  // Example badge with blue color
        )

    ),
    ExType(
        title = "ARM CIRCLES",
        duration = "00:30",
        image = R.drawable.armcircle,
        badges = listOf(
            Badge("Shoulder Strength", Color.Red), // Example badge with green color
            Badge("Flexibility", Color.Magenta)  // Example badge with blue color
        )
    ),
    ExType(
        title = "BIG ARM CIRCLES",
        duration = "00:30",
        image = R.drawable.bigarmcircles,
        badges = listOf(
            Badge("Shoulder Strength", Color.Red), // Example badge with green color
            Badge("Flexibility", Color.Magenta)  // Example badge with blue color
        )
    ),
    ExType(
        title = "PLANK SHOULDER TAPS",
        duration = "00:30",
        image = R.drawable.plankshouldertaps,
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
        badges = listOf(
            Badge("Lower Body", Color.White), // Example badge with green color
            Badge("Endurance", Color.Blue)  // Example badge with blue color
        )
    ),
    ExType(
        title = "COSSACK SQUATS",
        duration = "00:30",
        image = R.drawable.cossacksquat,
        badges = listOf(
            Badge("Lower Body", Color.White), // Example badge with green color
            Badge("Flexibility", Color.Magenta)  // Example badge with blue color
        )
    ),
    ExType(
        title = "CRAB KICKS",
        duration = "00:30",
        image = R.drawable.crabkicks,
        badges = listOf(
            Badge("Lower Body", Color.White), // Example badge with green color
            Badge("Cardio", Color.Green)  // Example badge with blue color
        )
    ),
    ExType(
        title = "MARCH IN PLACE",
        duration = "00:30",
        image = R.drawable.marchinplace,
        badges = listOf(
            Badge("Lower Body", Color.White), // Example badge with green color
            Badge("Cardio", Color.Green)  // Example badge with blue color
        )
    ),
    ExType(
        title = "SHRIMP SQUATS",
        duration = "00:30",
        image = R.drawable.shrimpsquat,
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

@Preview
@Composable
fun Exercise() {
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
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.primary,)
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
                )
            }
        }

    }
}

@Composable
fun ExerciseCard(index: Int) {
    val ex = exTypes[index]
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(10.dp))
            .clickable { }
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

//                Row {
//                    // Display colored dots below duration
//                    ex.badges.forEach { badge ->
//                        Box(
//                            modifier = Modifier
//                                .size(10.dp)
//                                .background(badge.color, RoundedCornerShape(8.dp))
//                                .padding(end = 14.dp)
//                        ){
//                            Text(
//                                text = badge.text,
//                                style = MaterialTheme.typography.bodySmall,
//                                color = MaterialTheme.colorScheme.onPrimary,
//                                fontSize = 10.sp
//                            )
//                        }
//                    }
                }
            }

        }
    }
}




