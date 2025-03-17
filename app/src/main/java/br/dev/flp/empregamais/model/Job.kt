package br.dev.flp.empregamais.model

data class Job(
    val id: Int,
    val title: String,
    val company: String,
    val location: String,
    val salary: String,
    val description: String
)
