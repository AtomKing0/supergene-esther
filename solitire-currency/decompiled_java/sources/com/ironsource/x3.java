package com.ironsource;

import android.text.TextUtils;
import java.util.HashSet;

/* JADX INFO: loaded from: classes4.dex */
public class x3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f16127d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16129f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashSet<String> f16125b = new HashSet<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f16124a = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f16128e = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f16130g = true;

    public int a() {
        return this.f16129f;
    }

    public HashSet<String> b() {
        return this.f16125b;
    }

    public String c() {
        return this.f16127d;
    }

    public String d() {
        return this.f16126c;
    }

    public boolean e() {
        return this.f16128e;
    }

    public boolean f() {
        return this.f16124a;
    }

    public boolean g() {
        return this.f16130g;
    }

    public void a(int i10) {
        this.f16129f = i10;
    }

    public void b(String str) {
        this.f16127d = str;
    }

    public void c(String str) {
        this.f16126c = str;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f16125b.add(str);
    }

    public void b(boolean z10) {
        this.f16130g = z10;
    }

    public void c(boolean z10) {
        this.f16128e = z10;
    }

    public void a(boolean z10) {
        this.f16124a = z10;
    }
}
