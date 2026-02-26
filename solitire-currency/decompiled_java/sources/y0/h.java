package y0;

import java.util.Collections;
import java.util.Map;
import y0.j;

/* JADX INFO: compiled from: Headers.java */
/* JADX INFO: loaded from: classes2.dex */
public interface h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final h f36282a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f36283b = new j.a().a();

    /* JADX INFO: compiled from: Headers.java */
    class a implements h {
        a() {
        }

        @Override // y0.h
        public Map<String, String> b() {
            return Collections.emptyMap();
        }
    }

    Map<String, String> b();
}
