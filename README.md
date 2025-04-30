# 🧙 Fiche Personnage - Interface graphique Java (R2.02 - Séance 2)

## 🎯 Objectif

Ce projet a pour but de concevoir une interface graphique en Java permettant de gérer une fiche personnage pour un jeu de rôle, en respectant le modèle MVC et les principes de la programmation orientée objet. Il s'inscrit dans le cadre du module R2.02 (Développement d'IHM) du BUT Informatique – Semestre 2.

---

## 🧩 Fonctionnalités

### 1. Interface Graphique (Swing)
- **Barre d’outils** à gauche avec 4 boutons : `Nouveau`, `Charger`, `Enregistrer`, `Enregistrer sous`.
- **Barre d’état** en bas avec un champ de statut (texte dynamique) à gauche et la version du programme à droite.
- **Zone centrale** : 
  - Champ de texte pour le **Nom**.
  - Menus déroulants pour **Race** et **Classe**.
  - Boutons radio pour le **Sexe**.
  - **Spinners** pour les **caractéristiques** : Force (Str), Constitution (Con), Dextérité (Dex), Intelligence (Int), Sagesse (Wis), Charisme (Cha).

### 2. Gestion des événements
- Affichage dans la barre d’état de l’action effectuée par l’utilisateur (clic sur un bouton de la barre d’outils).
- Utilisation d’un contrôleur séparé (`CharacterSheetListener`) pour la gestion des événements.

### 3. Caractéristiques et règles de validation
- Chaque caractéristique est initialisée à 8 et peut aller de 8 à 15.
- Le joueur dispose de **27 points maximum à répartir**.
- Le modèle assure la cohérence des règles via un **PropertyChangeSupport**.

---

## 🛠️ Technologies utilisées

- **Java 8+**
- **Swing** pour l'interface graphique
- **Design pattern MVC**
- **Beans / PropertyChangeListener**

---

![interface](https://github.com/user-attachments/assets/0f42201a-ca17-4569-8faf-eb68c9f93024)

---

Projet réalisé par QUINTANE Faustin
BUT Informatique – IUT de Vannes
Module R2.02 – Interface Graphique Java
Année universitaire 2024-2025
