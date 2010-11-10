all: CatFiles.class ProgramOptions.class BinaryCatenator.class TextCatenator.class Catenator.class InvalidUsageException.class

CatFiles.class: CatFiles.java ProgramOptions.class BinaryCatenator.class TextCatenator.class Catenator.class InvalidUsageException.class
	javac $<

ProgramOptions.class: ProgramOptions.java
	javac $<

BinaryCatenator.class: BinaryCatenator.java Catenator.class
	javac $<

TextCatenator.class: TextCatenator.java Catenator.class
	javac $<

Catenator.class: Catenator.java ProgramOptions.class
	javac $<

InvalidUsageException.class: InvalidUsageException.java
	javac $<

test: all
	mkdir -p gen
	echo "Input 1" > gen/input1
	echo "Input 2" > gen/input2
	cat gen/input1 gen/input2 > gen/outputexpect
	java CatFiles gen/input1 gen/input2 gen/output
	diff gen/output gen/outputexpect
	echo "Single file" > gen/single
	! java CatFiles
	! java CatFiles gen/single
