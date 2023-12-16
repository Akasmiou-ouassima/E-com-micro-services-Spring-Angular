# Mise en oeuvre des architectures micro-services : Spring cloud Congig, Consul Discovery, Consul Config, Vault
Projet visant à développer et interconnecter les microservices en utilisant la configuration Consul, une passerelle (Gateway), Feign, la configuration Vault, la sécurité Spring, ainsi qu'une interface utilisateur Frontend réalisée avec Angular.
## Architecture Micro-services
<p align="center">
  <img src="captures/img.png" width="700">
</p>

## Consul Discovery service
Pour Exécuter Consul on utilise la commande :
<ul>
 <li>consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=192.168.1.41 </li>
</ul>

ou

<ul>
 <li>consul agent -dev</li>
</ul>

**Ouvrez un navigateur Web et accédez à l'interface Web de Consul en utilisant l'URL suivante :** http://localhost:8700.

<p align="center">
  <img src="captures/img_1.png" width="700">
</p>

## Dépendences des Micro-Services

**Config service**

<p align="center">
  <img src="captures/%23001-dependances-config-service.jpg" width="700">
</p>

**Tous les services**
<p align="center">
  <img src="captures/%23002-dependances-services.jpg" width="700">
</p>
<p align="center">
  <img src="captures/%23003-dependances-services.jpg" width="700">
</p>

**Gateway service**
<p align="center">
  <img src="captures/%23004-dependances-gateway.jpg" width="700">
</p>

**Add Dépendances dans order-service**
<p align="center">
  <img src="captures/%23005-add-dependances-in-order-service.jpg" width="700">
</p>

**Billing-service**
<p align="center">
  <img src="captures/billing.jpg" width="700">
</p>

## Test Endpoints des Micro-Services

**http://localhost:9999/customer-service/customers**

<p align="center">
  <img src="captures/img_3.png" width="700">
</p>

**http://localhost:9999/customer-service/customers?projection=fullCustomer**

<p align="center">
  <img src="captures/img_4.png" width="700">
</p>

**http://localhost:9999/inventory-service/products?projection=fullProduct**

<p align="center">
  <img src="captures/img_5.png" width="700">
</p>

**http://localhost:9999/inventory-service/products/1?projection=fullProduct**

<p align="center">
  <img src="captures/img_6.png" width="700">
</p>

**http://localhost:9999/inventory-service/products**

<p align="center">
  <img src="captures/img_7.png" width="700">
</p>

**http://localhost:9999/order-service/fullOrder/3**

<p align="center">
  <img src="captures/img_8.png" width="700">
</p>

**http://localhost:9999/order-service/orders**

<p align="center">
  <img src="captures/img_9.png" width="700">
</p>

**http://localhost:9999/order-service/orders/search/byCustomerId?customerId=1&projection=fullOrder**

<p align="center">
  <img src="captures/img_10.png" width="700">
</p>

**http://localhost:9999/order-service/orders/search/byCustomerId?projection=fullOrder&customerId=1**

<p align="center">
  <img src="captures/img_11.png" width="700">
</p>

## Vault

| pour démarrer vault : 
_vault server -dev_

<p align="center">
  <img src="captures/img_13.png" width="700">
</p>


**Connecter à vault avec le token généré**

<p align="center">
  <img src="captures/img_14.png" width="700">
</p>

<p align="center">
  <img src="captures/img_12.png" width="700">
</p>

**Créer Key/Value**

<ul>set VAULT_ADDR=http://127.0.0.1:8200 :
<li>Cette commande définit la variable d'environnement VAULT_ADDR à l'adresse du serveur Vault local, qui est http://127.0.0.1:8200. Cette adresse est utilisée pour communiquer avec le serveur Vault.</li>
</ul>

<ul>vault kv put secret/billing-service user.username=root user.password=123456 :

<li>Cette commande utilise l'outil Vault (vault) pour stocker des informations secrètes dans le chemin spécifié (secret/billing-service) sous forme de paires clé-valeur.</li>
<li>Dans cet exemple, deux paires clé-valeur sont ajoutées :</li>
<li>user.username avec la valeur root.</li>
<li>user.password avec la valeur 123456.</li>
</ul>

<p align="center">
  <img src="captures/img_15.png" width="700">
</p>

**Pour Retourner key/value**
<p align="center">
  <img src="captures/img_16.png" width="700">
</p>

**http://127.0.0.1:8200/ui/vault/secrets/secret/show/billing-service**

<p align="center">
  <img src="captures/img_17.png" width="700">
</p>

<p align="center">
  <img src="captures/img_18.png" width="700">
</p>

<p align="center">
  <img src="captures/img_23.png" width="700">
</p>

# Frontend

## Liste des clients
<p align="center">
  <img src="captures/img_19.png" width="700">
</p>

## Liste des commandes du client ID=1
<p align="center">
  <img src="captures/img_21.png" width="700">
</p>
## Les détails de la commande ID=1 du client ID=1
<p align="center">
  <img src="captures/img_22.png" width="700">
</p>

## Liste des produits
<p align="center">
  <img src="captures/img_20.png" width="700">
</p>
