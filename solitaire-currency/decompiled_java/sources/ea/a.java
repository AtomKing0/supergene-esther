package ea;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AbstractJsonLexer.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f25411a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private String f25413c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final c0 f25412b = new c0();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private StringBuilder f25414d = new StringBuilder();

    private final int B(CharSequence charSequence, int i10) {
        char cCharAt = charSequence.charAt(i10);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        char c10 = 'a';
        if (!('a' <= cCharAt && cCharAt < 'g')) {
            c10 = 'A';
            if (!('A' <= cCharAt && cCharAt < 'G')) {
                y(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6, null);
                throw new v8.h();
            }
        }
        return (cCharAt - c10) + 10;
    }

    private final String K() {
        String str = this.f25413c;
        kotlin.jvm.internal.t.f(str);
        this.f25413c = null;
        return str;
    }

    private final boolean O() {
        return C().charAt(this.f25411a - 1) != '\"';
    }

    private final int b(int i10) {
        int iG = G(i10);
        if (iG == -1) {
            y(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
            throw new v8.h();
        }
        int i11 = iG + 1;
        char cCharAt = C().charAt(iG);
        if (cCharAt == 'u') {
            return d(C(), i11);
        }
        char cB = b.b(cCharAt);
        if (cB != 0) {
            this.f25414d.append(cB);
            return i11;
        }
        y(this, "Invalid escaped char '" + cCharAt + '\'', 0, null, 6, null);
        throw new v8.h();
    }

    private final int c(int i10, int i11) {
        e(i10, i11);
        return b(i11 + 1);
    }

    private final int d(CharSequence charSequence, int i10) {
        int i11 = i10 + 4;
        if (i11 < charSequence.length()) {
            this.f25414d.append((char) ((B(charSequence, i10) << 12) + (B(charSequence, i10 + 1) << 8) + (B(charSequence, i10 + 2) << 4) + B(charSequence, i10 + 3)));
            return i11;
        }
        this.f25411a = i10;
        v();
        if (this.f25411a + 4 < charSequence.length()) {
            return d(charSequence, this.f25411a);
        }
        y(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
        throw new v8.h();
    }

    private final boolean h(int i10) {
        int iG = G(i10);
        if (iG >= C().length() || iG == -1) {
            y(this, "EOF", 0, null, 6, null);
            throw new v8.h();
        }
        int i11 = iG + 1;
        int iCharAt = C().charAt(iG) | ' ';
        if (iCharAt == 102) {
            j("alse", i11);
            return false;
        }
        if (iCharAt == 116) {
            j("rue", i11);
            return true;
        }
        y(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, null, 6, null);
        throw new v8.h();
    }

    private final void j(String str, int i10) {
        if (C().length() - i10 < str.length()) {
            y(this, "Unexpected end of boolean literal", 0, null, 6, null);
            throw new v8.h();
        }
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (str.charAt(i11) != (C().charAt(i10 + i11) | ' ')) {
                y(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, null, 6, null);
                throw new v8.h();
            }
        }
        this.f25411a = i10 + str.length();
    }

    private final String u(int i10, int i11) {
        e(i10, i11);
        String string = this.f25414d.toString();
        kotlin.jvm.internal.t.h(string, "escapedString.toString()");
        this.f25414d.setLength(0);
        return string;
    }

    public static /* synthetic */ Void y(a aVar, String str, int i10, String str2, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i11 & 2) != 0) {
            i10 = aVar.f25411a;
        }
        if ((i11 & 4) != 0) {
            str2 = "";
        }
        return aVar.x(str, i10, str2);
    }

    public final void A(@NotNull String key) {
        kotlin.jvm.internal.t.i(key, "key");
        x("Encountered an unknown key '" + key + '\'', p9.r.k0(J(0, this.f25411a), key, 0, false, 6, null), "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw new v8.h();
    }

    @NotNull
    protected abstract CharSequence C();

    protected final boolean D(char c10) {
        return !(((c10 == '}' || c10 == ']') || c10 == ':') || c10 == ',');
    }

    public final byte E() {
        CharSequence charSequenceC = C();
        int i10 = this.f25411a;
        while (true) {
            int iG = G(i10);
            if (iG == -1) {
                this.f25411a = iG;
                return (byte) 10;
            }
            char cCharAt = charSequenceC.charAt(iG);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f25411a = iG;
                return b.a(cCharAt);
            }
            i10 = iG + 1;
        }
    }

    @Nullable
    public final String F(boolean z10) {
        String strQ;
        byte bE = E();
        if (z10) {
            if (bE != 1 && bE != 0) {
                return null;
            }
            strQ = s();
        } else {
            if (bE != 1) {
                return null;
            }
            strQ = q();
        }
        this.f25413c = strQ;
        return strQ;
    }

    public abstract int G(int i10);

    public final void H(boolean z10) {
        ArrayList arrayList = new ArrayList();
        byte bE = E();
        if (bE != 8 && bE != 6) {
            s();
            return;
        }
        while (true) {
            byte bE2 = E();
            boolean z11 = true;
            if (bE2 != 1) {
                if (bE2 != 8 && bE2 != 6) {
                    z11 = false;
                }
                if (z11) {
                    arrayList.add(Byte.valueOf(bE2));
                } else if (bE2 == 9) {
                    if (((Number) kotlin.collections.d0.t0(arrayList)).byteValue() != 8) {
                        throw a0.f(this.f25411a, "found ] instead of } at path: " + this.f25412b, C());
                    }
                    kotlin.collections.a0.O(arrayList);
                } else if (bE2 == 7) {
                    if (((Number) kotlin.collections.d0.t0(arrayList)).byteValue() != 6) {
                        throw a0.f(this.f25411a, "found } instead of ] at path: " + this.f25412b, C());
                    }
                    kotlin.collections.a0.O(arrayList);
                } else if (bE2 == 10) {
                    y(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                    throw new v8.h();
                }
                m();
                if (arrayList.size() == 0) {
                    return;
                }
            } else if (z10) {
                s();
            } else {
                k();
            }
        }
    }

    public abstract int I();

    @NotNull
    public String J(int i10, int i11) {
        return C().subSequence(i10, i11).toString();
    }

    public abstract boolean L();

    public final boolean M() {
        int iG = G(I());
        int length = C().length() - iG;
        if (length < 4 || iG == -1) {
            return true;
        }
        for (int i10 = 0; i10 < 4; i10++) {
            if ("null".charAt(i10) != C().charAt(iG + i10)) {
                return true;
            }
        }
        if (length > 4 && b.a(C().charAt(iG + 4)) == 0) {
            return true;
        }
        this.f25411a = iG + 4;
        return false;
    }

    protected final void N(char c10) {
        int i10 = this.f25411a - 1;
        this.f25411a = i10;
        if (i10 >= 0 && c10 == '\"' && kotlin.jvm.internal.t.d(s(), "null")) {
            x("Expected string literal but 'null' literal was found", this.f25411a - 4, "Use 'coerceInputValues = true' in 'Json {}` builder to coerce nulls to default values.");
            throw new v8.h();
        }
        z(b.a(c10));
        throw new v8.h();
    }

    protected void e(int i10, int i11) {
        this.f25414d.append(C(), i10, i11);
    }

    public abstract boolean f();

    public final boolean g() {
        return h(I());
    }

    public final boolean i() {
        boolean z10;
        int I = I();
        if (I == C().length()) {
            y(this, "EOF", 0, null, 6, null);
            throw new v8.h();
        }
        if (C().charAt(I) == '\"') {
            I++;
            z10 = true;
        } else {
            z10 = false;
        }
        boolean zH = h(I);
        if (z10) {
            if (this.f25411a == C().length()) {
                y(this, "EOF", 0, null, 6, null);
                throw new v8.h();
            }
            if (C().charAt(this.f25411a) != '\"') {
                y(this, "Expected closing quotation mark", 0, null, 6, null);
                throw new v8.h();
            }
            this.f25411a++;
        }
        return zH;
    }

    @NotNull
    public abstract String k();

    @Nullable
    public abstract String l(@NotNull String str, boolean z10);

    public abstract byte m();

    public final byte n(byte b10) {
        byte bM = m();
        if (bM == b10) {
            return bM;
        }
        z(b10);
        throw new v8.h();
    }

    public abstract void o(char c10);

    public final long p() {
        boolean z10;
        int iG = G(I());
        if (iG >= C().length() || iG == -1) {
            y(this, "EOF", 0, null, 6, null);
            throw new v8.h();
        }
        if (C().charAt(iG) == '\"') {
            iG++;
            if (iG == C().length()) {
                y(this, "EOF", 0, null, 6, null);
                throw new v8.h();
            }
            z10 = true;
        } else {
            z10 = false;
        }
        int i10 = iG;
        long j10 = 0;
        boolean z11 = true;
        boolean z12 = false;
        while (z11) {
            char cCharAt = C().charAt(i10);
            if (cCharAt != '-') {
                if (b.a(cCharAt) != 0) {
                    break;
                }
                i10++;
                z11 = i10 != C().length();
                int i11 = cCharAt - '0';
                if (!(i11 >= 0 && i11 < 10)) {
                    y(this, "Unexpected symbol '" + cCharAt + "' in numeric literal", 0, null, 6, null);
                    throw new v8.h();
                }
                j10 = (j10 * ((long) 10)) - ((long) i11);
                if (j10 > 0) {
                    y(this, "Numeric value overflow", 0, null, 6, null);
                    throw new v8.h();
                }
            } else {
                if (i10 != iG) {
                    y(this, "Unexpected symbol '-' in numeric literal", 0, null, 6, null);
                    throw new v8.h();
                }
                i10++;
                z12 = true;
            }
        }
        if (iG == i10 || (z12 && iG == i10 - 1)) {
            y(this, "Expected numeric literal", 0, null, 6, null);
            throw new v8.h();
        }
        if (z10) {
            if (!z11) {
                y(this, "EOF", 0, null, 6, null);
                throw new v8.h();
            }
            if (C().charAt(i10) != '\"') {
                y(this, "Expected closing quotation mark", 0, null, 6, null);
                throw new v8.h();
            }
            i10++;
        }
        this.f25411a = i10;
        if (z12) {
            return j10;
        }
        if (j10 != Long.MIN_VALUE) {
            return -j10;
        }
        y(this, "Numeric value overflow", 0, null, 6, null);
        throw new v8.h();
    }

    @NotNull
    public final String q() {
        return this.f25413c != null ? K() : k();
    }

    @NotNull
    protected final String r(@NotNull CharSequence source, int i10, int i11) {
        int iG;
        kotlin.jvm.internal.t.i(source, "source");
        char cCharAt = source.charAt(i11);
        boolean z10 = false;
        while (cCharAt != '\"') {
            if (cCharAt == '\\') {
                iG = G(c(i10, i11));
                if (iG == -1) {
                    y(this, "EOF", iG, null, 4, null);
                    throw new v8.h();
                }
            } else {
                i11++;
                if (i11 >= source.length()) {
                    e(i10, i11);
                    iG = G(i11);
                    if (iG == -1) {
                        y(this, "EOF", iG, null, 4, null);
                        throw new v8.h();
                    }
                } else {
                    continue;
                    cCharAt = source.charAt(i11);
                }
            }
            z10 = true;
            i10 = iG;
            i11 = i10;
            cCharAt = source.charAt(i11);
        }
        String strJ = !z10 ? J(i10, i11) : u(i10, i11);
        this.f25411a = i11 + 1;
        return strJ;
    }

    @NotNull
    public final String s() {
        if (this.f25413c != null) {
            return K();
        }
        int I = I();
        if (I >= C().length() || I == -1) {
            y(this, "EOF", I, null, 4, null);
            throw new v8.h();
        }
        byte bA = b.a(C().charAt(I));
        if (bA == 1) {
            return q();
        }
        if (bA != 0) {
            y(this, "Expected beginning of the string, but got " + C().charAt(I), 0, null, 6, null);
            throw new v8.h();
        }
        boolean z10 = false;
        while (b.a(C().charAt(I)) == 0) {
            I++;
            if (I >= C().length()) {
                e(this.f25411a, I);
                int iG = G(I);
                if (iG == -1) {
                    this.f25411a = I;
                    return u(0, 0);
                }
                I = iG;
                z10 = true;
            }
        }
        String strJ = !z10 ? J(this.f25411a, I) : u(this.f25411a, I);
        this.f25411a = I;
        return strJ;
    }

    @NotNull
    public final String t() {
        String strS = s();
        if (!kotlin.jvm.internal.t.d(strS, "null") || !O()) {
            return strS;
        }
        y(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
        throw new v8.h();
    }

    @NotNull
    public String toString() {
        return "JsonReader(source='" + ((Object) C()) + "', currentPosition=" + this.f25411a + ')';
    }

    public final void w() {
        if (m() == 10) {
            return;
        }
        y(this, "Expected EOF after parsing, but had " + C().charAt(this.f25411a - 1) + " instead", 0, null, 6, null);
        throw new v8.h();
    }

    @NotNull
    public final Void x(@NotNull String message, int i10, @NotNull String hint) {
        String str;
        kotlin.jvm.internal.t.i(message, "message");
        kotlin.jvm.internal.t.i(hint, "hint");
        if (hint.length() == 0) {
            str = "";
        } else {
            str = '\n' + hint;
        }
        throw a0.f(i10, message + " at path: " + this.f25412b.a() + str, C());
    }

    @NotNull
    public final Void z(byte b10) {
        y(this, "Expected " + (b10 == 1 ? "quotation mark '\"'" : b10 == 4 ? "comma ','" : b10 == 5 ? "colon ':'" : b10 == 6 ? "start of the object '{'" : b10 == 7 ? "end of the object '}'" : b10 == 8 ? "start of the array '['" : b10 == 9 ? "end of the array ']'" : "valid token") + ", but had '" + ((this.f25411a == C().length() || this.f25411a <= 0) ? "EOF" : String.valueOf(C().charAt(this.f25411a - 1))) + "' instead", this.f25411a - 1, null, 4, null);
        throw new v8.h();
    }

    public void v() {
    }
}
