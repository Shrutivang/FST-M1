import pytest

def test_sum(num_list):
    #create a sum variable
    sum = 0
    #calculate the sum of the numbers in list
    for num in num_list:
        sum += num

    #assertion
    assert sum ==55    