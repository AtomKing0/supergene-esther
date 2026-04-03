package z3;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.ironsource.v8;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import k2.l1;

/* JADX INFO: compiled from: DataSpec.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f37463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f37464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f37465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final byte[] f37466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f37467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public final long f37468f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f37469g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f37470h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final String f37471i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f37472j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final Object f37473k;

    /* JADX INFO: compiled from: DataSpec.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private Uri f37474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f37475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f37476c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private byte[] f37477d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map<String, String> f37478e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f37479f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f37480g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        private String f37481h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f37482i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        private Object f37483j;

        public o a() {
            a4.a.j(this.f37474a, "The uri must be set.");
            return new o(this.f37474a, this.f37475b, this.f37476c, this.f37477d, this.f37478e, this.f37479f, this.f37480g, this.f37481h, this.f37482i, this.f37483j);
        }

        public b b(int i10) {
            this.f37482i = i10;
            return this;
        }

        public b c(@Nullable byte[] bArr) {
            this.f37477d = bArr;
            return this;
        }

        public b d(int i10) {
            this.f37476c = i10;
            return this;
        }

        public b e(Map<String, String> map) {
            this.f37478e = map;
            return this;
        }

        public b f(@Nullable String str) {
            this.f37481h = str;
            return this;
        }

        public b g(long j10) {
            this.f37479f = j10;
            return this;
        }

        public b h(Uri uri) {
            this.f37474a = uri;
            return this;
        }

        public b i(String str) {
            this.f37474a = Uri.parse(str);
            return this;
        }

        public b() {
            this.f37476c = 1;
            this.f37478e = Collections.emptyMap();
            this.f37480g = -1L;
        }

        private b(o oVar) {
            this.f37474a = oVar.f37463a;
            this.f37475b = oVar.f37464b;
            this.f37476c = oVar.f37465c;
            this.f37477d = oVar.f37466d;
            this.f37478e = oVar.f37467e;
            this.f37479f = oVar.f37469g;
            this.f37480g = oVar.f37470h;
            this.f37481h = oVar.f37471i;
            this.f37482i = oVar.f37472j;
            this.f37483j = oVar.f37473k;
        }
    }

    static {
        l1.a("goog.exo.datasource");
    }

    public static String c(int i10) {
        if (i10 == 1) {
            return "GET";
        }
        if (i10 == 2) {
            return "POST";
        }
        if (i10 == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public b a() {
        return new b();
    }

    public final String b() {
        return c(this.f37465c);
    }

    public boolean d(int i10) {
        return (this.f37472j & i10) == i10;
    }

    public String toString() {
        return "DataSpec[" + b() + " " + this.f37463a + ", " + this.f37469g + ", " + this.f37470h + ", " + this.f37471i + ", " + this.f37472j + v8.i.f15839e;
    }

    private o(Uri uri, long j10, int i10, @Nullable byte[] bArr, Map<String, String> map, long j11, long j12, @Nullable String str, int i11, @Nullable Object obj) {
        byte[] bArr2 = bArr;
        long j13 = j10 + j11;
        boolean z10 = true;
        a4.a.a(j13 >= 0);
        a4.a.a(j11 >= 0);
        if (j12 <= 0 && j12 != -1) {
            z10 = false;
        }
        a4.a.a(z10);
        this.f37463a = uri;
        this.f37464b = j10;
        this.f37465c = i10;
        this.f37466d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f37467e = Collections.unmodifiableMap(new HashMap(map));
        this.f37469g = j11;
        this.f37468f = j13;
        this.f37470h = j12;
        this.f37471i = str;
        this.f37472j = i11;
        this.f37473k = obj;
    }
}
