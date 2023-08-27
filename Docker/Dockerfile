FROM node:14.16.0-alpine3.13
RUN addgroup app && adduser -S -G app app
USER app
WORKDIR /app
#copying package8.json bcz if not changed npm install will be reused from cached
COPY package*.json .
RUN npm install
COPY . .
ENV API_URL=http://api.myapp.com/
EXPOSE 3000

#Shell form (runs in a seprate shell)
#CMD npm start

#Exec form
#CMD ["npm", "start"]

#Choosing CMD or ENTRYPOINT is matter of choice
ENTRYPOINT [ "npm", "start" ]