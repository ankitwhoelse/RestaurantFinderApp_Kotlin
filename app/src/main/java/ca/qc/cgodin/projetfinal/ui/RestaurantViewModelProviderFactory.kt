package ca.qc.cgodin.projetfinal.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ca.qc.cgodin.projetfinal.repository.RestaurantRepository

class RestaurantViewModelProviderFactory(
    val restaurantRepository: RestaurantRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RestaurantViewModel(restaurantRepository) as T
    }
}