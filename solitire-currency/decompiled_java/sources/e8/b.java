package e8;

import com.ironsource.nb;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.a1;
import kotlin.collections.z0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Codecs.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Set<Byte> f25184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Set<Character> f25185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Set<Character> f25186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final List<Byte> f25187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Set<Character> f25188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Set<Character> f25189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final List<Byte> f25190g;

    /* JADX INFO: compiled from: Codecs.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.l<Byte, v8.k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ StringBuilder f25191g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f25192h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(StringBuilder sb, boolean z10) {
            super(1);
            this.f25191g = sb;
            this.f25192h = z10;
        }

        public final void a(byte b10) {
            if (b.f25184a.contains(Byte.valueOf(b10)) || b.f25190g.contains(Byte.valueOf(b10))) {
                this.f25191g.append((char) b10);
            } else if (this.f25192h && b10 == 32) {
                this.f25191g.append('+');
            } else {
                this.f25191g.append(b.u(b10));
            }
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(Byte b10) {
            a(b10.byteValue());
            return v8.k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: e8.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Codecs.kt */
    static final class C0548b extends kotlin.jvm.internal.v implements h9.l<Byte, v8.k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ StringBuilder f25193g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0548b(StringBuilder sb) {
            super(1);
            this.f25193g = sb;
        }

        public final void a(byte b10) {
            this.f25193g.append(b.u(b10));
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(Byte b10) {
            a(b10.byteValue());
            return v8.k0.f35197a;
        }
    }

    /* JADX INFO: compiled from: Codecs.kt */
    static final class c extends kotlin.jvm.internal.v implements h9.l<Byte, v8.k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f25194g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ StringBuilder f25195h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f25196i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(boolean z10, StringBuilder sb, boolean z11) {
            super(1);
            this.f25194g = z10;
            this.f25195h = sb;
            this.f25196i = z11;
        }

        public final void a(byte b10) {
            if (b10 == 32) {
                if (this.f25194g) {
                    this.f25195h.append('+');
                    return;
                } else {
                    this.f25195h.append("%20");
                    return;
                }
            }
            if (b.f25184a.contains(Byte.valueOf(b10)) || (!this.f25196i && b.f25187d.contains(Byte.valueOf(b10)))) {
                this.f25195h.append((char) b10);
            } else {
                this.f25195h.append(b.u(b10));
            }
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(Byte b10) {
            a(b10.byteValue());
            return v8.k0.f35197a;
        }
    }

    static {
        List listA0 = kotlin.collections.d0.A0(kotlin.collections.d0.z0(new n9.c('a', 'z'), new n9.c('A', 'Z')), new n9.c('0', '9'));
        ArrayList arrayList = new ArrayList(kotlin.collections.w.v(listA0, 10));
        Iterator it = listA0.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf((byte) ((Character) it.next()).charValue()));
        }
        f25184a = kotlin.collections.d0.T0(arrayList);
        f25185b = kotlin.collections.d0.T0(kotlin.collections.d0.A0(kotlin.collections.d0.z0(new n9.c('a', 'z'), new n9.c('A', 'Z')), new n9.c('0', '9')));
        f25186c = kotlin.collections.d0.T0(kotlin.collections.d0.A0(kotlin.collections.d0.z0(new n9.c('a', 'f'), new n9.c('A', 'F')), new n9.c('0', '9')));
        Set setH = z0.h(':', '/', '?', '#', '[', ']', '@', '!', '$', '&', '\'', '(', ')', '*', ',', ';', Character.valueOf(nb.T), '-', '.', '_', '~', '+');
        ArrayList arrayList2 = new ArrayList(kotlin.collections.w.v(setH, 10));
        Iterator it2 = setH.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Byte.valueOf((byte) ((Character) it2.next()).charValue()));
        }
        f25187d = arrayList2;
        f25188e = z0.h(':', '@', '!', '$', '&', '\'', '(', ')', '*', '+', ',', ';', Character.valueOf(nb.T), '-', '.', '_', '~');
        f25189f = a1.j(f25185b, z0.h('!', '#', '$', '&', '+', '-', '.', '^', '_', '`', '|', '~'));
        List listN = kotlin.collections.v.n('-', '.', '_', '~');
        ArrayList arrayList3 = new ArrayList(kotlin.collections.w.v(listN, 10));
        Iterator it3 = listN.iterator();
        while (it3.hasNext()) {
            arrayList3.add(Byte.valueOf((byte) ((Character) it3.next()).charValue()));
        }
        f25190g = arrayList3;
    }

    private static final int e(char c10) {
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        char c11 = 'A';
        if (!('A' <= c10 && c10 < 'G')) {
            c11 = 'a';
            if (!('a' <= c10 && c10 < 'g')) {
                return -1;
            }
        }
        return (c10 - c11) + 10;
    }

    private static final String f(CharSequence charSequence, int i10, int i11, int i12, boolean z10, Charset charset) throws i0 {
        int i13 = i11 - i10;
        if (i13 > 255) {
            i13 /= 3;
        }
        StringBuilder sb = new StringBuilder(i13);
        if (i12 > i10) {
            sb.append(charSequence, i10, i12);
        }
        byte[] bArr = null;
        while (i12 < i11) {
            char cCharAt = charSequence.charAt(i12);
            if (z10 && cCharAt == '+') {
                sb.append(' ');
            } else if (cCharAt == '%') {
                if (bArr == null) {
                    bArr = new byte[(i11 - i12) / 3];
                }
                int i14 = 0;
                while (i12 < i11 && charSequence.charAt(i12) == '%') {
                    int i15 = i12 + 2;
                    if (i15 >= i11) {
                        throw new i0("Incomplete trailing HEX escape: " + charSequence.subSequence(i12, charSequence.length()).toString() + ", in " + ((Object) charSequence) + " at " + i12);
                    }
                    int i16 = i12 + 1;
                    int iE = e(charSequence.charAt(i16));
                    int iE2 = e(charSequence.charAt(i15));
                    if (iE == -1 || iE2 == -1) {
                        throw new i0("Wrong HEX escape: %" + charSequence.charAt(i16) + charSequence.charAt(i15) + ", in " + ((Object) charSequence) + ", at " + i12);
                    }
                    bArr[i14] = (byte) ((iE * 16) + iE2);
                    i12 += 3;
                    i14++;
                }
                sb.append(new String(bArr, 0, i14, charset));
            } else {
                sb.append(cCharAt);
            }
            i12++;
        }
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "sb.toString()");
        return string;
    }

    private static final String g(String str, int i10, int i11, boolean z10, Charset charset) {
        for (int i12 = i10; i12 < i11; i12++) {
            char cCharAt = str.charAt(i12);
            if (cCharAt == '%' || (z10 && cCharAt == '+')) {
                return f(str, i10, i11, i12, z10, charset);
            }
        }
        if (i10 == 0 && i11 == str.length()) {
            return str;
        }
        String strSubstring = str.substring(i10, i11);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @NotNull
    public static final String h(@NotNull String str, int i10, int i11, @NotNull Charset charset) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(charset, "charset");
        return g(str, i10, i11, false, charset);
    }

    public static /* synthetic */ String i(String str, int i10, int i11, Charset charset, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            charset = p9.d.f32952b;
        }
        return h(str, i10, i11, charset);
    }

    @NotNull
    public static final String j(@NotNull String str, int i10, int i11, boolean z10, @NotNull Charset charset) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(charset, "charset");
        return g(str, i10, i11, z10, charset);
    }

    public static /* synthetic */ String k(String str, int i10, int i11, boolean z10, Charset charset, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            charset = p9.d.f32952b;
        }
        return j(str, i10, i11, z10, charset);
    }

    @NotNull
    public static final String l(@NotNull String str, boolean z10) throws Throwable {
        kotlin.jvm.internal.t.i(str, "<this>");
        StringBuilder sb = new StringBuilder();
        CharsetEncoder charsetEncoderNewEncoder = p9.d.f32952b.newEncoder();
        kotlin.jvm.internal.t.h(charsetEncoderNewEncoder, "UTF_8.newEncoder()");
        s(o8.b.d(charsetEncoderNewEncoder, str, 0, 0, 6, null), new a(sb, z10));
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String m(String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return l(str, z10);
    }

    @NotNull
    public static final String n(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        return l(str, true);
    }

    @NotNull
    public static final String o(@NotNull String str, boolean z10) throws Throwable {
        int i10;
        kotlin.jvm.internal.t.i(str, "<this>");
        StringBuilder sb = new StringBuilder();
        Charset charset = p9.d.f32952b;
        int i11 = 0;
        while (i11 < str.length()) {
            char cCharAt = str.charAt(i11);
            if ((!z10 && cCharAt == '/') || f25185b.contains(Character.valueOf(cCharAt)) || f25188e.contains(Character.valueOf(cCharAt))) {
                sb.append(cCharAt);
                i11++;
            } else {
                if (cCharAt == '%' && (i10 = i11 + 2) < str.length()) {
                    Set<Character> set = f25186c;
                    int i12 = i11 + 1;
                    if (set.contains(Character.valueOf(str.charAt(i12))) && set.contains(Character.valueOf(str.charAt(i10)))) {
                        sb.append(cCharAt);
                        sb.append(str.charAt(i12));
                        sb.append(str.charAt(i10));
                        i11 += 3;
                    }
                }
                int i13 = p9.c.h(cCharAt) ? 2 : 1;
                CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
                kotlin.jvm.internal.t.h(charsetEncoderNewEncoder, "charset.newEncoder()");
                int i14 = i13 + i11;
                s(o8.b.c(charsetEncoderNewEncoder, str, i11, i14), new C0548b(sb));
                i11 = i14;
            }
        }
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @NotNull
    public static final String p(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        return o(str, true);
    }

    @NotNull
    public static final String q(@NotNull String str, boolean z10, boolean z11, @NotNull Charset charset) throws Throwable {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(charset, "charset");
        StringBuilder sb = new StringBuilder();
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        kotlin.jvm.internal.t.h(charsetEncoderNewEncoder, "charset.newEncoder()");
        s(o8.b.d(charsetEncoderNewEncoder, str, 0, 0, 6, null), new c(z11, sb, z10));
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String r(String str, boolean z10, boolean z11, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        if ((i10 & 4) != 0) {
            charset = p9.d.f32952b;
        }
        return q(str, z10, z11, charset);
    }

    private static final void s(p8.j jVar, h9.l<? super Byte, v8.k0> lVar) throws Throwable {
        boolean z10 = true;
        q8.a aVarB = q8.g.b(jVar, 1);
        if (aVarB == null) {
            return;
        }
        while (true) {
            try {
                if (aVarB.j() > aVarB.h()) {
                    lVar.invoke(Byte.valueOf(aVarB.k()));
                } else {
                    try {
                        aVarB = q8.g.c(jVar, aVarB);
                        if (aVarB == null) {
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        z10 = false;
                        if (z10) {
                            q8.g.a(jVar, aVarB);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private static final char t(int i10) {
        boolean z10 = false;
        if (i10 >= 0 && i10 < 10) {
            z10 = true;
        }
        return (char) (z10 ? i10 + 48 : ((char) (i10 + 65)) - '\n');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String u(byte b10) {
        int i10 = b10 & 255;
        return p9.q.p(new char[]{'%', t(i10 >> 4), t(i10 & 15)});
    }
}
