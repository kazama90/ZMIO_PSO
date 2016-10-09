package us.edu.pl.pso;

public enum Funkcje {
	
	Himmelblau("f(x,y) = (x^2 + y -11)^2 + (x + y^2 - 7)^2"), 
	Matyas("f(x,y) = 0.26(x^2 + y^2) - 0.48xy"),
	Beales("f(x,y) = (1.5 -x + xy)^2 + (2.25 - x + xy^2)^2 + (2.625 - x + xy^3)^2"), 
	Booths("f(x,y) = (x + 2y - 7)^2 + (2x + y -5)^2");
	
	
	private final String wzor;
	
	public String getWzor() {
		return wzor;
	}

	
	Funkcje(String wzor) {
		this.wzor = wzor;
	}
}
