package com.homework1.Dao.Claim

import com.homework1.Dao.Dao
import com.homework1.Dao.Database

class ClaimDao : Dao() {

    fun addClaim(cObj: Claim) {
        // 1. Get db connection
        val conn = Database.getInstance()?.getDbConnection()

        // 2. prepare the sql statement
        sqlStmt =
            "insert into claim (id, title, date, is_solved) values ('${cObj.id}', '${cObj.title}', '${cObj.date}', '${cObj.isSolved}')"

        // 3. submit the sql statement
        conn?.exec(sqlStmt)
    }

    fun getAll(): List<Claim> {
        // 1. Get db connection
        val conn = Database.getInstance()?.getDbConnection()

        // 2. prepare the sql statement
        sqlStmt = "select first_name, last_name, ssn from person"

        // 3. submit the sql statement
        var claimList: MutableList<Claim> = mutableListOf()
        val st = conn?.prepare(sqlStmt)

        // 4. Convert into Kotlin object format
        while (st?.step()!!) {
            val id = st.columnString(0)
            val title = st.columnString(1)
            val date = st.columnString(2)
            val solved = st.columnInt(3)
            claimList.add(Claim(id, title, date, solved))
        }
        return claimList
    }
}