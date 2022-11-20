public class sol {
    public static void main(String[] args) {
        System.out.println(lcmTriplets(7));
    }

    private static int lcmTriplets(int N) {
        // No arguments in LCM can be 0.
        if(N == 0) return LCM(-1, -2, -3);
        if(N == 1) return LCM(1, -1, -2);
        if(N == 2) return LCM(2, 1, -1);

        return LCM(N, N-1, N-2);
    }

    private static int LCM(int... args)
    {
        // A Lowest Common Multiple is the multiplication of all prime factors of args or 
        // factors that aren't divisible by other args.
        // For example take arguments, 15, 5, 2 => 15 = 5 * 3 therefore the LCM is 2*3*5.

        // Derive prime factors.
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args.length; j++) {
                if(args[i] == args[j]) continue; // skip self and duplicates.
                if(args[i] % args[j] == 0) // if divides cleanly, there is a lower common multiple already
                    {
                        args[i] /= args[j];
                        j = 0;
                    }
            }
        }

        // Remove duplicates
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args.length; j++) {
                if(i == j) continue;
                if(args[i] == args[j])
                    {
                        args[j] = 0;
                    }
            }
        }

        // Multiply and disregard duplicates.
        int sum = 1;
        for (int i : args) {
            if(i != 0) sum *= i;
        }
        return sum;
        
    }
}