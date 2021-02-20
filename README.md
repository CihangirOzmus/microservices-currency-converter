# microservices-currency-converter
Updated with new release of Spring Cloud

* Spring Cloud LoadBalancer is used instead of Ribbon

* Spring Cloud Gateway is used instead of Zuul

* Resilience4j is used instead of Hystrix

# Endpoints
_With Api Gateway_

http://localhost:8765/currency-conversion/currency-conversion-feign/from/USD/to/INR/quantity/10

http://localhost:8765/currency-conversion/currency-conversion/from/USD/to/INR/quantity/10

http://localhost:8765/currency-exchange/currency-exchange/from/USD/to/INR

_Real Urls_

http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10

http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10

http://localhost:8000/currency-exchange/from/USD/to/INR

http://localhost:8080/limits

http://localhost:8888/limits-service/dev
