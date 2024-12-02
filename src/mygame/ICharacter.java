package mygame;

import java.util.*;

public interface ICharacter {
    String getName();
    int getLevel();
    String getJob();
    int getHealth();
    int getMana();
    Map<String, Integer> getBaseStats();
    List<IAccessory> getEquippedAccessories();

    void equipAccessory(IAccessory accessory); //รายการอุปกรณ์เสริมที่ตัวละครสวมใส่ถูกอัปเดต
    void useAbility(String abilityName, ICharacter target); //ใช้ความสามรถ
    void levelUp();//มีผลกับ status ต่างๆ
}
