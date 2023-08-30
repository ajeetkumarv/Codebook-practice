x_coord = [23, 53, 2, -12, 95, 103, 14, -5]
y_coord = [677, 233, 405, 433, 905, 376, 432, 445]
z_coord = [4, 16, -6, -42, 3, -6, 23, -1]
labels = ["F", "J", "A", "Q", "Y", "B", "W", "X"]

points = []
for point in zip(labels, x_coord, y_coord, z_coord):
    points.append("{}: {}, {}, {}".format(*point))

for point in points:
    print(point)

data = ((0, 1, 2), (3, 4, 5), (6, 7, 8), (9, 10, 11))
#zip(*data) = zip(data[0],data[1],data[2])
data_transpose = tuple(zip(*data))
print(data_transpose)