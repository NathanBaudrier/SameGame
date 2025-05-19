# VARIABLES
SRC_DIR = src
BIN_DIR = bin
DOC_DIR = doc
MAIN_CLASS = Main

# Find all .java files in the source directory
SOURCES := $(shell find $(SRC_DIR) -name "*.java")
CLASSES := $(patsubst $(SRC_DIR)/%, $(BIN_DIR)/%, $(SOURCES:.java=.class))

# Compilation and documentation flags
JAVAC_FLAGS = -d $(BIN_DIR) -encoding UTF-8 -implicit:none
JAVADOC_FLAGS = -d $(DOC_DIR) -encoding UTF-8 -private

### OPTIONAL RULES ###

# Default target: compile and run
all: compile run

# List available Makefile commands
list:
	@echo "Available make commands: all, compile, run, doc, clean, fclean"

# Compile all Java source files into the bin directory
compile:
	mkdir -p $(BIN_DIR)
	javac $(JAVAC_FLAGS) $(SOURCES)

# Run the main class from the bin directory
run: compile
	java -cp $(BIN_DIR) $(MAIN_CLASS)

# Generate Javadoc documentation for the project
doc:
	mkdir -p $(DOC_DIR)
	javadoc $(JAVADOC_FLAGS) -sourcepath $(SRC_DIR) -subpackages model controller view utils components

# Clean compiled classes and generated documentation
clean:
	rm -rf $(BIN_DIR)/*
	rm -rf $(DOC_DIR)/*

# Full clean: remove bin and doc directories entirely
fclean: clean
	rm -rf $(BIN_DIR) $(DOC_DIR)

# Recompile everything from scratch
re: fclean all

### FAKE GOALS ###
.PHONY: all list compile run doc clean fclean re
