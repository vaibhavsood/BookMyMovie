# BookMyMovie
This is a proof of concept movie ticket booking application using Spring Boot, Spring Security and a simple but neat HTML/CSS/Bootstrap frontend.

It uses the [MovieLens small dataset](http://files.grouplens.org/datasets/movielens/) to populate movie info  


![Movies](movies-home-page.png)

## Running BookMyMovie locally

BookMyMovie is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). It can be run either from the command line or through an IDE

### Prerequisites

* Java 8+
* git command line tool (https://help.github.com/articles/set-up-git)
* Maven
* Your prefered IDE (optional but recommended, i use Intellij) 

### Steps:

1) Clone the project from git
```
git clone https://github.com/vaibhavsood/BookMyMovie.git
```
2) To run from the command line:
```
cd BookMyMovie
./mvnw package
java -jar target/*.jar
```
