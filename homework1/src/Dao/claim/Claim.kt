package com.homework1.Dao.Claim

import java.util.*

data class Claim(var id: UUID = UUID.randomUUID(), var title: String, var date: String, var isSolved: Boolean = false)