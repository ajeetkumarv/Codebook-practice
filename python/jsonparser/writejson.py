import json

json_data = [
	{"name":"Ajeet","age":29},
	{"name":"babu","age":0.8}
]

str_json = json.dumps(json_data,sort_keys=True,
		indent=4,separators=(',',':'))

print(str_json)
print(type(str_json))

print("second data structure")

json_data = [
	[1,2],
	{"name":"Ajeet","age":29},
	{"name":"babu","age":0.8}
]

str_json = json.dumps(json_data)

print(str_json)
print(type(str_json))