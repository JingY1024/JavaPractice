package edu.nyu.cs9053.homework5;

/**
 * User: blangel
 */
public class Chef {
    private Oven oven = new Oven(300);
    private SousChef sousChef = new SousChef(oven);

    public static void main(String[] args) {
	// TODO - create an instance of Chef and cook the proper recipes according to the instructions.
        Timer timer = new Timer() {
            private int time = 0;
            private int ovenTemperature = 300;

            public void update(Time unit, int value, int ovenTemperature) {
                // this method should adjust the recipe and continue cooking it until done
                if (unit == Time.Seconds) {
                    this.time += value;
                }
                else {
                    this.time += value * 10;
                }
                this.ovenTemperature = ovenTemperature;
            }

            public int getTime() {
                return this.time;
            }

            public int getOvenTemperature() {
                return this.ovenTemperature;
            }
        };
    }

    private void prepareToCook(Recipe recipe) {
        RoastedSweetPotato roastedSweetPotato = new RoastedSweetPotato();
        roastedSweetPotato.initializeFromOven(oven);
        // roastedSweetPotato.initializeFromTimer(timer);
        sousChef.prepare(roastedSweetPotato, roastedSweetPotato);
    }
}
