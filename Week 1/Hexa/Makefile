.java.class:
	javac $<

all: HexaTester.class

HexaTester.class: HexaTester.java Hexa.class HexaWrong.class
	javac HexaTester.java

Hexa.class: Hexa.java
	javac Hexa.java

HexaWrong.class: HexaWrong.java
	javac HexaWrong.java

test: HexaTester.class
	java -ea HexaTester
