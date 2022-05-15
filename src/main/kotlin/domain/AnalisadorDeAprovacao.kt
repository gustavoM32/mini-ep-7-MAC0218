package domain

import domain.Boletim
import domain.BoletimFechado
import domain.criterios.CriterioDeAprovacao

class AnalisadorDeAprovacao {

    // ---------------------------------
    //
    //      Seu código deve vir aqui
    //
    //      Defina atributos e métodos conforme especificado
    //      no arquivo de teste encontrado em
    //      'src/test/kotlin/domain/AnalisadorDeAprovacaoTest'
    //
    // ---------------------------------

    private lateinit var criterio: CriterioDeAprovacao

    fun defineCriterio(novoCriterio: CriterioDeAprovacao) {
        criterio = novoCriterio
    }

    fun fechaBoletim(boletim: Boletim): BoletimFechado {
        val mediaFinal = criterio.mediaFinal(boletim)
        val foiAprovado = criterio.estaAprovado(boletim)
        return BoletimFechado(boletim.mediaEPs, boletim.mediaMiniEPs, mediaFinal, foiAprovado)
    }
}