package ru.nblackie.exchangerates.repo.remote.cbr

import retrofit2.http.GET
import retrofit2.http.Query
import ru.nblackie.exchangerates.repo.remote.cbr.response.DynamicValCurs

interface CbrApi {

    @GET("XML_dynamic.asp")
    suspend     fun getExchangeRate(
        @Query("VAL_NM_RQ") currencyId: String,
        @Query("date_req1") dateFrom: String,
        @Query("date_req2") dateTo: String
    ): DynamicValCurs
}