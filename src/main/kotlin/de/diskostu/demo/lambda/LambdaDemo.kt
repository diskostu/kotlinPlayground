package de.diskostu.demo.lambda

fun main() {
    // assigning functions to variables

    // option 1
    val trickFunction1 = ::trick

    // option 2 - as a lambda call
    val trickFunction2 = { trick() }

    // option 3 - as an inline lambda
    val trickFunction3 = {
        println("No treats!")
    }

    // explicit parameter name ("quantity")
    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    // implicit parameter name ("it")
    val cupcakes: (Int) -> String = {
        "$it cupcakes"
    }

    // assign the "trickOrTreat" function to a variable
    // the second argument of the function call ("coins") is itself a function, defined above
    val trickFunction = trickOrTreat(true, coins)

    // similar to the above statement: assign the "trickOrTreat" function to a variable
    // this time, the second argument of the function call is an inline lambda
    val treatFunction = trickOrTreat(false) {
        "$it quarters"
    }

    repeat(4) {
        treatFunction()
    }

    trickFunction()
}

/**
 * @param isTrick simple [Boolean] parameter
 * @param extraTreat function as a parameter, with a default value (lambda expression)
 */
fun trickOrTreat(isTrick: Boolean, extraTreat: (Int) -> String = { "no extra treat" }): () -> Unit {
    return if (isTrick) {
        trick
    } else {
        println(extraTreat(5))
        treat
    }
}

val trick = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}