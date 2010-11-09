all: CatFiles.class

CatFiles.class: CatFiles.java
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
