TraceableRandom
===============

This is a fun little library for when you want to choose something randomly,
but you also want to have some sense of *why* it was chosen.

For example, imagine you have a bunch of recipes you like and you want to get
a random suggestion for what to cook for dinner. You could just choose
completely randomly from the list, but it would be fun if you were given a
suggestion based on the weather today. And even more fun is if you can trace
the choice back to the particular weather details. Maybe the program could
output "Why don't you cook lasagna tonight, since it is cloudy and 20 degrees
outside?" That is the kind of thing TraceableRandom allows you to do.

**Note:** the Random Number Generator created by TraceableRandom is not even
a little bit secure. Please don't use it for anything where security is
important. It's just a fun toy.

Building
--------
The library is built with gradle and the repository includes a copy of
gradle wrapper. Running `./gradlew` in the top directory of the repository
will download dependencies and build the software into the `build` directory.

Tests
-----
The tests can be run with `gradle test`.

License
-------
This software is free software licensed under the GPL v3. See the LICENSE
file for details.