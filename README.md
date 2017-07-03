# Scipio 
What you see here is a lightweight but robust and powerful error
reporting framework. You can use custom handlers to broadcast failure
descriptions across your internal network. You can provide those failures
in an enumeration or built a fully custom one.

By adding a handler you can control how your failures will be handled. You can post them
to a RESTful service or just save them in a database to be reviewed from a monitor application.

Scipio provides two basic examples for a logger located at https://github.com/D3adspaceEnterprises/scipio/tree/master/src/main/java/de/d3adspace/scipio/handler/logger

# Installation / Usage

- Install [Maven](http://maven.apache.org/download.cgi)
- Clone this repo
- Install: ```mvn clean install```

**Maven dependencies**

_Scipio:_
```xml
<dependency>
    <groupId>de.d3adspace</groupId>
    <artifactId>scipio</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

#Example
Setting up Scipio with a handler that prints all failures:
```java
/*
 * Copyright (c) 2017 D3adspace
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import de.d3adspace.scipio.Scipio;
import de.d3adspace.scipio.ScipioFactory;
import de.d3adspace.scipio.description.FailureDescription;
import de.d3adspace.scipio.description.FailureDescriptionBuilder;
import de.d3adspace.scipio.description.FailureDescriptionFactory;
import de.d3adspace.scipio.handler.FailureHandler;
import de.d3adspace.scipio.priority.Priority;

/**
 * @author Felix 'SasukeKawaii' Klauke
 */
public class ScipioTest {
	
	public static void main(String[] args) {
		Scipio scipio = ScipioFactory.createScipio();
		
		scipio.addFailureHandler(System.out::println);
	}
}
```

Handle a failure:
```java
FailureDescription description = FailureDescriptionFactory.createFailureDescription("Human", "Organs", "CompleteFailure", Priority.CRITICAL);
scipio.handleFailure(description);
```

Provide the failure with an enum:
```java
FailureDescription description = FailureDescriptionFactory.createFailureDescription(ScipioTestFailures.COMPLETE_ORGANIC_FAILURE);
scipio.handleFailure(description);
```

```java
/*
 * Copyright (c) 2017 D3adspace
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import de.d3adspace.scipio.priority.Priority;
import de.d3adspace.scipio.provider.FailureProvider;

/**
 * @author Felix 'SasukeKawaii' Klauke
 */
public enum ScipioTestFailures implements FailureProvider {
	
	COMPLETE_ORGANIC_FAILURE("Human", "Organs", "CompleteFailure", Priority.CRITICAL),
	SCRATCH("Human", "Epidermis", "splinter", Priority.WARNING);
	
	private final String system;
	private final String application;
	private final String failure;
	private final Priority priority;
	
	ScipioTestFailures(String system, String application, String failure,
		Priority priority) {
		this.system = system;
		this.application = application;
		this.failure = failure;
		this.priority = priority;
	}
	
	@Override
	public String getFailure() {
		return failure;
	}
	
	@Override
	public String getSystem() {
		return system;
	}
	
	@Override
	public String getApplication() {
		return application;
	}
	
	@Override
	public Priority getPriority() {
		return priority;
	}
}

```

Build a failure on your own:
```java
FailureDescription description = new FailureDescriptionBuilder()
	.setSystem("Custom")
        .setApplication("Error")
        .setFailure("example")
        .setTimestamp(System.currentTimeMillis())
        .setPriority(Priority.WARNING)
        .createSimpleFailureDescription();
```

Work with meta data:
```java
FailureDescription description = FailureDescriptionFactory.createFailureDescription(ScipioTestFailures.SCRATCH);
description.getMetadata().addMetadataEntry("depth", "5 millimeters");
```

