# README : Interface qui permet de remplir une fiche de personnage.
TLDR : Cette application est un TP pour le cours de pour l'IUT de Vannes.

---

## Fonctionnalités principales
1. **Interface graphique**  
   Cette interface sera composée :
    • d’une barre d’outils (à gauche) contenant une grille de 4 boutons représentant chacun une action (sous forme de texte et/ou d’image) : nouveau, charger, enregistrer, enregistrer sous…) ;
    • d’une barre d’état (en bas), avec un label vide à gauche et la version de programme à droite;
    • d’un panneau d’information (au centre), avec une zone de saisie (nom), des listes déroulantes (race, classe), et des boutons radio (sexe).

2. **Réaction aux évènements**  
   On souhaite maintenant pouvoir définir des réactions aux différents évènements utilisateurs.
En reprenant les exemples vus en cours, et en veillant à bien séparer le code de présentation
des composants de celui permettant la réaction aux actions utilisateurs (c’est ici que la classe
CharacterSheetListener est à compléter), afficher l’action effectuée dans le champs
statut de la barre d’état. On ne s'intéresse ici qu'aux actions des boutons de la barre d’outils.

3. **Aller plus loin**  
   On souhaite maintenant ajouter plus d’éléments à notre fiche, notamment les caractéristiques.
   Le système de caractéristiques obéit à certaines règles :
      • Chaque caractéristique a une valeur initiale de 8 et doit être comprise entre 8 et 15.
      • Le total de points à dépenser est de 27.
Les caractéristiques à ajouter sont la Force (Str), la Constitution (Con), la Dextérité (Dex),
l’Intelligence (Int), la Sagesse (Wis) et le Charisme (Cha). Vous veillerez à respecter le
design pattern MVC en ajoutant les caractéristiques au Model. 

---

## Quelques images 

![interface](https://github.com/user-attachments/assets/0f42201a-ca17-4569-8faf-eb68c9f93024)


---
