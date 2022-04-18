package ru.tatarchuk.rest.client

import ru.nblackie.exchangerates.repo.remote.client.RestClient

class CentralBankClient : RestClient() {

    override fun baseUrl() = "http://www.cbr.ru/scripts/"
}