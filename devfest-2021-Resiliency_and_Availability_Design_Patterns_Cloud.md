# Resiliency and Availability Design Patterns for the Cloud

### **Type** : *Backend - Cloud*

### **Speaker** : *Sébastien Stormacq*

### **Résumé** :

Les systèmes distribués sont difficiles.

De là, admettons un fait : "ça" va tomber en panne.

Anticipons donc la "failure" dans le dev de nos applis.

On appelle cela la résilience.

Elle est atteinte par l'association de plusieurs techniques, que voici.

## I. La disponibilité géographique

Cela consiste à répartir les nœuds d'un cluster sur plusieurs datacenters espacés géographiquement, et qui sont chacun sensibles à des types de pannes différentes.

Une gestion d'état de ces datacenter permet de switcher automatiquement sur ceux en bonne santé.

## II. L'auto-scaling

C'est le fait de démarrer automatiquement de nouveaux noeuds lorsque la charge augmente.

C’est un scaling horizontal.

On le distingue du scaling vertical, où on se contente d'augmenter les performances des serveurs hôtes.

## III. Decoupling and asynchronisme

"Découpler" (instaurer un couplage faible) permet de rendre le système modulaire : on peut en remplacer/modifier un module sans devoir toucher aux autres.

C'est le S de SOLID : Single Responsability Principle.

On peut découpler 2 applications RESTFUL synchrones on les désynchronisant.

### Fonctionnement synchrone

```puml
@startuml
InvoiceApp -> PaymentApp: /search/invoice/123
activate PaymentApp
InvoiceApp <-- PaymentApp: {"id": 123, "amount": 38.98}
deactivete PaymentApp
InvoiceApp -> Invoice App: doSomeStuffWithThePayment()
@enduml
```

### Fonctionnement asynchrone

```puml
@startuml
InvoiceApp --> PaymentQueue: need payment 123
PaymentQueue --> PaymentApp: invoiceApp need payment 123
PaymentApp --> PaymentQueue: {"id": 123, "amount": 38.98}
PaymentQueue --> InvoiceApp: {"id": 123, "amount": 38.98}
InvoiceApp -> Invoice App: doSomeStuffWithThePayment()
@enduml
```

Ainsi, les 2 applications sont découplées, elles fonctionnent indépendament à l'aide de queues et d'interfaces json (openApi et/ou asyncApi).

Si l'une d'elle à une défaillance, la queue se remplira toujours, et sera consommée lors du retour à la normale.

On affectera alors des priorités aux queues afin de choisir précisément quels services on souhaite dégrader en cas de défaillance.

## Databases

Et si on séparait les responsabilité read/write ?

```puml
@startuml
database master \n read/write
database replicat 1 read-only
database replicat 2 read-only
@enduml
```

On peut à présent :
* dégrader les services en read-only (plutôt que de fermer totalement)
* Scaler horizontalement les bases

### Database sharding

Une autre option de résilience et de scaling de database est le sharding, qui consiste à répartir les data sur plusieurs databases. 

Par exemple :
* ids 1 à 10 -> le shard 1
* ids 11 à 20 -> le shard 2
* ...

## Timout, Backoff, Retries

La quasi totalité de nos outils ont des valeurs de timeout par défaut, parfois (souvent) élevées.

Exemple : un HTTP GET sans réponse depuis 4 secondes, et qui attendra en tout 10 secondes avant d'arrêter son attente et de remonter une exception technique.

Dans un flux métier complexe où plusieurs appels http se succèdent, la somme des timeout au bout de ce flux est conséquente.

On peut alors avoir des boards de supervision, la panne mettra (trop ?) longtemps à y apparaitre.

De plus, dans le cas d'une forte volumétrie d'appels, une application qui cesse de répondre va mettre en attente une quantité d'appels si importante que le nombre de connexion max sera atteints, et boum -> tout tombe.

On préfère là aussi une dégradation de service à un arrêt total.

La solution : abaisser fortement les temps de timeout ! Probablement < 1 seconde

Les latences réseaux inévitables vont alors faire échouer quelques requetes, qui auraient pu passer à la 1003ème ms.

On résout ce problème-ci avec des retries (ré-essaies)
