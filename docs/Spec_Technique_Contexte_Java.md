# Spécification Technique : Contexte Java SailPoint

## 1. Vue d'ensemble

SailPoint IdentityIQ est une application Java EE déployée généralement sur un serveur d'application (Tomcat, JBoss, WebSphere). Toutes les interactions avec la plateforme passent par l'objet `SailPointContext`.

## 2. Objet `SailPointContext`

### Rôle
Point d'entrée principal pour toutes les opérations :
- Accès à la base de données
- Gestion des transactions
- Chargement et sauvegarde des objets
- Journalisation (logging)

### Cycle de vie
┌─────────────────┐
│ Ouverture │ ← new SailPointContext() ou injection
├─────────────────┤
│ Opérations │ ← getObject, saveObject, search, etc.
├─────────────────┤
│ Commit/Close │ ← context.commit() puis context.close()
└─────────────────┘