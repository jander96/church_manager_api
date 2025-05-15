package com.devj.church_manager.curch.domain.service

import com.devj.church_manager.common.PaginatedResponse
import com.devj.church_manager.curch.domain.models.ChurchCreationRequest
import com.devj.church_manager.curch.domain.models.ChurchModel
import jakarta.servlet.http.HttpServletRequest

interface ChurchService {

    fun save(request: ChurchCreationRequest): ChurchModel

    fun getPage(offset: Int, limit: Int, request: HttpServletRequest): PaginatedResponse<ChurchModel>

    fun getById(id: Long): ChurchModel

    fun delete(id: Long)

    fun update(id: Long, request: ChurchCreationRequest): ChurchModel

}