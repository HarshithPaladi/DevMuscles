package com.example.devmuscles.data

import com.example.devmuscles.R
import com.example.devmuscles.model.FitnessTrainer
import com.example.devmuscles.model.WorkoutCategory

var beginnerWorkoutList = listOf<WorkoutCategory>(
    WorkoutCategory("Wake Up Call","04 Workouts for Beginner", R.drawable.woc1, false),
    WorkoutCategory("Full Body Goal Crusher","07 Workouts for Beginner", R.drawable.woc2, true),
    WorkoutCategory("Lower Body Strength","05 Workouts  for Beginner", R.drawable.woc3, true),
    WorkoutCategory("Wake Up Call","05 Workouts for Beginner", R.drawable.woc4, true),
    WorkoutCategory("Learn the Basic of Training","06 Workouts for Beginner", R.drawable.woc7,false),
    WorkoutCategory("Learn the Basic of Training","06 Workouts for Beginner", R.drawable.woc5,false)
)

var intermediateWorkoutList = listOf<WorkoutCategory>(
    WorkoutCategory("Wake Up Call","04 Workouts for Intermediate", R.drawable.woc1, false),
    WorkoutCategory("Full Body Goal Crusher","07 Workouts for Intermediate", R.drawable.woc2, true),
    WorkoutCategory("Lower Body Strength","05 Workouts for Intermediate", R.drawable.woc3, true),
    WorkoutCategory("Wake Up Call","05 Workouts for Intermediate", R.drawable.woc4, true),
    WorkoutCategory("Learn the Basic of Training","06 Workouts for Intermediate", R.drawable.woc7,false),
    WorkoutCategory("Learn the Basic of Training","06 Workouts for Intermediate", R.drawable.woc5,false)
)

var advancedWorkoutList = listOf<WorkoutCategory>(
    WorkoutCategory("Wake Up Call","04 Workouts for Advanced", R.drawable.woc1, false),
    WorkoutCategory("Full Body Goal Crusher","07 Workouts for Advanced", R.drawable.woc2, true),
    WorkoutCategory("Lower Body Strength","05 Workouts  for Advanced", R.drawable.woc3, true),
    WorkoutCategory("Wake Up Call","05 Workouts for Advanced", R.drawable.woc4, true),
    WorkoutCategory("Learn the Basic of Training","06 Workouts for Advanced", R.drawable.woc7,false),
    WorkoutCategory("Learn the Basic of Training","06 Workouts for Advanced", R.drawable.woc5,false)
)
var trainersList = listOf<FitnessTrainer>(
    FitnessTrainer("Richard Will",4.8,"High Intensity Training",5),
    FitnessTrainer("Jennifer James",4.6,"Functional Strength",4),
    FitnessTrainer("Brian Edward",4.5,"Strength Training",6),
    FitnessTrainer("Emily Kevin",4.9,"High Intensity Training",2),
    FitnessTrainer("Rebecca Smith",4.8,"Functional Strength",8),
    FitnessTrainer("Ronald Jason",4.2,"High Intensity Training",9),
    FitnessTrainer("Cristofer Arcand",4.8,"Strength Training",5),
    FitnessTrainer("",0.0,"",0),
    FitnessTrainer("",0.0,"",0)

)

data class Notification(val text1:String, val text2:String, val time:String)
var notifications = listOf<Notification>(
    Notification("Congratulations","35% your daily challenge completed","9:45 AM"),
    Notification("Attention","Your subscription is going to expire very soon. Subscribe now.","9:38 AM"),
    Notification("Daily Attention","Time for your workout session ","8:25 AM")
)