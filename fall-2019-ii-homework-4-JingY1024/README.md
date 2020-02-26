## Homework 4 - Week 4

### Motivation
* Demonstrate your ability to program using inheritance in the Java programming language.
* Demonstrate your knowledge of proper `equals` and `hashCode` implementations in the Java programming language.
* Demonstrate your knowledge of variable arguments and enum types in the Java programming language.

### Instructions
* There are four tasks to complete
    - Create an object hierarchy which mimics the classification of [bodies of water](https://en.wikipedia.org/wiki/Body_of_water).
        - The hierarchy should be contained within package [edu.nyu.cs9053.homework4.hierarchy](src/main/java/edu/nyu/cs9053/homework4/hierarchy)
        - There should be a base class called [BodyOfWater](src/main/java/edu/nyu/cs9053/homework4/hierarchy/BodyOfWater.java)
        - There should be the following subtypes:
            - [Ocean](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Ocean.java) a major body of salty water that, in totality, covers about 71% of the Earth's surface.
            - [Puddle](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Puddle.java) a small accumulation of water on a surface, usually the ground.
            - [Sea](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Sea.java)  a large expanse of saline water connected with an ocean, or a large, usually saline, lake that lacks a natural outlet such as the Caspringian Sea and the Dead Sea. In common usage, often synonymous with the ocean.
            - [Spring](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Spring.java) a point where groundwater flows out of the ground, and is thus where the aquifer surface meets the ground surface
            - [Swamp](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Swamp.java) a wetland that features permanent inundation of large areas of land by shallow bodies of water, generally with a substantial number of hummocks, or dry-land protrusions.
            - [Tarn](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Tarn.java) a mountain lake or pool formed in a cirque excavated by a glacier.
            - [FreshWater](src/main/java/edu/nyu/cs9053/homework4/hierarchy/FreshWater.java)
            - [Lake](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Lake.java) a body of water, usually freshwater, of relatively large size contained on a body of land.
            - [Creek](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Creek.java) a (narrow) stream that is smaller than a river; a minor tributary of a river; brook
            - [Brook](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Brook.java) a small stream; a creek.
            - [SaltWater](src/main/java/edu/nyu/cs9053/homework4/hierarchy/SaltWater.java)
            - [Bay](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Bay.java) an area of water bordered by land on three sides, similar to, but smaller than a gulf.
            - [Stream](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Stream.java) a body of water with a detectable current, confined within a bed and banks.
            - [Lagoon](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Lagoon.java) a body of comparatively shallow salt or brackish water separated from the deeper sea by a shallow or exposed sandbank, coral reef, or similar feature.
            - [Estuary](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Estuary.java)  a semi-enclosed coastal body of water with one or more rivers or streams flowing into it, and with a free connection to the open sea
            - [Tributary](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Tributary.java) a stream or river that flows into the main stem (or parent) river or a lake.
            - [Gulf](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Gulf.java) a part of a lake or ocean that extends so that it is surrounded by land on three sides, similar to, but larger than a bay.
        - Each of the subtypes should have the following methods:
            - `getName` returns a name for the body of water as a `String`. This value is per object and not defined by the class it should be used for equality and hashCode.
            - `getVolume` returns the volume in liters of the body of water as a `double`. This value is per object and not defined by the class it should be used for equality and hashCode.
        - If appropriate, the subtypes should have the following methods:
            - `getConnectedWaterBodiesCount` returns the number of tributaries or bodies of water which are connected to this object as an `int`.
            - `getFlow` returns the flow of any stream as liters of type `double`
        - For each class which has no sub-types itself, add an instance field to the class particular to the type which is also used in the `equals` and `hashCode` methods.
    - Provide implementations of the `equals` and `hashCode` methods for each concrete class within package [edu.nyu.cs9053.homework4.hierarchy](src/main/java/edu/nyu/cs9053/homework4/hierarchy)
        - Note, these methods are testing equality and returning hashes for the objects and so should only include checks on type information and object specific values.
        - Note, do not use Objects helper class, write your own implementations.
        - Note, do not share code with super classes.
    - Create an enum type representing the [five ocean names of the world](https://simple.wikipedia.org/wiki/World_Ocean);
        - Each OceanName must also have a method returning the the area in kilometers squared as a `double`, name it `getArea`
        - The enum should be called [OceanName](src/main/java/edu/nyu/cs9053/homework4/OceanName.java) with package `edu.nyu.cs9053.homework4`
    - Create a static varargs method within [OceanName](src/main/java/edu/nyu/cs9053/homework4/OceanName.java) which takes a variable number of OceanName objects and prints each object's area.

### Implementation
* Ensure your code is correct by compiling and testing it
* A portion of your grade will be based upon readability and organization of your code.
    - Follow the naming guidelines of lecture
    - Break large functions into multiple functions based on logical organizations
* Some hierarchies are not apparent and there is not one correct answer.  If in doubt clarify and document the decisions available to you in your code and justify your choice.    
    