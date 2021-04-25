#!/usr/bin/python3
"""
Python script to:
    * Open analysed files and get array of [min, max, average]
    * Create DataFrame for AVLApp results
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
    for n in range(500, 5001, 500):
        data = []
        for type in ['find', 'insert']:
            data += getdata(f"data/experiment/analysis/AVL_{type}_n_{n}.txt")
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
    index = pd.MultiIndex.from_arrays([['Find' for i in range(0,3)] + ['Insert' for i in range(0,3)], ['best_case', 'worst_case', 'average_case']*2])
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
    with open(f'data/experiment/results/combined_stats.csv', 'w') as stats:
        dataFrame.to_csv(stats)
        stats.close()

def graphData(dataFrame):
    """
    Plot a graph with data from data frame
    """
    dataFrame.plot.line()
    plt.title(f"AVL operation count for Find and Insert methods")
    plt.xlabel("Subset (n)")
    plt.ylabel("operation count")
    plt.savefig(f'data/experiment/results/combined_graph.png')

if __name__ == "__main__":
    main()