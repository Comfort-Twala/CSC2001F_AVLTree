#!/usr/bin/python3
"""
Python script to:
    * Open analysed files and get array of [min, max, average]
    * Create DataFrame for Array- and BSTApp results
    * Create Graphs from data  
"""

## Imports
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

def main():
    """
    Main method to initiate graphing
    """
    df = data_frame_create()
    for n in range(200, 2001, 200):
        data = []
        for data_struc in ["Array", "AVL"]:
            data += getdata(f"data/experiment/analysis/{data_struc}_n_{n}.txt")
        populate_data_frame(df, data, n)

    data_frame_csv(df)
    graphData(df)

def getdata(file):
    """
    Open file and return array of [min, max, average]
    """
    data = []
    with open(file, 'r') as f:
        for line in f:
            try:
                data.append(eval(line))
            except:
                pass
        f.close()
    return data

def data_frame_create():
    """
    Create a DataFrame
    """
    index = pd.MultiIndex.from_arrays([['Array' for i in range(0,3)]+['AVL' for i in range(0,3)], ['best_case', 'worst_case', 'average_case']*2])    
    df = pd.DataFrame(columns=index)
    return df

def populate_data_frame(df, data, n):
    """
    Populate given data frame with data
    """
    df.loc[n] = data

def data_frame_csv(dataFrame):
    """
    Create csv file from DataFrame
    """
    with open('data/experiment/results/stats.csv', 'w') as stats:
        dataFrame.to_csv(stats)
        stats.close()

def graphData(dataFrame):
    """
    Plot a graph with data from data frame
    """
    dataFrame.plot.line()
    plt.savefig('data/experiment/results/graph.png')
    plt.show()

if __name__ == "__main__":
    main()