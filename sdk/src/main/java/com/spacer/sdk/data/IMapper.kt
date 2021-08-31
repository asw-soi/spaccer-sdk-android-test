package com.spacer.sdk.data

import com.spacer.sdk.data.api.resData.key.KeyGenerateResData

interface IMapper<TSource, TDestination> {
    fun map(source: TSource): TDestination
}
