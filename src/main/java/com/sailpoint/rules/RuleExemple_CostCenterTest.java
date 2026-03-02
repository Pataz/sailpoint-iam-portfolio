package com.sailpoint.rules;

import org.junit.Test;
import org.junit.Assert;
import com.sailpoint.api.SailPointContext;
import com.sailpoint.object.Identity;

/**
 * Classe de test unitaire pour la règle CostCenter.
 * Démontre la maîtrise des tests automatisés (Exigence Revenu Québec).
 */
public class RuleExemple_CostCenterTest {

    @Test
    public void testDepartementFinance() {
        SailPointContext context = new SailPointContext();
        Identity identity = context.getObjectById(Identity.class, "1");
        identity.setAttribute("department", "FINANCE");

        // On appelle la logique métier (méthode privée rendue accessible ou test via main)
        String result = RuleExemple_CostCenter.mapDepartmentToCostCenter("FINANCE");

        Assert.assertEquals("CC-1001", result);
    }

    @Test
    public void testDepartementRH() {
        String result = RuleExemple_CostCenter.mapDepartmentToCostCenter("RH");
        Assert.assertEquals("CC-1002", result);
    }

    @Test
    public void testDepartementInconnu() {
        String result = RuleExemple_CostCenter.mapDepartmentToCostCenter("MARKETING");
        Assert.assertEquals("CC-9999", result);
    }

    @Test
    public void testDepartementNull() {
        String result = RuleExemple_CostCenter.mapDepartmentToCostCenter(null);
        Assert.assertNull(result);
    }
}