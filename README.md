Démo JPA
=========

Démonstration de Java Persistence API (JPA) avec Hibernate. JPA est une API d'ORM (Object Relational Mapping) et permet de manipuler des entités qui sont sauvées dans une base de données relationnelle (PostgreSQL, MariaDB, ...). JPA permet une abstraction de la base de données et évite donc l'écriture de classes pour gérer les opérations CRUD (Create, Read, Update, Delete).

Hibernate est une implémentation de JPA, la plus célèbre.

Pré-requis : 
* Java8
* Une base de données relationnelle comme mariadb (fournie dans ce projet via docker)

Import du projet
---------------

Le projet est pré paramétré pour être importé sous Eclipse. 

 
Base de données (docker)
---------------

Lancer le serveur de base de données en exécutant la commande ci-dessous depuis le répetoire ```docker-mariadb``` :
```
cd docker-mariadb
docker-compose up
```

La base de données est accessible sur le port **3306** et l'interface graphique d'administration de la base de données [phpmyadmin](https://www.phpmyadmin.net/) est accesible à l'adresse [http://localhost:8001](http://localhost:8001)

- Mot de passe root : **0000**
- Base de données : **bda**


Lancement de l'application
---------------

Exécuter la classe ```Main.java``` pour lancer le programme qui enregistre quelques informations dans la base de données et exécute quelques requêtes simples.