package com.zybooks.testworldsalsa;

/**
 * homepage object to create custom spinner
 */
public class HomePageSpinner {

    private String name;
    private int picture;

    /**
     *  constructor
     * @param name constructor
     * @param picture constructor
     */
    public HomePageSpinner(String name, int picture) {
        this.name = name;
        this.picture = picture;
    }

    /**
     *  getters
     * @return getters
     */
    public String getName() {
        return name;
    }

    public int getPicture() {
        return picture;
    }
}
