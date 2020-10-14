package com.homework1.Dao.Claim

//id uuid title string date string isSolved bool
data class Claim(var id: String, var title:String, var date:String, var isSolved: Int)

/*
fun main() {
// JSON Serialization
var pObj = Person("George", "Sampson", "6475847474")
var jsonStr = Gson().toJson(pObj)
println("The converted JSON string : ${jsonStr}")

// Serialization of List<Person>
var pList : MutableList<Person> = mutableListOf()
pList.add(pObj)
pList.add(Person("Amie", "Lam", "647383829"))
val listJsonString = Gson().toJson(pList)
//JSONArray object
println("${listJsonString}")

// List<Person> object deserialization
val personListType : Type = object : TypeToken<Person>(){}.type

// JSON Deserialization
var pObj1 : Person
jsonStr = "{\"lastName\":\"Lam\", \"ssn\":\"647483839\"}"
pObj1 = Gson().fromJson(jsonStr, Person::class.java)
println("${pObj1.toString()}")

}
*/