
# VetServices <Service Name> Performance Test

This module was created to facilitate the performance testing of  <Service Name> and has no other functionality.

This test will execute requests for the <no of endpoints> rest end points available in <Service Name>.

- Get list of <endpoint name>: <URL>


Additionally it will also hit the /token end point to generate JWT token for the users

## Performance Test Configuration

The test suite can be configure to execute each test a different number of time and with different number of threads.
To override any of the below properties please pass them as -D arguments (ex. -Ddomain=dev.internal.vetservices.gov)

|Property|Description|Default Value|Perf Env Test Values|
|-|-|-|-|
|domain| service Base Url|localhost| |
|port|Service Port|8762|443 |
|protocol| Service Protocol|http|https |
|BearerTokenCreate.threadGroup.threads|Number of threads for Bearer Token Create/Generate|5|150|
|BearerTokenCreate.threadGroup.rampUp|Thead ramp up|1|50|
|BearerTokenCreate.threadGroup.loopCount|Number of executions |1|1|

## Performance Test Execution

To execute test locally simply run **mvn clean verify -Pperftest**. If you need to override any of the properties please use -D arguments with the arguments mention above.

Use below sample commands to execute for different environment:

DEV: **mvn clean verify -Pperftest -Dprotocol=https -Ddomain=dev.internal.vetservices.gov -Dport=443  -Djavax.net.ssl.keyStore="path to keystore" -Djavax.net.ssl.keyStorePassword="keystore password"**

Stage: **mvn clean verify -Pperftest -Dprotocol=https -Ddomain=staging.internal.vetservices.gov -Dport=443 -Djavax.net.ssl.keyStore="path to keystore" -Djavax.net.ssl.keyStorePassword="keystore password"**

Note: To execute the test against dev and stagging JKS file has to be stored locally.

Sample Command for executing the test in performance test environment: 

**mvn clean verify -Pperftest -Dprotocol=<> -Ddomain=<> -Dport=<> -DBearerTokenCreate.threadGroup.threads=150 
-Djavax.net.ssl.keyStore="path to keystore" -Djavax.net.ssl.keyStorePassword="keystore password" -DBearerTokenCreate.threadGroup.rampUp=50 -DBearerTokenCreate.threadGroup.loopCount=1**

For developing the performance test, use the GUI mode. For the actual test execution, use of NON-GUI mode is recommended.
