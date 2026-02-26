package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ib0 {
    public static String a(String apiKey) {
        kotlin.jvm.internal.t.i(apiKey, "apiKey");
        return "com.braze.storage.server_config." + apiKey;
    }

    public static int b() {
        return vb0.f4102e;
    }

    public static int a() {
        return vb0.f4103f;
    }
}
