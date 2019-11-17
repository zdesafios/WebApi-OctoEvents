package com.octoevents.app.domain.repository

import com.octoevents.app.domain.entity.Issue
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import javax.sql.DataSource

private object Issues: Table() {
    val id: Column<Long> = long(name = "id")
    val action: Column<String> = varchar(name = "action", length = 255)
    val url: Column<String> = varchar(name = "url", length = 255)
    val title: Column<String> = varchar(name = "title", length = 255)
    val user: Column<String> = varchar(name = "user", length = 255)
    val number: Column<Long> = long(name = "number")
    val createdAt: Column<DateTime> = date(name="create_at")
    val updatedAt: Column<DateTime> = date(name="updated_at")
    val closedAt: Column<DateTime?> = date(name="closed_at").nullable()

    fun toDomain(row: ResultRow): Issue {
        return Issue(0, "", "", "", "", 10, DateTime(), DateTime(), null);
    }
}

class IssueRepository(private val dataSource: DataSource) {
    init {
        transaction(Database.connect(dataSource)) {
            SchemaUtils.create(Issues)
        }
    }

    fun findByNumber(number: Long): List<Issue> {
        return Issues.select {Issues.number eq number}.map {row->
            Issues.toDomain(row)
        }
    }
}