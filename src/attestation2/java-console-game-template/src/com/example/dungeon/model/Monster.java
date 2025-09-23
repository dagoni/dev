package com.example.dungeon.model;


import java.util.List;
import java.util.ArrayList;

public class Monster extends Entity {
    private int level;
    private List<Item> loot; // Предметы, которые выпадают после смерти

    public Monster(String name, int level, int hp, List<Item> loot) {
        super(name, hp);
        this.level = level;
        this.loot = loot != null ? loot : new ArrayList<>();
    }

    public List<Item> getLoot() {
        return loot;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
