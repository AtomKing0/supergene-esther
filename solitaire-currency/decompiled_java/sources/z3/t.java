package z3;

import a4.o0;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.webkit.ProxyConfig;
import com.google.common.collect.c1;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import z3.k;
import z3.t;

/* JADX INFO: compiled from: DefaultHttpDataSource.java */
/* JADX INFO: loaded from: classes2.dex */
public class t extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f37533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f37534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f37535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final String f37536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private final c0 f37537i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final c0 f37538j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f37539k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private e5.p<String> f37540l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private o f37541m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private HttpURLConnection f37542n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private InputStream f37543o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f37544p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f37545q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f37546r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f37547s;

    /* JADX INFO: compiled from: DefaultHttpDataSource.java */
    public static final class b implements k.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private m0 f37549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private e5.p<String> f37550c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private String f37551d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f37554g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f37555h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c0 f37548a = new c0();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f37552e = 8000;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f37553f = 8000;

        @Override // z3.k.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public t createDataSource() {
            t tVar = new t(this.f37551d, this.f37552e, this.f37553f, this.f37554g, this.f37548a, this.f37550c, this.f37555h);
            m0 m0Var = this.f37549b;
            if (m0Var != null) {
                tVar.b(m0Var);
            }
            return tVar;
        }

        public b b(@Nullable String str) {
            this.f37551d = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DefaultHttpDataSource.java */
    static class c extends com.google.common.collect.t<String, List<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, List<String>> f37556a;

        public c(Map<String, List<String>> map) {
            this.f37556a = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$entrySet$1(Map.Entry entry) {
            return entry.getKey() != null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$keySet$0(String str) {
            return str != null;
        }

        @Override // com.google.common.collect.t, java.util.Map
        public boolean containsKey(@Nullable Object obj) {
            return obj != null && super.containsKey(obj);
        }

        @Override // com.google.common.collect.t, java.util.Map
        public boolean containsValue(@Nullable Object obj) {
            return super.standardContainsValue(obj);
        }

        @Override // com.google.common.collect.t, java.util.Map
        public Set<Map.Entry<String, List<String>>> entrySet() {
            return c1.b(super.entrySet(), new e5.p() { // from class: z3.v
                @Override // e5.p
                public final boolean apply(Object obj) {
                    return t.c.lambda$entrySet$1((Map.Entry) obj);
                }
            });
        }

        @Override // com.google.common.collect.t, java.util.Map
        public boolean equals(@Nullable Object obj) {
            return obj != null && super.standardEquals(obj);
        }

        @Override // com.google.common.collect.t, java.util.Map
        public int hashCode() {
            return super.standardHashCode();
        }

        @Override // com.google.common.collect.t, java.util.Map
        public boolean isEmpty() {
            if (super.isEmpty()) {
                return true;
            }
            return super.size() == 1 && super.containsKey(null);
        }

        @Override // com.google.common.collect.t, java.util.Map
        public Set<String> keySet() {
            return c1.b(super.keySet(), new e5.p() { // from class: z3.u
                @Override // e5.p
                public final boolean apply(Object obj) {
                    return t.c.lambda$keySet$0((String) obj);
                }
            });
        }

        @Override // com.google.common.collect.t, java.util.Map
        public int size() {
            return super.size() - (super.containsKey(null) ? 1 : 0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.t, com.google.common.collect.u
        public Map<String, List<String>> delegate() {
            return this.f37556a;
        }

        @Override // com.google.common.collect.t, java.util.Map
        @Nullable
        public List<String> get(@Nullable Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }
    }

    private void g() {
        HttpURLConnection httpURLConnection = this.f37542n;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e10) {
                a4.t.d("DefaultHttpDataSource", "Unexpected error while disconnecting", e10);
            }
            this.f37542n = null;
        }
    }

    private URL h(URL url, @Nullable String str, o oVar) throws z {
        if (str == null) {
            throw new z("Null location redirect", oVar, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !ProxyConfig.MATCH_HTTP.equals(protocol)) {
                throw new z("Unsupported protocol redirect: " + protocol, oVar, 2001, 1);
            }
            if (this.f37533e || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new z("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", oVar, 2001, 1);
        } catch (MalformedURLException e10) {
            throw new z(e10, oVar, 2001, 1);
        }
    }

    private static boolean i(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    private HttpURLConnection j(URL url, int i10, @Nullable byte[] bArr, long j10, long j11, boolean z10, boolean z11, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnectionM = m(url);
        httpURLConnectionM.setConnectTimeout(this.f37534f);
        httpURLConnectionM.setReadTimeout(this.f37535g);
        HashMap map2 = new HashMap();
        c0 c0Var = this.f37537i;
        if (c0Var != null) {
            map2.putAll(c0Var.a());
        }
        map2.putAll(this.f37538j.a());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnectionM.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = d0.a(j10, j11);
        if (strA != null) {
            httpURLConnectionM.setRequestProperty("Range", strA);
        }
        String str = this.f37536h;
        if (str != null) {
            httpURLConnectionM.setRequestProperty("User-Agent", str);
        }
        httpURLConnectionM.setRequestProperty("Accept-Encoding", z10 ? "gzip" : "identity");
        httpURLConnectionM.setInstanceFollowRedirects(z11);
        httpURLConnectionM.setDoOutput(bArr != null);
        httpURLConnectionM.setRequestMethod(o.c(i10));
        if (bArr != null) {
            httpURLConnectionM.setFixedLengthStreamingMode(bArr.length);
            httpURLConnectionM.connect();
            OutputStream outputStream = httpURLConnectionM.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnectionM.connect();
        }
        return httpURLConnectionM;
    }

    private HttpURLConnection k(o oVar) throws IOException {
        HttpURLConnection httpURLConnectionJ;
        URL url = new URL(oVar.f37463a.toString());
        int i10 = oVar.f37465c;
        byte[] bArr = oVar.f37466d;
        long j10 = oVar.f37469g;
        long j11 = oVar.f37470h;
        boolean zD = oVar.d(1);
        if (!this.f37533e && !this.f37539k) {
            return j(url, i10, bArr, j10, j11, zD, true, oVar.f37467e);
        }
        URL urlH = url;
        int i11 = i10;
        byte[] bArr2 = bArr;
        int i12 = 0;
        while (true) {
            int i13 = i12 + 1;
            if (i12 > 20) {
                throw new z(new NoRouteToHostException("Too many redirects: " + i13), oVar, 2001, 1);
            }
            long j12 = j10;
            long j13 = j10;
            int i14 = i11;
            URL url2 = urlH;
            long j14 = j11;
            httpURLConnectionJ = j(urlH, i11, bArr2, j12, j11, zD, false, oVar.f37467e);
            int responseCode = httpURLConnectionJ.getResponseCode();
            String headerField = httpURLConnectionJ.getHeaderField("Location");
            if ((i14 == 1 || i14 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                httpURLConnectionJ.disconnect();
                urlH = h(url2, headerField, oVar);
                i11 = i14;
            } else {
                if (i14 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    break;
                }
                httpURLConnectionJ.disconnect();
                if (this.f37539k && responseCode == 302) {
                    i11 = i14;
                } else {
                    bArr2 = null;
                    i11 = 1;
                }
                urlH = h(url2, headerField, oVar);
            }
            i12 = i13;
            j10 = j13;
            j11 = j14;
        }
        return httpURLConnectionJ;
    }

    private static void l(@Nullable HttpURLConnection httpURLConnection, long j10) {
        int i10;
        if (httpURLConnection == null || (i10 = o0.f214a) < 19 || i10 > 20) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (j10 == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else if (j10 <= 2048) {
                return;
            }
            String name = inputStream.getClass().getName();
            if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                Method declaredMethod = ((Class) a4.a.e(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    private int n(byte[] bArr, int i10, int i11) throws IOException {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f37546r;
        if (j10 != -1) {
            long j11 = j10 - this.f37547s;
            if (j11 == 0) {
                return -1;
            }
            i11 = (int) Math.min(i11, j11);
        }
        int i12 = ((InputStream) o0.j(this.f37543o)).read(bArr, i10, i11);
        if (i12 == -1) {
            return -1;
        }
        this.f37547s += (long) i12;
        c(i12);
        return i12;
    }

    private void o(long j10, o oVar) throws IOException {
        if (j10 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j10 > 0) {
            int i10 = ((InputStream) o0.j(this.f37543o)).read(bArr, 0, (int) Math.min(j10, 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new z(new InterruptedIOException(), oVar, 2000, 1);
            }
            if (i10 == -1) {
                throw new z(oVar, 2008, 1);
            }
            j10 -= (long) i10;
            c(i10);
        }
    }

    @Override // z3.k
    public long a(o oVar) throws z {
        byte[] bArrL0;
        this.f37541m = oVar;
        long j10 = 0;
        this.f37547s = 0L;
        this.f37546r = 0L;
        e(oVar);
        try {
            HttpURLConnection httpURLConnectionK = k(oVar);
            this.f37542n = httpURLConnectionK;
            this.f37545q = httpURLConnectionK.getResponseCode();
            String responseMessage = httpURLConnectionK.getResponseMessage();
            int i10 = this.f37545q;
            if (i10 < 200 || i10 > 299) {
                Map<String, List<String>> headerFields = httpURLConnectionK.getHeaderFields();
                if (this.f37545q == 416) {
                    if (oVar.f37469g == d0.c(httpURLConnectionK.getHeaderField("Content-Range"))) {
                        this.f37544p = true;
                        f(oVar);
                        long j11 = oVar.f37470h;
                        if (j11 != -1) {
                            return j11;
                        }
                        return 0L;
                    }
                }
                InputStream errorStream = httpURLConnectionK.getErrorStream();
                try {
                    bArrL0 = errorStream != null ? o0.L0(errorStream) : o0.f219f;
                } catch (IOException unused) {
                    bArrL0 = o0.f219f;
                }
                byte[] bArr = bArrL0;
                g();
                throw new b0(this.f37545q, responseMessage, this.f37545q == 416 ? new l(2008) : null, headerFields, oVar, bArr);
            }
            String contentType = httpURLConnectionK.getContentType();
            e5.p<String> pVar = this.f37540l;
            if (pVar != null && !pVar.apply(contentType)) {
                g();
                throw new a0(contentType, oVar);
            }
            if (this.f37545q == 200) {
                long j12 = oVar.f37469g;
                if (j12 != 0) {
                    j10 = j12;
                }
            }
            boolean zI = i(httpURLConnectionK);
            if (zI) {
                this.f37546r = oVar.f37470h;
            } else {
                long j13 = oVar.f37470h;
                if (j13 != -1) {
                    this.f37546r = j13;
                } else {
                    long jB = d0.b(httpURLConnectionK.getHeaderField("Content-Length"), httpURLConnectionK.getHeaderField("Content-Range"));
                    this.f37546r = jB != -1 ? jB - j10 : -1L;
                }
            }
            try {
                this.f37543o = httpURLConnectionK.getInputStream();
                if (zI) {
                    this.f37543o = new GZIPInputStream(this.f37543o);
                }
                this.f37544p = true;
                f(oVar);
                try {
                    o(j10, oVar);
                    return this.f37546r;
                } catch (IOException e10) {
                    g();
                    if (e10 instanceof z) {
                        throw ((z) e10);
                    }
                    throw new z(e10, oVar, 2000, 1);
                }
            } catch (IOException e11) {
                g();
                throw new z(e11, oVar, 2000, 1);
            }
        } catch (IOException e12) {
            g();
            throw z.c(e12, oVar, 1);
        }
    }

    @Override // z3.k
    public void close() throws z {
        try {
            InputStream inputStream = this.f37543o;
            if (inputStream != null) {
                long j10 = this.f37546r;
                long j11 = -1;
                if (j10 != -1) {
                    j11 = j10 - this.f37547s;
                }
                l(this.f37542n, j11);
                try {
                    inputStream.close();
                } catch (IOException e10) {
                    throw new z(e10, (o) o0.j(this.f37541m), 2000, 3);
                }
            }
        } finally {
            this.f37543o = null;
            g();
            if (this.f37544p) {
                this.f37544p = false;
                d();
            }
        }
    }

    @Override // z3.f, z3.k
    public Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.f37542n;
        return httpURLConnection == null ? com.google.common.collect.a0.k() : new c(httpURLConnection.getHeaderFields());
    }

    @Override // z3.k
    @Nullable
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.f37542n;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @VisibleForTesting
    HttpURLConnection m(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    @Override // z3.h
    public int read(byte[] bArr, int i10, int i11) throws z {
        try {
            return n(bArr, i10, i11);
        } catch (IOException e10) {
            throw z.c(e10, (o) o0.j(this.f37541m), 2);
        }
    }

    private t(@Nullable String str, int i10, int i11, boolean z10, @Nullable c0 c0Var, @Nullable e5.p<String> pVar, boolean z11) {
        super(true);
        this.f37536h = str;
        this.f37534f = i10;
        this.f37535g = i11;
        this.f37533e = z10;
        this.f37537i = c0Var;
        this.f37540l = pVar;
        this.f37538j = new c0();
        this.f37539k = z11;
    }
}
