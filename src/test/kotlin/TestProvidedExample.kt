import com.github.northburns.nut8.compress
import com.github.northburns.nut8.inputFile
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec


class MyTests : BehaviorSpec({
    given("the provided input") {
        `when`("compressed") {
            then("it should match the provided output") {

                val input = inputFile("test_input.txt")
                val output = inputFile("test_output.txt")

                compress(input).shouldBe(output)
            }
        }
    }
})

