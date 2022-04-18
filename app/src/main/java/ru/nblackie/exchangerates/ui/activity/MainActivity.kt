package ru.nblackie.exchangerates.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.nblackie.exchangerates.R
import ru.nblackie.exchangerates.repo.remote.cbr.CbrApi
import ru.nblackie.exchangerates.repo.remote.cbr.CbrClient
import ru.nblackie.exchangerates.repo.remote.cbr.response.DynamicValCurs
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    private val client: CbrClient = CbrClient()
    private val api: CbrApi = client.createService(CbrApi::class.java)
    private val responseDateFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    private val date = "17.04.2022"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            runCatching {
                getExchangeRate()
            }.onSuccess {
                it.records.forEach { record ->
                    Log.i("nblackie", record.value)
                }
            }.onFailure {
                Log.e("nblackie", "load failed", it)
            }
        }
    }

    private suspend fun getExchangeRate(): DynamicValCurs {

        return withContext(Dispatchers.IO) {
            api.getExchangeRate("R01239", "13/04/2022", "17/04/2022")
        }
    }
}