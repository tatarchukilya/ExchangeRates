package ru.nblackie.exchangerates.repo.remote.cbr

import ru.nblackie.exchangerates.repo.remote.RestClient

class CbrClient : RestClient() {

    override fun baseUrl() = "https://www.cbr.ru/scripts/"
}