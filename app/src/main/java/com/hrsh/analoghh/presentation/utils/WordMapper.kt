package com.hrsh.analoghh.presentation.utils

import kotlin.math.abs

fun getNoun(num: Int, one: String, two: String, five: String): String {
    var n = abs(num)

    n %= 100
    if (n in 5..20) {
        return five
    }
    n %= 10;
    if (n == 1) {
        return one
    }
    if (n in 2..4) {
        return two
    }

    return five
}