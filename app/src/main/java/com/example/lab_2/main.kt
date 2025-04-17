package com.example.lab_2

fun main(){

    //Приклад з блоку умовних виразів
    println("Введіть число:")
    val number1=readln().toInt()
    if (number1 % 2 == 0){
        println("Число $number1 парне")
    }else{
        println("Число $number1 непарне")
    }

    //Приклад з блоку циклів та ітерацій
    println("Введіть число n:")
    val number2=readln().toInt()
    var count = 1
    var result = 0
    while (count != number2 + 1){
        result += count
        count += 1
    }
    println("$result - сума2 чисел від 1 до $number2")

    //Приклад з блоку масивів, списків
    print("Введіть кількість чисел n: ")
    val n = readln().toInt()
    val numbers = IntArray(n)

    println("Введіть $n чисел:")

    for (i in 0 until n) {
        print("Число ${i + 1}: ")
        numbers[i] = readln().toInt()
    }

    println("Числа у зворотному порядку:")
    for (i in n - 1 downTo 0) {
        println(numbers[i])
    }

    //Приклад з блоку Null safety
    val str: String? = null

    val length = str?.length
    println("Довжина рядка: $length")

    //Приклад з блоку Обробки винятків
    print("Введіть чисельник: ")
    val input1 = readln().toInt()

    print("Введіть знаменник: ")
    val input2 = readln().toInt()

    try {
        val result = input1 / input2
        println("Результат ділення: $result")
    } catch (e: ArithmeticException) {
        println("Помилка: не можна ділити на нуль!")
    }

    //Варіант 17 Задача 7. «Фінансовий трекер»
    class InvalidExpenseException(message: String) : Exception(message)

    val expenses = mutableListOf<Int>()

    println("Введіть витрати за 7 днів:")

    for (i in 1..7) {
        print("День $i: ")
        try {
            val expense = readln().toInt()
            if (expense < 0) {
                throw InvalidExpenseException("Витрата не може бути від’ємною! День $i")
            }
            expenses.add(expense)
        } catch (e: InvalidExpenseException) {
            println("Помилка: ${e.message}")
            expenses.add(0)
        }
    }

    val total = expenses.sum()
    val average = expenses.average()
    val maxExpense = expenses.maxOrNull() ?: 0
    val maxDay = expenses.indexOf(maxExpense) + 1

    println("Результати:")
    println("Загальні витрати: $total грн")
    println("Середня витрата: $average грн")
    println("Найбільша витрата: $maxExpense грн (день $maxDay)")

    // Оцінка загальних витрат
    val rating = when {
        total < 500 -> "Економно"
        total in 500..999 -> "Помірно"
        total >= 1000 -> "Занадто багато"
        else -> "Невизначено"
    }

    println("Оцінка витрат: $rating")
}