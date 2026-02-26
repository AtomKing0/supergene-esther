package k2;

import java.util.HashSet;

/* JADX INFO: compiled from: ExoPlayerLibraryInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashSet<String> f29272a = new HashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f29273b = "goog.exo.core";

    public static synchronized void a(String str) {
        if (f29272a.add(str)) {
            f29273b += ", " + str;
        }
    }

    public static synchronized String b() {
        return f29273b;
    }
}
