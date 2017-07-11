# Mars Rover

Développer une API qui déplacer un rover à travers une grille.
Développer un affichage (console ou graphique) représentant la grille et les éléments présents.

### Règles
- Vous donnerez un point de départ initial (x,y) du rover et son orientation (N,S,E,W)
- Vous générerez une grille de LxH avec 15% d’obstacle. 
- Le rover recevra un tableau de caractères représentant les commandes à réaliser.
- Implémenter les commandes qui déplacent le rover en avant et en arrière (f = forward, b = backward).
- Implémenter les commandes qui déplacent le rover à droite et à gauche (l = left, r = right).
- Implémenter le déplacement d’un bord à l’autre de la grille (les planètes sont des sphères).
- Implémenter la détection d’obstacle avant le déplacement vers une nouvelle cellule de la grille. Pour une séquence de déplacements donnés, le rover se déplacera vers le dernier point accessible et informera de l’obstacle.
- Implémenter ensuite la possibilité de donner l’ordre au rover de se rendre sur une cellule donnée (x,y). Il devra déterminer un chemin à travers la grille en évitant les obstacles.

### Modelisation

#### Packages
[Packages](https://raw.githubusercontent.com/rbello/CorrectionRover/master/Package%20Structure.png)

#### Classes
[Classes](https://raw.githubusercontent.com/rbello/CorrectionRover/master/Classes.png)

#### Type hierarchy
[Type hierarchy](https://raw.githubusercontent.com/rbello/CorrectionRover/master/Type%20Hierarchy.png)

