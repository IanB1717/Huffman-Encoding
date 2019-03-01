# Huffman-Encoding
Code used when using Huffman Encoding in relation to Data Structures and algorithms in Java
1)AsciiCodeEncoder will take in a string of any length and will then tell you how many times each ascii charachter was used in the string if
the space beside a number is the output is blank this means it has read a space, it will also then turn the charachter into its ascii
decimal value and will then turn that decimal value to binary and print both of these to the screen.
2)HuffmanEncoding - takes in a string and will print out the huffman encoding of the string in bianry.The program uses priority queues and binary trees to do the huffman encoding , the file gets the frequency a char appears in the string creates a forrest of binary trees based on this putting the least occuring at the bottom of the trees and the most near the top , it then progresses through the forrest and creates a strings of 1 and o's if you must go left in the tree to get a char you add a 0 and if you go left you get a 1 and this continues until all the string has been found in bianry and concatinats them together e.g hello would be 1111100010 in huffman encoding based on this.
