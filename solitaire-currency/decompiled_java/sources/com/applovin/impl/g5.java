package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.applovin.impl.a0;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class g5 extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b f5266g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f5267h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f5268i;

    public interface b {
        void a(a0.b bVar, String str);

        void a(String str, String str2);
    }

    public g5(com.applovin.impl.sdk.j jVar, String str, b bVar) {
        super("TaskFetchAppAdsContent", jVar);
        this.f5267h = str;
        this.f5266g = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList = new ArrayList(Arrays.asList(Uri.parse(this.f5267h).getAuthority().split("\\.")));
        if (arrayList.size() > 0) {
            String str = (String) arrayList.get(0);
            if ("www".equals(str) || "m".equals(str)) {
                arrayList.remove(0);
            }
        }
        String strJoin = TextUtils.join(".", arrayList);
        Uri uriBuild = new Uri.Builder().scheme("https").authority(strJoin).appendPath("app-ads.txt").build();
        com.applovin.impl.sdk.network.a aVarA = com.applovin.impl.sdk.network.a.a(this.f7677a).c("GET").b(uriBuild.toString()).a(new Uri.Builder().scheme(ProxyConfig.MATCH_HTTP).authority(strJoin).appendPath("app-ads.txt").build().toString()).a((Object) "").a(false).a();
        this.f5268i = uriBuild.toString();
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Looking up app-ads.txt at " + this.f5268i);
        }
        this.f7677a.j0().a(new a(aVarA, this.f7677a));
    }

    class a extends z5 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, String str2, int i10) {
            if (TextUtils.isEmpty(str2)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f7679c.b(this.f7678b, "No app-ads.txt found");
                }
                g5.this.f5266g.a(a0.b.APPADSTXT_NOT_FOUND, g5.this.f5268i);
            } else {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f7679c.a(this.f7678b, "Found app-ads.txt");
                }
                g5.this.f5266g.a(str2, g5.this.f5268i);
            }
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, int i10, String str2, String str3) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.b(this.f7678b, "Unable to fetch app-ads.txt due to: " + str2 + ", and received error code: " + i10);
            }
            g5.this.f5266g.a(a0.b.APPADSTXT_NOT_FOUND, g5.this.f5268i);
        }
    }
}
