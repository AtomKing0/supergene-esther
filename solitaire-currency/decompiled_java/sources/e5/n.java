package e5;

import java.util.logging.Logger;

/* JADX INFO: compiled from: Platform.java */
/* JADX INFO: loaded from: classes3.dex */
final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f25153a = Logger.getLogger(n.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final m f25154b = b();

    /* JADX INFO: compiled from: Platform.java */
    private static final class b implements m {
        private b() {
        }
    }

    private n() {
    }

    static String a(String str) {
        if (c(str)) {
            return null;
        }
        return str;
    }

    private static m b() {
        return new b();
    }

    static boolean c(String str) {
        return str == null || str.isEmpty();
    }
}
