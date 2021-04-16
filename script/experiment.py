#!/usr/bin/python3
"""
Python script to:
    * Create a subset of n entries from sample data
    * Run both instrumented applications for every one of the n parameters corresponding to the subset of the data file.  Store all operation count values.
    * Determine the minimum (best case), maximum (worst case) and average of these count values. 
"""

### Imports
import os
import random


def main():
    """
    Main method to run expiriment.
    paramenter - App on which to run the experiment on.
    """
    for n in range(200, 2001, 200):
        subset = create_subset(n)
        runArray(subset)
        runAVL(subset)

def runArray(subset):
    """
    Function to run AccessArrayApp on every value in subset and write the results into file Array_subset_{n}.txt
    """
    with open(f'data/experiment/Array_subset_n_{len(subset)}.txt', 'w') as f:
        for detail in subset:
            id = detail.split(" ")[0]
            os.system(f"make runArray ID={id} >> {f.name}")


def runAVL(subset):
    """
    Function to run AccessAVLApp on every value in subset and write the results into file AVL_subset_{n}.txt
    """        
    with open(f'data/experiment/AVL_subset_n_{len(subset)}.txt', 'w') as f:
        for detail in subset:
            id = detail.split(" ")[0]
            os.system(f"make runAVL ID={id} >> {f.name}")

def create_subset(n):
    """
    Create a subset of n entries from sample data
    """
    sample_data = open_datafile()
    return random.sample(sample_data, n)

def open_datafile():
    """
    opens datafile and returns a datalist (sample data) 
    """
    datalist = []
    with open('data/oklist.txt', 'r') as data:
        for entry in data:
            datalist.append(entry)
        data.close()
    return datalist


if __name__ == "__main__":
    main()