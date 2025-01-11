package sobes.numbers;

public class SumDigits {

    public int addDigits(int num) {

        while (num >= 10) {
            int sum = 0;
            int sum1 = 0;
            int num1 = num;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
    public static void main(String[] args) {
        SumDigits solution = new SumDigits();
        int result = solution.addDigits(12345);
        System.out.println("Результат: " + result); // Вывод: 6
    }
}
