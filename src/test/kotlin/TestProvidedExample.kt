import com.github.northburns.nut8.Line
import com.github.northburns.nut8.compress
import com.github.northburns.nut8.inputFile
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class TestProvidedExample : BehaviorSpec({
    given("the provided input") {
        `when`("compressed") {
            then("it should match the provided output") {

                val input = inputFile("test_input.txt")
                val output = inputFile("test_output.txt").trim()

                compress(input).shouldBe(output)
            }
        }
    }

    given("empty line") {
        `when`("it is empty") {
            then("it should have room for an 80 letter word") {
                Line().roomLeft.shouldBe(80)
            }
        }
        `when`("one long word is added") {
            then("it should have the expected space left") {
                Line().apply { append("1234567890") }.roomLeft.shouldBe(69)
            }
        }
        `when`("two long words are added") {
            then("it should have the expected space left (counting the space between)") {
                Line()
                        .apply { append("1234567890"); append("1234567890") }
                        .roomLeft.shouldBe(58)
            }
        }
    }
})

