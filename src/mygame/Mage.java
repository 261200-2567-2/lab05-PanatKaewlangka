package mygame;

import java.util.*;

public class Mage implements ICharacter {
    private String name;
    private int level;
    private String job;
    private int health;
    private int mana;
    private Map<String, Integer> baseStats;
    private List<IAccessory> equippedAccessories;
    private List<String> spellbook;
    //Status เริ่มต้นของตัวละคร
    public Mage(String name) {
        this.name = name;
        this.level = 1;
        this.job = "Mage";
        this.health = 100;
        this.mana = 100;
        this.baseStats = new HashMap<>();
        this.baseStats.put("Intelligence", 25);
        this.baseStats.put("Agility", 8);
        this.equippedAccessories = new ArrayList<>();
        this.spellbook = new ArrayList<>();
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
    // show อุปกรณ์ที่เราสวมใส่อยู่
    @Override
    public List<IAccessory> getEquippedAccessories() {
        return equippedAccessories;
    }
    //สวมใส่อุปกรณ์ทำให้ค่าStatus ของ Mana เปลี่ยน
    @Override
    public void equipAccessory(IAccessory accessory) {
        equippedAccessories.add(accessory);
        accessory.applyEffect(this);

        // ซิงค์ค่าที่ปรับปรุงใหม่ใน baseStats
        if (baseStats.containsKey("Mana")) {
            mana += baseStats.get("Mana");
        }
        if (baseStats.containsKey("Intelligence")) {
            System.out.println(name + "'s Intelligence is now " + baseStats.get("Intelligence"));
        }
    }


    // ใช้ความสามารถโดยจะมีผลต่อ Strength โดยดูจากค่าMana
    @Override
    public void useAbility(String abilityName, ICharacter target) {
        if (spellbook.contains(abilityName)) {
            System.out.println(name + " casts " + abilityName + " on " + target.getName() + "!");
            mana -= 20; // Example cost
        } else {
            System.out.println(name + " does not know this spell!");
        }
    }
    //เรียนคาถา โดยรับค่าเป็น String
    public void learnSpell(String spellName) {
        spellbook.add(spellName);
        System.out.println(name + " learns " + spellName + "!");
    }
    //update ค่ามานา
    public void restoreMana(int amount) {
        mana = Math.min(mana + amount, 100+(level*20));
        System.out.println(name + " restores " + amount + " mana!");
    }

    public void reduceMana(int amount) {
        mana = Math.max(0, mana - amount);
        System.out.println(name + " loses " + amount + " mana!");
    }

    //Level up ส่งผลกับStatusของตัวละคร
    @Override
    public void levelUp() {
        level++;
        health += 50;
        // เพิ่มมานาโดยสัมพันธ์กับระดับเลเวล
        mana += level * 5; // เพิ่มมานาเมื่ออัพเลเวล (เพิ่มตามเลเวล)

        // ปรับปรุงค่า Intelligence ใน baseStats
        baseStats.put("Intelligence", baseStats.get("Intelligence") + 5);

        // สะท้อนค่ามานาใหม่
        System.out.println(name + " leveled up to " + level + "!");
        System.out.println(name + "'s mana is now " + mana);
    }

}
