package com.example.bookcharms

data class TopData(
    val title: String,
    val logo: Int,
    val desc: String,
    var isExpandable: Boolean = false
)