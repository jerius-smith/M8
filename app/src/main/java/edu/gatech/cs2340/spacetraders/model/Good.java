package edu.gatech.cs2340.spacetraders.model;

/**
 * The enum Good.
 */
public enum Good {
    /**
     * Water good.
     */
    WATER(30, 0, 3, 4),
    /**
     * Fur good.
     */
    FUR(250, 0, 10, 10),
    /**
     * Food good.
     */
    FOOD(100, 1, 5, 5),
    /**
     * Ore good.
     */
    ORE(350, 2, 20, 10),
    /**
     * Games good.
     */
    GAMES(250, 3, -10, 5),
    /**
     * Firearms good.
     */
    FIREARMS(1250, 3, -75, 100),
    /**
     * Medicine good.
     */
    MEDICINE(650, 4, -20, 10),
    /**
     * Machines good.
     */
    MACHINES(900, 4, -30, 5),
    /**
     * Narcotics good.
     */
    NARCOTICS(3500, 5, -125, 150),
    /**
     * Robots good.
     */
    ROBOTS(5000, 6, -150, 100);

    public void setBASE_PRICE(double BASE_PRICE) {
        this.BASE_PRICE = BASE_PRICE;
    }

    public void setMTLP(int MTLP) {
        this.MTLP = MTLP;
    }

    public void setIPL(int IPL) {
        this.IPL = IPL;
    }

    public void setVarianceFactor(int varianceFactor) {
        this.varianceFactor = varianceFactor;
    }

    private double BASE_PRICE;
    private int MTLP;
    private int IPL;
    private int varianceFactor;

    Good(double price, int MTLP, int IPL, int varianceFactor) {
        this.BASE_PRICE = price;
        this.MTLP = MTLP;
        this.IPL = IPL;
        this.varianceFactor = varianceFactor;
    }

    Good() {
    }

    public double getBASE_PRICE() {
        return BASE_PRICE;
    }

    public int getMTLP() {
        return MTLP;
    }

    public int getIPL() {
        return IPL;
    }

    public int getVarianceFactor() {
        return varianceFactor;
    }

    public String toString() {
        return name();
    }


}
