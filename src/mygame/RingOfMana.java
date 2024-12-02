package mygame;

import java.util.*;

public class RingOfMana implements IAccessory {
    private String name = "Ring of Mana";
    private String effectDescription = "Increases Mana and Intelligence.";
    private Map<String, Integer> statsBuff;
    // เมื่อ apply ส่งผลกับค่าStatus
    public RingOfMana() {
        statsBuff = new HashMap<>();
        statsBuff.put("Mana", 50);
        statsBuff.put("Intelligence", 10);
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
    // เมื่อ apply ส่งผลกับค่าStatus โดยจะเพิ่มค่าMana และ Int มีผลกับ Mage
    @Override
    public void applyEffect(ICharacter character) {
        Map<String, Integer> baseStats = character.getBaseStats();
        baseStats.put("Mana", baseStats.getOrDefault("Mana", 0) + statsBuff.get("Mana"));
        baseStats.put("Intelligence", baseStats.getOrDefault("Intelligence", 0) + statsBuff.get("Intelligence"));
        System.out.println(character.getName() + " equips " + name + ".");
    }
    // เมื่อ remove ส่งผลกับค่าStatus โดยจะทำให้Mana และ Int กลับไปเป็นแบบเดิมตอนก่อนใส่ มีผลกับ Mage
    @Override
    public void removeEffect(ICharacter character) {
        Map<String, Integer> baseStats = character.getBaseStats();

        // ลดค่าใน baseStats
        baseStats.put("Mana", baseStats.get("Mana") - statsBuff.get("Mana"));
        baseStats.put("Intelligence", baseStats.get("Intelligence") - statsBuff.get("Intelligence"));

        // ถ้า character เป็น Mage ให้ปรับค่าฟิลด์ mana
        if (character instanceof Mage) {
            Mage mage = (Mage) character;
            mage.reduceMana(statsBuff.get("Mana")); // ลดค่า mana
        }

        System.out.println(character.getName() + " unequips " + name + ".");
    }
}