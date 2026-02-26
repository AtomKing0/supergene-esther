package b2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: LogSourceMetrics.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d f1922c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<c> f1924b;

    /* JADX INFO: compiled from: LogSourceMetrics.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1925a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<c> f1926b = new ArrayList();

        a() {
        }

        public d a() {
            return new d(this.f1925a, Collections.unmodifiableList(this.f1926b));
        }

        public a b(List<c> list) {
            this.f1926b = list;
            return this;
        }

        public a c(String str) {
            this.f1925a = str;
            return this;
        }
    }

    d(String str, List<c> list) {
        this.f1923a = str;
        this.f1924b = list;
    }

    public static a c() {
        return new a();
    }

    @s5.d(tag = 2)
    public List<c> a() {
        return this.f1924b;
    }

    @s5.d(tag = 1)
    public String b() {
        return this.f1923a;
    }
}
