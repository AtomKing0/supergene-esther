package ea;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StringJsonLexer.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class u0 extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final String f25499e;

    public u0(@NotNull String source) {
        kotlin.jvm.internal.t.i(source, "source");
        this.f25499e = source;
    }

    @Override // ea.a
    public int G(int i10) {
        if (i10 < C().length()) {
            return i10;
        }
        return -1;
    }

    @Override // ea.a
    public int I() {
        char cCharAt;
        int i10 = this.f25411a;
        if (i10 == -1) {
            return i10;
        }
        while (i10 < C().length() && ((cCharAt = C().charAt(i10)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
            i10++;
        }
        this.f25411a = i10;
        return i10;
    }

    @Override // ea.a
    public boolean L() {
        int I = I();
        if (I == C().length() || I == -1 || C().charAt(I) != ',') {
            return false;
        }
        this.f25411a++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ea.a
    @NotNull
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public String C() {
        return this.f25499e;
    }

    @Override // ea.a
    public boolean f() {
        int i10 = this.f25411a;
        if (i10 == -1) {
            return false;
        }
        while (i10 < C().length()) {
            char cCharAt = C().charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f25411a = i10;
                return D(cCharAt);
            }
            i10++;
        }
        this.f25411a = i10;
        return false;
    }

    @Override // ea.a
    @NotNull
    public String k() {
        o('\"');
        int i10 = this.f25411a;
        int iD0 = p9.r.d0(C(), '\"', i10, false, 4, null);
        if (iD0 == -1) {
            z((byte) 1);
            throw new v8.h();
        }
        for (int i11 = i10; i11 < iD0; i11++) {
            if (C().charAt(i11) == '\\') {
                return r(C(), this.f25411a, i11);
            }
        }
        this.f25411a = iD0 + 1;
        String strSubstring = C().substring(i10, iD0);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @Override // ea.a
    @Nullable
    public String l(@NotNull String keyToMatch, boolean z10) {
        kotlin.jvm.internal.t.i(keyToMatch, "keyToMatch");
        int i10 = this.f25411a;
        try {
            if (m() != 6) {
                return null;
            }
            if (!kotlin.jvm.internal.t.d(z10 ? k() : t(), keyToMatch)) {
                return null;
            }
            if (m() != 5) {
                return null;
            }
            return z10 ? q() : t();
        } finally {
            this.f25411a = i10;
        }
    }

    @Override // ea.a
    public byte m() {
        byte bA;
        String strC = C();
        do {
            int i10 = this.f25411a;
            if (i10 == -1 || i10 >= strC.length()) {
                return (byte) 10;
            }
            int i11 = this.f25411a;
            this.f25411a = i11 + 1;
            bA = b.a(strC.charAt(i11));
        } while (bA == 3);
        return bA;
    }

    @Override // ea.a
    public void o(char c10) {
        if (this.f25411a == -1) {
            N(c10);
        }
        String strC = C();
        while (this.f25411a < strC.length()) {
            int i10 = this.f25411a;
            this.f25411a = i10 + 1;
            char cCharAt = strC.charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                if (cCharAt == c10) {
                    return;
                } else {
                    N(c10);
                }
            }
        }
        N(c10);
    }
}
