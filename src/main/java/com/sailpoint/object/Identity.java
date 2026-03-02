package com.sailpoint.object;

import java.util.HashMap;
import java.util.Map;

public class Identity {
    private String id;
    private String name;
    private Map<String, Object> attributes = new HashMap<>();

    public Identity() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }
}