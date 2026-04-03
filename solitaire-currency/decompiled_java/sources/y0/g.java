package y0;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: GlideUrl.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements r0.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f36275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final URL f36276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f36277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private String f36278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private URL f36279f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private volatile byte[] f36280g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f36281h;

    public g(URL url) {
        this(url, h.f36283b);
    }

    private byte[] d() {
        if (this.f36280g == null) {
            this.f36280g = c().getBytes(r0.f.f33247a);
        }
        return this.f36280g;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f36278e)) {
            String string = this.f36277d;
            if (TextUtils.isEmpty(string)) {
                string = ((URL) o1.j.d(this.f36276c)).toString();
            }
            this.f36278e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f36278e;
    }

    private URL g() throws MalformedURLException {
        if (this.f36279f == null) {
            this.f36279f = new URL(f());
        }
        return this.f36279f;
    }

    @Override // r0.f
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.f36277d;
        return str != null ? str : ((URL) o1.j.d(this.f36276c)).toString();
    }

    public Map<String, String> e() {
        return this.f36275b.b();
    }

    @Override // r0.f
    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return c().equals(gVar.c()) && this.f36275b.equals(gVar.f36275b);
    }

    public URL h() throws MalformedURLException {
        return g();
    }

    @Override // r0.f
    public int hashCode() {
        if (this.f36281h == 0) {
            int iHashCode = c().hashCode();
            this.f36281h = iHashCode;
            this.f36281h = (iHashCode * 31) + this.f36275b.hashCode();
        }
        return this.f36281h;
    }

    public String toString() {
        return c();
    }

    public g(String str) {
        this(str, h.f36283b);
    }

    public g(URL url, h hVar) {
        this.f36276c = (URL) o1.j.d(url);
        this.f36277d = null;
        this.f36275b = (h) o1.j.d(hVar);
    }

    public g(String str, h hVar) {
        this.f36276c = null;
        this.f36277d = o1.j.b(str);
        this.f36275b = (h) o1.j.d(hVar);
    }
}
