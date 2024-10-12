https://stackoverflow.com/questions/64689460/mapstruct-mapper-returns-empty-mapped-object

Problem:
Generated mapper implementation returns empty mapped object.

Solution:
In pom.xml, write the configuration of `lombok` before the configuration of `mapstruct`.
