# Given list of numbers
#numlist = [1,2,3,4,5,6]
numlist = list(input("Enter the list of numbers seperated by commas:  ").split(","))       
#calculate sum of numbers int he list
sum = 0
for num in numlist:
    sum += int(num)
#print the sum
print("the sum of the numbers in the list is:", sum)
