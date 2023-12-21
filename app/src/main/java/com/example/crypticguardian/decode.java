package com.example.crypticguardian;

public class decode {

        public static String dec(String s) {
            String inv = "This code was not encrypted by CrypticGuardian";

            // create the same initial
            // string as in encode class
            String initializer = "11111111";
            Boolean flag = true;

            // run a loop of size 8
            for (int i = 0; i < 8; i++) {
                // check if the initial value is same
                if (initializer.charAt(i) != s.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            String data = "";

            // reverse the encrypted code
            for (int i = 8; i < s.length(); i++) {
                char temp = s.charAt(i);
                data = data.concat(String.valueOf(temp));
            }

            // create a 2 dimensional array
            int asc[][] = new int[11101][8];
            int idx = -1;
            int idx2 = 0;

            // run a loop of size of the encrypted code
            for (int i = 0; i < data.length(); i++) {

                // check if the position of the
                // string if divisible by 7
                if (i % 7 == 0) {
                    // start the value in other
                    // column of the 2D array
                    idx++;
                    idx2 = 0;
                    char ch = data.charAt(i);
                    asc[idx][idx2] = ch - '0';
                    idx2++;
                } else {
                    // otherwise store the value
                    // in the same column
                    char temp = data.charAt(i);
                    asc[idx][idx2] = temp - '0';
                    idx2++;
                }
            }
            // create an array
            int num[] = new int[11111];
            int nidx = 0;
            int temp = 0;
            int ct= 0;

            // run a loop of size of the column
            for (int i = 0; i <= idx; i++) {
                ct = 0;
                temp = 0;
                // convert binary to decimal and add them
                // from each column and store in the array
                for (int j = 6; j >= 0; j--) {
                    int temp1 = (int) Math.pow(2, ct);
                    temp += (asc[i][j] * temp1);
                    ct++;
                }
                num[nidx++] = temp;
            }
            String rv = "";
            char ch;
            // convert the decimal ascii number to its
            // char value and add them to form a decrypted
            // string using conception function
            for (int i = 0; i < nidx; i++) {
                ch = (char) num[i];
                rv = rv.concat(String.valueOf(ch));
            }


            // check if the encrypted code was
            // generated for this algorithm
            if (data.length() % 7 == 0 && flag == true) {
                // return the decrypted code
                return rv;
            } else {
                // otherwise return an invalid message
                return inv;
            }
        }
    }


