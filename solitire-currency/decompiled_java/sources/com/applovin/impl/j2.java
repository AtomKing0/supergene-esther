package com.applovin.impl;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.applovin.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public class j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected c f5437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f5438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected SpannedString f5439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected SpannedString f5440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f5441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f5442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f5443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f5444h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f5445i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f5446j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f5447k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f5448l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected boolean f5449m;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c f5450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f5451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        SpannedString f5452c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        SpannedString f5453d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f5454e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f5455f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f5456g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f5457h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f5458i = ViewCompat.MEASURED_STATE_MASK;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f5459j = ViewCompat.MEASURED_STATE_MASK;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f5460k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f5461l = 0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f5462m;

        public b(c cVar) {
            this.f5450a = cVar;
        }

        public b a(boolean z10) {
            this.f5451b = z10;
            return this;
        }

        public b b(SpannedString spannedString) {
            this.f5452c = spannedString;
            return this;
        }

        public b c(String str) {
            return a(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        public b d(String str) {
            return b(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        public b a(SpannedString spannedString) {
            this.f5453d = spannedString;
            return this;
        }

        public b b(String str) {
            this.f5454e = str;
            return this;
        }

        public b a(String str) {
            this.f5455f = str;
            return this;
        }

        public b b(int i10) {
            this.f5461l = i10;
            return this;
        }

        public b c(int i10) {
            this.f5459j = i10;
            return this;
        }

        public b d(int i10) {
            this.f5458i = i10;
            return this;
        }

        public b a(int i10) {
            this.f5457h = i10;
            return this;
        }

        public b b(boolean z10) {
            this.f5462m = z10;
            return this;
        }

        public b a(Context context) {
            this.f5457h = R.drawable.applovin_ic_disclosure_arrow;
            this.f5461l = i0.a(R.color.applovin_sdk_disclosureButtonColor, context);
            return this;
        }

        public j2 a() {
            return new j2(this);
        }
    }

    public enum c {
        SECTION(0),
        SECTION_CENTERED(1),
        SIMPLE(2),
        DETAIL(3),
        RIGHT_DETAIL(4),
        COUNT(5);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f5470a;

        c(int i10) {
            this.f5470a = i10;
        }

        public int b() {
            return this == SECTION ? R.layout.mediation_debugger_list_section : this == SECTION_CENTERED ? R.layout.mediation_debugger_list_section_centered : this == SIMPLE ? android.R.layout.simple_list_item_1 : this == DETAIL ? R.layout.applovin_debugger_list_item_detail : R.layout.mediation_debugger_list_item_right_detail;
        }

        public int c() {
            return this.f5470a;
        }
    }

    public static b a() {
        return a(c.RIGHT_DETAIL);
    }

    public static int n() {
        return c.COUNT.c();
    }

    public String b() {
        return this.f5442f;
    }

    public String c() {
        return this.f5441e;
    }

    public int d() {
        return this.f5444h;
    }

    public int e() {
        return this.f5448l;
    }

    public SpannedString f() {
        return this.f5440d;
    }

    public int g() {
        return this.f5446j;
    }

    public int h() {
        return this.f5443g;
    }

    public int i() {
        return this.f5447k;
    }

    public int j() {
        return this.f5437a.b();
    }

    public SpannedString k() {
        return this.f5439c;
    }

    public int l() {
        return this.f5445i;
    }

    public int m() {
        return this.f5437a.c();
    }

    public boolean o() {
        return this.f5438b;
    }

    public boolean p() {
        return this.f5449m;
    }

    protected j2(c cVar) {
        this.f5443g = 0;
        this.f5444h = 0;
        this.f5445i = ViewCompat.MEASURED_STATE_MASK;
        this.f5446j = ViewCompat.MEASURED_STATE_MASK;
        this.f5447k = 0;
        this.f5448l = 0;
        this.f5437a = cVar;
    }

    public static b a(c cVar) {
        return new b(cVar);
    }

    private j2(b bVar) {
        this.f5443g = 0;
        this.f5444h = 0;
        this.f5445i = ViewCompat.MEASURED_STATE_MASK;
        this.f5446j = ViewCompat.MEASURED_STATE_MASK;
        this.f5447k = 0;
        this.f5448l = 0;
        this.f5437a = bVar.f5450a;
        this.f5438b = bVar.f5451b;
        this.f5439c = bVar.f5452c;
        this.f5440d = bVar.f5453d;
        this.f5441e = bVar.f5454e;
        this.f5442f = bVar.f5455f;
        this.f5443g = bVar.f5456g;
        this.f5444h = bVar.f5457h;
        this.f5445i = bVar.f5458i;
        this.f5446j = bVar.f5459j;
        this.f5447k = bVar.f5460k;
        this.f5448l = bVar.f5461l;
        this.f5449m = bVar.f5462m;
    }
}
