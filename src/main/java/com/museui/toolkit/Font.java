package com.museui.toolkit;

public class Font {
    public static final int CHAR_WIDTH = 5;
    public static final int CHAR_HEIGHT = 7;

    private static final byte[][] FONT = new byte[128][];

    static {
        FONT['B'] = new byte[]{
                0b11110,
                0b10001,
                0b10001,
                0b11110,
                0b10001,
                0b10001,
                0b11110
        };
        FONT['C'] = new byte[]{
                0b01111,
                0b10000,
                0b10000,
                0b10000,
                0b10000,
                0b10000,
                0b01111
        };
        FONT['D'] = new byte[]{
                0b11110,
                0b10001,
                0b10001,
                0b10001,
                0b10001,
                0b10001,
                0b11110
        };
        FONT['E'] = new byte[]{
                0b11111,
                0b10000,
                0b10000,
                0b11110,
                0b10000,
                0b10000,
                0b11111
        };
        FONT['F'] = new byte[]{
                0b11111,
                0b10000,
                0b10000,
                0b11110,
                0b10000,
                0b10000,
                0b10000
        };
        FONT['G'] = new byte[]{
                0b01111,
                0b10000,
                0b10000,
                0b10111,
                0b10001,
                0b10001,
                0b01111
        };
        FONT['H'] = new byte[]{
                0b10001,
                0b10001,
                0b10001,
                0b11111,
                0b10001,
                0b10001,
                0b10001
        };
        FONT['I'] = new byte[]{
                0b11111,
                0b00100,
                0b00100,
                0b00100,
                0b00100,
                0b00100,
                0b11111
        };
        FONT['J'] = new byte[]{
                0b00001,
                0b00001,
                0b00001,
                0b00001,
                0b10001,
                0b10001,
                0b01110
        };
        FONT['K'] = new byte[]{
                0b10001,
                0b10010,
                0b10100,
                0b11000,
                0b10100,
                0b10010,
                0b10001
        };
        FONT['L'] = new byte[]{
                0b10000,
                0b10000,
                0b10000,
                0b10000,
                0b10000,
                0b10000,
                0b11111
        };
        FONT['M'] = new byte[]{
                0b10001,
                0b11011,
                0b10101,
                0b10001,
                0b10001,
                0b10001,
                0b10001
        };
        FONT['N'] = new byte[]{
                0b10001,
                0b11001,
                0b10101,
                0b10011,
                0b10001,
                0b10001,
                0b10001
        };
        FONT['O'] = new byte[]{
                0b01110,
                0b10001,
                0b10001,
                0b10001,
                0b10001,
                0b10001,
                0b01110
        };
        FONT['P'] = new byte[]{
                0b11110,
                0b10001,
                0b10001,
                0b11110,
                0b10000,
                0b10000,
                0b10000
        };
        FONT['Q'] = new byte[]{
                0b01110,
                0b10001,
                0b10001,
                0b10001,
                0b10101,
                0b10010,
                0b01101
        };
        FONT['R'] = new byte[]{
                0b11110,
                0b10001,
                0b10001,
                0b11110,
                0b10100,
                0b10010,
                0b10001
        };
        FONT['S'] = new byte[]{
                0b01111,
                0b10000,
                0b10000,
                0b01110,
                0b00001,
                0b00001,
                0b11110
        };
        FONT['T'] = new byte[]{
                0b11111,
                0b00100,
                0b00100,
                0b00100,
                0b00100,
                0b00100,
                0b00100
        };
        FONT['U'] = new byte[]{
                0b10001,
                0b10001,
                0b10001,
                0b10001,
                0b10001,
                0b10001,
                0b01110
        };
        FONT['V'] = new byte[]{
                0b10001,
                0b10001,
                0b10001,
                0b10001,
                0b10001,
                0b01010,
                0b00100
        };
        FONT['W'] = new byte[]{
                0b10001,
                0b10001,
                0b10001,
                0b10101,
                0b10101,
                0b10101,
                0b01010
        };
        FONT['X'] = new byte[]{
                0b10001,
                0b10001,
                0b01010,
                0b00100,
                0b01010,
                0b10001,
                0b10001
        };
        FONT['Y'] = new byte[]{
                0b10001,
                0b10001,
                0b01010,
                0b00100,
                0b00100,
                0b00100,
                0b00100
        };
        FONT['Z'] = new byte[]{
                0b11111,
                0b00001,
                0b00010,
                0b00100,
                0b01000,
                0b10000,
                0b11111
        };
        // Digits 0-9
        FONT['0'] = new byte[]{
                0b01110,
                0b10001,
                0b10011,
                0b10101,
                0b11001,
                0b10001,
                0b01110
        };
        FONT['1'] = new byte[]{
                0b00100,
                0b01100,
                0b00100,
                0b00100,
                0b00100,
                0b00100,
                0b01110
        };
        FONT['2'] = new byte[]{
                0b01110,
                0b10001,
                0b00001,
                0b00010,
                0b00100,
                0b01000,
                0b11111
        };
        FONT['3'] = new byte[]{
                0b11110,
                0b00001,
                0b00001,
                0b01110,
                0b00001,
                0b00001,
                0b11110
        };
        FONT['4'] = new byte[]{
                0b00010,
                0b00110,
                0b01010,
                0b10010,
                0b11111,
                0b00010,
                0b00010
        };
        FONT['5'] = new byte[]{
                0b11111,
                0b10000,
                0b10000,
                0b11110,
                0b00001,
                0b00001,
                0b11110
        };
        FONT['6'] = new byte[]{
                0b00110,
                0b01000,
                0b10000,
                0b11110,
                0b10001,
                0b10001,
                0b01110
        };
        FONT['7'] = new byte[]{
                0b11111,
                0b00001,
                0b00010,
                0b00100,
                0b01000,
                0b01000,
                0b01000
        };
        FONT['8'] = new byte[]{
                0b01110,
                0b10001,
                0b10001,
                0b01110,
                0b10001,
                0b10001,
                0b01110
        };
        FONT['9'] = new byte[]{
                0b01110,
                0b10001,
                0b10001,
                0b01111,
                0b00001,
                0b00010,
                0b01100
        };
        // Symbols
        FONT[' '] = new byte[]{
                0b00000,
                0b00000,
                0b00000,
                0b00000,
                0b00000,
                0b00000,
                0b00000
        };
        FONT['.'] = new byte[]{
                0b00000,
                0b00000,
                0b00000,
                0b00000,
                0b00000,
                0b01100,
                0b01100
        };
        FONT[','] = new byte[]{
                0b00000,
                0b00000,
                0b00000,
                0b00000,
                0b01100,
                0b01100,
                0b00100
        };
        FONT['!'] = new byte[]{
                0b00100,
                0b00100,
                0b00100,
                0b00100,
                0b00100,
                0b00000,
                0b00100
        };
        FONT['?'] = new byte[]{
                0b01110,
                0b10001,
                0b00001,
                0b00010,
                0b00100,
                0b00000,
                0b00100
        };
        FONT['-'] = new byte[]{
                0b00000,
                0b00000,
                0b00000,
                0b11111,
                0b00000,
                0b00000,
                0b00000
        };
        FONT['a'] = new byte[] {
                0b00000,
                0b00000,
                0b01110,
                0b00001,
                0b01111,
                0b10001,
                0b01111
        };
        FONT['b'] = new byte[] {
                0b10000,
                0b10000,
                0b11110,
                0b10001,
                0b10001,
                0b10001,
                0b11110
        };
        FONT['c'] = new byte[] {
                0b00000,
                0b00000,
                0b01110,
                0b10000,
                0b10000,
                0b10000,
                0b01110
        };
        FONT['d'] = new byte[] {
                0b00001,
                0b00001,
                0b01111,
                0b10001,
                0b10001,
                0b10001,
                0b01111
        };
        FONT['e'] = new byte[] {
                0b00000,
                0b00000,
                0b01110,
                0b10001,
                0b11111,
                0b10000,
                0b01110
        };
        FONT['f'] = new byte[] {
                0b00110,
                0b01001,
                0b01000,
                0b11100,
                0b01000,
                0b01000,
                0b01000
        };
        FONT['g'] = new byte[] {
                0b00000,
                0b01111,
                0b10001,
                0b01111,
                0b00001,
                0b10001,
                0b01110
        };
        FONT['h'] = new byte[] {
                0b10000,
                0b10000,
                0b11110,
                0b10001,
                0b10001,
                0b10001,
                0b10001
        };
        FONT['i'] = new byte[] {
                0b00100,
                0b00000,
                0b01100,
                0b00100,
                0b00100,
                0b00100,
                0b01110
        };
        FONT['j'] = new byte[] {
                0b00010,
                0b00000,
                0b00110,
                0b00010,
                0b00010,
                0b10010,
                0b01100
        };
        FONT['k'] = new byte[] {
                0b10000,
                0b10010,
                0b10100,
                0b11000,
                0b10100,
                0b10010,
                0b10001
        };
        FONT['l'] = new byte[] {
                0b01100,
                0b00100,
                0b00100,
                0b00100,
                0b00100,
                0b00100,
                0b01110
        };
        FONT['m'] = new byte[] {
                0b00000,
                0b00000,
                0b11010,
                0b10101,
                0b10101,
                0b10101,
                0b10101
        };
        FONT['n'] = new byte[] {
                0b00000,
                0b00000,
                0b11110,
                0b10001,
                0b10001,
                0b10001,
                0b10001
        };
        FONT['o'] = new byte[] {
                0b00000,
                0b00000,
                0b01110,
                0b10001,
                0b10001,
                0b10001,
                0b01110
        };
        FONT['p'] = new byte[] {
                0b00000,
                0b11110,
                0b10001,
                0b10001,
                0b11110,
                0b10000,
                0b10000
        };
        FONT['q'] = new byte[] {
                0b00000,
                0b01111,
                0b10001,
                0b10001,
                0b01111,
                0b00001,
                0b00001
        };
        FONT['r'] = new byte[] {
                0b00000,
                0b10110,
                0b11001,
                0b10000,
                0b10000,
                0b10000,
                0b10000
        };
        FONT['s'] = new byte[] {
                0b00000,
                0b01111,
                0b10000,
                0b01110,
                0b00001,
                0b10001,
                0b01110
        };
        FONT['t'] = new byte[] {
                0b01000,
                0b01000,
                0b11100,
                0b01000,
                0b01000,
                0b01001,
                0b00110
        };
        FONT['u'] = new byte[] {
                0b00000,
                0b00000,
                0b10001,
                0b10001,
                0b10001,
                0b10011,
                0b01101
        };
        FONT['v'] = new byte[] {
                0b00000,
                0b00000,
                0b10001,
                0b10001,
                0b01010,
                0b01010,
                0b00100
        };
        FONT['w'] = new byte[] {
                0b00000,
                0b00000,
                0b10001,
                0b10001,
                0b10101,
                0b10101,
                0b01010
        };
        FONT['x'] = new byte[] {
                0b00000,
                0b00000,
                0b10001,
                0b01010,
                0b00100,
                0b01010,
                0b10001
        };
        FONT['y'] = new byte[] {
                0b00000,
                0b10001,
                0b10001,
                0b01111,
                0b00001,
                0b00001,
                0b01110
        };
        FONT['z'] = new byte[] {
                0b00000,
                0b00000,
                0b11111,
                0b00010,
                0b00100,
                0b01000,
                0b11111
        };
    }

    public static byte[] getCharBitmap(char c) {
        if (c >= 128 || FONT[c] == null)
            return FONT[' '];
        return FONT[c];
    }
}
