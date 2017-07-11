# Mars Rover

D�velopper une API qui d�placer un rover � travers une grille.
D�velopper un affichage (console ou graphique) repr�sentant la grille et les �l�ments pr�sents.

### R�gles
- Vous donnerez un point de d�part initial (x,y) du rover et son orientation (N,S,E,W)
- Vous g�n�rerez une grille de LxH avec 15% d�obstacle. 
- Le rover recevra un tableau de caract�res repr�sentant les commandes � r�aliser.
- Impl�menter les commandes qui d�placent le rover en avant et en arri�re (f = forward, b = backward).
- Impl�menter les commandes qui d�placent le rover � droite et � gauche (l = left, r = right).
- Impl�menter le d�placement d�un bord � l�autre de la grille (les plan�tes sont des sph�res).
- Impl�menter la d�tection d�obstacle avant le d�placement vers une nouvelle cellule de la grille. Pour une s�quence de d�placements donn�s, le rover se d�placera vers le dernier point accessible et informera de l�obstacle.
- Impl�menter ensuite la possibilit� de donner l�ordre au rover de se rendre sur une cellule donn�e (x,y). Il devra d�terminer un chemin � travers la grille en �vitant les obstacles.

### Modelisation

#### Packages
[Packages](https://raw.githubusercontent.com/rbello/CorrectionRover/master/Package%20Structure.png)

#### Classes
[Classes](https://raw.githubusercontent.com/rbello/CorrectionRover/master/Classes.png)

#### Type hierarchy
[Type hierarchy](https://raw.githubusercontent.com/rbello/CorrectionRover/master/Type%20Hierarchy.png)

