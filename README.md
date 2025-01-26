## Guide d'Utilisation avec Docker

### Prérequis

Assurez-vous que Docker est installé et en cours d'exécution sur votre machine.


1. **Construire l'Image Docker**

Exécutez la commande suivante dans le répertoire racine du projet (où se trouve le `Dockerfile`) pour construire l'image Docker :

docker build -t tennis-game .

2. **Exécuter le Conteneur Docker Pour exécuter l'application avec une séquence de points spécifique, utilisez la commande suivante :

docker run --rm tennis-game "ABABAA"

Remplacez "ABABAA" par la séquence de points que vous souhaitez tester.


## Description des Classes

- **TennisGame** : La classe principale qui gère la logique du jeu. Elle prend les entrées des joueurs et met à jour les scores en conséquence.

- **Player** : Représente un joueur de tennis avec des attributs pour gérer l'état du joueur, comme le score et le statut (par ex., vainqueur).

- **PlayerState** : Énumération qui définit les différents états qu'un joueur peut avoir (par exemple, `WINNER`, `DEUCE`, etc.).

- **InputValidator** : Classe utilitaire dédiée à la validation des entrées pour s'assurer qu'elles ne contiennent que des caractères valides ('A' et 'B').

