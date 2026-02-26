package r6;

import android.util.Log;

/* JADX INFO: compiled from: JavaPluginPreloader.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f33324a = 0;

    static {
        a(s6.a.class.getName());
    }

    private static void a(String str) {
        try {
            Class.forName(str);
        } catch (ClassNotFoundException e10) {
            Log.e("Unity", "Failed to load class", e10);
        } catch (LinkageError e11) {
            Log.e("Unity", "Failed to load class", e11);
        }
    }
}
