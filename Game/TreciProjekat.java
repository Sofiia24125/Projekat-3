package TreciProjekat;


public class GameObject {
    private int x;
    private int y;
    private int width;
    private int height;
	public GameObject(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
    
	 public boolean intersects(GameObject other) {
	        return this.x < other.x + other.width &&
	               this.x + this.width > other.x &&
	               this.y < other.y + other.height &&
	               this.y + this.height > other.y;
	    }

	    @Override
	    public String toString() {
	        return "GameObject @ (" + x + "," + y + ") " + width + "x" + height;
	    }
	    
	}



public class Player extends GameObject {
    private String name;
    private int health;
	public Player(int x, int y, int width, int height, String name, int health) {
		super(x, y, width, height);
		this.name = name;
		this.health = health;
	}
	 public Player() {
	        this("Unknown", 0, 0);
	    }

	    
	    public Player(String name, int x, int y) {
	        this(name, x, y, 50, 50, 100);
	    }

	  
	    private String formatName(String name) {
	        if (name == null || name.trim().isEmpty()) {
	            return "Unknown";
	        }
	        name = name.trim();
	        return name.substring(0, 1).toUpperCase() + name.substring(1);
	    }

	    
	    private int fixHealth(int health) {
	        if (health < 0) return 0;
	        if (health > 100) return 100;
	        return health;
	    }


	    public String getName() {
	        return name;
	    }

	    @Override
	    public String toString() {
	        return "Player{name='" + name + "', x=" + x + ", y=" + y +
	               ", width=" + width + ", height=" + height + ", health=" + health + "}";
	    }
	}

public class Enemy extends GameObject {
    private String type;
    private int damage;
    private int health;

    public Enemy(String type, int x, int y, int width, int height, int damage, int health) {
        super(x, y, width, height);
        setType(type);
        setDamage(damage);
        setHealth(health);
        this.type = type.trim();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.damage = Math.max(0, damage);
				
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String tip) {
	     if (tip.isEmpty())
	     {
	    	 throw new IllegalArgumentException("Tip neprijatelja ne smije biti prazan!");
	     }
	     this.type = tip.trim();
	}
	
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
	     this.x = x;
	}
	
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
	     this.y = y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
	     this.width = width;
	}
	
	
	public int getHealth() {
		return heigth;
	}
	
	public void setHeigth(int heigth) {
	     this.heigth = heigth;
	}

				
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int Damage) {
	     this.damage = Math.max(0, damage);
	}
	
	
	public String toString() {
		return String.format("Enemy(%s) @ (%d %d) %dx%d DMG=%d",
				type, x, y, width, heigth, damage);
	}
	
	
}
class MeleeEnemy extends Enemy {
    public MeleeEnemy(String type, int x, int y, int width, int height, int damage, int health) {
        super(type, x, y, width, height, damage, health);
    }
}

