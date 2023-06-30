enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val nivel: Nivel)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    private val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun cancelarMatricula(usuario: Usuario) {
        inscritos.remove(usuario)
    }

    fun estaMatriculado(usuario: Usuario): Boolean {
        return inscritos.contains(usuario)
    }

    fun getInscritos(): List<Usuario> {
        return inscritos.toList()
    }

    fun pesquisarConteudoPorNome(nome: String): List<ConteudoEducacional> {
        return conteudos.filter { it.nome == nome }
    }

}

fun main() {
    val conteudos = listOf(
        ConteudoEducacional("Introdução à Programação", 60),
        ConteudoEducacional("Algoritmos e Estruturas de Dados", 90),
        ConteudoEducacional("Banco de Dados", 75)
    )

    val usuario1 = Usuario("João", Nivel.BASICO)
    val usuario2 = Usuario("Maria", Nivel.INTERMEDIARIO)

    val formacao = Formacao("Ciência da Computação", conteudos)
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    println(formacao.getInscritos())
    println(formacao.pesquisarConteudoPorNome("Banco de Dados"))
    println(formacao.estaMatriculado(usuario1))
    println(formacao.estaMatriculado(usuario2))
    
    formacao.cancelarMatricula(usuario1)
    println(formacao.getInscritos())
    println(formacao.estaMatriculado(usuario1))
}
