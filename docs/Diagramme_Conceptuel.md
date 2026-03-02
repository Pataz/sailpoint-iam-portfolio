# Diagramme Conceptuel des Objets SailPoint

## Vue d'ensemble
Ce diagramme illustre la relation entre les objets principaux dans l'architecture de données de SailPoint IdentityIQ. Il est crucial pour comprendre comment les accès sont modélisés pour les développeurs Java.

## Modèle de Données (UML Simplifié)

```mermaid
classDiagram
    class Identity {
        +String firstName
        +String lastName
        +String email
        +String department
        +getAttribute(String name)
        +setAttribute(String name, Object value)
    }

    class Link {
        +String identityId
        +String applicationId
        +String accountName
        +Date lastRefresh
    }

    class Account {
        +String nativeIdentity
        +String applicationName
        +Map~String, Object~ attributes
        +Boolean disabled
    }

    class Application {
        +String name
        +String type (e.g., AD, SAP)
        +ConnectorConfig
    }

    Identity "1" --> "0..*" Link : possède
    Link "0..*" --> "1" Identity : appartient à
    Link "1" --> "1" Account : référence
    Link "1" --> "1" Application : cible
    Account "1" --> "1" Application : réside sur

    note for Identity "Entité centrale (Personne)"
    note for Link "Pont entre Identité et Compte"
    note for Account "Accès technique réel"