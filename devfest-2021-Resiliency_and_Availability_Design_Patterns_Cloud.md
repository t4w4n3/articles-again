# Resiliency and Availability Design Patterns for the Cloud

### **Type** : *Backend - Cloud*

### **Speaker** : *Sébastien Stormacq*

### **Résumé** :

Les systèmes distribués sont difficiles.

De là, admettons un fait : ça va tomber en panne.

Anticipons donc la "failure" dans le dev de nos applis.

On appelle cela la résilience.

Elle est atteinte par l'association de plusieurs techniques : 

## La disponibilité géographique

Cela consiste à répartir les nœuds d'un cluster sur plusieurs datacenters espacés géographiquement, et qui sont chacun sensibles à des types de pannes différentes.

Une gestion d'état de ces datacenter permet de switcher automatiquement sur ceux en bonne santé.

## L'auto-scaling

C'est le fait de démarrer automatiquement de nouveaux noeuds lorsque la charge augmente.

C’est un scaling horizontal.

## wip
