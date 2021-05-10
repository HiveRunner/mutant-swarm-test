/*
 * Copyright (C) 2020 Expedia, Inc.
 * Copyright (C) 2021 The HiveRunner Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expediagroup.dataplatform.mutantswarm.test.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;

import com.klarna.hiverunner.HiveShell;
import com.klarna.hiverunner.annotations.HiveSQL;
import com.klarna.hiverunner.annotations.HiveSetupScript;

import com.hotels.mutantswarm.MutantSwarmExtension;
import com.hotels.mutantswarm.annotation.MutantSwarmTest;

@ExtendWith(MutantSwarmExtension.class)
public class Junit5Test {
  @HiveSetupScript
  private final File setup = new File("src/test/resources/mutantSwarmTest/setupInputTable.sql");
  @HiveSetupScript
  private final File insert = new File("src/test/resources/mutantSwarmTest/setupInputData.sql");

  @HiveSQL(files = { "mutantSwarmTest/scriptToTest1.sql", "mutantSwarmTest/scriptToTest2.sql" })
  public HiveShell hiveShell;

  @MutantSwarmTest
  public void test() {
    List<String> result = hiveShell.executeQuery("SELECT * FROM bar");
    List<String> expected = Arrays.asList("1\ttrue", "3\ttrue", "3\tfalse", "5\tfalse");
    assertEquals(expected, result);
  }
  
  @MutantSwarmTest
  public void test2() {
    List<String> result = hiveShell.executeQuery("SELECT c FROM foobar");
    List<String> expected = Arrays.asList("true", "false");
    assertEquals(expected, result);
  }

}
