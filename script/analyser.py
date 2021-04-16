#!/usr/bin/python3
"""
Python script to:
    * Open all experiment results files
    * Store all operation count values.
    * Determine the minimum (best case), maximum (worst case) and average of these count values. 
"""

def main():
    for n in range(200, 2001, 200):
        for data_struc in ["Array", "AVL"]:
            expfile = open_expfile(f'data/experiment/{data_struc}_subset_n_{n}.txt')
            valueList = count_val(expfile)
            recordData(best_case(valueList), worst_case(valueList), average(valueList), data_struc, n)

def open_expfile(file):
    """
    Function to open experiment file and return results as a list
    """
    filelist = []
    with open(file, 'r') as f:
        for line in f:
            filelist.append(line)
        f.close()
    return filelist

def count_val(file_list):
    """
    Function to store all the operation count values from given list and return as a list
    """
    countlist = []
    for entry in file_list:
        try:
            countlist.append(int(entry))
        except:
            pass
    return countlist

def best_case(c_list):
    """
    Funtion to determine the minimum of the count values
    """
    return min(c_list)

def worst_case(c_list):
    """
    Funtion to determine the maximum of the count values
    """
    return max(c_list)

def average(c_list):
    """
    Funtion to determine the average of the count values
    """
    return sum(c_list)/len(c_list)

def recordData(min, max, avr, type, n):
    """
    Function that takes in minimum, maximum and average for count and writes it to a file.
    """
    with open(f'data/experiment/analysis/{type}_n_{n}.txt', 'w') as f:
        f.write(f"Analysis of {type}App when n is {n}:\n")
        f.write("Minimum (Best Case):\n")
        f.write(f'{min}\n')
        f.write("Maximum (Worst Case):\n")
        f.write(f'{max}\n')
        f.write("Average:\n")
        f.write(f'{avr}')
        f.close()

if __name__ == "__main__":
    main()