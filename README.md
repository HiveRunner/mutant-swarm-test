## Overview
This project tests that [Mutant Swarm](https://github.com/HotelsDotCom/mutant-swarm) works as a dependency with both JUnit4 and JUnit5.

It has 3 modules:
- mutant-swarm-test-junit4: only has JUnit4 on the classpath.
- mutant-swarm-test-junit5: only has JUnit5 on the classpath.
- mutant-swarm-test-junit4-and-5: has both JUnit4 and JUnit5 on the classpath.

## How to test it
Simply `git clone` the project and run `mvn package`. If the build is successful, check that the report in `/target/mutant-swarm-reports/` was generated successfully in each of the modules.
