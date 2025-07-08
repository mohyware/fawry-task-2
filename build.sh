#!/bin/sh

echo "=== Building E-Commerce System ==="

# Create build directory
mkdir -p build

# Compile all Java files
echo "Compiling Java files..."
javac -d build src/main/java/com/fawry/QuantumBookstore/Main.java src/main/java/com/fawry/QuantumBookstore/model/*.java src/main/java/com/fawry/QuantumBookstore/service/*.java

if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo ""
    echo "=== Running Main Demo ==="
    java -cp build com.fawry.QuantumBookstore.Main
else
    echo "Compilation failed!"
    exit 1
fi 