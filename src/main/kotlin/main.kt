fun main() {
    val contaBruno = Conta(titular = "Bruno", numero = 1000)
    contaBruno.deposita(5000.0)

    val contaMaria = Conta("Maria", 1001)
    contaMaria.deposita(3000.0)

    println(contaBruno.titular)
    println(contaBruno.numero)
    println(contaBruno.saldo)
    println()

    println(contaMaria.titular)
    println(contaMaria.numero)
    println(contaMaria.saldo)

    println("Depositando na conta do Bruno")
    contaBruno.deposita(50.0)
    println(contaBruno.saldo)

    println("Sacando conta do Bruno")
    contaBruno.saca(5050.0)
    println("Saldo Bruno pos saque: ${contaBruno.saldo}")
    println()
    println("Depositando na conta da Maria")
    contaMaria.deposita(230.0)
    println(contaMaria.saldo)
    println()
    println("Sacando conta da Maria")
    contaMaria.saca(3030.0)
    println("Saldo Maria pos saque: ${contaMaria.saldo}")

    println("Transferência da conta da Maria para o Bruno")
    if (contaMaria.transfere(valor = 210.0, destino = contaBruno)) {
        println("Transferência realizada com sucesso!")
    } else {
        println("Não há saldo para realizar essa operação!")
    }

    println("Saldo Bruno pos transferência: ${contaBruno.saldo}")
    println("Saldo Maria pos transferência: ${contaMaria.saldo}")
}

class Conta(
    var titular: String,
    val numero: Int
) {
    var saldo = 0.0
        private set

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    fun saca(valor: Double) {
        if (this.saldo >= valor) {
            saldo -= valor
        } else {
            println("Valor acima valor do saldo, operação inválida!")
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (this.saldo >= valor) {
            this.saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }
}

fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println(numeroX)
    println(numeroY)

    val contaJoao = Conta("João", 1002)
    var contaMaria = Conta("Maria", 1003)
    contaMaria.titular = "Maria"
    contaJoao.titular = "João"
    println("Titular conta joao:${contaJoao.titular}")
    println("Titular conta maria:${contaMaria.titular}")

    println(contaJoao)
    println(contaMaria)
}

fun testaLacos() {
    var i = 0
    while (i < 5) {
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0
        println("Titular $titular")
        println("Número da conta $numeroConta")
        println("Saldo da conta $saldo")
        println()
        i++
    }

    for (i in 5 downTo 1) {
        if (i == 4) {
            continue
        }
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0
        println("Titular $titular")
        println("Número da conta $numeroConta")
        println("Saldo da conta $saldo")
        println()
    }
}

fun testaCondicoes(saldo: Double) {
    if (saldo > 0.0) {
        println("Conta é positiva")
    } else if (saldo == 0.0) {
        println("Conta é neutra")
    } else {
        println("Conta é negativa")
    }

    when {
        saldo > 0.0 -> println("Conta é positiva")
        saldo == 0.0 -> println("Conta é neutra")
        else -> println("Conta é negativa")
    }
}