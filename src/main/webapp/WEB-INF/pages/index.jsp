<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="fr">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Accueil</title>
        <!-- Tailwind CSS -->
        <script src="https://cdn.tailwindcss.com"></script>
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
                    <h2 class="text-2xl font-bold text-dark mb-4 text-center">Bienvenue sur notre plateforme</h2>
                    <p class="text-gray-600 text-center mb-8">
                        Rejoignez notre communauté pour accéder à tous nos services exclusifs.
                    </p>

                    <div class="space-y-4">
                        <a href="/login"
                            class="block w-full bg-gradient-to-r from-primary to-secondary text-white font-medium py-3 px-4 rounded-lg hover:opacity-90 transition-opacity shadow-md text-center">
                            Se connecter
                        </a>

                        <a href="/register"
                            class="block w-full bg-white text-primary border-2 border-primary font-medium py-3 px-4 rounded-lg hover:bg-gray-50 transition-colors shadow-md text-center">
                            Créer un compte
                        </a>
                    </div>

                    <div class="text-center mt-8">
                        <p class="text-sm text-gray-600">
                            Découvrez tous les avantages de notre plateforme et commencez dès aujourd'hui !
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </body>

    </html>