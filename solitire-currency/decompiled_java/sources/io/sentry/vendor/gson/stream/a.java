package io.sentry.vendor.gson.stream;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: JsonReader.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public class a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Reader f28414a;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f28422i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f28423j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f28424k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int[] f28425l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String[] f28427n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int[] f28428o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f28415b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final char[] f28416c = new char[1024];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f28417d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f28418e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f28419f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f28420g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f28421h = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f28426m = 0 + 1;

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f28425l = iArr;
        iArr[0] = 6;
        this.f28427n = new String[32];
        this.f28428o = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f28414a = reader;
    }

    private boolean B(char c10) throws IOException {
        if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
            return false;
        }
        if (c10 != '#') {
            if (c10 == ',') {
                return false;
            }
            if (c10 != '/' && c10 != '=') {
                if (c10 == '{' || c10 == '}' || c10 == ':') {
                    return false;
                }
                if (c10 != ';') {
                    switch (c10) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        c();
        return false;
    }

    private void G0(int i10) {
        int i11 = this.f28426m;
        int[] iArr = this.f28425l;
        if (i11 == iArr.length) {
            int i12 = i11 * 2;
            this.f28425l = Arrays.copyOf(iArr, i12);
            this.f28428o = Arrays.copyOf(this.f28428o, i12);
            this.f28427n = (String[]) Arrays.copyOf(this.f28427n, i12);
        }
        int[] iArr2 = this.f28425l;
        int i13 = this.f28426m;
        this.f28426m = i13 + 1;
        iArr2[i13] = i10;
    }

    private char I0() throws IOException {
        int i10;
        int i11;
        if (this.f28417d == this.f28418e && !x(1)) {
            throw N0("Unterminated escape sequence");
        }
        char[] cArr = this.f28416c;
        int i12 = this.f28417d;
        int i13 = i12 + 1;
        this.f28417d = i13;
        char c10 = cArr[i12];
        if (c10 == '\n') {
            this.f28419f++;
            this.f28420g = i13;
        } else if (c10 != '\"' && c10 != '\'' && c10 != '/' && c10 != '\\') {
            if (c10 == 'b') {
                return '\b';
            }
            if (c10 == 'f') {
                return '\f';
            }
            if (c10 == 'n') {
                return '\n';
            }
            if (c10 == 'r') {
                return '\r';
            }
            if (c10 == 't') {
                return '\t';
            }
            if (c10 != 'u') {
                throw N0("Invalid escape sequence");
            }
            if (i13 + 4 > this.f28418e && !x(4)) {
                throw N0("Unterminated escape sequence");
            }
            int i14 = this.f28417d;
            int i15 = i14 + 4;
            char c11 = 0;
            while (i14 < i15) {
                char c12 = this.f28416c[i14];
                char c13 = (char) (c11 << 4);
                if (c12 < '0' || c12 > '9') {
                    if (c12 >= 'a' && c12 <= 'f') {
                        i10 = c12 - 'a';
                    } else {
                        if (c12 < 'A' || c12 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.f28416c, this.f28417d, 4));
                        }
                        i10 = c12 - 'A';
                    }
                    i11 = i10 + 10;
                } else {
                    i11 = c12 - '0';
                }
                c11 = (char) (c13 + i11);
                i14++;
            }
            this.f28417d += 4;
            return c11;
        }
        return c10;
    }

    private void J0(char c10) throws IOException {
        char[] cArr = this.f28416c;
        do {
            int i10 = this.f28417d;
            int i11 = this.f28418e;
            while (i10 < i11) {
                int i12 = i10 + 1;
                char c11 = cArr[i10];
                if (c11 == c10) {
                    this.f28417d = i12;
                    return;
                }
                if (c11 == '\\') {
                    this.f28417d = i12;
                    I0();
                    i10 = this.f28417d;
                    i11 = this.f28418e;
                } else {
                    if (c11 == '\n') {
                        this.f28419f++;
                        this.f28420g = i12;
                    }
                    i10 = i12;
                }
            }
            this.f28417d = i10;
        } while (x(1));
        throw N0("Unterminated string");
    }

    private boolean K0(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f28417d + length > this.f28418e && !x(length)) {
                return false;
            }
            char[] cArr = this.f28416c;
            int i10 = this.f28417d;
            if (cArr[i10] != '\n') {
                for (int i11 = 0; i11 < length; i11++) {
                    if (this.f28416c[this.f28417d + i11] != str.charAt(i11)) {
                        break;
                    }
                }
                return true;
            }
            this.f28419f++;
            this.f28420g = i10 + 1;
            this.f28417d++;
        }
    }

    private void L0() throws IOException {
        char c10;
        do {
            if (this.f28417d >= this.f28418e && !x(1)) {
                return;
            }
            char[] cArr = this.f28416c;
            int i10 = this.f28417d;
            int i11 = i10 + 1;
            this.f28417d = i11;
            c10 = cArr[i10];
            if (c10 == '\n') {
                this.f28419f++;
                this.f28420g = i11;
                return;
            }
        } while (c10 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        c();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void M0() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f28417d
            int r2 = r1 + r0
            int r3 = r4.f28418e
            if (r2 >= r3) goto L51
            char[] r2 = r4.f28416c
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.c()
        L4b:
            int r1 = r4.f28417d
            int r1 = r1 + r0
            r4.f28417d = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f28417d = r1
            r0 = 1
            boolean r0 = r4.x(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.a.M0():void");
    }

    private IOException N0(String str) throws IOException {
        throw new d(str + J());
    }

    private int O(boolean z10) throws IOException {
        char[] cArr = this.f28416c;
        int i10 = this.f28417d;
        int i11 = this.f28418e;
        while (true) {
            if (i10 == i11) {
                this.f28417d = i10;
                if (!x(1)) {
                    if (!z10) {
                        return -1;
                    }
                    throw new EOFException("End of input" + J());
                }
                i10 = this.f28417d;
                i11 = this.f28418e;
            }
            int i12 = i10 + 1;
            char c10 = cArr[i10];
            if (c10 == '\n') {
                this.f28419f++;
                this.f28420g = i12;
            } else if (c10 != ' ' && c10 != '\r' && c10 != '\t') {
                if (c10 == '/') {
                    this.f28417d = i12;
                    if (i12 == i11) {
                        this.f28417d = i12 - 1;
                        boolean zX = x(2);
                        this.f28417d++;
                        if (!zX) {
                            return c10;
                        }
                    }
                    c();
                    int i13 = this.f28417d;
                    char c11 = cArr[i13];
                    if (c11 == '*') {
                        this.f28417d = i13 + 1;
                        if (!K0("*/")) {
                            throw N0("Unterminated comment");
                        }
                        i10 = this.f28417d + 2;
                        i11 = this.f28418e;
                    } else {
                        if (c11 != '/') {
                            return c10;
                        }
                        this.f28417d = i13 + 1;
                        L0();
                        i10 = this.f28417d;
                        i11 = this.f28418e;
                    }
                } else {
                    if (c10 != '#') {
                        this.f28417d = i12;
                        return c10;
                    }
                    this.f28417d = i12;
                    c();
                    L0();
                    i10 = this.f28417d;
                    i11 = this.f28418e;
                }
            }
            i10 = i12;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
    
        r1.append(r0, r3, r2 - r3);
        r9.f28417d = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String S(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.f28416c
            r1 = 0
        L3:
            int r2 = r9.f28417d
            int r3 = r9.f28418e
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L5c
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L28
            r9.f28417d = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L20
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r3, r7)
            return r10
        L20:
            r1.append(r0, r3, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L28:
            r8 = 92
            if (r2 != r8) goto L4f
            r9.f28417d = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L40
            int r1 = r7 + 1
            int r1 = r1 * 2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r2.<init>(r1)
            r1 = r2
        L40:
            r1.append(r0, r3, r7)
            char r2 = r9.I0()
            r1.append(r2)
            int r2 = r9.f28417d
            int r3 = r9.f28418e
            goto L7
        L4f:
            r5 = 10
            if (r2 != r5) goto L5a
            int r2 = r9.f28419f
            int r2 = r2 + r6
            r9.f28419f = r2
            r9.f28420g = r7
        L5a:
            r2 = r7
            goto L9
        L5c:
            if (r1 != 0) goto L6c
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L6c:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.f28417d = r2
            boolean r2 = r9.x(r6)
            if (r2 == 0) goto L7a
            goto L3
        L7a:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.N0(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.a.S(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        c();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String W() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.f28417d
            int r4 = r3 + r2
            int r5 = r6.f28418e
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f28416c
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.c()
            goto L5c
        L4e:
            char[] r3 = r6.f28416c
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.x(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r1 = r2
            goto L7e
        L5e:
            if (r0 != 0) goto L6b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L6b:
            char[] r3 = r6.f28416c
            int r4 = r6.f28417d
            r0.append(r3, r4, r2)
            int r3 = r6.f28417d
            int r3 = r3 + r2
            r6.f28417d = r3
            r2 = 1
            boolean r2 = r6.x(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r0 != 0) goto L8a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.f28416c
            int r3 = r6.f28417d
            r0.<init>(r2, r3, r1)
            goto L95
        L8a:
            char[] r2 = r6.f28416c
            int r3 = r6.f28417d
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L95:
            int r2 = r6.f28417d
            int r2 = r2 + r1
            r6.f28417d = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.a.W():java.lang.String");
    }

    private void c() throws IOException {
        if (!this.f28415b) {
            throw N0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int h0() throws IOException {
        String str;
        String str2;
        int i10;
        char c10 = this.f28416c[this.f28417d];
        if (c10 == 't' || c10 == 'T') {
            str = com.ironsource.mediationsdk.metadata.a.f13688g;
            str2 = "TRUE";
            i10 = 5;
        } else if (c10 == 'f' || c10 == 'F') {
            str = "false";
            str2 = "FALSE";
            i10 = 6;
        } else {
            if (c10 != 'n' && c10 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i10 = 7;
        }
        int length = str.length();
        for (int i11 = 1; i11 < length; i11++) {
            if (this.f28417d + i11 >= this.f28418e && !x(i11 + 1)) {
                return 0;
            }
            char c11 = this.f28416c[this.f28417d + i11];
            if (c11 != str.charAt(i11) && c11 != str2.charAt(i11)) {
                return 0;
            }
        }
        if ((this.f28417d + length < this.f28418e || x(length + 1)) && B(this.f28416c[this.f28417d + length])) {
            return 0;
        }
        this.f28417d += length;
        this.f28421h = i10;
        return i10;
    }

    private void i() throws IOException {
        O(true);
        int i10 = this.f28417d - 1;
        this.f28417d = i10;
        if (i10 + 5 <= this.f28418e || x(5)) {
            char[] cArr = this.f28416c;
            if (cArr[i10] == ')' && cArr[i10 + 1] == ']' && cArr[i10 + 2] == '}' && cArr[i10 + 3] == '\'' && cArr[i10 + 4] == '\n') {
                this.f28417d += 5;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0091, code lost:
    
        if (B(r14) != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0093, code lost:
    
        if (r9 != 2) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0095, code lost:
    
        if (r10 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009b, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009d, code lost:
    
        if (r13 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a3, code lost:
    
        if (r11 != 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
    
        if (r13 != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a7, code lost:
    
        if (r13 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00aa, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ab, code lost:
    
        r18.f28422i = r11;
        r18.f28417d += r8;
        r18.f28421h = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b6, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b7, code lost:
    
        if (r9 == 2) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ba, code lost:
    
        if (r9 == 4) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00bd, code lost:
    
        if (r9 != 7) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c0, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c2, code lost:
    
        r18.f28423j = r8;
        r18.f28421h = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c8, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00c9, code lost:
    
        return 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int i0() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.a.i0():int");
    }

    private boolean x(int i10) throws IOException {
        int i11;
        int i12;
        char[] cArr = this.f28416c;
        int i13 = this.f28420g;
        int i14 = this.f28417d;
        this.f28420g = i13 - i14;
        int i15 = this.f28418e;
        if (i15 != i14) {
            int i16 = i15 - i14;
            this.f28418e = i16;
            System.arraycopy(cArr, i14, cArr, 0, i16);
        } else {
            this.f28418e = 0;
        }
        this.f28417d = 0;
        do {
            Reader reader = this.f28414a;
            int i17 = this.f28418e;
            int i18 = reader.read(cArr, i17, cArr.length - i17);
            if (i18 == -1) {
                return false;
            }
            i11 = this.f28418e + i18;
            this.f28418e = i11;
            if (this.f28419f == 0 && (i12 = this.f28420g) == 0 && i11 > 0 && cArr[0] == 65279) {
                this.f28417d++;
                this.f28420g = i12 + 1;
                i10++;
            }
        } while (i11 < i10);
        return true;
    }

    public String C() throws IOException {
        String strS;
        int iN = this.f28421h;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 14) {
            strS = W();
        } else if (iN == 12) {
            strS = S('\'');
        } else {
            if (iN != 13) {
                throw new IllegalStateException("Expected a name but was " + peek() + J());
            }
            strS = S('\"');
        }
        this.f28421h = 0;
        this.f28427n[this.f28426m - 1] = strS;
        return strS;
    }

    String J() {
        return " at line " + (this.f28419f + 1) + " column " + ((this.f28417d - this.f28420g) + 1) + " path " + getPath();
    }

    public boolean L() throws IOException {
        int iN = this.f28421h;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 5) {
            this.f28421h = 0;
            int[] iArr = this.f28428o;
            int i10 = this.f28426m - 1;
            iArr[i10] = iArr[i10] + 1;
            return true;
        }
        if (iN == 6) {
            this.f28421h = 0;
            int[] iArr2 = this.f28428o;
            int i11 = this.f28426m - 1;
            iArr2[i11] = iArr2[i11] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + peek() + J());
    }

    public void R() throws IOException {
        int iN = this.f28421h;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 7) {
            this.f28421h = 0;
            int[] iArr = this.f28428o;
            int i10 = this.f28426m - 1;
            iArr[i10] = iArr[i10] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + J());
    }

    public void a() throws IOException {
        int iN = this.f28421h;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 3) {
            G0(1);
            this.f28428o[this.f28426m - 1] = 0;
            this.f28421h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + J());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f28421h = 0;
        this.f28425l[0] = 8;
        this.f28426m = 1;
        this.f28414a.close();
    }

    public String e0() throws IOException {
        String str;
        int iN = this.f28421h;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 10) {
            str = W();
        } else if (iN == 8) {
            str = S('\'');
        } else if (iN == 9) {
            str = S('\"');
        } else if (iN == 11) {
            str = this.f28424k;
            this.f28424k = null;
        } else if (iN == 15) {
            str = Long.toString(this.f28422i);
        } else {
            if (iN != 16) {
                throw new IllegalStateException("Expected a string but was " + peek() + J());
            }
            str = new String(this.f28416c, this.f28417d, this.f28423j);
            this.f28417d += this.f28423j;
        }
        this.f28421h = 0;
        int[] iArr = this.f28428o;
        int i10 = this.f28426m - 1;
        iArr[i10] = iArr[i10] + 1;
        return str;
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i10 = this.f28426m;
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = this.f28425l[i11];
            if (i12 == 1 || i12 == 2) {
                sb.append('[');
                sb.append(this.f28428o[i11]);
                sb.append(']');
            } else if (i12 == 3 || i12 == 4 || i12 == 5) {
                sb.append('.');
                String str = this.f28427n[i11];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    public void h() throws IOException {
        int iN = this.f28421h;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 1) {
            G0(3);
            this.f28421h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + J());
        }
    }

    public final void j(boolean z10) {
        this.f28415b = z10;
    }

    public void k() throws IOException {
        int iN = this.f28421h;
        if (iN == 0) {
            iN = n();
        }
        if (iN != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + peek() + J());
        }
        int i10 = this.f28426m - 1;
        this.f28426m = i10;
        this.f28427n[i10] = null;
        int[] iArr = this.f28428o;
        int i11 = i10 - 1;
        iArr[i11] = iArr[i11] + 1;
        this.f28421h = 0;
    }

    int n() throws IOException {
        int iO;
        int[] iArr = this.f28425l;
        int i10 = this.f28426m;
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            iArr[i10 - 1] = 2;
        } else if (i11 == 2) {
            int iO2 = O(true);
            if (iO2 != 44) {
                if (iO2 != 59) {
                    if (iO2 != 93) {
                        throw N0("Unterminated array");
                    }
                    this.f28421h = 4;
                    return 4;
                }
                c();
            }
        } else {
            if (i11 == 3 || i11 == 5) {
                iArr[i10 - 1] = 4;
                if (i11 == 5 && (iO = O(true)) != 44) {
                    if (iO != 59) {
                        if (iO != 125) {
                            throw N0("Unterminated object");
                        }
                        this.f28421h = 2;
                        return 2;
                    }
                    c();
                }
                int iO3 = O(true);
                if (iO3 == 34) {
                    this.f28421h = 13;
                    return 13;
                }
                if (iO3 == 39) {
                    c();
                    this.f28421h = 12;
                    return 12;
                }
                if (iO3 == 125) {
                    if (i11 == 5) {
                        throw N0("Expected name");
                    }
                    this.f28421h = 2;
                    return 2;
                }
                c();
                this.f28417d--;
                if (!B((char) iO3)) {
                    throw N0("Expected name");
                }
                this.f28421h = 14;
                return 14;
            }
            if (i11 == 4) {
                iArr[i10 - 1] = 5;
                int iO4 = O(true);
                if (iO4 != 58) {
                    if (iO4 != 61) {
                        throw N0("Expected ':'");
                    }
                    c();
                    if (this.f28417d < this.f28418e || x(1)) {
                        char[] cArr = this.f28416c;
                        int i12 = this.f28417d;
                        if (cArr[i12] == '>') {
                            this.f28417d = i12 + 1;
                        }
                    }
                }
            } else if (i11 == 6) {
                if (this.f28415b) {
                    i();
                }
                this.f28425l[this.f28426m - 1] = 7;
            } else if (i11 == 7) {
                if (O(false) == -1) {
                    this.f28421h = 17;
                    return 17;
                }
                c();
                this.f28417d--;
            } else if (i11 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iO5 = O(true);
        if (iO5 == 34) {
            this.f28421h = 9;
            return 9;
        }
        if (iO5 == 39) {
            c();
            this.f28421h = 8;
            return 8;
        }
        if (iO5 != 44 && iO5 != 59) {
            if (iO5 == 91) {
                this.f28421h = 3;
                return 3;
            }
            if (iO5 != 93) {
                if (iO5 == 123) {
                    this.f28421h = 1;
                    return 1;
                }
                this.f28417d--;
                int iH0 = h0();
                if (iH0 != 0) {
                    return iH0;
                }
                int iI0 = i0();
                if (iI0 != 0) {
                    return iI0;
                }
                if (!B(this.f28416c[this.f28417d])) {
                    throw N0("Expected value");
                }
                c();
                this.f28421h = 10;
                return 10;
            }
            if (i11 == 1) {
                this.f28421h = 4;
                return 4;
            }
        }
        if (i11 != 1 && i11 != 2) {
            throw N0("Unexpected value");
        }
        c();
        this.f28417d--;
        this.f28421h = 7;
        return 7;
    }

    public double nextDouble() throws IOException {
        int iN = this.f28421h;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 15) {
            this.f28421h = 0;
            int[] iArr = this.f28428o;
            int i10 = this.f28426m - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.f28422i;
        }
        if (iN == 16) {
            this.f28424k = new String(this.f28416c, this.f28417d, this.f28423j);
            this.f28417d += this.f28423j;
        } else if (iN == 8 || iN == 9) {
            this.f28424k = S(iN == 8 ? '\'' : '\"');
        } else if (iN == 10) {
            this.f28424k = W();
        } else if (iN != 11) {
            throw new IllegalStateException("Expected a double but was " + peek() + J());
        }
        this.f28421h = 11;
        double d10 = Double.parseDouble(this.f28424k);
        if (!this.f28415b && (Double.isNaN(d10) || Double.isInfinite(d10))) {
            throw new d("JSON forbids NaN and infinities: " + d10 + J());
        }
        this.f28424k = null;
        this.f28421h = 0;
        int[] iArr2 = this.f28428o;
        int i11 = this.f28426m - 1;
        iArr2[i11] = iArr2[i11] + 1;
        return d10;
    }

    public int nextInt() throws IOException {
        int iN = this.f28421h;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 15) {
            long j10 = this.f28422i;
            int i10 = (int) j10;
            if (j10 == i10) {
                this.f28421h = 0;
                int[] iArr = this.f28428o;
                int i11 = this.f28426m - 1;
                iArr[i11] = iArr[i11] + 1;
                return i10;
            }
            throw new NumberFormatException("Expected an int but was " + this.f28422i + J());
        }
        if (iN == 16) {
            this.f28424k = new String(this.f28416c, this.f28417d, this.f28423j);
            this.f28417d += this.f28423j;
        } else {
            if (iN != 8 && iN != 9 && iN != 10) {
                throw new IllegalStateException("Expected an int but was " + peek() + J());
            }
            if (iN == 10) {
                this.f28424k = W();
            } else {
                this.f28424k = S(iN == 8 ? '\'' : '\"');
            }
            try {
                int i12 = Integer.parseInt(this.f28424k);
                this.f28421h = 0;
                int[] iArr2 = this.f28428o;
                int i13 = this.f28426m - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return i12;
            } catch (NumberFormatException unused) {
            }
        }
        this.f28421h = 11;
        double d10 = Double.parseDouble(this.f28424k);
        int i14 = (int) d10;
        if (i14 != d10) {
            throw new NumberFormatException("Expected an int but was " + this.f28424k + J());
        }
        this.f28424k = null;
        this.f28421h = 0;
        int[] iArr3 = this.f28428o;
        int i15 = this.f28426m - 1;
        iArr3[i15] = iArr3[i15] + 1;
        return i14;
    }

    public long nextLong() throws IOException {
        int iN = this.f28421h;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 15) {
            this.f28421h = 0;
            int[] iArr = this.f28428o;
            int i10 = this.f28426m - 1;
            iArr[i10] = iArr[i10] + 1;
            return this.f28422i;
        }
        if (iN == 16) {
            this.f28424k = new String(this.f28416c, this.f28417d, this.f28423j);
            this.f28417d += this.f28423j;
        } else {
            if (iN != 8 && iN != 9 && iN != 10) {
                throw new IllegalStateException("Expected a long but was " + peek() + J());
            }
            if (iN == 10) {
                this.f28424k = W();
            } else {
                this.f28424k = S(iN == 8 ? '\'' : '\"');
            }
            try {
                long j10 = Long.parseLong(this.f28424k);
                this.f28421h = 0;
                int[] iArr2 = this.f28428o;
                int i11 = this.f28426m - 1;
                iArr2[i11] = iArr2[i11] + 1;
                return j10;
            } catch (NumberFormatException unused) {
            }
        }
        this.f28421h = 11;
        double d10 = Double.parseDouble(this.f28424k);
        long j11 = (long) d10;
        if (j11 != d10) {
            throw new NumberFormatException("Expected a long but was " + this.f28424k + J());
        }
        this.f28424k = null;
        this.f28421h = 0;
        int[] iArr3 = this.f28428o;
        int i12 = this.f28426m - 1;
        iArr3[i12] = iArr3[i12] + 1;
        return j11;
    }

    public void p() throws IOException {
        int i10 = 0;
        do {
            int iN = this.f28421h;
            if (iN == 0) {
                iN = n();
            }
            if (iN == 3) {
                G0(1);
            } else if (iN == 1) {
                G0(3);
            } else if (iN == 4 || iN == 2) {
                this.f28426m--;
                i10--;
                this.f28421h = 0;
            } else {
                if (iN == 14 || iN == 10) {
                    M0();
                } else if (iN == 8 || iN == 12) {
                    J0('\'');
                } else if (iN == 9 || iN == 13) {
                    J0('\"');
                } else if (iN == 16) {
                    this.f28417d += this.f28423j;
                }
                this.f28421h = 0;
            }
            i10++;
            this.f28421h = 0;
        } while (i10 != 0);
        int[] iArr = this.f28428o;
        int i11 = this.f28426m;
        int i12 = i11 - 1;
        iArr[i12] = iArr[i12] + 1;
        this.f28427n[i11 - 1] = "null";
    }

    public b peek() throws IOException {
        int iN = this.f28421h;
        if (iN == 0) {
            iN = n();
        }
        switch (iN) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public void q() throws IOException {
        int iN = this.f28421h;
        if (iN == 0) {
            iN = n();
        }
        if (iN != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + peek() + J());
        }
        int i10 = this.f28426m - 1;
        this.f28426m = i10;
        int[] iArr = this.f28428o;
        int i11 = i10 - 1;
        iArr[i11] = iArr[i11] + 1;
        this.f28421h = 0;
    }

    public String toString() {
        return getClass().getSimpleName() + J();
    }

    public boolean z() throws IOException {
        int iN = this.f28421h;
        if (iN == 0) {
            iN = n();
        }
        return (iN == 2 || iN == 4) ? false : true;
    }
}
