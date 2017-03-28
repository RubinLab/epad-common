package edu.stanford.epad.common.pixelmed;

public class DSOColorHelper {
	
	/*** start of rgb to lab conversion code********************************/	
	public static double ade(double r) {
		return (r>0.04045)?(Math.pow(((r+0.055)/1.055),2.4)):(r/12.92);
	}
	public static double[] rgb2xyz(double[] rgb){
		
		double ad=ade(rgb[0]/255.0);
		double ae=ade(rgb[1]/255.0);
		double af=ade(rgb[2]/255.0);
		
		double x=ad*41.24+ae*35.76+af*18.05;
		double y=ad*21.26+ae*71.52+af*7.22;
		double z=ad*1.93+ae*11.92+af*95.05;
//		System.out.println("xyz   ["+x+" "+y+" "+z+"]");
		
		return new double[]{x,y,z};
		
	}
	
	public static double ijk(double r) {
		return (r>0.008856)?(Math.pow(r,(1.0/3.0))):((7.787*r)+(16.0/116.0));
	}
	public static double[] xyz2lab(double[] xyz){
		//D65 Daylight reference
		double xr=95.047;
		double yr=100;
		double zr=108.883;
		
		double ag=xyz[0]/xr;
		double ah=xyz[1]/yr;
		double ai=xyz[2]/zr;
		
		double aj=ijk(ag);
		double ak=ijk(ah);
		double al=ijk(ai);
		
		double l=(116*ak)-16;
		double a=500*(aj-ak);
		double b=200*(ak-al);
		
//		System.out.println("lab   ["+l+" "+a+" "+b+"]");
		
		return new double[]{l,a,b};
	}
	
	public static double[] rgb2lab(double[] rgb){
		return xyz2lab(rgb2xyz(rgb));
	}
	public static int[] scaleLab4DSO(double[] lab){
		int[] scaled=new int[3];
		scaled[0]=(int) (lab[0]/100.0*65535.0); //0:100
		scaled[1]=(int) ((lab[1]+128)/255.0 *65535.0); //-128:127
		scaled[2]=(int) ((lab[2]+128)/255.0 *65535.0); //-128:127
//		System.out.println("scaled   ["+scaled[0]+" "+scaled[1]+" "+scaled[2]+"]");
		
		return scaled;
	}
	
	public static int[] rgb2ScaledLab(double[] rgb) {
		return scaleLab4DSO(rgb2lab(rgb));
	}

	/*** end of rgb to lab conversion code********************************/
	/*** lab to rgb ***********************************/
	
	public static int[] scaledLab2Rgb(int[] lab) {
		return lab2rgb(unscaleLab4DSO(lab));
	}
	
	public static double[] unscaleLab4DSO(int[] lab){
		double[] scaled=new double[3];
		scaled[0]= (((double)lab[0])*100.0/65535.0); //0:100
		scaled[1]= ((((double)lab[1])*255.0/65535.0)-128); //-128:127
		scaled[2]=((((double)lab[2])*255.0/65535.0)-128); //-128:127
//		System.out.println("unscaled   ["+scaled[0]+" "+scaled[1]+" "+scaled[2]+"]");
		//loosing some precision but the scaled value is the same and we can go to the same rgb
//		int[] scaleagain=scaleLab4DSO(scaled);
//		System.out.println("rescaled   ["+scaleagain[0]+" "+scaleagain[1]+" "+scaleagain[2]+"]");
		return scaled;
	}
	
	public static int[] lab2rgb(double[] lab){
		return xyz2rgb(lab2xyz(lab));
	}
	
	public static double ijkr(double r) {
		return (r>0.008856)?(Math.pow(r,(3.0))):(((r-16.0/116.0)/7.787));
	}
	public static double[] lab2xyz(double[] lab){
		//D65 Daylight reference
		double xr=95.047;
		double yr=100;
		double zr=108.883;

		double ak2=(lab[0]+16)/116;
		double aj2=(lab[1]/500.0)+ak2;
		double al2=ak2-lab[2]/200.0;
		
		double ag2=ijkr(aj2);
		double ah2=ijkr(ak2);
		double ai2=ijkr(al2);
		
		double x=ag2*xr;
		double y=ah2*yr;
		double z=ai2*zr;
//		System.out.println("xyz   ["+x+" "+y+" "+z+"]");
		
		return new double[]{x,y,z};
	}
	
	
	public static double ader(double r) {
		return (r>0.04045)?((Math.pow(r,(1.0/2.4))*1.055-0.055)):(r*12.92);
	}
	public static int[] xyz2rgb(double[] xyz){		
		double a=41.24;
		double b=35.76;
		double c=18.05;
		double d=-1*xyz[0];
		double l=21.26;
		double m=71.52;
		double n=7.22;
		double k=-1*xyz[1];
		double p=1.93;
		double q=11.92;
		double r=95.05;
		double s=-1*xyz[2];
		double D = (a*m*r+b*p*n+c*l*q)-(a*n*q+b*l*r+c*m*p);
		double ad2 = ((b*r*k+c*m*s+d*n*q)-(b*n*s+c*q*k+d*m*r))/D;
		double ae2 = ((a*n*s+c*p*k+d*l*r)-(a*r*k+c*l*s+d*n*p))/D;
		double af2 = ((a*q*k+b*l*s+d*m*p)-(a*m*s+b*p*k+d*l*q))/D;

		int r2=(int) Math.round(ader(ad2)*255.0);
		int g2=(int) Math.round(ader(ae2)*255.0);
		int b2=(int) Math.round(ader(af2)*255.0);
		
//		System.out.println("rgb   ["+r2+" "+g2+" "+b2+"]");
		
		return new int[]{r2,g2,b2};
		
	}
	
	/***********end of lab to rgb *******************/

}
