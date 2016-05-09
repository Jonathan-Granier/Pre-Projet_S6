# Pre-Projet_S6

Ce dossier contient le code source en Java du jeu gauffre empoisonné.  
Plus d'information ici : http://inf362.forge.imag.fr/Projet/  


#Architecture

Test_Gaufre.java : main / Interface  

Terrain.java : L'etat actuel du terrain  
                -> matrice de booléens. vrai <=> on peut jouer sur la case  

Moteur.java : contient un terrain, permet de :  
- Connaitre les coups possibles  
- Jouer un coup (joueur 1 ou 2)  
- Déterminer si la partie est terminée  

IA.java : 
- Prend un moteur en argument de constructeur et une difficulté  
- A une fonction jouer_coup();  


#Organisation   

Astor/Thibault : Moteur  
Noha/Dimitri : Interface  
Jonathan/Gabriel : IA  
