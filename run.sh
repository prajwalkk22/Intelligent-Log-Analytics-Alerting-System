#!/bin/bash

# Exit if any command fails
set -e

# Create logs directory if it doesn't exist
mkdir -p logs

# Compile the Java file
echo "Compiling Main.java..."
javac -d out src/Main.java

# Run the program
echo "Starting log tailer..."
java -cp out src.Main
