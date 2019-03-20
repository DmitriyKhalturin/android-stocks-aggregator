package dmitriykhalturin.medicalnote.testtask.model.mapper

import dmitriykhalturin.medicalnote.testtask.model.ApiResponseModel
import dmitriykhalturin.medicalnote.testtask.view.currency_list.CurrencyData

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for android-medicalnote-test-task on 20.03.19 3:21.
 */
fun stocksResponseToCurrenciesList(response: ApiResponseModel.GetStocks) = MutableList(response.stock.size) {
  val stock = response.stock[it]

  CurrencyData(
    stock.name,
    stock.volume.toLong(),
    stock.price.amount.toDouble()
  )
}
