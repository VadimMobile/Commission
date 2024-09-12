fun main() {
    calculation()
    println("Комиссия за перевод: $commission руб.")
}

const val monthLimit = 75_000
const val visaCommission = 0.0075
const val visaMinCommission = 35
const val maxDayLimit = 150_000
const val maxMonthLimit = 600_000
const val typeVisa = "Visa"
const val typeMastercard = "Mastercard"
const val typeMir = "Мир"
const val mirCommission = 0
var commission = 0

fun calculation(cardType: String = "Мир", totalTransfersThisMonth: Int = 0, transferAmount: Int = 150000): Int {
    val sumCommissionMastercard = (transferAmount * 0.006 + 20).toInt()
    val sumCommissionVisa = (transferAmount * visaCommission).toInt()
    val mastercardCommissions = if (transferAmount <= monthLimit) 0 else sumCommissionMastercard - 450
    val visaCommissions = if (sumCommissionVisa > visaMinCommission) sumCommissionVisa else visaMinCommission

    if (totalTransfersThisMonth + transferAmount > maxMonthLimit) {

        println("Превышен месячный лимит на сумму переводов")
    }
    if (transferAmount > maxDayLimit) {
        println("Превышен суточный лимит на сумму переводов")
    }
    when (cardType) {
        typeMastercard -> commission = mastercardCommissions
        typeVisa -> commission = visaCommissions
        typeMir -> commission = mirCommission
        else -> println("Неккоректная операция")
    }
    return commission
}