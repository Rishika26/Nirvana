package com.rishika.nirvana.ui.theme.navigation

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rishika.nirvana.Chatbot
import com.rishika.nirvana.Exercise
import com.rishika.nirvana.Meditation
import com.rishika.nirvana.Profile
import com.rishika.nirvana.R
import com.rishika.nirvana.Screens
import com.rishika.nirvana.Yoga


@Composable
fun BottomNavigation() {
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(R.drawable.meditationhand)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                content = {
                    IconButton(onClick = {
                        selected.value = R.drawable.meditationhand
                        navigationController.navigate("meditation")
                    },
                        modifier = Modifier.weight(1f)
                        ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(50.dp)
                                .background(
                                color = if (selected.value == R.drawable.meditationhand) Color.LightGray else Color.Transparent,
                                shape = CircleShape

                            )
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.meditationhand),
                                contentDescription = "Meditation",
                                modifier = Modifier.size(26.dp),
                                tint = if (selected.value == R.drawable.meditationhand) Color.Black else Color.DarkGray
                            )
                        }
//

                    }
                    IconButton(onClick = {
                        selected.value = R.drawable.yogahand
                        navigationController.navigate("yoga")
                    },
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(50.dp)
                                .background(
                                color = if (selected.value == R.drawable.yogahand) Color.LightGray else Color.Transparent,
                                shape = CircleShape
                            )
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.yogahand),
                                contentDescription = "Yoga",
                                modifier = Modifier.size(26.dp),
                                tint = if (selected.value == R.drawable.yogahand) Color.Black else Color.DarkGray
                            )
                        }

                    }
                    IconButton(onClick = {
                        selected.value = R.drawable.bicep
                        navigationController.navigate("exercise")
                    },
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(50.dp)
                                .background(
                                    color = if (selected.value == R.drawable.bicep) Color.LightGray else Color.Transparent,
                                    shape = CircleShape
                                )
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.bicep),
                                contentDescription = "Exercise",
                                modifier = Modifier.size(26.dp),
                                tint = if (selected.value == R.drawable.bicep) Color.Black else Color.DarkGray
                            )

                        }
                    }
                    IconButton(onClick = {
                        selected.value = R.drawable.chatbot
                        navigationController.navigate("chatbot")
                    },
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(50.dp)
                                .background(
                                    color = if (selected.value == R.drawable.chatbot) Color.LightGray else Color.Transparent,
                                    shape = CircleShape
                                )
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.chatbot),
                                contentDescription = "Exercise",
                                modifier = Modifier.size(26.dp),
                                tint = if (selected.value == R.drawable.chatbot) Color.Black else Color.DarkGray
                            )

                        }
                    }

                    IconButton(onClick = {
                        selected.value = R.drawable.profile
                        navigationController.navigate("profile")
                    },
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(50.dp)
                                .background(
                                    color = if (selected.value == R.drawable.profile) Color.LightGray else Color.Transparent,
                                    shape = CircleShape
                                )
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.profile),
                                contentDescription = "Exercise",
                                modifier = Modifier.size(26.dp),
                                tint = if (selected.value == R.drawable.profile) Color.Black else Color.DarkGray
                            )

                        }
                    }
//
                }
            )
        }
    ) {paddingValues ->
        NavHost(navController = navigationController,
            startDestination = Screens.Meditation.screen,
            modifier = Modifier.padding(paddingValues)) {
            composable(Screens.Meditation.screen){ Meditation()}
            composable(Screens.Yoga.screen){ Yoga() }
            composable(Screens.Exercise.screen){ Exercise() }
            composable(Screens.Chatbot.screen){ Chatbot() }
            composable(Screens.Profile.screen){ Profile() }
        }
    }
}

@Preview
@Composable
private fun BottomNavigationPreview() {
    BottomNavigation()
}

