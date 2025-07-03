package com.yogesh.cohort3assignments

class SecureBankAccount {
    var accountHolder: String = ""
    private var balance: Long = 0


    fun deposit(bal: Long) {


        if (bal > 0) {
            balance += bal

            println("Amount $balance is deposited successfully !")

        } else {
            println("Invalid Amount !")
        }
    }

    fun withdraw(bal: Long) {

        if (bal > 0 && bal <= balance) {

            balance -= bal
            println("Remaining balance is : $balance")
        } else {
            println("Invalid Amount !")
        }
    }

    fun getBalance() {
        println("Account Holder : $accountHolder")
        println("Balance : $balance")
    }


}


fun main() {
    val customer = SecureBankAccount()

    customer.accountHolder = "Yogesh Verma"
    customer.getBalance()
    customer.accountHolder
    customer.withdraw(10000)
    customer.deposit(1000000000)
    customer.getBalance()
    customer.withdraw(1)
}