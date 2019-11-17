package com.octoevents.app.domain.service

import com.octoevents.app.domain.repository.IssueRepository

class IssueService(private val issueRepository: IssueRepository) {

    fun getByNumber(number: Long) {
        issueRepository.findByNumber(number)
    }

}