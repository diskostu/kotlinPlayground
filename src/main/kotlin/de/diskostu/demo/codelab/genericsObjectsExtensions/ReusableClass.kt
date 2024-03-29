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

    // with "apply", we can chain methods without creating a field
    Quiz().apply {
        printQuiz()
        printProgressBar()
    }
}


/**
 * Instead of creating 3 different classes because the data type of "answer" can be different, we use Generics.
 */
data class GenericQuestion<T>(val questionText: String, val answer: T, val difficulty: Difficulty)

enum class Difficulty {
    EASY, MEDIUM, HARD
}

interface ProgressPrintable {
    val progressText: String

    fun printProgressBar()
}

class Quiz : ProgressPrintable {
    val question1 = GenericQuestion("Quoth the raven _____", "nevermore", Difficulty.MEDIUM)
    val question2 = GenericQuestion("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = GenericQuestion("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        const val total = 10
        const val answered = 3
    }

    override val progressText: String
        get() = "$answered out of $total"

    override fun printProgressBar() {
        repeat(answered) { print("▓") }
        repeat(total - answered) { print("▒") }
        println()
        println(progressText)
    }

    fun printQuiz() {
        for (item in listOf(question1, question2, question3)) {
            item.let {
                println(it.questionText)
                println(it.answer)
                println(it.difficulty)
                println()
            }
        }
    }
}