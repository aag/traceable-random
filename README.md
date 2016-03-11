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

Usage
-----
The way the library works is it takes a Seed Provider and seeds a
`java.util.Random` object with the seed from the provider. This means that you must
first create a seed provider, then instantiate a `TraceableRandom` object with
it, then retrieve the Random object. You can then get random values from the
Random object.

Seed Providers
--------------

### Time

The Time provider seeds the RNG with the date and time.

```java
import com.github.aag.traceablerandom.TraceableRandom;
import com.github.aag.traceablerandom.providers.TimeProvider;

TimeProvider provider = new TimeProvider(Clock.systemDefaultZone());
TraceableRandom traceableRandom = new TraceableRandom(provider);

int r = traceableRandom.getRandom().nextInt();
String time = traceableRandom.getSeedText();
```

### Weather

The weather provider seeds the RNG with the current weather in a given
location. It uses the [OpenWeatherMap](http://openweathermap.org/)
service to get the weather, so you need to create an account there
if you want to use it. Once you have created an account and you have
an API key, you can use the Weather Provider like this:

```java
import com.github.aag.traceablerandom.TraceableRandom;
import com.github.aag.traceablerandom.datasources.HttpOpenWeatherMapDataSource;
import com.github.aag.traceablerandom.providers.WeatherProvider;

import java.time.LocalDateTime;

HttpOpenWeatherMapDataSource weatherSource = new HttpOpenWeatherMapDataSource(
    "104c549becf3af34b43ab37d2a48013c",
    WeatherDataSource.Units.CELSIUS,
    "Cologne,DE"
);

WeatherProvider provider = new WeatherProvider(weatherSource);
TraceableRandom traceableRandom = new TraceableRandom(provider);

int r = traceableRandom.getRandom().nextInt();
String currentWeather = traceableRandom.getSeedText();
LocalDateTime weatherTime = traceableRandom.getSeedCreationDateTime();
```

Tests
-----
The tests can be run with `gradle test`.

License
-------
This software is free software licensed under the GPL v3. See the LICENSE
file for details.