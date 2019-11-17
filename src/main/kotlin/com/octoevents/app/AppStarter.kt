package com.octoevents.app

import com.octoevents.app.web.Router
import org.koin.core.KoinComponent
import org.koin.core.inject

class AppStarter: KoinComponent {
    val router: Router by inject<Router>()
}