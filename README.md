## Overview
This project tests that [Mutant Swarm](https://github.com/HiveRunner/mutant-swarm) works as a dependency with both JUnit4 and JUnit5.

It has 3 modules:
- mutant-swarm-test-junit4: only has JUnit4 on the classpath.
- mutant-swarm-test-junit5: only has JUnit5 on the classpath.
- mutant-swarm-test-junit4-and-5: has both JUnit4 and JUnit5 on the classpath.

## How to test it
Simply `git clone` the project and run `mvn package`. If the build is successful, check that the report in `/target/mutant-swarm-reports/` was generated successfully in each of the modules.

Note: Mutant Swarm is supported and tested using Surefire version [3.0.0-M5](https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-surefire-plugin/3.0.0-M5) and therefore we recommend that users use this one. If you use other versions (or don't specify any) there might be errors in the Maven testing stage.

# Legal
This project is available under the [Apache 2.0 License](http://www.apache.org/licenses/LICENSE-2.0.html).

Copyright 2021 The HiveRunner Contributors
Copyright 2020 Expedia, Inc.
