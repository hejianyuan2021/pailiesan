package com.pl3.app.algo.util

object MathUtil {
    fun oddEven(n: Int): String = if (n % 2 == 0) "偶" else "奇"
    fun bigSmall(n: Int, mid: Int = 5): String = if (n >= mid) "大" else "小"
    fun combo(draw: List<Int>): String {
        return draw.joinToString("") { if (it % 2 == 0) "偶" else "奇" } + "/" +
               draw.joinToString("") { if (it >= 5) "大" else "小" }
    }
}
