import org.junit.Test

import org.junit.Assert.*

class CommissionKtTest {

    @Test
    fun calculationMir() {
        val cardType = "Мир"
        val totalTransfersThisMonth = 0
        val transferAmount = 150000
        val result = calculation(cardType, totalTransfersThisMonth, transferAmount)
        assertEquals(5, result)
    }

    @Test
    fun calculationMastercard() {
        val cardType = "Mastercard"
        val totalTransfersThisMonth = 0
        val transferAmount = 150000
        val result = calculation(cardType, totalTransfersThisMonth, transferAmount)
        assertEquals(470, result)
    }

    @Test
    fun calculationMastercard2() {
        val cardType = "Mastercard"
        val totalTransfersThisMonth = 0
        val transferAmount = 75000
        val result = calculation(cardType, totalTransfersThisMonth, transferAmount)
        assertEquals(0, result)
    }

    @Test
    fun calculationVisa() {
        val cardType = "Visa"
        val totalTransfersThisMonth = 0
        val transferAmount = 150000
        val result = calculation(cardType, totalTransfersThisMonth, transferAmount)
        assertEquals(1125, result)
    }

    @Test
    fun calculationVisa2() {
        val cardType = "Visa"
        val totalTransfersThisMonth = 0
        val transferAmount = 250
        val result = calculation(cardType, totalTransfersThisMonth, transferAmount)
        assertEquals(35, result)
    }

    @Test
    fun calculationElse() {
        val cardType = "Maestro"
        val totalTransfersThisMonth = 0
        val transferAmount = 150000
        val result = calculation(cardType, totalTransfersThisMonth, transferAmount)
        assertEquals(0, result)
    }

    @Test
    fun calculationMonthLimit() {
        val cardType = "Мир"
        val totalTransfersThisMonth = 700000
        val transferAmount = 150000
        val result = calculation(cardType, totalTransfersThisMonth, transferAmount)
        assertEquals(ERROR_MAX_MONTH_LIMIT, result)
    }

    @Test
    fun calculationDayLimit() {
        val cardType = "Мир"
        val totalTransfersThisMonth = 300000
        val transferAmount = 250000
        val result = calculation(cardType, totalTransfersThisMonth, transferAmount)
        assertEquals(ERROR_MAX_DAY_LIMIT, result)
    }


}