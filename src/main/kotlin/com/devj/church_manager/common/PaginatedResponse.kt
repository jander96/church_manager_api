package com.devj.church_manager.common

data class PaginatedResponse<T>(
    val count: Long,
    val next: String?,
    val prev: String?,
    val results: List<T>
)