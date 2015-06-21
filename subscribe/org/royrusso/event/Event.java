/**
 * (C) Copyright 2014 Roy Russo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 *
 */


package org.royrusso.event;

import org.royrusso.ITest;

import java.io.Serializable;

/**
 * @author royrusso@gmail.com
 */
public class Event implements Serializable,ITest {

    private final String data;

    public Event(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Event{" +
                "data='" + data + '\'' +
                '}';
    }

	@Override
	public void test() {
		System.out.println("....");
	}
}
