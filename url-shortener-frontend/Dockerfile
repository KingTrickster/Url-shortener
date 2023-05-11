FROM node:18.12.1-alpine3.17 AS build
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod
EXPOSE 4200
# Stage 2
FROM nginx:alpine
COPY --from=build /app/dist/url-shortener-frontend /usr/share/nginx/html
EXPOSE 80
