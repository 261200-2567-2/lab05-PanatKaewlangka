package mygame;

import java.util.*;

public class BootsOfSwiftness implements IAccessory {
    private String name = "Boots of Swiftness";
    private String effectDescription = "Increases agility.";
    private Map<String, Integer> statsBuff;

    //เพิ่มค่า Status Agility แทน MovementSpeed
    public BootsOfSwiftness() {
        statsBuff = new HashMap<>();
        statsBuff.put("Agility", 10);  // เปลี่ยน Agility
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEffectDescription() {
        return effectDescription;
    }

    @Override
    public Map<String, Integer> getStatsBuff() {
        return statsBuff;
    }

    // เมื่อ apply ส่งผลกับค่า Status โดยจะเพิ่มค่า Agility มีผลกับ Warrior
    @Override
    public void applyEffect(ICharacter character) {
        Map<String, Integer> baseStats = character.getBaseStats();
        baseStats.put("Agility", baseStats.getOrDefault("Agility", 0) + statsBuff.get("Agility"));
        System.out.println(character.getName() + " equips " + name + ".");
    }

    // เมื่อ remove ส่งผลกับค่า Status โดยจะทำให้ Agility กลับไปเป็นแบบเดิมตอนก่อนใส่
    @Override
    public void removeEffect(ICharacter character) {
        Map<String, Integer> baseStats = character.getBaseStats();
        baseStats.put("Agility", baseStats.get("Agility") - statsBuff.get("Agility"));
        System.out.println(character.getName() + " unequips " + name + ".");
    }
}