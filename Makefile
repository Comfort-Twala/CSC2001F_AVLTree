# Assignment 2 program makefile
# Comfort Twala

JAVA=/usr/bin/java
JAVAC=/usr/bin/javac
JAVADOC=/usr/bin/javadoc
PYTHON=/usr/bin/python3
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin
DOCDIR=doc
SCRIPTDIR=script

$(BINDIR)/%.class:$(SRCDIR)/%.java
		$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=BinaryTreeNode.class BTQueueNode.class BTQueue.class BinaryTree.class AVLTree.class Student.class fileHandler.class AVLApp.class AccessAVLApp.class Experiment.class runExperiment.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
		$(RM) $(BINDIR)/*.class

runAVL: $(CLASS_FILES)
		$(JAVA) -cp $(BINDIR) AccessAVLApp $(ID)

experiment: $(CLASS_FILES)
		$(JAVA) -cp $(BINDIR) runExperiment 

docs:
		$(JAVADOC) -d $(DOCDIR) $(SRCDIR)/*

clean-doc:
		rm -r $(DOCDIR)/*

clean-exp:
		$(RM) data/experiment/find/*.txt
		$(RM) data/experiment/insert/*.txt

analyse:
		$(PYTHON) $(SCRIPTDIR)/analyser.py

clean-analysis:
		$(RM) data/experiment/analysis/*

stats:
		$(PYTHON) $(SCRIPTDIR)/grapher.py
		$(PYTHON) $(SCRIPTDIR)/combinedStats.py

clean-stats:
		$(RM) data/experiment/results/*

visualise:
		$(PYTHON) $(SCRIPTDIR)/visualise.py $(n)