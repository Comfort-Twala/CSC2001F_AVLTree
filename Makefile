# Assignment 2 program makefile
# Comfort Twala

### VARIABLES ###
JAVA=/usr/bin/java
JAVAC=/usr/bin/javac
JAVADOC=/usr/bin/javadoc
PYTHON=/usr/bin/python3
PYTHONENV=env/bin/python3
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin
DOCDIR=doc
SCRIPTDIR=script

### PART 1: PROGRAM ###
$(BINDIR)/%.class:$(SRCDIR)/%.java
		$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=BinaryTreeNode.class BTQueueNode.class BTQueue.class BinaryTree.class AVLTree.class Student.class fileHandler.class AVLApp.class AccessAVLApp.class Experiment.class runExperiment.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
		$(RM) $(BINDIR)/*.class

runAVL: $(CLASS_FILES)
		$(JAVA) -cp $(BINDIR) AccessAVLApp $(ID)

### PART 2: EXPERIMENT ####
### SETUP ###
### Setting up virtualenv and installing dependencies
pip-install:
		$(PYTHON) -m pip install --user --upgrade pip
		sudo apt-get install python3-venv
		$(PYTHON) -m venv env
		. env/bin/activate &&  $(PYTHONENV) -m pip install -r requirements.txt

clean-install:
		rm -rf env

### Running Experiment
experiment: $(CLASS_FILES)
		$(JAVA) -cp $(BINDIR) runExperiment 

clean-exp:
		$(RM) data/experiment/find/*.txt
		$(RM) data/experiment/insert/*.txt

### Running analysis
analyse:
		$(PYTHONENV) $(SCRIPTDIR)/analyser.py

clean-analysis:
		$(RM) data/experiment/analysis/*

### Gathering stats 
stats:
		$(PYTHONENV) $(SCRIPTDIR)/grapher.py
		$(PYTHONENV) $(SCRIPTDIR)/combinedStats.py

clean-stats:
		$(RM) data/experiment/results/*

### Visualising AVL algorithm
visualise:
		$(PYTHONENV) $(SCRIPTDIR)/visualise.py $(n)

### Documentation
docs:
		$(JAVADOC) -d $(DOCDIR) $(SRCDIR)/*

clean-doc:
		rm -r $(DOCDIR)/*