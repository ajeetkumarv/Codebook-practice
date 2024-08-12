num = 1

while num < 11
	puts num
	num += 1
end

class Car
	attr_accessor :color, :make, :model

	def initialize (color, make, model)
		@color = color
		@make = make
		@model = model
	end
end

class ElectricCar < Car
end

my_car = ElectricCar.new("red", "Toyota", "Corolla")

puts my_car.color
print my_car.make

