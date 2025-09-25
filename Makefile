
all: logs

logs: java-build cpp-build
	cd java-logging-example && mvn -q exec:java -Dexec.mainClass=org.example.Main -Dexec.args="Finn Henrietta" > ../lnav-java.log &
	cd cmake-project && ./build/lnav-cpp-debug-example Finn Henrietta > ../lnav-cpp.log &
	cd python-logging-example && python3 -m python_logging_example > ../lnav-python.log &

cpp-build:
	cd cmake-project && mkdir -p build && cmake -S . -B build && cmake --build build

java-build:
	cd java-logging-example && mvn package
