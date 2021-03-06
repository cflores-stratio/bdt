/*
 * Copyright (C) 2014 Stratio (http://stratio.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stratio.qa.cucumber.converter;


import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayListConverterTest {
    private ArrayListConverter converter = new ArrayListConverter();

    @Test
    public void test() {
        assertThat(converter.transform("")).as("Empty input converter").hasSize(1);
    }

    @Test
    public void test_1() {
        assertThat(converter.transform("foo")).as("Single string input converter").hasSize(1);
    }

    @Test
    public void test_2() {
        assertThat(converter.transform("foo")).as("Single string input converter").contains("foo");
    }

    @Test
    public void test_3() {
        assertThat(converter.transform("foo,bar")).as("Complex string input converter").hasSize(2);
    }

    @Test
    public void test_4() {
        assertThat(converter.transform("foo , bar")).as("Single string input converter").contains("foo", "bar");
    }

    @Test
    public void test_5() {
        assertThat(converter.transform("foo , , bar")).as("Single string input converter").contains("foo", " ", "bar");
    }

    @Test
    public void test_6() {
        assertThat(converter.transform("foo ,   , bar")).as("Single string input converter").contains("foo", "   ", "bar");
    }

}
