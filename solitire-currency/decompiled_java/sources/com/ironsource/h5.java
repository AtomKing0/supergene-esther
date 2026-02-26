package com.ironsource;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class h5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f12383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f12386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f12387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f12388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f12389g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f12390h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f12391i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f12392j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f12393k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f12394l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f12395m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ArrayList<String> f12396n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f12397o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f12398p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f12399q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f12400r;

    public h5() {
        this.f12384b = "";
        this.f12385c = "";
        this.f12386d = "";
        this.f12391i = 0L;
        this.f12392j = 0L;
        this.f12393k = 0L;
        this.f12394l = 0L;
        this.f12395m = true;
        this.f12396n = new ArrayList<>();
        this.f12389g = 0;
        this.f12397o = false;
        this.f12398p = false;
        this.f12399q = 1;
    }

    public String a() {
        return this.f12384b;
    }

    public long b() {
        return this.f12392j;
    }

    public int c() {
        return this.f12388f;
    }

    public int d() {
        return this.f12399q;
    }

    public boolean e() {
        return this.f12395m;
    }

    public ArrayList<String> f() {
        return this.f12396n;
    }

    public int g() {
        return this.f12387e;
    }

    public boolean h() {
        return this.f12383a;
    }

    public int i() {
        return this.f12389g;
    }

    public long j() {
        return this.f12393k;
    }

    public long k() {
        return this.f12391i;
    }

    public long l() {
        return this.f12394l;
    }

    public long m() {
        return this.f12390h;
    }

    public boolean n() {
        return this.f12397o;
    }

    public boolean o() {
        return this.f12398p;
    }

    public boolean p() {
        return this.f12400r;
    }

    h5(String str, String str2, String str3, int i10, int i11, long j10, long j11, long j12, long j13, long j14, boolean z10, int i12, boolean z11, boolean z12, boolean z13, int i13, boolean z14) {
        this.f12384b = str;
        this.f12385c = str2;
        this.f12386d = str3;
        this.f12387e = i10;
        this.f12388f = i11;
        this.f12390h = j10;
        this.f12383a = z13;
        this.f12391i = j11;
        this.f12392j = j12;
        this.f12393k = j13;
        this.f12394l = j14;
        this.f12395m = z10;
        this.f12389g = i12;
        this.f12396n = new ArrayList<>();
        this.f12397o = z11;
        this.f12398p = z12;
        this.f12399q = i13;
        this.f12400r = z14;
    }

    public String a(boolean z10) {
        return z10 ? this.f12386d : this.f12385c;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f12396n.add(str);
    }
}
