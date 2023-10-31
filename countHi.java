public int countHi(String str) {
        // Base case: If the length is less than 2, it can't contain "hi"
        if (str.length() < 2)
            return 0;

        // Check if the substring starting from the current index is "hi"
        if (str.substring(0, 2).equals("hi"))
            return 1 + countHi(str.substring(2));  // If "hi" is found, increment count and check the rest of the string
        else
            return countHi(str.substring(1));  // If not "hi", check the rest of the string
    
}