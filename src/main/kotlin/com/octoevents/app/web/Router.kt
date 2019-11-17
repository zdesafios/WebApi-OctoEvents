package com.octoevents.app.web

import com.octoevents.app.web.controllers.IssueController
import io.javalin.Javalin

class Router(private val issueController: IssueController) {

    fun register(app: Javalin) {
        app.post("/issue/:number", issueController::getByNumber)
    }

}