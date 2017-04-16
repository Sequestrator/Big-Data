![Bombarding](http://cdn.wallpapersafari.com/36/91/LK7N9T.jpg)



```
Required files are in git.
in order to run, please use Eclipse IDE.

There are 2 Required Files. Main and ProjectFunctions.
Each calls their own class in order to write. Simple schemas, but still writing to database
There are executable args denoted by args[0] and args[1]
Please go to the top toolbar, go to Run>RunConfig>Args

and then your arugment list is as follows.
--> localhost src/simpleData.csv
```

#Proof of Data Write

```
Output:
Mar 25, 2017 3:27:36 PM org.mongodb.morphia.logging.MorphiaLoggerFactory chooseLoggerFactory
INFO: LoggerImplFactory set to org.mongodb.morphia.logging.jdk.JDKLoggerFactory
Mar 25, 2017 3:27:36 PM com.mongodb.diagnostics.logging.JULLogger log
INFO: Cluster created with settings {hosts=[localhost:27017], mode=SINGLE, requiredClusterType=UNKNOWN, serverSelectionTimeout='30000 ms', maxWaitQueueSize=500}
Mar 25, 2017 3:27:37 PM com.mongodb.diagnostics.logging.JULLogger log
INFO: Opened connection [connectionId{localValue:1, serverValue:1}] to localhost:27017
Mar 25, 2017 3:27:37 PM com.mongodb.diagnostics.logging.JULLogger log
INFO: Monitor thread successfully connected to server with description ServerDescription{address=localhost:27017, type=STANDALONE, state=CONNECTED, ok=true, version=ServerVersion{versionList=[3, 4, 2]}, minWireVersion=0, maxWireVersion=5, maxDocumentSize=16777216, roundTripTimeNanos=502926}
Adding airline AA	American Airlines
Mar 25, 2017 3:27:37 PM com.mongodb.diagnostics.logging.JULLogger log
INFO: Opened connection [connectionId{localValue:2, serverValue:2}] to localhost:27017
Adding airline SWA	Southwest Airlines
Adding airport IND	IN	Indianapolis
Adding airport ORD	IL	Chicago
Adding airport LAX	CA	Los Angeles
Adding airport DCA	DC	Washington DC
Adding plane 777	400 seats
Adding plane 727	128 seats
Adding flight AA102	from IND to ORD on 0	plane 727
Adding flight AA201	from ORD to IND on 0	plane 727
Adding flight AA103	from IND to ORD on 0	plane 727
Adding flight AA301	from ORD to IND on 0	plane 727
Adding flight AA102	from IND to ORD on 1	plane 727
Adding flight AA201	from ORD to IND on 1	plane 727
Adding flight AA103	from IND to ORD on 1	plane 727
Adding flight AA301	from ORD to IND on 1	plane 727
Adding flight AA102	from IND to ORD on 2	plane 727
Adding flight AA201	from ORD to IND on 2	plane 727
Adding flight AA103	from IND to ORD on 2	plane 727
Adding flight AA301	from ORD to IND on 2	plane 727
Adding flight AA102	from IND to ORD on 3	plane 727
Adding flight AA201	from ORD to IND on 3	plane 727
Adding flight AA103	from IND to ORD on 3	plane 727
Adding flight AA301	from ORD to IND on 3	plane 727
Adding flight AA102	from IND to ORD on 4	plane 727
Adding flight AA201	from ORD to IND on 4	plane 727
Adding flight AA103	from IND to ORD on 4	plane 727
Adding flight AA301	from ORD to IND on 4	plane 727
Adding flight AA102	from IND to ORD on 5	plane 727
Adding flight AA201	from ORD to IND on 5	plane 727
Adding flight AA103	from IND to ORD on 5	plane 727
Adding flight AA301	from ORD to IND on 5	plane 727
Adding flight AA102	from IND to ORD on 6	plane 727
Adding flight AA201	from ORD to IND on 6	plane 727
Adding flight AA103	from IND to ORD on 6	plane 727
Adding flight AA301	from ORD to IND on 6	plane 727
Adding flight SW800	from IND to ORD on 6	plane 727
Adding flight SW801	from ORD to IND on 6	plane 727
Adding flight SW810	from IND to ORD on 6	plane 727
Adding flight SW811	from ORD to IND on 6	plane 727
Adding flight SW800	from IND to ORD on 0	plane 727
Adding flight SW801	from ORD to IND on 0	plane 727
Adding flight SW810	from IND to ORD on 0	plane 727
Adding flight SW811	from ORD to IND on 0	plane 727
Adding flight AA555	from ORD to LAX on 1	plane 777
Adding flight AA444	from LAX to ORD on 1	plane 777
Adding traveller 1	Mike
Adding traveller 2	Joe
Adding traveller 3	Tammy
Adding traveller 4	Dave
Adding traveller 5	Julia
Adding traveller 6	Joe
Adding traveller 7	Andrew
Adding traveller 8	Amy
Making reservation 1 for traveller 1 on flight AA102 for the date 2017-03-05
Making reservation 2 for traveller 1 on flight AA201 for the date 2017-03-06
Making reservation 3 for traveller 4 on flight AA555 for the date 2017-03-06
Making reservation 4 for traveller 5 on flight AA555 for the date 2017-03-06
Making reservation 5 for traveller 4 on flight AA444 for the date 2017-03-13
Making reservation 5 for traveller 5 on flight AA444 for the date 2017-03-13

***Writing To Database***

2017-03-25T15:26:05.439-0400 I NETWORK  [thread1] waiting for connections on port 27017
2017-03-25T15:27:37.008-0400 I NETWORK  [thread1] connection accepted from 127.0.0.1:49329 #1 (1 connection now open)
2017-03-25T15:27:37.013-0400 I NETWORK  [conn1] received client metadata from 127.0.0.1:49329 conn1: { driver: { name: "mongo-java-driver", version: "unknown" }, os: { type: "Darwin", name: "Mac OS X", architecture: "x86_64", version: "10.12.3" }, platform: "Java/Oracle Corporation/1.8.0_25-b17" }
2017-03-25T15:27:37.066-0400 I NETWORK  [thread1] connection accepted from 127.0.0.1:49330 #2 (2 connections now open)
2017-03-25T15:27:37.067-0400 I NETWORK  [conn2] received client metadata from 127.0.0.1:49330 conn2: { driver: { name: "mongo-java-driver", version: "unknown" }, os: { type: "Darwin", name: "Mac OS X", architecture: "x86_64", version: "10.12.3" }, platform: "Java/Oracle Corporation/1.8.0_25-b17" }
2017-03-25T15:27:38.004-0400 I WRITE    [conn2] update iSprayMyyAK47.Airline query: { _id: "AA" } planSummary: IDHACK update: { className: "cs473.Airline", _id: "AA", name: "American Airlines" } keysExamined:0 docsExamined:0 nMatched:0 nModified:0 upsert:1 keysInserted:1 numYields:0 locks:{ Global: { acquireCount: { r: 3, w: 3 } }, Database: { acquireCount: { w: 2, W: 1 } }, Collection: { acquireCount: { w: 2 } } } 929ms
2017-03-25T15:27:38.004-0400 I COMMAND  [conn2] command iSprayMyyAK47.$cmd command: update { update: "Airline", ordered: true, updates: [ { q: { _id: "AA" }, u: { className: "cs473.Airline", _id: "AA", name: "American Airlines" }, upsert: true } ] } numYields:0 reslen:105 locks:{ Global: { acquireCount: { r: 3, w: 3 } }, Database: { acquireCount: { w: 2, W: 1 } }, Collection: { acquireCount: { w: 2 } } } protocol:op_query 929ms
2017-03-25T15:27:38.845-0400 I WRITE    [conn2] update iSprayMyyAK47.Airport query: { _id: "IND" } planSummary: IDHACK update: { className: "cs473.Airport", _id: "IND", state: "IN", city: "Indianapolis" } keysExamined:0 docsExamined:0 nMatched:0 nModified:0 upsert:1 keysInserted:1 numYields:0 locks:{ Global: { acquireCount: { r: 3, w: 3 } }, Database: { acquireCount: { w: 2, W: 1 } }, Collection: { acquireCount: { w: 2 } } } 833ms
2017-03-25T15:27:38.845-0400 I COMMAND  [conn2] command iSprayMyyAK47.$cmd command: update { update: "Airport", ordered: true, updates: [ { q: { _id: "IND" }, u: { className: "cs473.Airport", _id: "IND", state: "IN", city: "Indianapolis" }, upsert: true } ] } numYields:0 reslen:106 locks:{ Global: { acquireCount: { r: 3, w: 3 } }, Database: { acquireCount: { w: 2, W: 1 } }, Collection: { acquireCount: { w: 2 } } } protocol:op_query 833ms
2017-03-25T15:27:39.618-0400 I WRITE    [conn2] update iSprayMyyAK47.Plane query: { _id: "777" } planSummary: IDHACK update: { className: "cs473.Plane", _id: "777", seats: 400 } keysExamined:0 docsExamined:0 nMatched:0 nModified:0 upsert:1 keysInserted:1 numYields:0 locks:{ Global: { acquireCount: { r: 3, w: 3 } }, Database: { acquireCount: { w: 2, W: 1 } }, Collection: { acquireCount: { w: 2 } } } 765ms
2017-03-25T15:27:39.618-0400 I COMMAND  [conn2] command iSprayMyyAK47.$cmd command: update { update: "Plane", ordered: true, updates: [ { q: { _id: "777" }, u: { className: "cs473.Plane", _id: "777", seats: 400 }, upsert: true } ] } numYields:0 reslen:106 locks:{ Global: { acquireCount: { r: 3, w: 3 } }, Database: { acquireCount: { w: 2, W: 1 } }, Collection: { acquireCount: { w: 2 } } } protocol:op_query 765ms
2017-03-25T15:27:40.571-0400 I WRITE    [conn2] update iSprayMyyAK47.Flight query: { _id: "AA" } planSummary: IDHACK update: { className: "cs473.Flight", _id: "AA", flightCode: "AA102", dayOfWeek: 0, origAirportCode: "IND", destAirportCode: "ORD", planeType: "727" } keysExamined:0 docsExamined:0 nMatched:0 nModified:0 upsert:1 keysInserted:1 numYields:0 locks:{ Global: { acquireCount: { r: 3, w: 3 } }, Database: { acquireCount: { w: 2, W: 1 } }, Collection: { acquireCount: { w: 2 } } } 948ms
2017-03-25T15:27:40.571-0400 I COMMAND  [conn2] command iSprayMyyAK47.$cmd command: update { update: "Flight", ordered: true, updates: [ { q: { _id: "AA" }, u: { className: "cs473.Flight", _id: "AA", flightCode: "AA102", dayOfWeek: 0, origAirportCode: "IND", destAirportCode: "ORD", planeType: "727" }, upsert: true } ] } numYields:0 reslen:105 locks:{ Global: { acquireCount: { r: 3, w: 3 } }, Database: { acquireCount: { w: 2, W: 1 } }, Collection: { acquireCount: { w: 2 } } } protocol:op_query 948ms
2017-03-25T15:27:41.566-0400 I WRITE    [conn2] update iSprayMyyAK47.Traveler query: { _id: 1 } planSummary: IDHACK update: { className: "cs473.Traveler", _id: 1, name: "Mike" } keysExamined:0 docsExamined:0 nMatched:0 nModified:0 upsert:1 keysInserted:1 numYields:0 locks:{ Global: { acquireCount: { r: 3, w: 3 } }, Database: { acquireCount: { w: 2, W: 1 } }, Collection: { acquireCount: { w: 2 } } } 947ms
2017-03-25T15:27:41.566-0400 I COMMAND  [conn2] command iSprayMyyAK47.$cmd command: update { update: "Traveler", ordered: true, updates: [ { q: { _id: 1 }, u: { className: "cs473.Traveler", _id: 1, name: "Mike" }, upsert: true } ] } numYields:0 reslen:102 locks:{ Global: { acquireCount: { r: 3, w: 3 } }, Database: { acquireCount: { w: 2, W: 1 } }, Collection: { acquireCount: { w: 2 } } } protocol:op_query 947ms
2017-03-25T15:27:42.374-0400 I WRITE    [conn2] update iSprayMyyAK47.Reservation query: { _id: 1 } planSummary: IDHACK update: { className: "cs473.Reservation", _id: 1, travelerId: 1, flightCode: "AA102", dayOfWeek: 0, date: new Date(1488690000000) } keysExamined:0 docsExamined:0 nMatched:0 nModified:0 upsert:1 keysInserted:1 numYields:0 locks:{ Global: { acquireCount: { r: 3, w: 3 } }, Database: { acquireCount: { w: 2, W: 1 } }, Collection: { acquireCount: { w: 2 } } } 800ms
2017-03-25T15:27:42.374-0400 I COMMAND  [conn2] command iSprayMyyAK47.$cmd command: update { update: "Reservation", ordered: true, updates: [ { q: { _id: 1 }, u: { className: "cs473.Reservation", _id: 1, travelerId: 1, flightCode: "AA102", dayOfWeek: 0, date: new Date(1488690000000) }, upsert: true } ] } numYields:0 reslen:102 locks:{ Global: { acquireCount: { r: 3, w: 3 } }, Database: { acquireCount: { w: 2, W: 1 } }, Collection: { acquireCount: { w: 2 } } } protocol:op_query 800ms
2017-03-25T15:27:42.402-0400 I -        [conn2] end connection 127.0.0.1:49330 (2 connections now open)
2017-03-25T15:27:42.402-0400 I -        [conn1] end connection 127.0.0.1:49329 (2 connections now open)
```

[![Github Issues](http://githubbadges.herokuapp.com/Bombarding/readme/issues.svg?style=flat-square)](https://github.com/Bombarding/readme/issues) [![Pending Pull-Requests](http://githubbadges.herokuapp.com/Bombarding/readme/pulls.svg?style=flat-square)](https://github.com/Bombarding/readme/pulls) [![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)[![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](http://www.gnu.org/licenses/gpl-3.0)

```
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 

IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```

![fb_img_1479189403554](https://images4.alphacoders.com/202/thumb-1920-202536.jpg)
