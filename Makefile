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

CLASSES=BinaryTreeNode.class BTQueueNode.class BTQueue.class BinaryTree.class AVLTree.class AVLTreeTest.class Student.class fileHandler.class AVLApp.class AccessAVLApp.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
		$(RM) $(BINDIR)/*.class

runAVL: $(CLASS_FILES)
		$(JAVA) -cp $(BINDIR) AccessAVLApp $(ID)

docs:
		$(JAVADOC) -d $(DOCDIR) $(SRCDIR)/*

clean-doc:
		rm -r $(DOCDIR)/*

experiment:
		$(PYTHON) $(SCRIPTDIR)/experiment.py 

clean-exp:
		$(RM) data/experiment/*.txt

analyse:
		$(PYTHON) $(SCRIPTDIR)/analyser.py

clean-analysis:
		$(RM) data/experiment/analysis/*

stats:
		$(PYTHON) $(SCRIPTDIR)/grapher.py

clean-stats:
		$(RM) data/experiment/results/*