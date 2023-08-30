import xml.etree.ElementTree as ET

input = '''
	<stuff>
		<users>
			<user x="2">
				<id>001</id>
				<name>Chuck</name>
			</user>
			<user x="7">
				<id>002</id>
				<name>Brent</name>
			</user>
		</users>
	</stuff>
'''

stuff = ET.fromstring(input)
user_list = stuff.findall("users/user")
print("User count: ",len(user_list))

for user in user_list:
	print('Name: ', user.find('name').text)
	print('Id: ',user.find('id').text)
	print('Attribute:', user.get("x"))