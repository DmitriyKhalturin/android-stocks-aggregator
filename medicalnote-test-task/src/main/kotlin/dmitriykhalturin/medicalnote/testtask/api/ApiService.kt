package dmitriykhalturin.medicalnote.testtask.api

import dmitriykhalturin.medicalnote.testtask.model.ResponseModel
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 20.03.19 2:41.
 */
interface ApiService {

  companion object {

    const val url = "http://phisix-api3.appspot.com/"

    fun create(): ApiService {
      val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(url)
        .build()

      return retrofit.create(ApiService::class.java)
    }

  }

  @GET(value = "stocks.json")
  fun getCurrenciesList(): Observable<ResponseModel.GetCurrenciesList>

}
