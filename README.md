In Springbooot Currency-Exchange service project Currency-service and Currency-Exchange are the major services
And these two Services Registered with the Service registry(Eureka-server) by using Application name. 
In Currency-Exchange service we are taking Schema.sql in that we take database Query and data.sql we take the insert queries 
the data pass to Currency-Service by using feign-client and with similar Entity class 
Api gateway is the single entry point for all requests from browser 
Api-Gateway Routes the incomming requests to the appropriate microservices.
when client sends the request ,Api Gateway retrievs the Service information from the service-registry(Eureka) if appropriate service is availabale ,then it routes the request to microservice
Otherwise, it returns an errror response to the client

      Depenndencies added to the Currency-service and Currency-Exchange
      
1)Spring web
2)Spring cloud-netflix-eureka-client
3)springboot-dev-tools
4)h2
5)Lombak
6)Spring-boot-starter-JPA
7)Spring-cloud-starter-open-feign
8)Spring-boot-starter-actuator


          Dependencies added to the  Service-registry(Eureka)
          
1)Spring web
2)Spring cloud-netflix-eureka-server
3)Spring-boot-dev-tools

        Dependencies added to the api gateway
        
1)Spring web
2)Discovery client
3)gateway
4)devtools
5)Actuvator
remove devtools and add the Loadbalancer 
==>Loabbalancer will balancing the requests across the multiple servers

Currency-Exchange URL
====>  http://localhost:8003/api/v1/from/USD/to/INR

o/p: {"id":10001,"fromCurrency":"USD","toCurrency":"INR","conversionMultiple":65.0}

Currency-Service URL:
====>   http://localhost:8001/api/v1/from/USD/to/INR/quantity/10

o/p: {"id":1,"fromCurrency":"USD","toCurrency":"INR","conversionMultiple":65.0,"totalCalculatedAmount":650.0,"quantity":10,"locatDateTime":"2025-01-28T10:48:12.8352906"}

API-GATEWAY URL:  http://localhost:7777/api/v1/from/USD/to/INR/quantity/19

URL:  http://localhost:7777/api/v1/from/USD/to/INR

URL:  http://localhost:7777/actuator

Actuator URL : http://localhost:8001/actuator
o/p:
{"_links":{"self":{"href":"http://localhost:8001/actuator","templated":false},
"circuitbreakers":{"href":"http://localhost:8001/actuator/circuitbreakers","templated":false},
"circuitbreakers-name":{"href":"http://localhost:8001/actuator/circuitbreakers/{name}","templated":true},
"circuitbreakerevents-name-eventType":{"href":"http://localhost:8001/actuator/circuitbreakerevents/{name}/{eventType}","templated":true},
"circuitbreakerevents-name":{"href":"http://localhost:8001/actuator/circuitbreakerevents/{name}","templated":true},"circuitbreakerevents":{"href":"http://localhost:8001/actuator/circuitbreakerevents","templated":false},
"ratelimiters":{"href":"http://localhost:8001/actuator/ratelimiters","templated":false},"ratelimiterevents-name-eventType":{"href":"http://localhost:8001/actuator/ratelimiterevents/{name}/{eventType}","templated":true},"ratelimiterevents-name":{"href":"http://localhost:8001/actuator/ratelimiterevents/{name}","templated":true},
"ratelimiterevents":{"href":"http://localhost:8001/actuator/ratelimiterevents","templated":false},"retries":{"href":"http://localhost:8001/actuator/retries","templated":false},"retryevents-name":{"href":"http://localhost:8001/actuator/retryevents/{name}","templated":true},"retryevents-name-eventType":{"href":"http://localhost:8001/actuator/retryevents/{name}/{eventType}","templated":true},
"retryevents":{"href":"http://localhost:8001/actuator/retryevents","templated":false},"timelimiters":{"href":"http://localhost:8001/actuator/timelimiters","templated":false},
"timelimiterevents":{"href":"http://localhost:8001/actuator/timelimiterevents","templated":false},"timelimiterevents-name-eventType":{"href":"http://localhost:8001/actuator/timelimiterevents/{name}/{eventType}","templated":true},"timelimiterevents-name":{"href":"http://localhost:8001/actuator/timelimiterevents/{name}","templated":true},
"beans":{"href":"http://localhost:8001/actuator/beans","templated":false},"caches-cache":{"href":"http://localhost:8001/actuator/caches/{cache}","templated":true},"caches":{"href":"http://localhost:8001/actuator/caches","templated":false},"health":{"href":"http://localhost:8001/actuator/health","templated":false},"health-path":{"href":"http://localhost:8001/actuator/health/{*path}","templated":true},"info":{"href":"http://localhost:8001/actuator/info","templated":false},"conditions":{"href":"http://localhost:8001/actuator/conditions","templated":false},"configprops":{"href":"http://localhost:8001/actuator/configprops","templated":false},"configprops-prefix":{"href":"http://localhost:8001/actuator/configprops/{prefix}","templated":true},"env":{"href":"http://localhost:8001/actuator/env","templated":false},"env-toMatch":{"href":"http://localhost:8001/actuator/env/{toMatch}","templated":true},"loggers":{"href":"http://localhost:8001/actuator/loggers","templated":false},"loggers-name":{"href":"http://localhost:8001/actuator/loggers/{name}","templated":true},"heapdump":{"href":"http://localhost:8001/actuator/heapdump","templated":false},"threaddump":{"href":"http://localhost:8001/actuator/threaddump","templated":false},"metrics-requiredMetricName":{"href":"http://localhost:8001/actuator/metrics/{requiredMetricName}","templated":true},"metrics":{"href":"http://localhost:8001/actuator/metrics","templated":false},"sbom":{"href":"http://localhost:8001/actuator/sbom","templated":false},"sbom-id":{"href":"http://localhost:8001/actuator/sbom/{id}","templated":true},"scheduledtasks":{"href":"http://localhost:8001/actuator/scheduledtasks","templated":false},"mappings":{"href":"http://localhost:8001/actuator/mappings","templated":false},"refresh":{"href":"http://localhost:8001/actuator/refresh","templated":false},"features":{"href":"http://localhost:8001/actuator/features","templated":false},"serviceregistry":{"href":"http://localhost:8001/actuator/serviceregistry","templated":false}
