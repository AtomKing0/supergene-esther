package com.applovin.impl;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.a0;
import com.ironsource.v8;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class i5 extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b f5386g;

    public interface b {
        void a(a0.b bVar);

        void a(String str);
    }

    public i5(com.applovin.impl.sdk.j jVar, b bVar) {
        super("TaskFetchDeveloperUri", jVar);
        this.f5386g = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strValueOf = String.valueOf(this.f7677a.y().C().get(v8.h.V));
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Looking up developer URI for package name: " + strValueOf);
        }
        this.f7677a.j0().a(new a(com.applovin.impl.sdk.network.a.a(this.f7677a).c("GET").b("https://play.google.com/store/apps/details?id=" + strValueOf).a((Object) "").a(false).a(), this.f7677a));
    }

    class a extends z5 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, String str2, int i10) {
            if (TextUtils.isEmpty(str2)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f7679c.b(this.f7678b, "No developer URI found - response from the Play Store is empty");
                }
                i5.this.f5386g.a(a0.b.APP_DETAILS_NOT_FOUND);
                return;
            }
            Matcher matcher = Pattern.compile("(?<=\"appstore:developer_url\" content=\").*?(?=\">)").matcher(str2);
            if (!matcher.find()) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f7679c.b(this.f7678b, "No developer URI found - unable to find the developer_url meta tag from the Play Store listing");
                }
                i5.this.f5386g.a(a0.b.INVALID_DEVELOPER_URI);
                return;
            }
            String strGroup = matcher.group();
            if (!URLUtil.isValidUrl(strGroup)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f7679c.b(this.f7678b, "Developer URI (" + strGroup + ") is not valid");
                }
                i5.this.f5386g.a(a0.b.INVALID_DEVELOPER_URI);
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Found developer URI: " + strGroup);
            }
            i5.this.f5386g.a(strGroup);
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, int i10, String str2, String str3) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.b(this.f7678b, "Unable to fetch app details due to: " + str2 + ", and received error code: " + i10);
            }
            i5.this.f5386g.a(a0.b.APP_DETAILS_NOT_FOUND);
        }
    }
}
