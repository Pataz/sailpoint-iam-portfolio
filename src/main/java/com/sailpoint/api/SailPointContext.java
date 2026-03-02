package com.sailpoint.api;

import com.sailpoint.object.Identity;
import java.util.HashMap;
import java.util.Map;

public class SailPointContext {
    // Simulation d'une base de données en mémoire
    private Map<String, Identity> database = new HashMap<>();

    public SailPointContext() {
        // Données de test pré-chargées
        Identity test = new Identity();
        test.setId("1");
        test.setName("test.user");
        test.setAttribute("department", "FINANCE");
        database.put("1", test);
    }

    public Identity getObjectById(Class<Identity> clazz, String id) {
        return database.get(id);
    }

    public void saveObject(Identity identity) {
        database.put(identity.getId(), identity);
        System.out.println("[INFO] Objet sauvegardé : " + identity.getName());
    }

    public void commit() {
        System.out.println("[INFO] Transaction commitée");
    }

    public void close() {
        System.out.println("[INFO] Contexte fermé");
    }
}