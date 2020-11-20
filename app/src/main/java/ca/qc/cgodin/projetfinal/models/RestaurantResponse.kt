package ca.qc.cgodin.projetfinal.models

import ca.qc.cgodin.projetfinal.models.Restaurant

data class RestaurantResponse(
    val html_attributions: List<Any>,
    val next_page_token: String,
    val restaurants: List<Restaurant>,
    val status: String
)