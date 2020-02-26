package edu.nyu.cs9053.homework2;

/**
 * User: blangel
 */
public class VehicleDataParser {

    /**
     * Given a 4 byte response, {@code mode01Pid00Response}, parse according to the {@literal SAE J1979} documentation.
     * For example, if {@code mode01Pid00Response} was {@literal 0xBE1FA813} the return value would be equal to:
     * {@literal new int[] { 0x01, 0x03, 0x04, 0x05, 0x06, 0x07, 0x0C, 0x0D, 0x0E, 0x0F, 0x10, 0x11, 0x13, 0x15, 0x1C, 0x1F, 0x20}}
     * @param mode01Pid00Response four byte response
     * @return an array of supported PID values given the input, {@code mode01Pid00Response}
     * @see {@literal https://en.wikipedia.org/wiki/OBD-II_PIDs#Service_01_PID_00}
     */
    public static int[] supportedPids(int mode01Pid00Response) {
        int count = 0;
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++){
            int temp = mode01Pid00Response % 2;
            if (temp == -1) {
                bits[31-i] = 1;
                count++;
            }
            else bits[31-i] = 0;
            mode01Pid00Response = mode01Pid00Response >> 1;
        }
        if (count == 0) return new int[]{};
        int[] result = new int[count];
        int resultIndex = 0;
        for (int i = 0; i < 32; i++){
            if (bits[i] == 1){
                result[resultIndex] = i;
                resultIndex++;
            }
        }
        return result;

    }

    /**
     * Given a {@code pid} between [0x1,0x20] return true iff {@code mode01Pid00Response} supports it.
     * @param pid value between [0x1,0x20] to check for support within {@code mode01Pid00Response}
     * @param mode01Pid00Response four byte response
     * @return true iff {@code mode01Pid00Response} supports {@code pid}.
     * @throws IllegalArgumentException if {@code pid} is less than 0x1 or greater than 0x20
     */
    public static boolean isSupported(int pid, int mode01Pid00Response) {
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++){
            int temp = mode01Pid00Response % 2;
            if (temp == -1) {
                bits[31-i] = 1;
            }
            else bits[31-i] = 0;
            mode01Pid00Response = mode01Pid00Response >> 1;
        }
        return bits[pid] == 1;
    }

}
