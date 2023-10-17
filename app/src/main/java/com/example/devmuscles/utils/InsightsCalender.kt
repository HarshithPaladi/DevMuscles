package com.example.devmuscles.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale
data class DaysData(val date:Int, val day:String)
fun getMonthName(year: Int, month: Int):String {
    val date = LocalDate.of(year, month, 1)
    return date.month.getDisplayName(TextStyle.FULL, Locale.ENGLISH)
}
fun datesWithDay(year: Int, month: Int):MutableList<DaysData> {
    var datesList = mutableListOf<DaysData>()
    val firstDay = LocalDate.of(year, month, 1)
    val lastDay = firstDay.plusMonths(1).minusDays(1)
    val formatter = DateTimeFormatter.ofPattern("dd eee") // Pattern to display date and day name, ("dd MM yyyy eee")
    var currentDate = firstDay
    while (!currentDate.isAfter(lastDay)) {
        val formattedDate = currentDate.format(formatter).split(" ")
        datesList.add(DaysData(formattedDate[0].toInt(),formattedDate[1][0].toString()))
        currentDate = currentDate.plusDays(1)
    }
    return datesList
}