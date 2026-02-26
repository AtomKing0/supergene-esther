package com.ironsource;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class qo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<String> f14545a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<String> f14546b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<String> f14547c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList<String> f14548d = new ArrayList<>();

    public ArrayList<String> a() {
        return this.f14547c;
    }

    public ArrayList<String> b() {
        return this.f14546b;
    }

    public ArrayList<String> c() {
        return this.f14548d;
    }

    public ArrayList<String> d() {
        return this.f14545a;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f14547c.add(str);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f14546b.add(str);
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f14548d.add(str);
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f14545a.add(str);
    }
}
