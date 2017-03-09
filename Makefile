JAVAC = javac
JVM = 1.8
BIN = ./out/production/arcticsearch/
SRC = ./src/
JAVAFLAGS = -g -d $(BIN) -cp $(SRC) -target $(JVM)
COMPILE = $(JAVAC) $(JAVAFLAGS)
EMPTY = 
JAVA_FILES = $(subst $(SRC), $(EMPTY), $(wildcard $(SRC)*.java))
ALL_FILES = $(JAVA_FILES)
CLASS_FILES = $(ALL_FILES:.java=.class)
.PHONY: clean init run all

all: init $(addprefix $(BIN), $(CLASS_FILES)) run

$(BIN)%.class: $(SRC)%.java
	$(COMPILE) $<

init:
	@mkdir -p $(BIN)

run:
	@echo java -cp $(BIN) test1 > run
	@chmod +x run

clean:
	rm -rf ./out/ run
