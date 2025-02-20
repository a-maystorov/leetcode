import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int arr[] = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(TwoSum.solution(arr, target)));
    }
}
