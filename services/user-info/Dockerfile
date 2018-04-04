FROM node:carbon
WORKDIR /usr/src/app

# install dependencies
COPY package*.json ./
RUN npm install

COPY . .
EXPOSE 8080

CMD [ "npm", "start" ]
