import java.util.ArrayList;

public class Robot {
	int x;
	int y;
	String derection;
	ArrayList<Runnable> commands = new ArrayList<Runnable>();
	
	public Robot(int x, int y,String derection) {
		this.x = x; 
		this.y = y;
		this.derection = derection;
	}
	
	public Robot() {
		this.x = 0; 
		this.y = 0;
		this.derection = "East";
	}
	
	
	public void turnRight() {
		if (this.derection == "East") {
			this.commands.add(() -> this.derection = "South");
		}
		else if (this.derection == "South") {
			this.commands.add(() -> this.derection = "west");
		}
		else if (this.derection == "West") {
			this.commands.add(() -> this.derection = "North");
		}
		else if (this.derection == "North") {
			this.commands.add(() -> this.derection = "East");
			
		}
	}
	
	public void turnLeft() {
		if (this.derection == "East") {
			this.commands.add(() -> this.derection = "North");
		}
		else if (this.derection == "North") {
			this.commands.add(() -> this.derection = "west");
		}
		else if (this.derection == "West") {
			this.commands.add(() -> this.derection = "South");
		}
		else if (this.derection == "South") {
			this.commands.add(() -> this.derection = "East");
		}
	}
	
	public void printState() {
		this.commands.add(() -> {
				System.out.println(this.derection);
				System.out.println(this.x);
				System.out.println(this.y);
		});
	
	}
	
	public void forward() {
		if (this.derection == "East") {
			this.commands.add(() -> this.x ++);
		}
		else if (this.derection == "North") {
			this.commands.add(() -> this.y ++);
		}
		else if (this.derection == "West") {
			this.commands.add(() -> this.x --);
		}
		else if (this.derection == "South") {
			this.commands.add(() -> this.y --);
		}
	}
	
	public void forward(int num) {
		
		if (this.derection == "East") {
			this.commands.add(() -> {if (num > 3) {
				this.x = this.x + 3;
			}
			else if (num < 0) {
				// do nothing
			}
			else {
				this.x = this.x + num;
			}
			});
		}
		else if (this.derection == "North") {
			this.commands.add(() -> {if (num > 3) {
				this.y = this.y + 3;
			}
			else if (num < 0) {
				// do nothing
			}
			else {
				this.y = this.y + num;
			}
			});
		}
		else if (this.derection == "West") {
			this.commands.add(() -> {if (num > 3) {
				this.x = this.x - 3;
			}
			else if (num < 0) {
				// do nothing
			}
			else {
				this.x = this.x - num;
			}
			});
		}
		else if (this.derection == "South") {
			this.commands.add(() -> {if (num > 3) {
				this.y = this.y - 3;
			}
			else if (num < 0) {
				// do nothing
			}
			else {
				this.y = this.y - num;
			}
			});
		}
	}
	
	public void backward() {
		if (this.derection == "East") {
			this.commands.add(() -> this.x --);
		}
		else if (this.derection == "North") {
			this.commands.add(() -> this.y --);
		}
		else if (this.derection == "West") {
			this.commands.add(() -> this.x ++);
		}
		else if (this.derection == "South") {
			this.commands.add(() -> this.y ++);
		}
	}
	
	   public void execute(){
	        for (Runnable m: commands) {
	            m.run();
	        }
	        this.commands.clear();
	    }
	
	public static void main(String[] args) {
		Robot my_first_robot = new Robot(0,1,"North");

		my_first_robot.printState();
		my_first_robot.forward();
		my_first_robot.turnRight();
		my_first_robot.backward();
		my_first_robot.forward(3);
		my_first_robot.forward(6);
		my_first_robot.printState();
		my_first_robot.turnLeft();
		my_first_robot.forward(2);
		my_first_robot.printState();
		my_first_robot.execute();
		
		
	}
}

