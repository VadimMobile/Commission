fun main() {
    println(calculation())
}

const val MONTH_LIMIT = 75_000
const val VISA_COMMISSION = 0.0075
const val VISA_MIN_COMMISSION = 35
const val MAX_DAY_LIMIT = 150_000
const val MAX_MONTH_LIMIT = 600_000
const val TYPE_VISA = "Visa"
const val TYPE_MASTERCARD = "Mastercard"
const val TYPE_MIR = "Мир"
const val MIR_COMMISSION = 0
const val ERROR_TYPE = -1
const val ERROR_MAX_MONTH_LIMIT = -2
const val ERROR_MAX_DAY_LIMIT = -3

fun calculation(cardType: String = "Мир", totalTransfersThisMonth: Int = 500000, transferAmount: Int = 150000): Int {
    val sumCommissionMastercard = (transferAmount * 0.006 + 20).toInt()
    val sumCommissionVisa = (transferAmount * VISA_COMMISSION).toInt()
    val mastercardCommissions = if (transferAmount <= MONTH_LIMIT) 0 else sumCommissionMastercard - 450
    val visaCommissions = if (sumCommissionVisa > VISA_MIN_COMMISSION) sumCommissionVisa else VISA_MIN_COMMISSION
    var commission = 0

    if (totalTransfersThisMonth + transferAmount > MAX_MONTH_LIMIT) return ERROR_MAX_MONTH_LIMIT
    if (transferAmount > MAX_DAY_LIMIT) return ERROR_MAX_DAY_LIMIT

    when (cardType) {
        TYPE_MASTERCARD -> commission = mastercardCommissions
        TYPE_VISA -> commission = visaCommissions
        TYPE_MIR -> commission = MIR_COMMISSION
        else -> ERROR_TYPE
    }
    return commission
}