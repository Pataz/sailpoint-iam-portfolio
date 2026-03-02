# Devis d'Essais - Règle CostCenter

## 1. Informations Générales

| Champ | Valeur |
|-------|--------|
| **Nom du composant** | RuleExemple_CostCenter |
| **Version** | 1.0 |
| **Auteur** | [Pascal AZANDEGBE] |
| **Date** | [02/03/2026] |
| **Type de test** | Unitaires et Fonctionnels |

## 2. Objectifs des Essais

Valider que la règle attribue correctement le centre de coûts selon le département, et gère adéquatement les cas d'erreur.

## 3. Environnement de Test

| Environnement | Description |
|--------------|-------------|
| **Développement** | Poste local avec Java 8+ |
| **Intégration** | Environnement SailPoint DEV |
| **Production** | Environnement SailPoint PROD (après validation) |

## 4. Cas de Test

### 4.1 Tests Unitaires (Logique Métier)

| ID | Description | Données d'entrée | Résultat Attendu | Statut |
|----|-------------|------------------|------------------|--------|
| TU-01 | Département FINANCE | department = "FINANCE" | costCenter = "CC-1001" | ☐ |
| TU-02 | Département RH | department = "RH" | costCenter = "CC-1002" | ☐ |
| TU-03 | Département IT | department = "IT" | costCenter = "CC-1003" | ☐ |
| TU-04 | Département inconnu | department = "MARKETING" | costCenter = "CC-9999" | ☐ |
| TU-05 | Département null | department = null | costCenter = null | ☐ |

### 4.2 Tests Fonctionnels (Intégration SailPoint)

| ID | Description | Préconditions | Résultat Attendu | Statut |
|----|-------------|---------------|------------------|--------|
| TF-01 | Identité existante | Identité avec département valide | Attribut costCenter mis à jour | ☐ |
| TF-02 | Identité inexistante | identityId invalide | Retour null, log d'erreur | ☐ |
| TF-03 | Contexte null | context = null | Retour null, log d'erreur | ☐ |
| TF-04 | Persistance | Identité modifiée | Changement visible en DB | ☐ |
| TF-05 | Journalisation | Exécution de la règle | Logs présents dans catalina.out | ☐ |

## 5. Critères d'Acceptation

- [ ] Tous les tests unitaires passent (5/5)
- [ ] Tous les tests fonctionnels passent (5/5)
- [ ] Aucune erreur non gérée (exception non catchée)
- [ ] Logs appropriés générés (INFO pour succès, ERROR pour échec)
- [ ] Aucune donnée sensible dans les logs
- [ ] Code révisé par un pair (code review)

## 6. Résultats des Essais

| Date | Exécutant | Tests Passés | Tests Échoués | Commentaires |
|------|-----------|--------------|---------------|--------------|
| [Date] | [Nom] | X/10 | 0/10 | - |

## 7. Approbation

| Rôle | Nom | Signature | Date |
|------|-----|-----------|------|
| Développeur | | | |
| Analyste QA | | | |
| Responsable Technique | | | |

---
*Document conforme aux normes de documentation Revenu Québec*