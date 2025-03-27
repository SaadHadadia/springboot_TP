<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="fr">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Mon Profil</title>
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

        <body class="bg-gradient-to-br from-blue-500 to-green-400 min-h-screen">
            <!-- Fixed Header/Navigation -->
            <nav class="bg-white shadow-md fixed top-0 left-0 right-0 z-50">
                <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
                    <div class="flex justify-between items-center h-16">
                        <div class="flex items-center">
                            <h1 class="text-xl font-bold text-gray-800">Mon Profil</h1>
                        </div>
                        <div class="flex items-center space-x-4">
                            <form action="/logout" method="post" class="inline">
                                <input type="hidden" name="currentlogeduser" value="${currentlogeduser}" />
                                <button type="submit"
                                    class="inline-flex items-center px-4 py-2 border border-transparent rounded-md text-sm font-medium text-white bg-red-600 hover:bg-red-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-red-500">
                                    <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 mr-2" fill="none"
                                        viewBox="0 0 24 24" stroke="currentColor">
                                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                            d="M17 16l4-4m0 0l-4-4m4 4H7m6 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h4a3 3 0 013 3v1" />
                                    </svg>
                                    Déconnexion
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </nav>

            <!-- Main Content -->
            <main class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 pt-24 pb-8">
                <div class="bg-white rounded-lg shadow-md overflow-hidden p-6">
                    <div class="max-w-3xl mx-auto">
                        <div class="space-y-6">
                            <!-- Profile Information -->
                            <div class="bg-gray-50 p-6 rounded-lg">
                                <div class="flex justify-between items-center mb-4">
                                    <h2 class="text-xl font-semibold text-gray-900">Informations du Profil</h2>
                                    <button type="button" id="editButton"
                                        class="inline-flex items-center px-4 py-2 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-primary hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-primary">
                                        <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 mr-2" fill="none"
                                            viewBox="0 0 24 24" stroke="currentColor">
                                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                                d="M15.232 5.232l3.536 3.536m-2.036-5.036a2.5 2.5 0 113.536 3.536L6.5 21.036H3v-3.572L16.732 3.732z" />
                                        </svg>
                                        Modifier
                                    </button>
                                </div>
                                <form action="/updateprofile" method="post" id="profileForm">
                                    <input type="hidden" name="currentlogeduser" value="${currentlogeduser}" />
                                    <div class="grid grid-cols-2 gap-6">
                                        <div>
                                            <label class="text-sm font-medium text-gray-500" for="login">Login</label>
                                            <input type="text" id="login" name="login" value="${currentlogeduser}" disabled
                                                class="mt-1 block w-full rounded-md py-3 px-4 border-gray-300 shadow-sm focus:border-primary focus:ring-primary sm:text-sm bg-gray-50">
                                        </div>
                                        <div>
                                            <label class="text-sm font-medium text-gray-500" for="username">Nom
                                                d'utilisateur</label>
                                            <input type="text" id="username" name="username" value="${user.nom}"
                                                disabled
                                                class="mt-1 block w-full rounded-md py-3 px-4 border-gray-300 shadow-sm focus:border-primary focus:ring-primary sm:text-sm bg-gray-50">
                                        </div>
                                        <div>
                                            <label class="text-sm font-medium text-gray-500" for="grade">Grade</label>
                                            <input type="text" id="grade" name="grade" value="${user.grade}" disabled
                                                class="mt-1 block w-full rounded-md py-3 px-4 border-gray-300 shadow-sm focus:border-primary focus:ring-primary sm:text-sm bg-gray-50">
                                        </div>
                                        <div>
                                            <p class="text-sm font-medium text-gray-500">Statut</p>
                                            <span
                                                class="mt-5 px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800">
                                                En ligne
                                            </span>
                                        </div>
                                    </div>
                                    <div class="mt-4 flex justify-end hidden" id="saveButtons">
                                        <button type="button" id="cancelButton"
                                            class="mr-3 inline-flex items-center px-4 py-2 border border-gray-300 rounded-md shadow-sm text-sm font-medium text-gray-700 bg-white hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-primary">
                                            Annuler
                                        </button>
                                        <button type="submit"
                                            class="inline-flex items-center px-4 py-2 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-primary hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-primary">
                                            Enregistrer
                                        </button>
                                    </div>
                                </form>
                            </div>

                            <!-- Password Change Form -->
                            <div class="bg-gray-50 p-6 rounded-lg">
                                <h2 class="text-xl font-semibold text-gray-900 mb-4">Changer le mot de passe</h2>
                                <form action="/changePassword" method="post" class="space-y-6">
                                    <input type="hidden" name="currentlogeduser" value="${currentlogeduser}" />
                                    <div>
                                        <label for="currentPassword" class="block text-sm font-medium text-gray-700">
                                            Mot de passe actuel
                                        </label>
                                        <input type="password" name="currentPassword" id="currentPassword" required
                                            class="mt-1 block w-full rounded-md py-3 px-4 border-gray-300 shadow-sm focus:border-primary focus:ring-primary sm:text-sm">
                                    </div>
                                    <div>
                                        <label for="newPassword" class="block text-sm font-medium text-gray-700">
                                            Nouveau mot de passe
                                        </label>
                                        <input type="password" name="newPassword" id="newPassword" required
                                            class="mt-1 block w-full rounded-md py-3 px-4 border-gray-300 shadow-sm focus:border-primary focus:ring-primary sm:text-sm">
                                    </div>
                                    <div>
                                        <label for="confirmPassword" class="block text-sm font-medium text-gray-700">
                                            Confirmer le nouveau mot de passe
                                        </label>
                                        <input type="password" name="confirmPassword" id="confirmPassword" required
                                            class="mt-1 block w-full rounded-md py-3 px-4 border-gray-300 shadow-sm focus:border-primary focus:ring-primary sm:text-sm">
                                    </div>
                                    <div class="flex justify-end">
                                        <button type="submit"
                                            class="inline-flex items-center px-4 py-2 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-primary hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-primary">
                                            Enregistrer
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </main>

            <script>
                document.addEventListener('DOMContentLoaded', function () {
                    const editButton = document.getElementById('editButton');
                    const saveButtons = document.getElementById('saveButtons');
                    const cancelButton = document.getElementById('cancelButton');
                    const form = document.getElementById('profileForm');
                    const inputs = form.querySelectorAll('input[type="text"]');
                    const initialValues = {};

                    // Store initial values
                    inputs.forEach(input => {
                        initialValues[input.id] = input.value;
                    });

                    editButton.addEventListener('click', function () {
                        inputs.forEach(input => {
                            if (input.id !== 'login') { // Keep login field disabled
                                input.disabled = false;
                                input.classList.remove('bg-gray-50');
                            }
                        });
                        editButton.classList.add('hidden');
                        saveButtons.classList.remove('hidden');
                    });

                    cancelButton.addEventListener('click', function () {
                        inputs.forEach(input => {
                            input.disabled = true;
                            input.classList.add('bg-gray-50');
                            input.value = initialValues[input.id];
                        });
                        editButton.classList.remove('hidden');
                        saveButtons.classList.add('hidden');
                    });

                    // Enable all fields before form submission
                    form.addEventListener('submit', function () {
                        inputs.forEach(input => {
                            input.disabled = false;
                        });
                    });
                });
            </script>
        </body>

        </html>