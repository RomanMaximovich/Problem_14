package com.company;

public class Main {

    static int begin = 3;

    static int[] decomposition (int n, int exp) //returns an array of 0's and 1's based on the decomposition of n into powers of 2.
    {
        int v = n;

        int[] res = new int[exp];

        if (v != 0)
        {
            for (int i = exp-1; i >= 0; i--)
            {
                if (Math.pow(2,i) <= v)
                {
                    res[i] = 1;
                    v -= Math.pow(2,i);

                    if (v == 0) break;
                }
            }
        }

        return res;
    }

    static int sum (int[] A) //takes the alternating sum corresponding to a given array of 0's and 1's
    {
        int res = 1;

        for (int i = 0; i < A.length; i++)
        {
            res += (i+2)*Math.pow(-1, A[i]);
        }

        return res;
    }

    static void print (int[] A) //prints the alternating sum in console
    {
        System.out.print(1);

        for (int i = 0; i < A.length; i++)
        {
            System.out.print((A[i]==0 ? "+" : "-") + (i+2));
        }

        System.out.println();
    }

    static void printNumberOfWays (int n, int m) //prints the ways n can be broken into an alternating sum of the first m numbers (1 always with a plus)
    {
        System.out.println("---Decomposing " + n + " into sums of the first " + m + " numbers---");

        System.out.println();

        int res = 0;

        for (int i = 0; i < Math.pow(2,m-1); i++)
        {
            int[] A = decomposition(i, m-1);

            if (n == sum(A))
            {
                res++;

                print(A);
            }
        }

        System.out.println();

        System.out.println("Total number of ways: " + res);
    }

    static int numberOfWays (int n, int m) //returns the number of ways n can be broken into an alternating sum of the first m numbers (1 always with a plus)
    {
        int res = 0;

        for (int i = 0; i < Math.pow(2,m-1); i++)
        {
            int[] A = decomposition(i, m-1);

            if (n == sum(A))
            {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args)
    {
        int x = 0;

        int bound = 55;

        for (int i = -64; i <= -bound ; i++)
        {
            x += numberOfWays(i, 11);
        }

        for (int i = bound+1; i <= 66; i++)
        {
            x += numberOfWays(i, 11);
        }

        System.out.println(1024-x);
    }
}
