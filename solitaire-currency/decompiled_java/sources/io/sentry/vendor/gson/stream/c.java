package io.sentry.vendor.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JsonWriter.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String[] f28429j = new String[128];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f28430k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Writer f28431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f28432b = new int[32];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f28433c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f28435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f28436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f28437g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f28438h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f28439i;

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f28429j[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = f28429j;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f28430k = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        h0(6);
        this.f28435e = ":";
        this.f28439i = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f28431a = writer;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void I0(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f28437g
            if (r0 == 0) goto L7
            java.lang.String[] r0 = io.sentry.vendor.gson.stream.c.f28430k
            goto L9
        L7:
            java.lang.String[] r0 = io.sentry.vendor.gson.stream.c.f28429j
        L9:
            java.io.Writer r1 = r8.f28431a
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f28431a
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f28431a
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f28431a
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f28431a
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.c.I0(java.lang.String):void");
    }

    private void O() throws IOException {
        if (this.f28434d == null) {
            return;
        }
        this.f28431a.write(10);
        int i10 = this.f28433c;
        for (int i11 = 1; i11 < i10; i11++) {
            this.f28431a.write(this.f28434d);
        }
    }

    private void P0() throws IOException {
        if (this.f28438h != null) {
            a();
            I0(this.f28438h);
            this.f28438h = null;
        }
    }

    private c S(int i10, char c10) throws IOException {
        c();
        h0(i10);
        this.f28431a.write(c10);
        return this;
    }

    private int W() {
        int i10 = this.f28433c;
        if (i10 != 0) {
            return this.f28432b[i10 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void a() throws IOException {
        int iW = W();
        if (iW == 5) {
            this.f28431a.write(44);
        } else if (iW != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        O();
        i0(4);
    }

    private void c() throws IOException {
        int iW = W();
        if (iW == 1) {
            i0(2);
            O();
            return;
        }
        if (iW == 2) {
            this.f28431a.append(',');
            O();
        } else {
            if (iW == 4) {
                this.f28431a.append((CharSequence) this.f28435e);
                i0(5);
                return;
            }
            if (iW != 6) {
                if (iW != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f28436f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            i0(7);
        }
    }

    private void h0(int i10) {
        int i11 = this.f28433c;
        int[] iArr = this.f28432b;
        if (i11 == iArr.length) {
            this.f28432b = Arrays.copyOf(iArr, i11 * 2);
        }
        int[] iArr2 = this.f28432b;
        int i12 = this.f28433c;
        this.f28433c = i12 + 1;
        iArr2[i12] = i10;
    }

    private void i0(int i10) {
        this.f28432b[this.f28433c - 1] = i10;
    }

    private c q(int i10, int i11, char c10) throws IOException {
        int iW = W();
        if (iW != i11 && iW != i10) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f28438h != null) {
            throw new IllegalStateException("Dangling name: " + this.f28438h);
        }
        this.f28433c--;
        if (iW == i11) {
            O();
        }
        this.f28431a.write(c10);
        return this;
    }

    @Nullable
    public String B() {
        return this.f28434d;
    }

    public final void G0(@Nullable String str) {
        if (str == null || str.length() == 0) {
            this.f28434d = null;
            this.f28435e = ":";
        } else {
            this.f28434d = str;
            this.f28435e = ": ";
        }
    }

    public c J(@Nullable String str) throws IOException {
        if (str == null) {
            return R();
        }
        P0();
        c();
        this.f28431a.append((CharSequence) str);
        return this;
    }

    public c J0(double d10) throws IOException {
        P0();
        if (this.f28436f || !(Double.isNaN(d10) || Double.isInfinite(d10))) {
            c();
            this.f28431a.append((CharSequence) Double.toString(d10));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d10);
    }

    public c K0(long j10) throws IOException {
        P0();
        c();
        this.f28431a.write(Long.toString(j10));
        return this;
    }

    public c L(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.f28438h != null) {
            throw new IllegalStateException();
        }
        if (this.f28433c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f28438h = str;
        return this;
    }

    public c L0(@Nullable Boolean bool) throws IOException {
        if (bool == null) {
            return R();
        }
        P0();
        c();
        this.f28431a.write(bool.booleanValue() ? com.ironsource.mediationsdk.metadata.a.f13688g : "false");
        return this;
    }

    public c M0(@Nullable Number number) throws IOException {
        if (number == null) {
            return R();
        }
        P0();
        String string = number.toString();
        if (this.f28436f || !(string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            c();
            this.f28431a.append((CharSequence) string);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public c N0(@Nullable String str) throws IOException {
        if (str == null) {
            return R();
        }
        P0();
        c();
        I0(str);
        return this;
    }

    public c O0(boolean z10) throws IOException {
        P0();
        c();
        this.f28431a.write(z10 ? com.ironsource.mediationsdk.metadata.a.f13688g : "false");
        return this;
    }

    public c R() throws IOException {
        if (this.f28438h != null) {
            if (!this.f28439i) {
                this.f28438h = null;
                return this;
            }
            P0();
        }
        c();
        this.f28431a.write("null");
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f28431a.close();
        int i10 = this.f28433c;
        if (i10 > 1 || (i10 == 1 && this.f28432b[i10 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f28433c = 0;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f28433c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f28431a.flush();
    }

    public c i() throws IOException {
        P0();
        return S(1, '[');
    }

    public final void j(boolean z10) {
        this.f28436f = z10;
    }

    public c n() throws IOException {
        P0();
        return S(3, '{');
    }

    public c x() throws IOException {
        return q(1, 2, ']');
    }

    public c z() throws IOException {
        return q(3, 5, '}');
    }
}
