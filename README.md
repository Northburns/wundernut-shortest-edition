# Wundernut 8 - Shortest Edition

My solution to [_Wundernut vol 8: Shortest Edition_](https://wunder.dog/the-shortest-edition).

## Details and how to run

Solution written in Kotlin, built with Gradle.

Requirements:
* Linux
* Java 8 (I used `openjdk 1.8.0_151`)

Run with this command, solution is then printed and saved to file `nut.txt`:

```sh
./gradlew run
```

* `gradlew` is the Gradle Wrapper, it'll download the desired Gradle version 
(to user's home) if it is not installed already.
* The build script downloads the needed resources from the 
[Wundernut 8's GitHub repo](https://github.com/wunderdogsw/wunderpahkina-vol8).
  * It only downloads the linux validator, hence the requiremnt 
