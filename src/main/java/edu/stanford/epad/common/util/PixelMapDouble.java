package edu.stanford.epad.common.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

//import com.gargoylesoftware.htmlunit.WebConsole.Logger;

//import java.util.logging.Logger;
import java.util.Set;
import java.util.TreeMap;

public class PixelMapDouble {

//	private static final Logger logger = Logger.getLogger("PixelMap");

	Map<Double, Double> map = new TreeMap<Double, Double>();

	Double total, min, max, range, mean, raw, lowerBound, upperBound;
	double stdDev;
	
	public void put(Double raw, Double count) {
		map.put(raw, count);
	}

	public Double get(Double raw) {
		return map.get(raw);
	}
	
	public Map<Double, Double> getMap() {
		return map;
	}

	public int size() {
		return map.size();
	}

	public Set<Entry<Double, Double>> entrySet() {
		return map.entrySet();
	}

	public void calc() {

		rawTotalMean();
		standardDeviation();

	}
	
	public void minMaxRange() {

		Entry<Double, Double> next;
//		min = max = 0;

		//ml this makes more sense! We can check if they are filled or not. min or max can be actually 0
		min = -9999999.0;
		max = 9999999.0;

		Iterator<Entry<Double, Double>> first = map.entrySet().iterator();
		if (first.hasNext()) {
			min = first.next().getKey();
		}

		Iterator<Entry<Double, Double>> last = map.entrySet().iterator();
		while (last.hasNext()) {
			next = last.next();
			max = next.getKey();
		}
		range = max - min;
		lowerBound = min;
		upperBound = max;
	}

	private void rawTotalMean() {

		Entry<Double, Double> next;
		total = raw = mean = 0.0;

		Iterator<Entry<Double, Double>> itr = map.entrySet().iterator();

		while (itr.hasNext()) {
			next = itr.next();
			Double key = next.getKey();
			Double value = next.getValue();
			if (key >= lowerBound && key <= upperBound) {
				raw += key * value;
				total += value;
			}
		}

		mean = (raw / total);
	}

	private void standardDeviation() {

		if (total != 0) {
			double sum = 0.0;

			Iterator<Entry<Double, Double>> itr = map.entrySet().iterator();
			while (itr.hasNext()) {

				Entry<Double, Double> next = itr.next();
				Double key = next.getKey();
				Double value = next.getValue();

				if (key >= lowerBound && key <= upperBound) {

					for (int i = 0; i < value; i++) {
						double x = (key - mean);
						sum += (x * x);
					}
				}
			}
			stdDev = Math.sqrt(sum / total);
		}

	}

	public double getStdDev() {
		return stdDev;
	}

	public Double getRange() {
		return range;
	}

	public Double getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(Double lowerBound) {
		this.lowerBound = lowerBound;
	}

	public Double getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(Double upperBound) {
		this.upperBound = upperBound;
	}

	public Double getMean() {
		return mean;
	}

	public int getSize() {
		return map.size();
	}

	public Double getMin() {
		return min;
	}

	public Double getMax() {
		return max;
	}
	
	

}