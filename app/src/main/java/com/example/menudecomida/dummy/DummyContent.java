package com.example.menudecomida.dummy;

import android.content.ClipData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.zip.CheckedOutputStream;


public class DummyContent {
    public static final List<Comida> ITEMS = new ArrayList<Comida>();
    public static final Map<String, Comida> ITEM_MAP = new HashMap<String, Comida>();
    private static final int COUNT = 0;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    public static void addItem(Comida item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);

    }

    public static void uppdateItems(Comida comida) {
        ITEMS.set(ITEMS.indexOf(comida), comida);
        ITEM_MAP.put(comida.getId(), comida);
    }
    public static void delateItems(Comida comida){
        ITEMS.remove(comida);
        ITEM_MAP.remove(comida);
    }

    private static Comida createDummyItem(int position) {
        return new Comida(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    public static class Comida {
        private String id;
        private String Nonbre;
        private String Prezio;


        public Comida(String id, String nonbre, String prezio) {
            this.id = id;
            Nonbre = nonbre;
            Prezio = prezio;
        }

        public Comida(String nonbre, String prezio) {
            Nonbre = nonbre;
            Prezio = prezio;
        }

        public Comida() {
        }

        public String getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Comida comida = (Comida) o;
            return Objects.equals(id, comida.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNonbre() {
            return Nonbre;
        }

        public void setNonbre(String nonbre) {
            Nonbre = nonbre;
        }

        public String getPrezio() {
            return Prezio;
        }

        public void setPrezio(String prezio) {
            Prezio = prezio;
        }

        @Override
        public String toString() {
            return Nonbre;
        }
    }
}