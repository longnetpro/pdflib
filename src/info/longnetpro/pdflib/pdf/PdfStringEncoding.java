package info.longnetpro.pdflib.pdf;

import java.io.UnsupportedEncodingException;

public class PdfStringEncoding {

    public static final byte EOL_CR = 0x0D;
    public static final byte EOL_LF = 0x0A;
    public static final String EMPTY = "";
    public static final String MAC_ROMAN_ENCODING = "MacRomanEncoding";
    public static final String WIN_ANSI_ENCODING = "WinAnsiEncoding";
    public static final String PDF_DOC_ENCODING = "PDFDocEncoding";
    public static final String PDF_UNICODE_ENCODING = "PDFUnicodeEncoding";

    public static boolean isWhiteSpace(byte ch) {
        switch (ch) {
        case 0: // Null (NUL)
        case 9: // HORIZONTAL TAB (HT)
        case 10: // LINE FEED (LF)
        case 12: // FORM FEED (FF)
        case 13: // CARRIAGE RETURN (CR)
        case 32: // SPACE (SP)
            return true;
        default:
            return false;
        }
    }

    public static boolean isDelimiter(int ch) {
        switch (ch) {
        case 40: // (
        case 41: // )
        case 60: // <
        case 62: // >
        case 91: // [
        case 93: // ]
        case 123: // {
        case 125: // }
        case 47: // /
        case 37: // %
            return true;
        default:
            return false;
        }
    }

    public static boolean isEolByte(int ch) {
        return ch == EOL_CR || ch == EOL_LF;
    }

    public static final String convertToString(byte[] bytes, String encoding) {
        if (bytes == null) {
            return EMPTY;
        }
        if (encoding == null) {
            char[] ch = new char[bytes.length];
            for (int i = 0; i < bytes.length; ++i)
                ch[i] = (char)(bytes[i] & 0xff);
            return new String(ch);
        }

        try {
            return new String(bytes, encoding);
        } catch (UnsupportedEncodingException e) {
            ;
            //throw new ExceptionConverter(e);
        }

        return EMPTY;
    }

    public static final String convertToString(byte[] bytes) {
        return convertToString(bytes, null);
    }

    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return "";
        }
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static char[] pdfDocEncodingTable() {
        char[] table = new char[256];
        for (int i = 0; i <= 0xff; i++) {
            table[i] = (char)i;
        }
        table[0x18] = 0x02d8;
        table[0x19] = 0x02c7;
        table[0x1a] = 0x02c6;
        table[0x1b] = 0x02d9;
        table[0x1c] = 0x02dd;
        table[0x1d] = 0x02db;
        table[0x1e] = 0x02da;
        table[0x1f] = 0x02dc;
        table[0x7f] = 0xFFFD;
        table[0x80] = 0x2022;
        table[0x81] = 0x2020;
        table[0x82] = 0x2021;
        table[0x83] = 0x2026;
        table[0x84] = 0x2014;
        table[0x85] = 0x2013;
        table[0x86] = 0x0192;
        table[0x87] = 0x2044;
        table[0x88] = 0x2039;
        table[0x89] = 0x203A;
        table[0x8a] = 0x2212;
        table[0x8b] = 0x2030;
        table[0x8c] = 0x201E;
        table[0x8d] = 0x201C;
        table[0x8e] = 0x201D;
        table[0x8f] = 0x2018;
        table[0x90] = 0x2019;
        table[0x91] = 0x201A;
        table[0x92] = 0x2122;
        table[0x93] = 0xFB01;
        table[0x94] = 0xFB02;
        table[0x95] = 0x0141;
        table[0x96] = 0x0152;
        table[0x97] = 0x0160;
        table[0x98] = 0x0178;
        table[0x99] = 0x017D;
        table[0x9a] = 0x0131;
        table[0x9b] = 0x0142;
        table[0x9c] = 0x0153;
        table[0x9d] = 0x0161;
        table[0x9e] = 0x017E;
        table[0x9f] = 0xFFFD;
        table[0xa0] = 0x20AC;
        table[0xad] = 0xFFFD;
        return table;
    }

    public static char[] winAnsiEncodingTable() {
        char[] table1 = new char[256];
        for (int i = 0; i <= 0xff; i++) {
            table1[i] = (char)i;
        }
        char[] table2 = pdfDocEncodingTable();
        table1[65] = table2[65];
        table1[198] = table2[198];
        table1[193] = table2[193];
        table1[194] = table2[194];
        table1[196] = table2[196];
        table1[192] = table2[192];
        table1[197] = table2[197];
        table1[195] = table2[195];
        table1[66] = table2[66];
        table1[67] = table2[67];
        table1[199] = table2[199];
        table1[68] = table2[68];
        table1[69] = table2[69];
        table1[201] = table2[201];
        table1[202] = table2[202];
        table1[203] = table2[203];
        table1[200] = table2[200];
        table1[208] = table2[208];
        table1[128] = table2[160];
        table1[70] = table2[70];
        table1[71] = table2[71];
        table1[72] = table2[72];
        table1[73] = table2[73];
        table1[205] = table2[205];
        table1[206] = table2[206];
        table1[207] = table2[207];
        table1[204] = table2[204];
        table1[74] = table2[74];
        table1[75] = table2[75];
        table1[76] = table2[76];
        table1[149] = 149 > 127 ? 0xFFFD : 149;
        table1[77] = table2[77];
        table1[78] = table2[78];
        table1[209] = table2[209];
        table1[79] = table2[79];
        table1[140] = table2[150];
        table1[211] = table2[211];
        table1[212] = table2[212];
        table1[214] = table2[214];
        table1[210] = table2[210];
        table1[216] = table2[216];
        table1[213] = table2[213];
        table1[80] = table2[80];
        table1[81] = table2[81];
        table1[82] = table2[82];
        table1[83] = table2[83];
        table1[138] = table2[151];
        table1[84] = table2[84];
        table1[222] = table2[222];
        table1[85] = table2[85];
        table1[218] = table2[218];
        table1[219] = table2[219];
        table1[220] = table2[220];
        table1[217] = table2[217];
        table1[86] = table2[86];
        table1[87] = table2[87];
        table1[88] = table2[88];
        table1[89] = table2[89];
        table1[221] = table2[221];
        table1[159] = table2[152];
        table1[90] = table2[90];
        table1[142] = table2[153];
        table1[97] = table2[97];
        table1[225] = table2[225];
        table1[226] = table2[226];
        table1[180] = table2[180];
        table1[228] = table2[228];
        table1[230] = table2[230];
        table1[224] = table2[224];
        table1[38] = table2[38];
        table1[229] = table2[229];
        table1[94] = table2[94];
        table1[126] = table2[126];
        table1[42] = table2[42];
        table1[64] = table2[64];
        table1[227] = table2[227];
        table1[98] = table2[98];
        table1[92] = table2[92];
        table1[124] = table2[124];
        table1[123] = table2[123];
        table1[125] = table2[125];
        table1[91] = table2[91];
        table1[93] = table2[93];
        table1[24] = 24 > 127 ? 0xFFFD : 24;
        table1[166] = table2[166];
        table1[149] = table2[128];
        table1[99] = table2[99];
        table1[25] = 25 > 127 ? 0xFFFD : 25;
        table1[231] = table2[231];
        table1[184] = table2[184];
        table1[162] = table2[162];
        table1[136] = table2[26];
        table1[58] = table2[58];
        table1[44] = table2[44];
        table1[169] = table2[169];
        table1[164] = table2[164];
        table1[100] = table2[100];
        table1[134] = table2[129];
        table1[135] = table2[130];
        table1[176] = table2[176];
        table1[168] = table2[168];
        table1[247] = table2[247];
        table1[36] = table2[36];
        table1[27] = 27 > 127 ? 0xFFFD : 27;
        table1[154] = 154 > 127 ? 0xFFFD : 154;
        table1[101] = table2[101];
        table1[233] = table2[233];
        table1[234] = table2[234];
        table1[235] = table2[235];
        table1[232] = table2[232];
        table1[56] = table2[56];
        table1[133] = table2[131];
        table1[151] = table2[132];
        table1[150] = table2[133];
        table1[61] = table2[61];
        table1[240] = table2[240];
        table1[33] = table2[33];
        table1[161] = table2[161];
        table1[102] = table2[102];
        table1[147] = 147 > 127 ? 0xFFFD : 147;
        table1[53] = table2[53];
        table1[148] = 148 > 127 ? 0xFFFD : 148;
        table1[131] = table2[134];
        table1[52] = table2[52];
        table1[135] = 135 > 127 ? 0xFFFD : 135;
        table1[103] = table2[103];
        table1[223] = table2[223];
        table1[96] = table2[96];
        table1[62] = table2[62];
        table1[171] = table2[171];
        table1[187] = table2[187];
        table1[139] = table2[136];
        table1[155] = table2[137];
        table1[104] = table2[104];
        table1[28] = 28 > 127 ? 0xFFFD : 28;
        table1[45] = table2[45];
        table1[105] = table2[105];
        table1[237] = table2[237];
        table1[238] = table2[238];
        table1[239] = table2[239];
        table1[236] = table2[236];
        table1[106] = table2[106];
        table1[107] = table2[107];
        table1[108] = table2[108];
        table1[60] = table2[60];
        table1[172] = table2[172];
        table1[155] = 155 > 127 ? 0xFFFD : 155;
        table1[109] = table2[109];
        table1[175] = table2[175];
        table1[138] = 138 > 127 ? 0xFFFD : 138;
        table1[181] = table2[181];
        table1[215] = table2[215];
        table1[110] = table2[110];
        table1[57] = table2[57];
        table1[241] = table2[241];
        table1[35] = table2[35];
        table1[111] = table2[111];
        table1[243] = table2[243];
        table1[244] = table2[244];
        table1[246] = table2[246];
        table1[156] = table2[156];
        table1[29] = 29 > 127 ? 0xFFFD : 29;
        table1[242] = table2[242];
        table1[49] = table2[49];
        table1[189] = table2[189];
        table1[188] = table2[188];
        table1[185] = table2[185];
        table1[170] = table2[170];
        table1[186] = table2[186];
        table1[248] = table2[248];
        table1[245] = table2[245];
        table1[112] = table2[112];
        table1[182] = table2[182];
        table1[40] = table2[40];
        table1[41] = table2[41];
        table1[37] = table2[37];
        table1[46] = table2[46];
        table1[183] = table2[183];
        table1[137] = table2[139];
        table1[43] = table2[43];
        table1[177] = table2[177];
        table1[113] = table2[113];
        table1[63] = table2[63];
        table1[191] = table2[191];
        table1[34] = table2[34];
        table1[132] = table2[140];
        table1[147] = table2[141];
        table1[148] = table2[142];
        table1[145] = table2[143];
        table1[146] = table2[144];
        table1[130] = table2[145];
        table1[39] = table2[39];
        table1[114] = table2[114];
        table1[174] = table2[174];
        table1[30] = 30 > 127 ? 0xFFFD : 30;
        table1[115] = table2[115];
        table1[154] = table2[157];
        table1[167] = table2[167];
        table1[59] = table2[59];
        table1[55] = table2[55];
        table1[54] = table2[54];
        table1[47] = table2[47];
        table1[32] = table2[32];
        table1[163] = table2[163];
        table1[116] = table2[116];
        table1[254] = table2[254];
        table1[51] = table2[51];
        table1[190] = table2[190];
        table1[179] = table2[179];
        table1[152] = table2[31];
        table1[153] = table2[146];
        table1[50] = table2[50];
        table1[178] = table2[178];
        table1[117] = table2[117];
        table1[250] = table2[250];
        table1[251] = table2[251];
        table1[252] = table2[252];
        table1[249] = table2[249];
        table1[95] = table2[95];
        table1[118] = table2[118];
        table1[119] = table2[119];
        table1[120] = table2[120];
        table1[121] = table2[121];
        table1[253] = table2[253];
        table1[255] = table2[255];
        table1[165] = table2[165];
        table1[122] = table2[122];
        table1[158] = table2[158];
        table1[48] = table2[48];
        return table1;
    }

}
