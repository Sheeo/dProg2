Driver.class: Driver.java
	javac Driver.java

MultiSet.class: MultiSet.java
	javac MultiSet.java

test: Driver.class MultiSet.class
	#"Testing Wordcount on sourcefiles"
	java Driver wordcount MultiSet.java Driver.java
	#"Testing multiset with Driver class"
	java Driver multiset
