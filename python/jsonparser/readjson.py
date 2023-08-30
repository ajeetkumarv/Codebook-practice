import json

json_str_msg = '''
	[
		{
			"name" : "Ajeetkumar",
			"age" : 29
		},
		{
			"name" : "Babu",
			"age" : 0.8
		}
	]
'''

jsonpy = json.loads(json_str_msg)
print("total objects:",len(jsonpy))

for obj in jsonpy:
	print("Name: ",obj["name"])
	print("Age: ",obj["age"])