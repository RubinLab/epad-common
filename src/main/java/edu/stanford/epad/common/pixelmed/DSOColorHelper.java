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
	

}
