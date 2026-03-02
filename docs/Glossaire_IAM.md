# Glossaire des Termes IAM (Identity & Access Management)

## Contexte
Ce document définit les termes techniques utilisés dans le cadre de la solution de gestion des identités SailPoint IdentityIQ. Il sert de référence pour les équipes de développement, d'analyse et d'exploitation afin d'assurer un langage commun et une compréhension précise des enjeux de sécurité.

## Définitions

| Terme (Français) | Terme (Anglais - SailPoint) | Définition | Enjeu de Sécurité |
| :--- | :--- | :--- | :--- |
| **Identité** | `Identity` | Représentation numérique d'une personne physique (ex: employé, contractuel) au sein du système IAM. C'est l'entité centrale. | Permet de centraliser la vue des accès d'un individu, peu importe le nombre de systèmes. |
| **Compte** | `Account` | Identifiant technique spécifique à une application cible (ex: compte AD, compte SAP). Une identité peut posséder plusieurs comptes. | Réduit le risque de comptes orphelins ou non révoqués lors d'un départ. |
| **Lien** | `Link` | Objet technique associant une **Identité** à un **Compte** sur une **Application** donnée. | Permet de tracer quel compte appartient à quelle identité réelle. |
| **Application** | `Application` | Système cible géré par l'IAM (ex: Active Directory, Oracle RH, Salesforce). | Définit le périmètre de gouvernance. |
| **Droit / Privilège** | `Entitlement` | Permission spécifique accordée dans une application (ex: accès au dossier X, rôle administrateur). | Granularité fine pour appliquer le principe du moindre privilège. |
| **Rôle** | `Role` | Regroupement logique de droits correspondant à une fonction métier (ex: "Comptable", "Gestionnaire RH"). | Simplifie l'attribution des accès et la conformité (RBAC). |
| **Approvisionnement** | `Provisioning` | Processus automatique de création, modification ou suppression de comptes sur les applications cibles. | Réduit les erreurs humaines et accélère la productivité (Joiner/Mover/Leaver). |
| **Certification** | `Certification` | Processus périodique où les gestionnaires valident les accès de leurs équipes. | Assure la conformité continue et la détection d'accès injustifiés. |
| **Politique** | `Policy` | Règle de sécurité définissant des interdits ou des obligations (ex: "Un utilisateur ne peut pas avoir les rôles Conflit A et B"). | Prévention de la fraude et respect de la séparation des tâches (SoD). |
| **Agrégation** | `Aggregation` | Processus de collecte des données depuis les applications cibles vers l'IAM. | Assure que l'IAM a une vue à jour de la réalité des accès. |

## Notes d'Usage
*   **Confidentialité :** Les données liées aux **Identités** sont considérées comme sensibles (renseignements personnels).
*   **Traçabilité :** Toute action d'**Approvisionnement** doit être journalisée (logs) à des fins d'audit.
*   **Langue :** Dans le code Java et la configuration SailPoint, les termes anglais (ex: `Identity`, `Link`) sont utilisés pour les noms de classes et d'objets.

---
*Document rédigé dans le cadre de la formation Analyste Développeur SailPoint.*