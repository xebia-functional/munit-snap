/*
 * Copyright 2023 Xebia Functional
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package munit

import io.circe._
import io.circe.generic.AutoDerivation
import io.circe.syntax._

class SnapshotSuiteSuite
    extends SnapshotSuite,
      AutoDerivation,
      SnapshotTestFixtures:

  snapshotTest("It should pass a snapshot test") { 1 + 1 }

  snapshotTest("It should fail a snapshot test".fail) { 2 + 2 }

  providedFixture.snapshotTest("It should pass with a fixture") { _ => 4 + 1 }

  providedFixture.snapshotTest("It should fail with a fixture".fail) { _ =>
    4 + 0
  }

  providedFixture.snapshotTest("It should clear".clear) { _ => 3 + 3 }
  providedFixture.snapshotTest("It should clear out a fixture".clear) { _ =>
    3 + 3
  }
