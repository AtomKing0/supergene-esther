package w3;

import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: WebvttCssStyle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @ColorInt
    private int f35378f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f35380h;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f35387o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f35373a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f35374b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set<String> f35375c = Collections.emptySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f35376d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private String f35377e = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f35379g = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f35381i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f35382j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f35383k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f35384l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f35385m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f35386n = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f35388p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f35389q = false;

    private static int B(int i10, String str, @Nullable String str2, int i11) {
        if (str.isEmpty() || i10 == -1) {
            return i10;
        }
        if (str.equals(str2)) {
            return i10 + i11;
        }
        return -1;
    }

    public d A(boolean z10) {
        this.f35383k = z10 ? 1 : 0;
        return this;
    }

    public int a() {
        if (this.f35381i) {
            return this.f35380h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.f35389q;
    }

    public int c() {
        if (this.f35379g) {
            return this.f35378f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    @Nullable
    public String d() {
        return this.f35377e;
    }

    public float e() {
        return this.f35387o;
    }

    public int f() {
        return this.f35386n;
    }

    public int g() {
        return this.f35388p;
    }

    public int h(@Nullable String str, @Nullable String str2, Set<String> set, @Nullable String str3) {
        if (this.f35373a.isEmpty() && this.f35374b.isEmpty() && this.f35375c.isEmpty() && this.f35376d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int iB = B(B(B(0, this.f35373a, str, 1073741824), this.f35374b, str2, 2), this.f35376d, str3, 4);
        if (iB == -1 || !set.containsAll(this.f35375c)) {
            return 0;
        }
        return iB + (this.f35375c.size() * 4);
    }

    public int i() {
        int i10 = this.f35384l;
        if (i10 == -1 && this.f35385m == -1) {
            return -1;
        }
        return (i10 == 1 ? 1 : 0) | (this.f35385m == 1 ? 2 : 0);
    }

    public boolean j() {
        return this.f35381i;
    }

    public boolean k() {
        return this.f35379g;
    }

    public boolean l() {
        return this.f35382j == 1;
    }

    public boolean m() {
        return this.f35383k == 1;
    }

    public d n(int i10) {
        this.f35380h = i10;
        this.f35381i = true;
        return this;
    }

    public d o(boolean z10) {
        this.f35384l = z10 ? 1 : 0;
        return this;
    }

    public d p(boolean z10) {
        this.f35389q = z10;
        return this;
    }

    public d q(int i10) {
        this.f35378f = i10;
        this.f35379g = true;
        return this;
    }

    public d r(@Nullable String str) {
        this.f35377e = str == null ? null : e5.c.e(str);
        return this;
    }

    public d s(float f10) {
        this.f35387o = f10;
        return this;
    }

    public d t(int i10) {
        this.f35386n = i10;
        return this;
    }

    public d u(boolean z10) {
        this.f35385m = z10 ? 1 : 0;
        return this;
    }

    public d v(int i10) {
        this.f35388p = i10;
        return this;
    }

    public void w(String[] strArr) {
        this.f35375c = new HashSet(Arrays.asList(strArr));
    }

    public void x(String str) {
        this.f35373a = str;
    }

    public void y(String str) {
        this.f35374b = str;
    }

    public void z(String str) {
        this.f35376d = str;
    }
}
