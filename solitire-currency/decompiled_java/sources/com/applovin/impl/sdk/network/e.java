package com.applovin.impl.sdk.network;

import com.applovin.impl.i4;
import com.applovin.impl.l4;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.network.a;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e extends com.applovin.impl.sdk.network.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f7307s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f7308t;

    public static class a extends a.C0175a {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private String f7309r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f7310s;

        public a(j jVar) {
            super(jVar);
            this.f7256h = ((Integer) jVar.a(l4.f5760v2)).intValue();
            this.f7257i = ((Integer) jVar.a(l4.f5753u2)).intValue();
            this.f7258j = ((Integer) jVar.a(l4.E2)).intValue();
        }

        @Override // com.applovin.impl.sdk.network.a.C0175a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a(String str) {
            this.f7251c = str;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0175a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public a b(int i10) {
            this.f7258j = i10;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0175a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public a b(String str) {
            this.f7250b = str;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0175a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public a c(String str) {
            this.f7249a = str;
            return this;
        }

        public a h(boolean z10) {
            this.f7310s = z10;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0175a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public a b(boolean z10) {
            this.f7264p = z10;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0175a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a b(Map map) {
            this.f7252d = map;
            return this;
        }

        public a e(String str) {
            this.f7309r = str;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0175a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public a c(int i10) {
            this.f7257i = i10;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0175a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public a a(boolean z10) {
            this.f7262n = z10;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0175a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a a(Map map) {
            this.f7253e = map;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0175a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a(int i10) {
            this.f7256h = i10;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0175a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(JSONObject jSONObject) {
            this.f7254f = jSONObject;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0175a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(Object obj) {
            this.f7255g = obj;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0175a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(i4.a aVar) {
            this.f7265q = aVar;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0175a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a() {
            return new e(this);
        }
    }

    protected e(a aVar) {
        super(aVar);
        this.f7307s = aVar.f7309r;
        this.f7308t = aVar.f7310s;
    }

    public static a b(j jVar) {
        return new a(jVar);
    }

    public String s() {
        return this.f7307s;
    }

    public boolean t() {
        return this.f7307s != null;
    }

    public boolean u() {
        return this.f7308t;
    }
}
