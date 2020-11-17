package ca.qc.cgodin.projetfinal.models

data class restaurant(
    val html_attributions: List<Any>,
    val next_page_token: String,
    val results: List<Result>,
    val status: String
)