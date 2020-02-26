package edu.nyu.cs9053.homework7;

public class Test {
    public static void main(String[] args) {
        /* public class BambooRatArrayCreator implements ArrayCreator<BambooRat> {

        adding this to avoid casting

        create: return new BambooRat[size];

        add arraycreator as a instance field in repository
    }

    in main:
        repository<BambooRat> repo = new Repository(size -> new BambooRat[size]);


    */
        ArrayCreator<bambooRat> arrayCreator = new bambooRatArrayCreator();
        Barn<bambooRat> barn = new Barn<>(arrayCreator, 10);
        barn.add(new bambooRat("Xiao Bai"));
        barn.add(new bambooRat("Xiao Hei"));
        barn.add(new bambooRat("Xiao Hui"));
        barn.remove(new bambooRat("Xiao Hei"));
        for (int i = 0; i < barn.size(); i++) {
            System.out.println(barn.get(i).getName());
        }
        Barn<bambooRat> newBarn = new Barn<>(arrayCreator, 10);
        newBarn.add(new bambooRat("Xiao Lan"));
        newBarn.add(new bambooRat("Xiao Hong"));
        BarnTransfer barnTransfer = new BarnTransfer();
        barnTransfer.transfer(newBarn, barn);
        for (int i = 0; i < barn.size(); i++) {
            System.out.println(barn.get(i).getName());
        }
    }
}
