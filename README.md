# Introduction
This is my pet-project directed to learn such technologies, as:
- Protocol Buffers
- Some parts of Spring (BeanPostProcessor, AOP, etc.)
- NoSQL (Redis, Neo4j)
- Spring Cloud
- Tests (testcontainers)

# What and when to use
- Protocol Buffers fox advanced serialization/deserialization speed, solve problem with Java native mechanism
- Redis, as says Chat GPT, for caching (I think in sessions, but not sure) (update 2: Chat GPT suggest to use it in real-time notification system)
- Neo4j for recommendation system
- Spring Cloud just for fun, it's my 4 time to use it
- DestructionAwareBeanPostProcessor
- Java RMI to remote administration
- gRPC to communicate between two microservices

# Idk
- I want an achievement system

# TODO
- JWT-tokens
- Email verification
- Business-valued email sending on registration
- Maybe store all user's ip addresses to notify if it sing in from strange device
- send suspect notification to account owner on throwing exception during sign-in 
- Store known user hosts in Auth module and send notification on suspect log in [datatypes for network](https://www.postgresql.org/docs/current/datatype-net-types.html)
- Move to scalable id [generation](https://medium.com/double-pointer/system-design-interview-scalable-unique-id-generator-twitter-snowflake-or-a-similar-service-18af22d74343)


https://docs.github.com/en/apps/oauth-apps/building-oauth-apps/authorizing-oauth-apps