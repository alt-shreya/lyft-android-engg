fun main() {    
    initDB()
    // println("Hello World")
    // Test functions here
	// println(validInfo(storedCard1)) //true
    // println(validInfo(invalidCard1)) //false
    println(addCardToDatabase(PaymentInfo("Jake Peralta", 99999999, 122))) //true
    println(addCardToDatabase(storedCard2)) //false
}

data class PaymentInfo(
    val cardOwner: String,
    val cardNumber: Int,
    val cardCVV: Int
)


val storedCard1 = PaymentInfo("Bob", 12222333, 111)
val storedCard2 = PaymentInfo("John", 11113333, 134)

val invalidCard1 = PaymentInfo("", 11113333, 134)
val invalidCard2 = PaymentInfo("", 11113333, 1222)

val cardDataBase = mutableMapOf<Int, PaymentInfo>()

fun initDB() {
    cardDataBase[storedCard1.cardNumber] = storedCard1
    cardDataBase[storedCard2.cardNumber] = storedCard2
}

fun validInfo(paymentInfo: PaymentInfo): Boolean {
    // TODO validate paymentInfo according to instructions
    val cardOwnerValid = !(paymentInfo.cardOwner.isBlank())
    val cardNumberValid = paymentInfo.cardNumber.toString().length == 8
    val CVVNumberValid = paymentInfo.cardCVV.toString().length == 3
    return cardOwnerValid && cardNumberValid && CVVNumberValid
}

fun addCardToDatabase(paymentInfo: PaymentInfo): Boolean {
    // TODO check if we can add card to database according to instructions 
   	if (cardDataBase.contains(paymentInfo.cardNumber))
    {
        println("ERROR")
        println(cardDataBase.keys)
        println(cardDataBase.values)
        return false
    }
	else{
        println("SUCCESS!")
        cardDataBase.put(paymentInfo.cardNumber, paymentInfo)
        return true
    }
    
}