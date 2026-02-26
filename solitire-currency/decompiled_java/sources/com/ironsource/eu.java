package com.ironsource;

import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class eu {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11999b = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12000c = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Boolean> f11998a = new a();

    class a extends HashMap<String, Boolean> {
        a() {
            put(Cif.f12602k, Boolean.valueOf(eu.this.f11999b == 0));
            put(Cif.f12603l, Boolean.valueOf(eu.this.f12000c == 0));
            Boolean bool = Boolean.FALSE;
            put(Cif.f12604m, bool);
            put(Cif.f12605n, bool);
        }
    }

    eu() {
    }

    public JSONObject a() {
        return new JSONObject(this.f11998a);
    }

    void a(String str, int i10, boolean z10) {
        if (this.f11998a.containsKey(str)) {
            this.f11998a.put(str, Boolean.valueOf(i10 == 0));
        }
        this.f11998a.put(Cif.f12604m, Boolean.valueOf(z10));
        this.f11998a.put(Cif.f12605n, Boolean.valueOf((this.f11998a.get(Cif.f12603l).booleanValue() || this.f11998a.get(Cif.f12602k).booleanValue()) && this.f11998a.get(Cif.f12604m).booleanValue()));
    }
}
