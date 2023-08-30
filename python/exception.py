try:
	num = int(input("Enter a number:"))
	print("You entered: ",num)
except:
	print("Enter a numeric without decimal")
else:
	print("No errors were found")
finally:
	print("Session completes")

print("Program ends")