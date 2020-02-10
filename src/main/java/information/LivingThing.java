package information;

/**
 * HeroとEnemyをまとめたクラス。
 *  String name; //敵の名前（Enemy,Hero）
 *  int hitPoint; //敵のHP（Enemy,Hero）
 *  int attack; //敵の攻撃力（Enemy,Hero）
 *  boolean dead; //敵の生死状態。（Enemy,Hero）true=死亡。
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public int getHitPoint(){
        return hitPoint;
    }
    public int getAttack(){
        return attack;
    }
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param hitPoint モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public LivingThing(String name, int hitPoint, int attack) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }
    /**
     * getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     * @return boolean
     */
    public boolean isDead() {
        return dead;
    }
    public  void setDead(boolean dead){
        this.dead = dead;
    }

    public String getName() {
        return name;
    }
    /**
     * 攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、opponent.wounded()によりダメージ処理を実行。
     * @param  opponent 攻撃対象
     */
    public void attack(LivingThing opponent){
        if(!dead) {


            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }
    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }

    }

}

