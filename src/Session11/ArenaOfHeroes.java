package Session11;

import java.util.ArrayList;
import java.util.List;

/* ===================== INTERFACE ===================== */
interface ISkill {
    void useUltimate(GameCharacter target);
}

/* ===================== ABSTRACT CLASS ===================== */
abstract class GameCharacter {
    protected String name;
    protected int hp;
    protected int attackPower;
    protected static int count = 0;

    public GameCharacter(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        count++;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public abstract void attack(GameCharacter target);

    public void takeDamage(int amount) {
        hp -= amount;
        if (hp <= 0) {
            hp = 0;
            System.out.println("   -> " + name + " đã bị hạ gục!");
        } else {
            System.out.println("   -> " + name + " mất " + amount + " máu. HP còn: " + hp + ".");
        }
    }

    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp);
    }

    public static int getCount() {
        return count;
    }
}

/* ===================== WARRIOR ===================== */
class Warrior extends GameCharacter implements ISkill {
    private int armor;

    public Warrior(String name, int hp, int attackPower, int armor) {
        super(name, hp, attackPower);
        this.armor = armor;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println("1. [Chiến binh] " + name + " tấn công " + target.getName() + "!");
        target.takeDamage(attackPower);
    }

    @Override
    public void useUltimate(GameCharacter target) {
        System.out.println("[Chiến binh] " + name + " dùng chiêu cuối ĐẤM NGÀN CÂN!");
        int damage = attackPower * 2;
        target.takeDamage(damage);

        int selfDamage = (int) (hp * 0.1);
        hp -= selfDamage;
        System.out.println("   -> " + name + " tự mất " + selfDamage + " HP do gắng sức.");
    }

    @Override
    public void takeDamage(int amount) {
        int realDamage = amount - armor;
        if (realDamage < 0) realDamage = 0;
        super.takeDamage(realDamage);
    }

    @Override
    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp + " | Giáp: " + armor);
    }
}

/* ===================== MAGE ===================== */
class Mage extends GameCharacter implements ISkill {
    private int mana;

    public Mage(String name, int hp, int attackPower, int mana) {
        super(name, hp, attackPower);
        this.mana = mana;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println("[Pháp sư] " + name + " tấn công " + target.getName() + "!");
        if (mana >= 5) {
            mana -= 5;
            target.takeDamage(attackPower);
        } else {
            System.out.println("   -> Hết mana! Đánh thường (giảm sát thương)");
            target.takeDamage(attackPower / 2);
        }
    }

    @Override
    public void useUltimate(GameCharacter target) {
        System.out.println("2. [Pháp sư] " + name + " dùng chiêu cuối lên " + target.getName() + "!");
        if (mana >= 50) {
            mana -= 50;
            int damage = attackPower * 3;
            System.out.println("   -> " + name + " tốn 50 mana.");
            target.takeDamage(damage);
        } else {
            System.out.println("   -> Không đủ mana để dùng chiêu cuối!");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp + " | Mana: " + mana);
    }
}

/* ===================== MAIN ===================== */
public class ArenaOfHeroes {
    public static void main(String[] args) {

        System.out.println("=== ARENA OF HEROES ===");

        List<GameCharacter> characters = new ArrayList<>();

        Warrior warrior = new Warrior("Yasuo", 500, 50, 20);
        Mage mage = new Mage("Veigar", 300, 40, 200);

        characters.add(warrior);
        characters.add(mage);

        /* ===== ANONYMOUS CLASS ===== */
        GameCharacter goblin = new GameCharacter("Goblin", 100, 10) {
            @Override
            public void attack(GameCharacter target) {
                System.out.println("3. [Quái vật] Goblin (Anonymous Class) tấn công!");
                System.out.println("   -> Goblin cắn trộm " + target.getName() + "... Gây 10 sát thương.");
                target.takeDamage(10);
            }

            @Override
            public void displayInfo() {
                System.out.println("Tên: Goblin | HP: " + hp);
            }
        };

        characters.add(goblin);

        System.out.println("Đã khởi tạo " + GameCharacter.getCount() + " nhân vật tham gia đấu trường.\n");

        /* ===== GIẢ LẬP TRẬN ĐẤU ===== */
        warrior.attack(goblin);
        mage.useUltimate(warrior);
        goblin.attack(mage);

        System.out.println("\n=== THÔNG SỐ SAU LƯỢT ĐẤU ===");
        for (GameCharacter c : characters) {
            c.displayInfo();
        }
    }
}

