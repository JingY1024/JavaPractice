package edu.nyu.cs9053.homework4;

public enum OceanName {

    Atlantic(106400000),

    Arctic(14056000),

    Indian(70560000),

    Pacific(181344000),

    Southern(20327000);

    private final double area;

    OceanName(double area) {
        this.area = area;
    }

    public static void print(OceanName... arguments) {
        for (OceanName argument : arguments) {
            System.out.printf("%f", argument.getArea());
        }
    }

    public double getArea() {
        return area;
    }

}
