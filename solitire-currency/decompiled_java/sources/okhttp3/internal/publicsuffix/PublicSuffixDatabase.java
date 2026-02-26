package okhttp3.internal.publicsuffix;

import androidx.webkit.ProxyConfig;
import f9.c;
import ha.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.d0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import o9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.r;
import qa.j;
import ua.e;
import ua.k0;
import ua.p;

/* JADX INFO: compiled from: PublicSuffixDatabase.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class PublicSuffixDatabase {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f32306e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final byte[] f32307f = {42};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final List<String> f32308g = u.e(ProxyConfig.MATCH_ALL_SCHEMES);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private static final PublicSuffixDatabase f32309h = new PublicSuffixDatabase();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final AtomicBoolean f32310a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final CountDownLatch f32311b = new CountDownLatch(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f32312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f32313d;

    /* JADX INFO: compiled from: PublicSuffixDatabase.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(byte[] bArr, byte[][] bArr2, int i10) {
            int i11;
            boolean z10;
            int iD;
            int iD2;
            int length = bArr.length;
            int i12 = 0;
            while (i12 < length) {
                int i13 = (i12 + length) / 2;
                while (i13 > -1 && bArr[i13] != 10) {
                    i13--;
                }
                int i14 = i13 + 1;
                int i15 = 1;
                while (true) {
                    i11 = i14 + i15;
                    if (bArr[i11] == 10) {
                        break;
                    }
                    i15++;
                }
                int i16 = i11 - i14;
                int i17 = i10;
                boolean z11 = false;
                int i18 = 0;
                int i19 = 0;
                while (true) {
                    if (z11) {
                        iD = 46;
                        z10 = false;
                    } else {
                        z10 = z11;
                        iD = d.d(bArr2[i17][i18], 255);
                    }
                    iD2 = iD - d.d(bArr[i14 + i19], 255);
                    if (iD2 != 0) {
                        break;
                    }
                    i19++;
                    i18++;
                    if (i19 == i16) {
                        break;
                    }
                    if (bArr2[i17].length != i18) {
                        z11 = z10;
                    } else {
                        if (i17 == bArr2.length - 1) {
                            break;
                        }
                        i17++;
                        i18 = -1;
                        z11 = true;
                    }
                }
                if (iD2 >= 0) {
                    if (iD2 <= 0) {
                        int i20 = i16 - i19;
                        int length2 = bArr2[i17].length - i18;
                        int length3 = bArr2.length;
                        for (int i21 = i17 + 1; i21 < length3; i21++) {
                            length2 += bArr2[i21].length;
                        }
                        if (length2 >= i20) {
                            if (length2 <= i20) {
                                Charset UTF_8 = StandardCharsets.UTF_8;
                                t.h(UTF_8, "UTF_8");
                                return new String(bArr, i14, i16, UTF_8);
                            }
                        }
                    }
                    i12 = i11 + 1;
                }
                length = i14 - 1;
            }
            return null;
        }

        @NotNull
        public final PublicSuffixDatabase c() {
            return PublicSuffixDatabase.f32309h;
        }
    }

    private final List<String> b(List<String> list) {
        String str;
        String str2;
        String strB;
        if (this.f32310a.get() || !this.f32310a.compareAndSet(false, true)) {
            try {
                this.f32311b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            e();
        }
        if (!(this.f32312c != null)) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        }
        int size = list.size();
        byte[][] bArr = new byte[size][];
        for (int i10 = 0; i10 < size; i10++) {
            String str3 = list.get(i10);
            Charset UTF_8 = StandardCharsets.UTF_8;
            t.h(UTF_8, "UTF_8");
            byte[] bytes = str3.getBytes(UTF_8);
            t.h(bytes, "this as java.lang.String).getBytes(charset)");
            bArr[i10] = bytes;
        }
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                str = null;
                break;
            }
            int i12 = i11 + 1;
            a aVar = f32306e;
            byte[] bArr2 = this.f32312c;
            if (bArr2 == null) {
                t.A("publicSuffixListBytes");
                bArr2 = null;
            }
            String strB2 = aVar.b(bArr2, bArr, i11);
            if (strB2 != null) {
                str = strB2;
                break;
            }
            i11 = i12;
        }
        if (size > 1) {
            byte[][] bArr3 = (byte[][]) bArr.clone();
            int length = bArr3.length - 1;
            int i13 = 0;
            while (i13 < length) {
                int i14 = i13 + 1;
                bArr3[i13] = f32307f;
                a aVar2 = f32306e;
                byte[] bArr4 = this.f32312c;
                if (bArr4 == null) {
                    t.A("publicSuffixListBytes");
                    bArr4 = null;
                }
                String strB3 = aVar2.b(bArr4, bArr3, i13);
                if (strB3 != null) {
                    str2 = strB3;
                    break;
                }
                i13 = i14;
            }
            str2 = null;
        } else {
            str2 = null;
        }
        if (str2 != null) {
            int i15 = size - 1;
            int i16 = 0;
            while (i16 < i15) {
                int i17 = i16 + 1;
                a aVar3 = f32306e;
                byte[] bArr5 = this.f32313d;
                if (bArr5 == null) {
                    t.A("publicSuffixExceptionListBytes");
                    bArr5 = null;
                }
                strB = aVar3.b(bArr5, bArr, i16);
                if (strB != null) {
                    break;
                }
                i16 = i17;
            }
            strB = null;
        } else {
            strB = null;
        }
        if (strB != null) {
            return r.B0(t.r("!", strB), new char[]{'.'}, false, 0, 6, null);
        }
        if (str == null && str2 == null) {
            return f32308g;
        }
        List<String> listB0 = str == null ? null : r.B0(str, new char[]{'.'}, false, 0, 6, null);
        if (listB0 == null) {
            listB0 = v.l();
        }
        List<String> listB02 = str2 != null ? r.B0(str2, new char[]{'.'}, false, 0, 6, null) : null;
        if (listB02 == null) {
            listB02 = v.l();
        }
        return listB0.size() > listB02.size() ? listB0 : listB02;
    }

    private final void d() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        e eVarD = k0.d(new p(k0.l(resourceAsStream)));
        try {
            byte[] bArrP = eVarD.P(eVarD.readInt());
            byte[] bArrP2 = eVarD.P(eVarD.readInt());
            v8.k0 k0Var = v8.k0.f35197a;
            c.a(eVarD, null);
            synchronized (this) {
                t.f(bArrP);
                this.f32312c = bArrP;
                t.f(bArrP2);
                this.f32313d = bArrP2;
            }
            this.f32311b.countDown();
        } finally {
        }
    }

    private final void e() {
        boolean z10 = false;
        while (true) {
            try {
                try {
                    d();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z10 = true;
                } catch (IOException e10) {
                    j.f33228a.g().k("Failed to read public suffix list", 5, e10);
                    if (z10) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    private final List<String> f(String str) {
        List<String> listB0 = r.B0(str, new char[]{'.'}, false, 0, 6, null);
        return t.d(d0.t0(listB0), "") ? d0.e0(listB0, 1) : listB0;
    }

    @Nullable
    public final String c(@NotNull String domain) {
        int size;
        int size2;
        t.i(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        t.h(unicodeDomain, "unicodeDomain");
        List<String> listF = f(unicodeDomain);
        List<String> listB = b(listF);
        if (listF.size() == listB.size() && listB.get(0).charAt(0) != '!') {
            return null;
        }
        if (listB.get(0).charAt(0) == '!') {
            size = listF.size();
            size2 = listB.size();
        } else {
            size = listF.size();
            size2 = listB.size() + 1;
        }
        return o.q(o.j(d0.a0(f(domain)), size - size2), ".", null, null, 0, null, null, 62, null);
    }
}
