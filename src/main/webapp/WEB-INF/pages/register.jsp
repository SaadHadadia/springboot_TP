<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Connexion</title>
  <!-- Tailwind CSS -->
  <script src="https://cdn.tailwindcss.com"></script>
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
  <script>
    tailwind.config = {
      theme: {
        extend: {
          colors: {
            primary: '#3B82F6',
            secondary: '#10B981',
            dark: '#1E293B',
            light: '#F8FAFC'
          }
        }
      }
    }
  </script>
</head>
<body class="bg-gradient-to-br from-blue-500 to-green-400 min-h-screen flex items-center justify-center p-4">
  <div class="w-full max-w-md">
    
    <!-- Card -->
    <div class="bg-white backdrop-blur-lg bg-opacity-95 rounded-2xl shadow-2xl overflow-hidden">      
      <div class="p-8">
        <h2 class="text-2xl font-bold text-dark mb-6 text-center">Bienvenue</h2>

        <!-- Add error message display -->
        <% if (request.getAttribute("Error") !=null) { %>
          <div class="mb-4 p-2 rounded-lg bg-red-100 border border-red-400 text-red-700">
            <p class="text-center">
              <%= request.getAttribute("Error") %>
            </p>
          </div>
          <% } %>
        
        <form method="post" action="register" class="space-y-6">
          <div>
            <div class="relative">
              <input 
                type="text" 
                id="login" 
                name="login" 
                required 
                class="peer w-full px-4 py-3 rounded-lg border-2 border-gray-200 outline-none focus:border-primary transition-colors placeholder-transparent"
                placeholder="Identifiant"
              />
              <label 
                for="login" 
                class="absolute left-4 -top-3 text-sm text-gray-500 bg-white px-1 transition-all
                peer-placeholder-shown:text-base peer-placeholder-shown:top-3 
                peer-focus:-top-3 peer-focus:text-sm peer-focus:text-primary"
              >
                Identifiant
              </label>
            </div>
          </div>
          
          <div>
            <div class="relative">
              <input 
                type="password" 
                id="password" 
                name="mdp" 
                required 
                class="peer w-full px-4 py-3 rounded-lg border-2 border-gray-200 outline-none focus:border-primary transition-colors placeholder-transparent"
                placeholder="Mot de passe"
              />
              <label 
                for="password" 
                class="absolute left-4 -top-3 text-sm text-gray-500 bg-white px-1 transition-all
                peer-placeholder-shown:text-base peer-placeholder-shown:top-3 
                peer-focus:-top-3 peer-focus:text-sm peer-focus:text-primary"
              >
                Mot de passe
              </label>
            </div>
          </div>
          
          <div>
            <button 
              type="submit" 
              class="w-full bg-gradient-to-r from-primary to-secondary text-white font-medium py-3 px-4 rounded-lg hover:opacity-90 transition-opacity shadow-md"
            >
              Créer un compte
            </button>
          </div>
        </form>
        
        <div class="text-center mt-8">
          <p class="text-sm text-gray-600">Vous n'avez pas de compte ?</p>
          <a href="/" class="text-primary hover:text-secondary font-medium">
            Se connecter
          </a>
        </div>
      </div>
    </div>
  </div>
</body>
</html>