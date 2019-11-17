package com.octoevents.app.web.controllers

import com.octoevents.app.domain.service.IssueService
import io.javalin.Javalin
import io.javalin.http.Context

class IssueController(private val issueService: IssueService) {

    fun getByNumber(context: Context): Unit {
        context.json(issueService.getByNumber(context.pathParam("number").toLong()))
    }
}