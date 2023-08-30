fruits = ['mango','banana','cherry']
weights = [20,30,10]

listTup = list(zip(fruits,weights))
setTup = set(zip(fruits,weights))

print("List Tuples:",listTup)
print("Set Tuples:",setTup)

for cargo in zip(fruits,weights):
	print("Using index:",cargo[0],cargo[1])
print()
for fruit, weight in zip(fruits,weights):
	print("Using extract:",fruit,weight)


print("Unzip below:",listTup)

items, weights = zip(*listTup)

for i in range(len(items)):
	print("Unizipped:",items[i],weights[i])

print("iterate with index and item")

for i, frt in zip(range(len(fruits)), fruits):
	print("Item with index:",i, frt)

for i, frt in enumerate(set(fruits)):
	print("enumerate with set:",i, frt)