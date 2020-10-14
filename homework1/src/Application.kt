package com.homework1

import com.google.gson.Gson
import com.homework1.Dao.Claim.Claim
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import com.homework1.Dao.Claim.ClaimDao
import java.util.*

fun main(args: Array<String>): Unit {
    io.ktor.server.netty.EngineMain.main(args)
}

@Suppress("unused")
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {

//        this.get("/ClaimService/add"){
//        println("HTTP message is using GET method with /get ")
//        val id = UUID.randomUUID().toString()
//        val title = call.request.queryParameters["Title"]
//        val date = call.request.queryParameters["Date"]
//        val isSolved = false
//        val response = String.format("id: %s title: %s date %s isSolved ", fn, ln)
//        //
//        val pObj = Claim(fn, ln, sn)
//        val dao = PersonDao().addPerson(pObj)
//        call.respondText(response, status= HttpStatusCode.OK, contentType = ContentType.Text.Plain)
//        }

        get("/ClaimService/getAll") {
            val CList = ClaimDao().getAll()
            // JSON Serialization/Deserialization
            val respJsonStr = Gson().toJson(CList)
            call.respondText(respJsonStr, status = HttpStatusCode.OK, contentType = ContentType.Application.Json)
        }

        post("/ClaimService/add") {
            println("HTTP message is using GET method with /get ")
            val id = UUID.randomUUID().toString()
            val title = call.request.queryParameters["Title"]
            val date = call.request.queryParameters["Date"]
            val isSolved = 0
            val response = String.format("Claim was added")
            //
            val cObj = Claim(id, title!!, date!!, isSolved)
            val dao = ClaimDao().addClaim(cObj)
            call.respondText(response, status = HttpStatusCode.OK, contentType = ContentType.Text.Plain)
        }
    }

}

