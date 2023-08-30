 
squared = [n **2 for n in range(10)]
print(squared)
print()

squared = [n **2 for n in range(10) if n%2 == 0]
print(squared)
print()

squared = [n **2 if n%2 == 0 else n + 0.1 for n in range(10) ]
print(squared)
