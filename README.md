# CSC2001F - Assignment 2
## AVL Tree
## Goal
### To test the performance of the AVL Tree, using a real-world application 

## Part 1: Program
### Build
```unix
$ make
```
### clean
```
$ make clean
```
### run AccessAVLApp
```
$ make runAVL
$ make runAVL ID=<studentID>
```

## Part 2: Experiment
## Setup
### Dependencies installation
#### Python scripts require external dependencies which need to be installed.
#### Run the following command to create virtual environment and install dependencies 
### NB! Requires sudo privileges 
```
$ make pip-install
```
### run Experiment
```
$ make experiment
```
### clean Experiment
```
$ make clean-exp
```
### run Analysis
```
$ make analyse
```
### clean Analysis
```
$ make clean-analysis
```
### run Stats
```
$ make stats
```
### clean Stats
```
$ make clean-stats
```
### run Algorithm Visualiser
```
$ make visualise
$ make visualise n=<n>
```
#### where n is the subset length you want to visualise

## Documentation
### generate Javadocs
```
$ make docs
```
### clean Javadocs
```
$ make clean-doc
```