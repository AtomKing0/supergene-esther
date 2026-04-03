package z6;

import android.os.Bundle;

/* JADX INFO: compiled from: RequestExtras.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f37591b = "query_info_type";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f37592c = "requester_type_5";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f37593d = "UnityScar";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37594a;

    public a(String str) {
        this.f37594a = f37593d + str;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString(f37591b, f37592c);
        return bundle;
    }

    public String b() {
        return this.f37594a;
    }
}
