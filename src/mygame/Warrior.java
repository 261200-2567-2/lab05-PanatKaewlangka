package mygame;

import java.util.*;

public class Warrior implements ICharacter {
    private String name;
    private int level;
    private String job;
    private int health;
    private int mana;
    private Map<String, Integer> baseStats;
    private List<IAccessory> equippedAccessories;
    private int rage;

    //Status เริ่มต้นของตัวละคร
    public Warrior(String name) {
        this.name = name;
        this.level = 1;
        this.job = "Warrior";
        this.health = 150;
        this.mana = 0;
        this.baseStats = new HashMap<>();
        this.baseStats.put("Strength", 20);
        this.baseStats.put("Agility", 10);
        this.equippedAccessories = new ArrayList<>();
        this.rage = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getJob() {
        return job;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public Map<String, Integer> getBaseStats() {
        return baseStats;
    }

    @Override
    public List<IAccessory> getEquippedAccessories() {
        return equippedAccessories;
    }

    //สวมใส่อุปกรณ์ทำให้ค่าStatus ของ Strength เปลี่ยน
    @Override
    public void equipAccessory(IAccessory accessory) {
        equippedAccessories.add(accessory);
        accessory.applyEffect(this);
    }

    // ใช้ความสามารถโดยจะมีผลต่อ Strength โดยดูจากค่าRage (ความโกรธ)
    @Override
    public void useAbility(String abilityName, ICharacter target) {
        switch (abilityName) {
            case "Berserk":
                if (rage >= 10) {
                    System.out.println(name + " uses Berserk!");
                    baseStats.put("Strength", baseStats.get("Strength") + 15);
                    rage -= 10;
                } else {
                    System.out.println(name + " does not have enough rage!");
                }
                break;
            default:
                System.out.println(name + " does not have this ability!");
        }
    }
    //Level up ส่งผลให้ค่าต่างๆเพิ่มขึ้นตามด้วย
    @Override
    public void levelUp() {
        level++;
        health += 70;
        baseStats.put("Strength", baseStats.get("Strength") + 5);
        baseStats.put("Agility", baseStats.get("Agility") + 2);
        System.out.println(name + " leveled up to " + level + "!");
    }
    // กำหนดค่า Rage โดยไม่ให้เกิน100 มีผลต่อ Damage
    public void gainRage(int amount) {
        rage = Math.min(rage + amount, 100);
        System.out.println(name + " gains " + amount + " rage!");
    }
}
