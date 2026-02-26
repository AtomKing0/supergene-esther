package ha;

import ga.c0;
import ga.e0;
import ga.r;
import ga.u;
import ga.v;
import ga.z;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.collections.d0;
import kotlin.collections.l0;
import kotlin.collections.p;
import kotlin.collections.r0;
import kotlin.collections.w;
import kotlin.jvm.internal.s0;
import kotlin.jvm.internal.t;
import n9.i;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.f;
import p9.q;
import p9.r;
import ua.e;
import ua.f;
import ua.n0;
import ua.x0;
import ua.z0;
import v8.k0;

/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final byte[] f26508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final u f26509b = u.f26213b.g(new String[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final e0 f26510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final c0 f26511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final n0 f26512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final TimeZone f26513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final f f26514g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f26515h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public static final String f26516i;

    static {
        byte[] bArr = new byte[0];
        f26508a = bArr;
        f26510c = e0.b.i(e0.Companion, bArr, null, 1, null);
        f26511d = c0.a.o(c0.Companion, bArr, null, 0, 0, 7, null);
        n0.a aVar = n0.f34787c;
        f.a aVar2 = ua.f.f34755d;
        f26512e = aVar.d(aVar2.b("efbbbf"), aVar2.b("feff"), aVar2.b("fffe"), aVar2.b("0000ffff"), aVar2.b("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        t.f(timeZone);
        f26513f = timeZone;
        f26514g = new p9.f("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        f26515h = false;
        String name = z.class.getName();
        t.h(name, "OkHttpClient::class.java.name");
        f26516i = r.w0(r.v0(name, "okhttp3."), "Client");
    }

    public static /* synthetic */ int A(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return z(str, i10, i11);
    }

    public static final int B(@NotNull String str, int i10, int i11) {
        t.i(str, "<this>");
        int i12 = i11 - 1;
        if (i10 <= i12) {
            while (true) {
                int i13 = i12 - 1;
                char cCharAt = str.charAt(i12);
                if (!((((cCharAt == '\t' || cCharAt == '\n') || cCharAt == '\f') || cCharAt == '\r') || cCharAt == ' ')) {
                    return i12 + 1;
                }
                if (i12 == i10) {
                    break;
                }
                i12 = i13;
            }
        }
        return i10;
    }

    public static /* synthetic */ int C(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return B(str, i10, i11);
    }

    public static final int D(@NotNull String str, int i10) {
        t.i(str, "<this>");
        int length = str.length();
        while (i10 < length) {
            int i11 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i10;
            }
            i10 = i11;
        }
        return str.length();
    }

    @NotNull
    public static final String[] E(@NotNull String[] strArr, @NotNull String[] other, @NotNull Comparator<? super String> comparator) {
        t.i(strArr, "<this>");
        t.i(other, "other");
        t.i(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i10 = 0;
        while (i10 < length) {
            String str = strArr[i10];
            i10++;
            int length2 = other.length;
            int i11 = 0;
            while (true) {
                if (i11 < length2) {
                    String str2 = other[i11];
                    i11++;
                    if (comparator.compare(str, str2) == 0) {
                        arrayList.add(str);
                        break;
                    }
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final boolean F(@NotNull pa.a aVar, @NotNull File file) throws IOException {
        t.i(aVar, "<this>");
        t.i(file, "file");
        x0 x0VarF = aVar.f(file);
        try {
            try {
                aVar.h(file);
                f9.c.a(x0VarF, null);
                return true;
            } catch (IOException unused) {
                k0 k0Var = k0.f35197a;
                f9.c.a(x0VarF, null);
                aVar.h(file);
                return false;
            }
        } finally {
        }
    }

    public static final boolean G(@NotNull Socket socket, @NotNull e source) {
        t.i(socket, "<this>");
        t.i(source, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                boolean z10 = !source.m0();
                socket.setSoTimeout(soTimeout);
                return z10;
            } catch (Throwable th) {
                socket.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final boolean H(@NotNull String name) {
        t.i(name, "name");
        return q.x(name, "Authorization", true) || q.x(name, "Cookie", true) || q.x(name, "Proxy-Authorization", true) || q.x(name, "Set-Cookie", true);
    }

    public static final int I(char c10) {
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        char c11 = 'a';
        if (!('a' <= c10 && c10 < 'g')) {
            c11 = 'A';
            if (!('A' <= c10 && c10 < 'G')) {
                return -1;
            }
        }
        return (c10 - c11) + 10;
    }

    @NotNull
    public static final Charset J(@NotNull e eVar, @NotNull Charset charset) throws IOException {
        t.i(eVar, "<this>");
        t.i(charset, "default");
        int iX = eVar.X(f26512e);
        if (iX == -1) {
            return charset;
        }
        if (iX == 0) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            t.h(UTF_8, "UTF_8");
            return UTF_8;
        }
        if (iX == 1) {
            Charset UTF_16BE = StandardCharsets.UTF_16BE;
            t.h(UTF_16BE, "UTF_16BE");
            return UTF_16BE;
        }
        if (iX == 2) {
            Charset UTF_16LE = StandardCharsets.UTF_16LE;
            t.h(UTF_16LE, "UTF_16LE");
            return UTF_16LE;
        }
        if (iX == 3) {
            return p9.d.f32951a.a();
        }
        if (iX == 4) {
            return p9.d.f32951a.b();
        }
        throw new AssertionError();
    }

    public static final int K(@NotNull e eVar) throws IOException {
        t.i(eVar, "<this>");
        return d(eVar.readByte(), 255) | (d(eVar.readByte(), 255) << 16) | (d(eVar.readByte(), 255) << 8);
    }

    public static final int L(@NotNull ua.c cVar, byte b10) throws EOFException {
        t.i(cVar, "<this>");
        int i10 = 0;
        while (!cVar.m0() && cVar.L(0L) == b10) {
            i10++;
            cVar.readByte();
        }
        return i10;
    }

    public static final boolean M(@NotNull z0 z0Var, int i10, @NotNull TimeUnit timeUnit) throws IOException {
        t.i(z0Var, "<this>");
        t.i(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jC = z0Var.timeout().e() ? z0Var.timeout().c() - jNanoTime : Long.MAX_VALUE;
        z0Var.timeout().d(Math.min(jC, timeUnit.toNanos(i10)) + jNanoTime);
        try {
            ua.c cVar = new ua.c();
            while (z0Var.read(cVar, 8192L) != -1) {
                cVar.c();
            }
            if (jC == Long.MAX_VALUE) {
                z0Var.timeout().a();
            } else {
                z0Var.timeout().d(jNanoTime + jC);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                z0Var.timeout().a();
            } else {
                z0Var.timeout().d(jNanoTime + jC);
            }
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                z0Var.timeout().a();
            } else {
                z0Var.timeout().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    @NotNull
    public static final ThreadFactory N(@NotNull final String name, final boolean z10) {
        t.i(name, "name");
        return new ThreadFactory() { // from class: ha.b
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return d.O(name, z10, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread O(String name, boolean z10, Runnable runnable) {
        t.i(name, "$name");
        Thread thread = new Thread(runnable, name);
        thread.setDaemon(z10);
        return thread;
    }

    @NotNull
    public static final List<oa.c> P(@NotNull u uVar) {
        t.i(uVar, "<this>");
        i iVarU = o.u(0, uVar.size());
        ArrayList arrayList = new ArrayList(w.v(iVarU, 10));
        Iterator<Integer> it = iVarU.iterator();
        while (it.hasNext()) {
            int iNextInt = ((l0) it).nextInt();
            arrayList.add(new oa.c(uVar.e(iNextInt), uVar.i(iNextInt)));
        }
        return arrayList;
    }

    @NotNull
    public static final u Q(@NotNull List<oa.c> list) {
        t.i(list, "<this>");
        u.a aVar = new u.a();
        for (oa.c cVar : list) {
            aVar.d(cVar.a().G(), cVar.b().G());
        }
        return aVar.f();
    }

    @NotNull
    public static final String R(@NotNull v vVar, boolean z10) {
        String strI;
        t.i(vVar, "<this>");
        if (r.P(vVar.i(), ":", false, 2, null)) {
            strI = '[' + vVar.i() + ']';
        } else {
            strI = vVar.i();
        }
        if (!z10 && vVar.n() == v.f26216k.c(vVar.r())) {
            return strI;
        }
        return strI + ':' + vVar.n();
    }

    public static /* synthetic */ String S(v vVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return R(vVar, z10);
    }

    @NotNull
    public static final <T> List<T> T(@NotNull List<? extends T> list) {
        t.i(list, "<this>");
        List<T> listUnmodifiableList = Collections.unmodifiableList(d0.R0(list));
        t.h(listUnmodifiableList, "unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    @NotNull
    public static final <K, V> Map<K, V> U(@NotNull Map<K, ? extends V> map) {
        t.i(map, "<this>");
        if (map.isEmpty()) {
            return r0.g();
        }
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        t.h(mapUnmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return mapUnmodifiableMap;
    }

    public static final long V(@NotNull String str, long j10) {
        t.i(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j10;
        }
    }

    public static final int W(@Nullable String str, int i10) {
        Long lValueOf;
        if (str == null) {
            lValueOf = null;
        } else {
            try {
                lValueOf = Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                return i10;
            }
        }
        if (lValueOf == null) {
            return i10;
        }
        long jLongValue = lValueOf.longValue();
        if (jLongValue > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (jLongValue < 0) {
            return 0;
        }
        return (int) jLongValue;
    }

    @NotNull
    public static final String X(@NotNull String str, int i10, int i11) {
        t.i(str, "<this>");
        int iZ = z(str, i10, i11);
        String strSubstring = str.substring(iZ, B(str, iZ, i11));
        t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String Y(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return X(str, i10, i11);
    }

    @NotNull
    public static final Throwable Z(@NotNull Exception exc, @NotNull List<? extends Exception> suppressed) {
        t.i(exc, "<this>");
        t.i(suppressed, "suppressed");
        if (suppressed.size() > 1) {
            System.out.println(suppressed);
        }
        Iterator<? extends Exception> it = suppressed.iterator();
        while (it.hasNext()) {
            v8.f.a(exc, it.next());
        }
        return exc;
    }

    public static final void a0(@NotNull ua.d dVar, int i10) throws IOException {
        t.i(dVar, "<this>");
        dVar.writeByte((i10 >>> 16) & 255);
        dVar.writeByte((i10 >>> 8) & 255);
        dVar.writeByte(i10 & 255);
    }

    public static final <E> void c(@NotNull List<E> list, E e10) {
        t.i(list, "<this>");
        if (list.contains(e10)) {
            return;
        }
        list.add(e10);
    }

    public static final int d(byte b10, int i10) {
        return b10 & i10;
    }

    public static final int e(short s10, int i10) {
        return s10 & i10;
    }

    public static final long f(int i10, long j10) {
        return ((long) i10) & j10;
    }

    @NotNull
    public static final r.c g(@NotNull final ga.r rVar) {
        t.i(rVar, "<this>");
        return new r.c() { // from class: ha.c
            @Override // ga.r.c
            public final ga.r a(ga.e eVar) {
                return d.h(rVar, eVar);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ga.r h(ga.r this_asFactory, ga.e it) {
        t.i(this_asFactory, "$this_asFactory");
        t.i(it, "it");
        return this_asFactory;
    }

    public static final boolean i(@NotNull String str) {
        t.i(str, "<this>");
        return f26514g.a(str);
    }

    public static final boolean j(@NotNull v vVar, @NotNull v other) {
        t.i(vVar, "<this>");
        t.i(other, "other");
        return t.d(vVar.i(), other.i()) && vVar.n() == other.n() && t.d(vVar.r(), other.r());
    }

    public static final int k(@NotNull String name, long j10, @Nullable TimeUnit timeUnit) {
        t.i(name, "name");
        boolean z10 = true;
        if (!(j10 >= 0)) {
            throw new IllegalStateException(t.r(name, " < 0").toString());
        }
        if (!(timeUnit != null)) {
            throw new IllegalStateException("unit == null".toString());
        }
        long millis = timeUnit.toMillis(j10);
        if (!(millis <= 2147483647L)) {
            throw new IllegalArgumentException(t.r(name, " too large.").toString());
        }
        if (millis == 0 && j10 > 0) {
            z10 = false;
        }
        if (z10) {
            return (int) millis;
        }
        throw new IllegalArgumentException(t.r(name, " too small.").toString());
    }

    public static final void l(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void m(@NotNull Closeable closeable) {
        t.i(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final void n(@NotNull Socket socket) {
        t.i(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e10) {
            throw e10;
        } catch (RuntimeException e11) {
            if (!t.d(e11.getMessage(), "bio == null")) {
                throw e11;
            }
        } catch (Exception unused) {
        }
    }

    @NotNull
    public static final String[] o(@NotNull String[] strArr, @NotNull String value) {
        t.i(strArr, "<this>");
        t.i(value, "value");
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length + 1);
        t.h(objArrCopyOf, "copyOf(this, newSize)");
        String[] strArr2 = (String[]) objArrCopyOf;
        strArr2[p.S(strArr2)] = value;
        return strArr2;
    }

    public static final int p(@NotNull String str, char c10, int i10, int i11) {
        t.i(str, "<this>");
        while (i10 < i11) {
            int i12 = i10 + 1;
            if (str.charAt(i10) == c10) {
                return i10;
            }
            i10 = i12;
        }
        return i11;
    }

    public static final int q(@NotNull String str, @NotNull String delimiters, int i10, int i11) {
        t.i(str, "<this>");
        t.i(delimiters, "delimiters");
        while (i10 < i11) {
            int i12 = i10 + 1;
            if (p9.r.O(delimiters, str.charAt(i10), false, 2, null)) {
                return i10;
            }
            i10 = i12;
        }
        return i11;
    }

    public static /* synthetic */ int r(String str, char c10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = str.length();
        }
        return p(str, c10, i10, i11);
    }

    public static final boolean s(@NotNull z0 z0Var, int i10, @NotNull TimeUnit timeUnit) {
        t.i(z0Var, "<this>");
        t.i(timeUnit, "timeUnit");
        try {
            return M(z0Var, i10, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    @NotNull
    public static final String t(@NotNull String format, @NotNull Object... args) {
        t.i(format, "format");
        t.i(args, "args");
        s0 s0Var = s0.f29840a;
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
        String str = String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        t.h(str, "format(locale, format, *args)");
        return str;
    }

    public static final boolean u(@NotNull String[] strArr, @Nullable String[] strArr2, @NotNull Comparator<? super String> comparator) {
        t.i(strArr, "<this>");
        t.i(comparator, "comparator");
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                int length = strArr.length;
                int i10 = 0;
                while (i10 < length) {
                    String str = strArr[i10];
                    i10++;
                    Iterator itA = kotlin.jvm.internal.c.a(strArr2);
                    while (itA.hasNext()) {
                        if (comparator.compare(str, (String) itA.next()) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long v(@NotNull ga.d0 d0Var) {
        t.i(d0Var, "<this>");
        String strA = d0Var.L().a("Content-Length");
        if (strA == null) {
            return -1L;
        }
        return V(strA, -1L);
    }

    @SafeVarargs
    @NotNull
    public static final <T> List<T> w(@NotNull T... elements) {
        t.i(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List<T> listUnmodifiableList = Collections.unmodifiableList(kotlin.collections.v.n(Arrays.copyOf(objArr, objArr.length)));
        t.h(listUnmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int x(@NotNull String[] strArr, @NotNull String value, @NotNull Comparator<String> comparator) {
        t.i(strArr, "<this>");
        t.i(value, "value");
        t.i(comparator, "comparator");
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (comparator.compare(strArr[i10], value) == 0) {
                return i10;
            }
        }
        return -1;
    }

    public static final int y(@NotNull String str) {
        t.i(str, "<this>");
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (t.k(cCharAt, 31) <= 0 || t.k(cCharAt, 127) >= 0) {
                return i10;
            }
            i10 = i11;
        }
        return -1;
    }

    public static final int z(@NotNull String str, int i10, int i11) {
        t.i(str, "<this>");
        while (i10 < i11) {
            int i12 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (!((((cCharAt == '\t' || cCharAt == '\n') || cCharAt == '\f') || cCharAt == '\r') || cCharAt == ' ')) {
                return i10;
            }
            i10 = i12;
        }
        return i11;
    }
}
