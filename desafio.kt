enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val email: String) {
    override fun toString(): String = "$nome - $email"
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60) {
    override fun toString(): String = "$nome - Duração: $duracao minutos"
}

class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    private val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (inscritos.none { it.email == usuario.email }) {
            inscritos.add(usuario)
            println("Matrícula do ${usuario.nome} efetuada com sucesso.")
        } else {
            println("${usuario.nome} está matriculado nesta formação.")
        }
    }

   fun listarAlunos() {
        println("Alunos inscritos na formação:")
        inscritos.forEachIndexed { index, aluno ->
            println("${index + 1}. $aluno")
        }
    }

    override fun toString(): String = "$nome - Nível: $nivel\nConteúdos:\n${conteudos.joinToString("\n")}"
}

fun main() {
    val conteudoKotlin = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudoJava = ConteudoEducacional("Introdução ao Java",50)

    val formacao = Formacao("Formação Kotlin e Java", Nivel.BASICO, listOf(conteudoKotlin, conteudoJava))

    val alunoTon = Usuario("Ton", "ton@ton.com")
    val alunoDan = Usuario("Dan", "dan@ton.com")

    formacao.matricular(alunoTon)
    formacao.matricular(alunoDan)

    println(formacao)

    formacao.listarAlunos()

}