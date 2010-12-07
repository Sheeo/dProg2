Driver.class: Driver.java
	javac Driver.java

MultiSet.class: MultiSet.java
	javac MultiSet.java

MultiSetTest.class: MultiSetTest.java
	javac MultiSetTest.java

pdf:
	pdflatex aflevering.tex

spec: MultiSet.class
	rspec --format=documentation MultiSetSpec.rb

test: Driver.class MultiSet.class MultiSetTest.class
	#"Testing Wordcount on sourcefiles"
	java Driver wordcount MultiSet.java Driver.java
	#"Testing multiset with Driver class"
	java Driver multiset
	#"Testing using gudmunds MultiSetTest.java"
	java -ea MultiSetTest
