package com.cooksys.ftd.assignments.objects;

import java.util.Objects;

import com.cooksys.ftd.assignments.objects.util.MissingImplementationException;

public class Rational implements IRational {
	
	private int numerator;
	private int denominator;
    /**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * No simplification of the numerator/denominator pair should occur in this method.
     *
     * @param numerator   the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public Rational(int numerator, int denominator) throws IllegalArgumentException {
        if(denominator == 0) {
        	throw new IllegalArgumentException();
        }
        
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * @return the numerator of this rational number
     */
    @Override
    public int getNumerator() {
        return this.numerator;
    }

    /**
     * @return the denominator of this rational number
     */
    @Override
    public int getDenominator() {
        return this.denominator;
    }

    /**
     * Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
     * <p>
     * Essentially, this method allows us to implement most of IRational methods directly in the interface while
     * preserving the underlying type
     *
     * @param numerator the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    @Override
    public Rational construct(int numerator, int denominator) throws IllegalArgumentException {
        if(denominator == 0) {
        	throw new IllegalArgumentException();
        }
        
        return new Rational(numerator,denominator);
    }

    //I used the generate hash and equals from eclipse to generate the hashcode, equals and toString methods
    @Override
	public int hashCode() {
		return Objects.hash(numerator, denominator);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rational other = (Rational) obj;
		return denominator == other.denominator && numerator == other.numerator;
	}

    @Override
	public String toString() {
    	if((numerator<0 && denominator<0)||(numerator>0&&denominator>0)) {
			return Math.abs(numerator)+"/"+Math.abs(denominator);	
    	}else {
    		return "-"+Math.abs(numerator)+"/"+Math.abs(denominator);		
    	}
	}
}
