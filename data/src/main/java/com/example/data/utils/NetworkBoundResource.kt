package com.example.data.utils

import android.util.Log
import com.example.domain.core.Resource
import kotlinx.coroutines.flow.*

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType?) -> Boolean = { true }
) = flow {
    val data = query().firstOrNull()

    val flow = if (shouldFetch(data)) {
        emit(Resource.Loading(data))

        try {
            val fetch = fetch()
            saveFetchResult(fetch)
            query().map { Resource.Success(it) }
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            query().map { Resource.Error(throwable, it) }
        }
    } else {
        query().map { Resource.Success(it) }
    }

    emitAll(flow)
}