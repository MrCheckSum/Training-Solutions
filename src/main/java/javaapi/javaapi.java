package javaapi;

public class javaapi {

   /*
nextLine
public String nextLine()
Advances this scanner past the current line and returns the input that was skipped. This method returns the rest of the current line, excluding any line separator at the end. The position is set to the beginning of the next line.
Since this method continues to search through the input looking for a line separator, it may buffer all of the input searching for the line to skip if no line separators are present.

Returns:
the line that was skipped
Throws:
NoSuchElementException - if no line was found
IllegalStateException - if this scanner is closed

nextInt
public int nextInt​(int radix)
Scans the next token of the input as an int. This method will throw InputMismatchException if the next token cannot be translated into a valid int value as described below. If the translation is successful, the scanner advances past the input that matched.
If the next token matches the Integer regular expression defined above then the token is converted into an int value as if by removing all locale specific prefixes, group separators, and locale specific suffixes, then mapping non-ASCII digits into ASCII digits via Character.digit, prepending a negative sign (-) if the locale specific negative prefixes and suffixes were present, and passing the resulting string to Integer.parseInt with the specified radix.

If the radix is less than Character.MIN_RADIX or greater than Character.MAX_RADIX, then an IllegalArgumentException is thrown.

Parameters:
radix - the radix used to interpret the token as an int value
Returns:
the int scanned from the input
Throws:
InputMismatchException - if the next token does not match the Integer regular expression, or is out of range
NoSuchElementException - if input is exhausted
IllegalStateException - if this scanner is closed
IllegalArgumentException - if the radix is out of range

    */
}
