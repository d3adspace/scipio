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
    <artifactId>scipio-core</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

# Example
Setting up Scipio with a handler that prints all failures:
```java
import de.d3adspace.scipio.core.Scipio;
import de.d3adspace.scipio.core.ScipioFactory;
import de.d3adspace.scipio.core.description.FailureDescription;
import de.d3adspace.scipio.core.description.FailureDescriptionBuilder;
import de.d3adspace.scipio.core.description.FailureDescriptionFactory;
import de.d3adspace.scipio.core.handler.FailureHandler;
import de.d3adspace.scipio.core.priority.Priority;

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
import de.d3adspace.scipio.core.priority.Priority;
import de.d3adspace.scipio.core.provider.FailureProvider;

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

