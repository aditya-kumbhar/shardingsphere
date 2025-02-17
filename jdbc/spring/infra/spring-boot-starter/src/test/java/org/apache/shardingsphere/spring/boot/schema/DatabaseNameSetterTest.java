/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.spring.boot.schema;

import org.junit.Test;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.env.MockEnvironment;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public final class DatabaseNameSetterTest {
    
    @Test
    public void assertGetDatabaseNameWhenConfigDatabaseName() {
        MockEnvironment mockEnv = new MockEnvironment();
        mockEnv.setProperty("spring.shardingsphere.database.name", "jdbc_db");
        StandardEnvironment standardEnv = new StandardEnvironment();
        standardEnv.merge(mockEnv);
        assertThat(DatabaseNameSetter.getDatabaseName(standardEnv), is("jdbc_db"));
    }
    
    @Test
    public void assertGetDatabaseNameWhenConfigSchemaName() {
        MockEnvironment mockEnv = new MockEnvironment();
        mockEnv.setProperty("spring.shardingsphere.schema.name", "jdbc_db");
        StandardEnvironment standardEnv = new StandardEnvironment();
        standardEnv.merge(mockEnv);
        assertThat(DatabaseNameSetter.getDatabaseName(standardEnv), is("jdbc_db"));
    }
}
