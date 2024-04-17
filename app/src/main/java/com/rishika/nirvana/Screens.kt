package com.rishika.nirvana

sealed class Screens(val screen: String) {
    data object Meditation: Screens("meditation")
    data object Yoga: Screens("yoga")
    data object Exercise: Screens("exercise")
    data object Chatbot: Screens("chatbot")
    data object Profile: Screens("profile")
}