# Ask user to input a number
Number1 = int(input(" enter a number"))

#tell them if the number is an even or odd number.

Number2 = (Number1 % 2)
if Number2 > 0:
    print ("{} is an odd number".format(Number1))
else:    
    print ("{} is an even number".format(Number1))
