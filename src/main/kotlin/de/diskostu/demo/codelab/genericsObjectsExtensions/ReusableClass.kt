package de.diskostu.demo.codelab.genericsObjectsExtensions

fun main() {
    val questionText = "what is the answer?"
    val genericQuestion1 = GenericQuestion(questionText, 42, Difficulty.EASY)
    val genericQuestion2 = GenericQuestion(questionText, true, Difficulty.MEDIUM)
    val genericQuestion3 = GenericQuestion(questionText, "universe", Difficulty.HARD)

    val answer1 = genericQuestion1.answer
    val answer2 = genericQuestion2.answer
    val answer3 = genericQuestion3.answer

    println("answer1 = $answer1")
    println("answer2 = $answer2")
    println("answer3 = $answer3")

    println("difficulty1 = ${genericQuestion1.difficulty}")
}


/**
 * Instead of creating 3 different classes because the data type of "answer" can be different, we use Generics.
 */
class GenericQuestion<T>(val questionText: String, val answer: T, val difficulty: Difficulty)

enum class Difficulty {
    EASY, MEDIUM, HARD
}