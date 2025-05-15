package com.devj.church_manager.curch.data

import com.devj.church_manager.common.PaginatedResponse
import com.devj.church_manager.common.PaginatedResponseBuilder
import com.devj.church_manager.curch.data.repo.ChurchRepository
import com.devj.church_manager.curch.data.table.Church
import com.devj.church_manager.curch.domain.models.ChurchCreationRequest
import com.devj.church_manager.curch.domain.models.ChurchModel
import com.devj.church_manager.curch.domain.service.ChurchService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class ChurchServiceImpl(private val churchRepository: ChurchRepository) : ChurchService {
    override fun save(request: ChurchCreationRequest): ChurchModel {
        val entityRequest = Church(request)
        val entity = churchRepository.save(entityRequest)
        return entity.toDomain()
    }

    override fun getPage(offset: Int, limit: Int, request: HttpServletRequest): PaginatedResponse<ChurchModel> {
        val pageRequest = PageRequest.of(offset / limit, limit)
        val page = churchRepository.findAll(pageRequest)

        return PaginatedResponseBuilder.build(
            page = page,
            offset = offset,
            limit = limit,
            request = request,
            resultMapper = { it.toDomain() }
        )
    }

    override fun getById(id: Long): ChurchModel = churchRepository.findById(id).get().toDomain()

    override fun delete(id: Long) = churchRepository.deleteById(id)

    override fun update(
        id: Long, request: ChurchCreationRequest
    ): ChurchModel {
        val existingChurch =
            churchRepository.findById(id).orElseThrow { NoSuchElementException("Church with id $id not found") }

        val updatedChurch = existingChurch.copy(
            name = request.name,
            denomination = request.denomination,
            address = request.address,
            lat = request.lat,
            lng = request.lng
        )

        val savedChurch = churchRepository.save(updatedChurch)
        return savedChurch.toDomain()
    }
}
