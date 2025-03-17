package br.dev.flp.empregamais.model

data class JobDetails(
    val title: String,
    val company: String,
    val rating: Double,
    val location: String,
    val workType: String,
    val salary: String,
    val description: String,
    val requirements: List<String>
)

// Lista de vagas disponíveis
val jobList = listOf(
    JobDetails(
        title = "Desenvolvedor FrontEnd",
        company = "System Solution",
        rating = 4.5,
        location = "São Paulo - SP, a 10km",
        workType = "Home Office",
        salary = "R$ 6.000 - R$ 8.000",
        description = "Será responsável por programar, desenvolver e implantar sistemas em linguagem JavaScript, realizar correções em sistemas para atender as necessidades dos usuários.",
        requirements = listOf(
            "Tecnólogo em Análise de Sistemas, Engenharia de Software ou áreas afins.",
            "Habilidades em JavaScript, React, HTML, CSS.",
            "Experiência com Figma e Design Responsivo.",
            "Inglês intermediário."
        )
    ),
    JobDetails(
        title = "Analista de Sistemas",
        company = "Tech Innovations",
        rating = 4.7,
        location = "Curitiba - PR",
        workType = "Presencial",
        salary = "R$ 5.500 - R$ 7.500",
        description = "Responsável por analisar, projetar e desenvolver soluções para sistemas empresariais.",
        requirements = listOf(
            "Graduação em Ciência da Computação, Sistemas de Informação ou áreas afins.",
            "Experiência com SQL, Java e API REST.",
            "Conhecimento em metodologias ágeis (Scrum, Kanban).",
            "Diferencial: experiência com AWS e DevOps."
        )
    )
)
