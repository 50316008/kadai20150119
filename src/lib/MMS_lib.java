package lib;

public class MMS_lib {
	private double lamuda,mu,alpha;
	private int s,r;
	public MMS_lib(double lamuda, double mu,int s,int r) {
		this.lamuda = lamuda;
		this.mu = mu;
		this.alpha=lamuda/mu;
		this.s = s;
		this.r = r;
	}
	public double getrho(){
		double rho;
		rho=alpha/s;
		return rho;
	}
	public int getFactorial(int s){
		int f=1;
		for(int i=s;i>=0;i--){
			if(i==0){
				f*=1;
			}else{
				f*=i;
			}
		}
		return f;

	}
	public int getConbination(int s,int r){
		int c=1;
		c=getFactorial(s)/getFactorial(r)/getFactorial(s-r);		
		return c;
	}
	public double getP0(){
		double p0=0,p01=0,p02=0;
		for(int k=0;k<this.s;k++){
			p01+=Math.pow(this.alpha,k)/getFactorial(k);
		}
		p02=Math.pow(this.alpha,this.s)/getFactorial(this.s)/(1-getrho());
		p0=1/(p01+p02);
		return p0;
	}
	public double getLq(){
		double lq;
		lq=Math.pow(this.s,this.s)*Math.pow(getrho(),this.s+1)*getP0()/getFactorial(this.s)/Math.pow(1-this.getrho(),2);	
	    return lq;
	}
	public double getL(){
		double l;
		l=getLq()+alpha;
	    return l;
	}
	public double getWq(){
		double wq;
		wq=getLq()/lamuda;
		return wq;
	}
	public double getW(){
		double w;
		w=getWq()+1/mu;
		return w;
	}
}


