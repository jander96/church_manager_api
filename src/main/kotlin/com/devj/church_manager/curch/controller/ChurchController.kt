package com.devj.church_manager.curch.controller

import com.devj.church_manager.common.PaginatedResponse
import com.devj.church_manager.curch.domain.models.ChurchCreationRequest
import com.devj.church_manager.curch.domain.models.ChurchModel
import com.devj.church_manager.curch.domain.service.ChurchService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/churches")
class ChurchController(
    private val churchService: ChurchService
) {

    @GetMapping
    fun getAll(
        @RequestParam(defaultValue = "0") offset: Int,
        @RequestParam(defaultValue = "10") limit: Int,
        request: HttpServletRequest
    ): PaginatedResponse<ChurchModel> {
        return churchService.getPage(offset, limit, request)
    }


    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ChurchModel {
        return churchService.getById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: ChurchCreationRequest): ChurchModel {
        return churchService.save(request)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long, @RequestBody request: ChurchCreationRequest
    ): ChurchModel {
        return churchService.update(id, request)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        churchService.delete(id)
    }
}