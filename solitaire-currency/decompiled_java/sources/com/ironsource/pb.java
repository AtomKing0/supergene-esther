package com.ironsource;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class pb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ke f14316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f14317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<Pair<String, String>> f14318f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f14319a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ke f14322d;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f14320b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f14321c = "POST";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f14323e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ArrayList<Pair<String, String>> f14324f = new ArrayList<>();

        public a(String str) {
            this.f14319a = "";
            if (str == null || str.isEmpty()) {
                return;
            }
            this.f14319a = str;
        }

        public a a(Pair<String, String> pair) {
            this.f14324f.add(pair);
            return this;
        }

        public a b() {
            this.f14321c = "GET";
            return this;
        }

        public a c() {
            this.f14321c = "POST";
            return this;
        }

        public a a(ke keVar) {
            this.f14322d = keVar;
            return this;
        }

        public a b(boolean z10) {
            this.f14320b = z10;
            return this;
        }

        public a a(List<Pair<String, String>> list) {
            this.f14324f.addAll(list);
            return this;
        }

        public a a(boolean z10) {
            this.f14323e = z10;
            return this;
        }

        public pb a() {
            return new pb(this);
        }
    }

    pb(a aVar) {
        this.f14317e = false;
        this.f14313a = aVar.f14319a;
        this.f14314b = aVar.f14320b;
        this.f14315c = aVar.f14321c;
        this.f14316d = aVar.f14322d;
        this.f14317e = aVar.f14323e;
        if (aVar.f14324f != null) {
            this.f14318f = new ArrayList<>(aVar.f14324f);
        }
    }

    public boolean a() {
        return this.f14314b;
    }

    public String b() {
        return this.f14313a;
    }

    public ke c() {
        return this.f14316d;
    }

    public ArrayList<Pair<String, String>> d() {
        return new ArrayList<>(this.f14318f);
    }

    public String e() {
        return this.f14315c;
    }

    public boolean f() {
        return this.f14317e;
    }
}
