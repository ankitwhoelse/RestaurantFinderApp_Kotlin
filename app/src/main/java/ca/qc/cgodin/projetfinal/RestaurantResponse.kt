package ca.qc.cgodin.projetfinal

data class RestaurantResponse(
    val html_attributions: List<Any>,
    val next_page_token: String,
    val restaurants: List<Restaurant>,
    val status: String
)