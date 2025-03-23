<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="fr">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Liste des Utilisateurs</title>
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
            <div class="bg-white backdrop-blur-lg bg-opacity-95 rounded-2xl shadow-2xl overflow-hidden">
                <div class="p-8">
                    <h2 class="text-2xl font-bold text-dark mb-6 text-center">Liste des Utilisateurs</h2>

                    <div class="space-y-4">
                        ${logins}
                    </div>
                </div>
            </div>
        </div>
    </body>

    </html>