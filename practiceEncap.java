//this for practicing encapsulation
public class Lab {
}

class Rational {
    private int num;   
    private int den; 

	public Rational() {
		num = 1;
		den = 1; 
    }

    public Rational(int numerator, int denominator) {
    	if(denominator == 0) {
    		num = 1;
    		den = 1;
    	}else {
    		num = numerator /gDiv(numerator, denominator);
    		den = denominator /gDiv(numerator, denominator);
    	}
    }	
    
    public int getNum() {
		return num;
	}
    
	public void setNum(int num) {
		this.num = num;
	}
	
	public int getDen() {
		return den;
	}

	public void setDen(int den) {
		this.den = den;
	}
	
    public Rational times(Rational b) {
    	Rational rNew = new Rational();
    	rNew.setNum((this.getNum() * b.getNum()));
    	rNew.setDen(getDen() * b.getDen());
    	
    	int gDiv = gDiv(rNew.getNum(),rNew.getDen());
    	
    	rNew.setNum(rNew.getNum()/gDiv);
    	rNew.setDen(rNew.getDen()/gDiv);
    	
    	return rNew;
    }

    public Rational plus(Rational b) {
    	Rational rNew = new Rational();
    	rNew.setNum((this.getNum()*b.getDen()) + (b.getNum()*this.getDen()));
    	rNew.setDen(this.getDen() * b.getDen());
    	
    	int gDiv = gDiv(rNew.getNum(),rNew.getDen());
    	
    	rNew.setNum(rNew.getNum()/gDiv);
    	rNew.setDen(rNew.getDen()/gDiv);
    	
    	return rNew;
    }
	
    public Rational divides(Rational b) {
    	Rational rNew= new Rational();
    	rNew.setNum((this.getNum() * b.getDen()));
    	rNew.setDen(getDen() * b.getNum());
    	
    	int gDiv = gDiv(rNew.getNum(),rNew.getDen());
    
    	rNew.setNum(rNew.getNum()/gDiv);
    	rNew.setDen(rNew.getDen()/gDiv);
    	
    	return rNew;
    }

    public String toString() {
    	String s1;
    	int gDiv = gDiv(this.getNum(), this.getDen());
    	
    	s1 = "" + ((this.getNum() == 0? this.getNum() : ((this.getDen()/gDiv) != 1 ? (this.getNum()/gDiv + "/" + this.getDen()/gDiv) : this.getNum() /gDiv)));
    	
    	return s1;
    }
    
    public boolean equals(Rational b) {
    	if(this.getNum() == b.getNum() && this.getDen() == b.getDen()) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public static int gDiv(int m, int n) {
    	if(n == 0) {
    		return m;
    	}return gDiv(n, m%n);
    }
}