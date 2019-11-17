package com.octoevents.hook.app.config

import com.octoevents.app.AppStarter
import com.octoevents.app.domain.repository.IssueRepository
import com.octoevents.app.domain.service.IssueService
import com.octoevents.app.web.Router
import com.octoevents.app.web.controllers.IssueController
import org.koin.dsl.module

object AppModules {

    private val configModule = module {
        single { AppStarter() }
        single { Router(get()) }
    }

    private val webModule = module {
        single { IssueController(get()) }
    }

    private val domainModule = module {
        single { IssueRepository(get()) }
        single { IssueService(get()) }
        single {
            DbConfig(
                getProperty<String>("db.url"),
                getProperty<String>("db.username"),
                getProperty<String>("db.password")
            ).dataSource()
        }
    }

    internal val allModules = listOf(configModule, webModule, domainModule)
}