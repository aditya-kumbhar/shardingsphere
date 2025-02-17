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

package org.apache.shardingsphere.test.runner.executor;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.apache.shardingsphere.test.runner.ParallelRunningStrategy.ParallelLevel;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * Parallel runner executor factory.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ParallelRunnerExecutorFactory {
    
    private static final Map<ParallelLevel, Class<? extends ParallelRunnerExecutor>> EXECUTORS = new HashMap<>();
    
    static {
        for (ParallelRunnerExecutor each : ServiceLoader.load(ParallelRunnerExecutor.class)) {
            EXECUTORS.put(each.getParallelLevel(), each.getClass());
        }
    }
    
    /**
     * Create new instance of parallel runner executor.
     * 
     * @param parallelLevel parallel level
     * @return created instance
     */
    @SneakyThrows(ReflectiveOperationException.class)
    public static ParallelRunnerExecutor newInstance(final ParallelLevel parallelLevel) {
        return EXECUTORS.get(parallelLevel).getDeclaredConstructor().newInstance();
    }
}
