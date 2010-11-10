CLASSES=CatFiles.class ProgramOptions.class BinaryCatenator.class TextCatenator.class Catenator.class InvalidUsageException.class
all: $(CLASSES)

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
	java CatFiles examples/bog{1,2,3}.txt gen/bogall.txt
	cat examples/bog{1,2,3}.txt|diff -q gen/bogall.txt -
	cat examples/bog{1,2,3}.txt > gen/bogall.txt
	java CatFiles examples/bog{1,2,3}.txt -|diff -q gen/bogall.txt -
	cat examples/bog1.txt|java CatFiles - gen/bog1.txt
	diff -q examples/bog1.txt gen/bog1.txt
	@rm gen/bog1.txt || true
	java CatFiles -nc {examples,gen}/bog1.txt
	! java CatFiles -nc {examples,gen}/bog1.txt
	echo -n "No newline" > gen/nonl.txt
	java CatFiles -t gen/nonl.txt gen/nl.txt
	! diff -q gen/{no,}nl.txt
	! java CatFiles
	! java CatFiles examples/bog1.txt
	@echo
	@echo "All tests succeeded! Congratz"

clean:
	@rm -v *.class || true
	@rm -rv gen || true
