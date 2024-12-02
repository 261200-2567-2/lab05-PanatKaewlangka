package mygame;

import java.util.*;

public interface IAccessory {
    String getName(); //คืนค่าชื่อAccessorry
    String getEffectDescription(); //อธิบาย
    Map<String, Integer> getStatsBuff(); //ใช้ String เป็นคีย์และ Integer เป็นค่า Status ของ Acessorry

    void applyEffect(ICharacter character);
    void removeEffect(ICharacter character);
}
