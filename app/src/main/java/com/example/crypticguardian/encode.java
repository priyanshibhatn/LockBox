package com.example.crypticguardian;

public class encode {

    public static String enc(String s) {
            // create a string to add in the initial
            // binary code for extra security
            String initializer = "111111111";
            int ct = 0;

            // create an array
            int a[] = new int[111111111];

            // iterate through the string
            for (int i = 0; i < s.length(); i++) {
                // put the ascii value of
                // each character in the array
                a[i] = (int) s.charAt(i);
                ct++;
            }
            String res = "";

            // create another array
            int bin[] = new int[111];
            int idx = 0;

            // run a loop of the size of string
            for (int ii = 0; ii < ct; ii++) {

                // get the ascii value at position
                // i1 from the first array
                int temp = a[ii];

                // run the second nested loop of same size
                // and set 0 value in the second array
                for (int j = 0; j < ct; j++) bin[j] = 0;
                idx = 0;

                // run a while for temp > 0
                while (temp > 0) {
                    // store the temp module
                    // of 2 in the 2nd array
                    bin[idx++] = temp % 2;
                    temp = temp / 2;
                }
                String dig = "";
                String temps;

                // run a loop of size 7
                for (int j = 0; j < 7; j++) {

                    // convert the integer to string
                    temps = Integer.toString(bin[j]);

                    // add the string using
                    // concatenation function
                    dig = dig.concat(temps);
                }
                String rev = "";

                // reverse the string
                for (int j = dig.length() - 1; j >= 0; j--) {
                    char ca = dig.charAt(j);
                    rev = rev.concat(String.valueOf(ca));
                }
                res = res.concat(rev);
            }
            // add the extra string to the binary code
            res = initializer.concat(res);

            // return the encrypted code
            return res;
        }
    }


