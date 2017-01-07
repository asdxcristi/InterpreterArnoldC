clean:
	rm -rf bin output doc
build:
	mkdir bin;
	javac src/*.java -d bin
doc:
	javadoc src/*.java -d doc
run:
	rm -rf output;
	mkdir output;
	for f in tests/*.ac;do \
		java -cp bin CommandLineInterface $$f; \
	done
