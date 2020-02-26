package edu.nyu.cs9053.homework7;

public class BarnTransfer { // cannot use implement here
    // to ensure the two arguments of function can be different, the type should not be the same
    // here wildcards are applied to ensure the polymorphism
    public <T extends Animal> void transfer(Barn<? extends T> sourceBarn, Barn<? super T> targetBarn) {
        if (targetBarn == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < sourceBarn.size(); i++) {
            targetBarn.add(sourceBarn.get(i));
        }
    }
}

/* why this cannot compile?
public void transfer(Barn<?> sourceBarn, Barn<?> targetBarn) {
        for (int i = 0; i < sourceBarn.size(); i++) {
            targetBarn.add(sourceBarn.get(i));
        }
    }
 */