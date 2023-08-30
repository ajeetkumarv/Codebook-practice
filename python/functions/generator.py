def my_even_generator(x):
	i = 0
	while i <= x:
		yield i
		i = i + 2

print(my_even_generator(10))

for i in my_even_generator(10):
	print(i)


even_iterator = (x ** 2 for x in range(10))  # this produces an iterator of squares

print(even_iterator)

for i in even_iterator:
	print("Using list comprehension:", i)