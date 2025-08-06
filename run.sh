#!/bin/bash

# Exit on error
set -e

# Create output directory if not present
mkdir -p out

# Compile all needed classes
javac -cp "lib/*" \
  src/collector/CollectorApp.java \
  src/collector/LogTailer.java \
  src/processor/LogParser.java \
  -d out

# Run the main class
java -cp "out:lib/*" src.collector.CollectorApp
