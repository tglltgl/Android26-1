package util

fun Long?.orZero(): Long = this ?: 0L

fun Int?.orZero(): Int = this ?: 0