package o2;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ironsource.nb;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import o2.g0;
import z3.k;
import z3.o;

/* JADX INFO: compiled from: HttpMediaDrmCallback.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l0 implements n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k.a f31911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f31912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f31913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, String> f31914d;

    public l0(@Nullable String str, boolean z10, k.a aVar) {
        a4.a.a((z10 && TextUtils.isEmpty(str)) ? false : true);
        this.f31911a = aVar;
        this.f31912b = str;
        this.f31913c = z10;
        this.f31914d = new HashMap();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(4:9|21|10|(2:12|13)(2:26|15)) */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
    
        r1 = d(r11, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
    
        if (r1 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
    
        r8 = r8 + 1;
        r9 = r9.a().i(r1).a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0052, code lost:
    
        throw r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        a4.o0.m(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0037, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
    
        r11 = move-exception;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] c(z3.k.a r8, java.lang.String r9, @androidx.annotation.Nullable byte[] r10, java.util.Map<java.lang.String, java.lang.String> r11) throws o2.o0 {
        /*
            z3.l0 r0 = new z3.l0
            z3.k r8 = r8.createDataSource()
            r0.<init>(r8)
            z3.o$b r8 = new z3.o$b
            r8.<init>()
            z3.o$b r8 = r8.i(r9)
            z3.o$b r8 = r8.e(r11)
            r9 = 2
            z3.o$b r8 = r8.d(r9)
            z3.o$b r8 = r8.c(r10)
            r9 = 1
            z3.o$b r8 = r8.b(r9)
            z3.o r2 = r8.a()
            r8 = 0
            r9 = r2
        L2a:
            z3.m r10 = new z3.m     // Catch: java.lang.Exception -> L57
            r10.<init>(r0, r9)     // Catch: java.lang.Exception -> L57
            byte[] r8 = a4.o0.L0(r10)     // Catch: java.lang.Throwable -> L37 z3.b0 -> L39
            a4.o0.m(r10)     // Catch: java.lang.Exception -> L57
            return r8
        L37:
            r8 = move-exception
            goto L53
        L39:
            r11 = move-exception
            java.lang.String r1 = d(r11, r8)     // Catch: java.lang.Throwable -> L37
            if (r1 == 0) goto L52
            int r8 = r8 + 1
            z3.o$b r9 = r9.a()     // Catch: java.lang.Throwable -> L37
            z3.o$b r9 = r9.i(r1)     // Catch: java.lang.Throwable -> L37
            z3.o r9 = r9.a()     // Catch: java.lang.Throwable -> L37
            a4.o0.m(r10)     // Catch: java.lang.Exception -> L57
            goto L2a
        L52:
            throw r11     // Catch: java.lang.Throwable -> L37
        L53:
            a4.o0.m(r10)     // Catch: java.lang.Exception -> L57
            throw r8     // Catch: java.lang.Exception -> L57
        L57:
            r8 = move-exception
            r7 = r8
            o2.o0 r8 = new o2.o0
            android.net.Uri r9 = r0.d()
            java.lang.Object r9 = a4.a.e(r9)
            r3 = r9
            android.net.Uri r3 = (android.net.Uri) r3
            java.util.Map r4 = r0.getResponseHeaders()
            long r5 = r0.c()
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.l0.c(z3.k$a, java.lang.String, byte[], java.util.Map):byte[]");
    }

    @Nullable
    private static String d(z3.b0 b0Var, int i10) {
        Map<String, List<String>> map;
        List<String> list;
        int i11 = b0Var.f37365d;
        if (!((i11 == 307 || i11 == 308) && i10 < 5) || (map = b0Var.f37367f) == null || (list = map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override // o2.n0
    public byte[] a(UUID uuid, g0.d dVar) throws o0 {
        return c(this.f31911a, dVar.b() + "&signedRequest=" + a4.o0.A(dVar.a()), null, Collections.emptyMap());
    }

    @Override // o2.n0
    public byte[] b(UUID uuid, g0.a aVar) throws o0 {
        String strB = aVar.b();
        if (this.f31913c || TextUtils.isEmpty(strB)) {
            strB = this.f31912b;
        }
        if (TextUtils.isEmpty(strB)) {
            throw new o0(new o.b().h(Uri.EMPTY).a(), Uri.EMPTY, com.google.common.collect.a0.k(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap map = new HashMap();
        UUID uuid2 = k2.i.f29130e;
        map.put(nb.K, uuid2.equals(uuid) ? "text/xml" : k2.i.f29128c.equals(uuid) ? nb.L : "application/octet-stream");
        if (uuid2.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.f31914d) {
            map.putAll(this.f31914d);
        }
        return c(this.f31911a, strB, aVar.a(), map);
    }

    public void e(String str, String str2) {
        a4.a.e(str);
        a4.a.e(str2);
        synchronized (this.f31914d) {
            this.f31914d.put(str, str2);
        }
    }
}
