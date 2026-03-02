
/**
 * Règle SailPoint : Attribution automatique du CostCenter
 * 
 * Description :
 * Cette règle attribue automatiquement le centre de coûts (CostCenter)
 * en fonction du département de l'identité.
 * 
 * Cas d'usage :
 * - Déclenchée lors de l'agrégation des identités
 * - Déclenchée lors de la création/modification d'une identité
 * 
 * Auteur : [Pascal AZANDEGBE]
 * Date : [02/03/2026]
 * Version : 1.0
 * 
 * Conformité :
 * - Respect des normes de développement Revenu Québec
 * - Journalisation des actions pour audit
 * - Gestion appropriée des transactions
 */

package com.sailpoint.rules;

import com.sailpoint.object.Identity;
import com.sailpoint.api.SailPointContext;
import org.apache.log4j.Logger;

public class RuleExemple_CostCenter {

    // Logger pour la traçabilité (exigence audit)
    private static final Logger log = Logger.getLogger(RuleExemple_CostCenter.class);

    /**
     * Point d'entrée principal de la règle SailPoint
     * 
     * @param context Contexte SailPoint (gestion DB, transactions)
     * @param identityId Identifiant de l'identité à traiter
     * @return L'objet Identity mis à jour ou null en cas d'erreur
     */
    public static Object main(SailPointContext context, String identityId) {
        
        // Validation des paramètres d'entrée
        if (context == null || identityId == null) {
            log.error("Paramètres invalides : context ou identityId est null");
            return null;
        }

        Identity identity = null;

        try {
            // Chargement de l'identité depuis la base de données
            identity = context.getObjectById(Identity.class, identityId);
            
            if (identity == null) {
                log.warn("Identité non trouvée : " + identityId);
                return null;
            }

            // Récupération du département
            String department = (String) identity.getAttribute("department");
            
            // Logique métier : mapping département -> costCenter
            String costCenter = mapDepartmentToCostCenter(department);
            
            if (costCenter != null) {
                // Application de la valeur
                identity.setAttribute("costCenter", costCenter);
                
                // Persistance des changements
                context.saveObject(identity);
                
                // Journalisation pour audit (IMPORTANT pour Revenu Québec)
                log.info("CostCenter attribué : " + costCenter + 
                         " pour identité : " + identity.getName());
            }

            return identity;

        } catch (Exception e) {
            // Gestion des erreurs avec journalisation complète
            log.error("Erreur lors du traitement de l'identité : " + identityId, e);
            
            // En cas d'erreur, on retourne null pour signaler l'échec
            return null;
            
        } finally {
            // Note : Dans une Rule SailPoint standard, le contexte est géré par la plateforme
            // Mais dans un code custom standalone, il faudrait faire context.close()
        }
    }

    /**
     * Mapper les départements vers les centres de coûts
     * 
     * @param department Nom du département
     * @return Code du centre de coûts correspondant
     */
    public static String mapDepartmentToCostCenter(String department) {
        
        if (department == null) {
            return null;
        }

        // Tableau de mapping (pourrait être externalisé dans une configuration)
        switch (department.toUpperCase()) {
            case "FINANCE":
                return "CC-1001";
            case "Ressources Humaines":
            case "RH":
                return "CC-1002";
            case "INFORMATIQUE":
            case "IT":
                return "CC-1003";
            case "JURIDIQUE":
                return "CC-1004";
            case "DÉVELOPPEMENT":
                return "CC-1005";
            default:
                // Département non reconnu - ne pas bloquer le processus
                return "CC-9999"; // Code par défaut pour investigation
        }
    }

    /**
     * Méthode de test unitaire (pour démonstration)
     * Peut être utilisée avec JUnit dans un environnement de développement
     */
    public static void main(String[] args) {
        // Tests de la logique de mapping
        System.out.println("Test mapping département -> costCenter");
        System.out.println("FINANCE : " + mapDepartmentToCostCenter("FINANCE"));
        System.out.println("RH : " + mapDepartmentToCostCenter("RH"));
        System.out.println("IT : " + mapDepartmentToCostCenter("IT"));
        System.out.println("INCONNU : " + mapDepartmentToCostCenter("MARKETING"));
    }
}