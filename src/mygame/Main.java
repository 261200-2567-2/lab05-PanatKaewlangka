package mygame;

public class Main {
    public static void main(String[] args) {
        // สร้างตัวละคร Warrior และ Mage
        Warrior warrior = new Warrior("Abigail");
        Warrior warrior2 = new Warrior("Nagi");
        Warrior warrior3 = new Warrior("Jazzper");
        Mage mage = new Mage("Eriulf");
        Mage mage2 = new Mage("Chordian");
        Mage mage3 = new Mage("Anatomi");
        Mage mage4 = new Mage("Genbu");

        // แสดงข้อมูลตัวละคร
        System.out.println("\n== Character Stats ==");
        System.out.println("Warrior: " + warrior.getName() + ", Level: " + warrior.getLevel() + ", Health: " + warrior.getHealth() + ", Agility: " + warrior.getBaseStats().get("Agility"));
        System.out.println("Mage: " + mage.getName() + ", Level: " + mage.getLevel() + ", Mana: " + mage.getMana() + ", Intelligence: " + mage.getBaseStats().get("Intelligence"));

        // สร้างอุปกรณ์เสริม
        RingOfMana ringOfMana = new RingOfMana();
        BootsOfSwiftness bootsOfSwiftness = new BootsOfSwiftness();

        // ทดลองสวมใส่อุปกรณ์
        System.out.println("\n== Equip Accessories ==");
        mage.equipAccessory(ringOfMana);
        warrior.equipAccessory(bootsOfSwiftness);

        // แสดงข้อมูลตัวละครหลังสวมใส่อุปกรณ์
        System.out.println("\n== Character Stats After Equipping Accessories ==");
        System.out.println("Warrior: " + warrior.getName() + ", Level: " + warrior.getLevel() + ", Health: " + warrior.getHealth() + ", Agility: " + warrior.getBaseStats().get("Agility"));
        System.out.println("Mage: " + mage.getName() + ", Level: " + mage.getLevel() + ", Mana: " + mage.getMana() + ", Intelligence: " + mage.getBaseStats().get("Intelligence"));

        // ทดสอบความสามารถ
        System.out.println("\n== Abilities ==");
        warrior.gainRage(15);
        warrior.useAbility("Berserk", mage);

        mage.learnSpell("Fireball");
        mage.useAbility("Fireball", warrior);

        // อัพเลเวลตัวละคร
        System.out.println("\n== Level Up ==");
        warrior.levelUp();
        mage.levelUp();

        // แสดงข้อมูลหลังอัพเลเวล
        System.out.println("\n== Updated Character Stats ==");
        System.out.println("Warrior: " + warrior.getName() + ", Level: " + warrior.getLevel() + ", Health: " + warrior.getHealth() + ", Agility: " + warrior.getBaseStats().get("Agility"));
        System.out.println("Mage: " + mage.getName() + ", Level: " + mage.getLevel() + ", Mana: " + mage.getMana() + ", Intelligence: " + mage.getBaseStats().get("Intelligence"));

        // ถอดอุปกรณ์
        System.out.println("\n== Unequip Accessories ==");
        ringOfMana.removeEffect(mage);
        bootsOfSwiftness.removeEffect(warrior);

        // แสดงข้อมูลตัวละครหลังถอดอุปกรณ์
        System.out.println("\n== Character Stats After Unequipping Accessories ==");
        System.out.println("Warrior: " + warrior.getName() + ", Level: " + warrior.getLevel() + ", Health: " + warrior.getHealth() + ", Agility: " + warrior.getBaseStats().get("Agility"));
        System.out.println("Mage: " + mage.getName() + ", Level: " + mage.getLevel() + ", Mana: " + mage.getMana() + ", Intelligence: " + mage.getBaseStats().get("Intelligence"));
    }
}