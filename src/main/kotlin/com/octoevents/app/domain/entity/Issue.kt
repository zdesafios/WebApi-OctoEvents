package com.octoevents.app.domain.entity

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.joda.time.DateTime
import java.util.*

data class Issue(val id: Long,
                 val action: String,
                 val url: String,
                 val title: String,
                 val user: String,
                 val number: Long,
                 val createdAt: DateTime,
                 val updatedAt: DateTime,
                 val closedAt: DateTime?)