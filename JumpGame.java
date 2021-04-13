import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class JumpGame {
    public int jump(int[] nums) {
        int last = nums.length - 1, step = 0, start = 0, end = 0;
        while (end < last) {
            step++;
            int maxEnd = end + 1;
            for (int i = start; i <= end; i++) {
                if (i + nums[i] >= last)
                    return step;
                maxEnd = Math.max(maxEnd, i + nums[i]);
            }
            start = end + 1;
            end = maxEnd;
        }
        return step;
    }

    public static void main(String[] args) throws FileNotFoundException{
        File infile = new File("test.txt");

        Scanner sc = new Scanner(infile);

        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(sc.hasNextInt()){
            arr.add(sc.nextInt());
        }
        JumpGame instant = new JumpGame();

        int[] nums = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            nums[i] = arr.get(i);
        }
        int res = instant.jump(nums);
        System.out.println(res);
        sc.close();
    }
}
