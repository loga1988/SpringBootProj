Spring Boot Security Implementation notes

Add the spring boot starter security org.springframework.boot:spring-boot-starter-security
Add the jwt dependency io.jsonwebtoken:jjwt:0.9.1
When we restart the application we see our endpoints will not work and will end in Unauthorized exception
Create a Util to write generateToken and validateToken methods
generateToken snippet Jwts.builder() .setClaims(claims) .setSubject(subject) .setIssuedAt(new Date(System.currentTimeMillis())) .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) .signWith(SignatureAlgorithm.HS256, SECRET) .compact();
Inside ValidateToken extract username from the token using io.jsonwebtoken.Claims
Write a filter class extending OncePerRequestFilter
Inside the filter class we have doFilterInternal overridden method and we can validate the token using the Util class
Now as a final step we need to create Security class by extending WebSecurityConfigurerAdapter
Inside SecurityConfig class we can add the request uri matcher and we can add filter to validate the jwt token
Important step is authentication we use username and password for the application authorization and generate token upon token generated then we can access other endpoints
Service Discovery, Service Registry and Load Balancer Service Discovery is a mechanism which registers the service information in the service registry when the server is booting Service Registry -- information about a microservice like its Ip and port number Example : Lets say microservice A wants to talk to microservice B then first step it goes to the load balancer and load balancer reaches service discovery which in turn looks at service registry to get the ip and port details of microservice B once obtained the data from servuce discovery the load balancer decides where to route the request Client-Side Service Discovery Example: Netflix Eureka, Zookeeper, Consul -- querying service registry to find the microservices Server-Side Service Discovery : Amazon ELB -- find the microservices availability from service registry through router or load balancer

Service Discovery -- Service Provider + Service Registry + Service Consumer

Circuit Breaker : When a request fails to the service again and again then circuit breaker opens and halts all the requests to the service Closed State, Open State, Half-open state

For spring at the method level we can use @transactional this ensures the DB transaction happens fine if not it will rollback the transaction Attrubutes of @Transactional

propagation -- how the transaction boundaries propogate to other method that will be called either directly or indirectly REQUIRED..... -- if no active transaction spring creates one otherwise use active transaction REQUIRES_NEW -- if active transaction exists it will terminate and create new transaction SUPPORTS -- if transaction exists it will use if not it will be executed non-transactional NOT_SUPPORTED -- if transaction exixts it will terminate and will be executed non-transactional MANDATORY -- if active transaction exists it will use if not it will throw exception NEVER -- if active transaction exists it will throw error NESTED -- if transaction exists it will create a save point if any error in the method it will rollback to the save point

readOnly -- if the current transaction is readOnly or readWrite default is true but can be overridden at the method level

rollbackFor, rollbackForClassName -- one or more throwable classes for which current transaction will be rolled back

noRollBackFor, noRollbackForClassName -- The "noRollbackFor" and "noRollbackForClassName" define one or more Throwable classes for which the current transaction will not be rolled back.

Examples : @Transactional(rollbackFor = {SQLException.class}, noRollbackFor = {EntityNotFoundException.class}) @Transactional(rollbackForClassName = {"NullpointerException"}, noRollbackForClassName = {"EntityNotFoundException"}) @Transactional(readOnly = true) @Transactional(propagation = Propagation.MANDATORY)

JWT token

header.payload.signature

header -- token type and algorithm used for signing --SHA payload -- consists of session data something like issuer, issued at etc signature -- A string that is generated via a cryptographic algorithm that can be used to verify the integrity of the JSON payload.

Symmetric -- single key for encryption and decrption Asymmetric -- public and private key RSA DES hash function -- generates hash value with fixed length

RestTemplate -- sync, blocking Webclient -- async , non-blocking

RestClient -- Rest Template Infrastructure + message converters, request factories, interceptors from Web client

ACID -- A=Atomicity, C=Consistency, I=Isolation, D=Durability @ControllerAdvice -- Exception Handler

activemq is a message broker with JMS client

JMS is an interface to exchange message between the computers

Saga pattern -- series of local transactions upon successful send event to other services to indicate the success Choreography -- every service listens to other service for event and decided what to do Orchestration -- one service acts as the controller and tells the other service what to do

OAuth is an open-standard authorization protocol that allows third-party applications to access user data from a service provider without sharing passwords.

OAuth -- open-standard authorization protocol which allows third party applications can access data from service provider

OAuth -- authorization to access resource from service provider -- browser,WEB, APIs JWT -- authentication and exchanging information -- APIs

OneToMany Mapping first entity can have a relation with multiple instances of the second entity

Ex: Employee Table, Account Table

employee entity can have multiple instances of account entity but one account cannot be linked to multiple employee

OneToOne Mapping first entity can have a relation with single instance of the second entity

Ex: user table, Address table id of user table is associated with user_id which is foreign key of address table

ManyToOne Mapping many entities of one table is linked with one entity if anothet table

Ex: comments, tutorial

multiple comments is linked with one tutorial id

ManytoMany mapping multiple instances of one entity is linked with multiple instances of another entity

Ex: student, courses

@Valid -- this annotation is used to validate the nested object inside a parent object and also it can be specifically used inside the controller @Validated -- allow you to group and validate constraints selectively based on specific use cases Ex for validated : when creating a user we have to validate username, password and email but when updating a user we have to allow only email and password update

@Pattern -- it sill match a specific pattern for the input string parameter Ex: @Pattern(regexp ="\d{13}", message="ISBN string should be a 13 digit number") @NotEmpty @NotNull @Size-- To valid the list of elements

Cache in Spring boot 
1) In-memory Caching -- this provides querying capacity on top of caching 
2) Web server caching -- stores data, such as a copy of a web page served by a web server
3) Database caching -- this helps to avoid querying database frequently 
4) CDN (Content Delivery Network) caching -- group of distributed servers that speed up the delivery of web content

@Cacheable -- method level annotation to cache the return object of method
@CacheEvict -- when we don't want to populate the values that we don't need often 
@CachePut -- to update the content of cache without method execution
@Caching -- if we want to use multiple cacheEvict then we can go for Caching 

kafka                                       JMS
pull type                                   push type
high throughput                             low throughput
more scalable and high availability         less scalable and moderate availability

***throughput -- number of messages kafka processes in a specific period of time 
