package com.devj.church_manager.common

import jakarta.servlet.http.HttpServletRequest
import org.springframework.data.domain.Page

object PaginatedResponseBuilder {

    fun <T,R> build(
        page: Page<T>,
        offset: Int,
        limit: Int,
        request: HttpServletRequest,
        resultMapper : (T) -> R
    ): PaginatedResponse<R> {
        val count = page.totalElements
        val baseUrl = request.requestURL.toString()
        val cleanQuery = request.queryString
            ?.replace(Regex("offset=\\d+"), "")
            ?.replace(Regex("limit=\\d+"), "") ?: ""

        val nextOffset = offset + limit
        val prevOffset = if (offset - limit >= 0) offset - limit else null

        val join = if (cleanQuery.isNotBlank()) "$cleanQuery&" else ""

        val next = if (nextOffset < count)
            "$baseUrl?$join" + "offset=$nextOffset&limit=$limit"
        else null

        val prev = if (prevOffset != null)
            "$baseUrl?$join" + "offset=$prevOffset&limit=$limit"
        else null

        return PaginatedResponse(
            count = count,
            next = next,
            prev = prev,
            results = page.content.map(resultMapper)
        )
    }
}