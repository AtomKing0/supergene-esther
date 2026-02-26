package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.k3;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z4 extends w4 implements k3.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final com.applovin.impl.sdk.ad.b f7894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AppLovinAdLoadListener f7895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.applovin.impl.sdk.l f7896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Collection f7897j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f7898k;

    z4(String str, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.j jVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super(str, jVar);
        if (bVar == null) {
            throw new IllegalArgumentException("No ad specified.");
        }
        this.f7894g = bVar;
        this.f7895h = appLovinAdLoadListener;
        this.f7896i = jVar.C();
        this.f7897j = g();
    }

    private Collection g() {
        HashSet hashSet = new HashSet();
        for (char c10 : ((String) this.f7677a.a(l4.B0)).toCharArray()) {
            hashSet.add(Character.valueOf(c10));
        }
        hashSet.add('\"');
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f7895h;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(this.f7894g);
            this.f7895h = null;
        }
    }

    @Override // com.applovin.impl.k3.a
    public void a(q2 q2Var) {
        if (q2Var.N().equalsIgnoreCase(this.f7894g.I())) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.b(this.f7678b, "Updating flag for timeout...");
            }
            f();
        }
        this.f7677a.S().b(this);
    }

    Uri b(String str, List list, boolean z10) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Caching video " + str + "...");
        }
        String strA = this.f7896i.a(a(), str, this.f7894g.getCachePrefix(), list, z10, this.f7677a.C().a(str, this.f7894g), this.f7894g.b0());
        if (!StringUtils.isValidString(strA)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.b(this.f7678b, "Failed to cache video: " + str);
            }
            this.f7677a.A().a(y1.f7788j0, "cacheVideo", CollectionUtils.hashMap("url", str));
            a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
            return null;
        }
        File fileA = this.f7896i.a(strA, a());
        if (fileA == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.b(this.f7678b, "Unable to retrieve File from cached video filename = " + strA);
            }
            this.f7677a.A().a(y1.f7788j0, "retrieveVideoFile", CollectionUtils.hashMap("url", strA));
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileA);
        if (uriFromFile != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Finish caching video for ad #" + this.f7894g.getAdIdNumber() + ". Updating ad with cachedVideoFilename = " + strA);
            }
            return uriFromFile;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.b(this.f7678b, "Unable to create URI from cached video file = " + fileA);
        }
        this.f7677a.A().a(y1.f7788j0, "extractUriFromVideoFile", CollectionUtils.hashMap("url", strA));
        return null;
    }

    Uri c(String str) {
        return b(str, this.f7894g.W(), true);
    }

    protected void f() {
        this.f7898k = true;
    }

    void i() {
        if (k0.d()) {
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Caching mute images...");
        }
        Uri uriA = a(this.f7894g.M(), "mute");
        if (uriA != null) {
            this.f7894g.b(uriA);
        }
        Uri uriA2 = a(this.f7894g.c0(), "unmute");
        if (uriA2 != null) {
            this.f7894g.c(uriA2);
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Ad updated with muteImageFilename = " + this.f7894g.M() + ", unmuteImageFilename = " + this.f7894g.c0());
        }
    }

    protected void j() {
        this.f7677a.S().b(this);
        MaxAdFormat maxAdFormatD = this.f7894g.getAdZone().d();
        if (((Boolean) this.f7677a.a(l4.Q0)).booleanValue() && maxAdFormatD != null && maxAdFormatD.isFullscreenAd()) {
            this.f7677a.h().b(this.f7894g);
        }
    }

    protected boolean k() {
        return this.f7898k;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f7894g.b1()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Subscribing to timeout events...");
            }
            this.f7677a.S().a(this);
        }
    }

    protected String c(String str, List list, boolean z10) {
        try {
            InputStream inputStreamA = this.f7896i.a(str, list, z10);
            if (inputStreamA == null) {
                if (inputStreamA != null) {
                    inputStreamA.close();
                }
                return null;
            }
            try {
                String strA = this.f7896i.a(inputStreamA);
                inputStreamA.close();
                return strA;
            } finally {
            }
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Unknown failure to read input stream.", th);
            }
            this.f7679c.a(this.f7678b, th);
            this.f7677a.A().a(this.f7678b, "readInputStreamAsString", th);
            return null;
        }
    }

    void e() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Rendered new ad:" + this.f7894g);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.qf
            @Override // java.lang.Runnable
            public final void run() {
                this.f6725a.h();
            }
        });
    }

    protected Uri a(Uri uri, String str) {
        if (uri == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "No " + str + " image to cache");
            }
            return null;
        }
        String string = uri.toString();
        if (TextUtils.isEmpty(string)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Failed to cache " + str + " image");
            }
            return null;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Caching " + str + " image...");
        }
        return b(string);
    }

    Uri a(String str, List list, boolean z10) {
        try {
            String strA = this.f7896i.a(a(), str, this.f7894g.getCachePrefix(), list, z10, this.f7677a.C().a(str, this.f7894g), this.f7894g.b0());
            if (StringUtils.isValidString(strA)) {
                File fileA = this.f7896i.a(strA, a());
                if (fileA != null) {
                    Uri uriFromFile = Uri.fromFile(fileA);
                    if (uriFromFile != null) {
                        return uriFromFile;
                    }
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f7679c.b(this.f7678b, "Unable to extract Uri from image file");
                    }
                    this.f7677a.A().a(y1.f7788j0, "extractUriFromImageFile", CollectionUtils.hashMap("url", strA));
                    return null;
                }
                if (com.applovin.impl.sdk.n.a()) {
                    this.f7679c.b(this.f7678b, "Unable to retrieve File from cached image filename = " + strA);
                }
                this.f7677a.A().a(y1.f7788j0, "retrieveImageFile", CollectionUtils.hashMap("url", strA));
                return null;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.b(this.f7678b, "Failed to cache image: " + str);
            }
            this.f7677a.A().a(y1.f7788j0, "cacheImageResource", CollectionUtils.hashMap("url", str));
            return null;
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Failed to cache image at url = " + str, th);
            }
            this.f7677a.A().a(this.f7678b, "cacheImageResource", th, CollectionUtils.hashMap("url", str));
            return null;
        }
    }

    protected Uri b(String str) {
        return a(str, this.f7894g.W(), true);
    }

    void a(com.applovin.impl.sdk.ad.b bVar) {
        String strE0 = bVar.e0();
        if (bVar.N0() && StringUtils.isValidString(strE0)) {
            String strA = a(strE0, bVar.W(), bVar);
            bVar.a(strA);
            this.f7679c.f(this.f7678b, "Ad updated with video button HTML assets cached = " + strA);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0034, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.lang.String a(java.lang.String r11, java.util.List r12, com.applovin.impl.sdk.ad.b r13) {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.z4.a(java.lang.String, java.util.List, com.applovin.impl.sdk.ad.b):java.lang.String");
    }

    private Uri a(String str, String str2) {
        File fileA = this.f7896i.a(z6.a(Uri.parse(str2), this.f7894g.getCachePrefix(), this.f7677a), com.applovin.impl.sdk.j.n());
        if (fileA == null) {
            return null;
        }
        if (this.f7896i.a(fileA)) {
            return Uri.parse(com.vungle.ads.internal.model.b.FILE_SCHEME + fileA.getAbsolutePath());
        }
        String str3 = str + str2;
        if (!this.f7896i.a(fileA, str3, Arrays.asList(str), this.f7677a.C().a(str3, this.f7894g), this.f7894g.b0())) {
            return null;
        }
        return Uri.parse(com.vungle.ads.internal.model.b.FILE_SCHEME + fileA.getAbsolutePath());
    }

    void a(int i10) {
        if (this.f7895h != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Calling back ad load failed with error code: " + i10);
            }
            this.f7895h.failedToReceiveAd(i10);
            this.f7895h = null;
        }
        f();
    }
}
