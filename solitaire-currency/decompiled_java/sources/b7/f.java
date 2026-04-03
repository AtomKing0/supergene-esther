package b7;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SignalsResult.java */
/* JADX INFO: loaded from: classes4.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f2230a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2231b = null;

    public void a(String str, String str2) {
        this.f2230a.put(str, str2);
    }

    public String b() {
        return this.f2231b;
    }

    public Map<String, String> c() {
        return this.f2230a;
    }

    public void d(String str) {
        this.f2231b = str;
    }
}
