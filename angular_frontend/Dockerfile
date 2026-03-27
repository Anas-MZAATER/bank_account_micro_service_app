# Stage 1 — Build; compile l'app Angular
FROM node:20-alpine AS build
WORKDIR /app
COPY package*.json ./
RUN npm ci        # installe exactement ce qui est dans package-lock.json
COPY . .
RUN npm run build:prod

# Stage 2 — Serve; sert uniquement les fichiers compilés
FROM nginx:alpine
# Nettoyer le contenu par défaut de nginx
RUN rm -rf /usr/share/nginx/html/*
# Copier le build Angular (Angular 17 → /browser)
COPY --from=build /app/dist/bank-account-angular-front-end/browser /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
