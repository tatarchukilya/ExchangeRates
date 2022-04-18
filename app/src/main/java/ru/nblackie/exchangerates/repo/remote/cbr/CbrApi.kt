package ru.nblackie.exchangerates.repo.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface CbrApi {

    @GET("XML_dynamic.asp")
    fun getDynamic(
        @Query("VAL_NM_RQ") currencyId: String,
        @Query("date_req1") dateFrom: String,
        @Query("date_req2") dateTo: String
    ): String
}