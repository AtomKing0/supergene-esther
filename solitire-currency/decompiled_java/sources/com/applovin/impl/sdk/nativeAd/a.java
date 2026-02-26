package com.applovin.impl.sdk.nativeAd;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.l4;
import com.applovin.impl.sdk.n;
import com.applovin.impl.w4;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class a extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AppLovinNativeAdImpl f7200g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final InterfaceC0174a f7201h;

    /* JADX INFO: renamed from: com.applovin.impl.sdk.nativeAd.a$a, reason: collision with other inner class name */
    public interface InterfaceC0174a {
        void a(AppLovinNativeAdImpl appLovinNativeAdImpl);
    }

    public a(AppLovinNativeAdImpl appLovinNativeAdImpl, com.applovin.impl.sdk.j jVar, InterfaceC0174a interfaceC0174a) {
        super("TaskCacheNativeAd", jVar);
        this.f7200g = appLovinNativeAdImpl;
        this.f7201h = interfaceC0174a;
    }

    private float a(Uri uri) {
        FileInputStream fileInputStream;
        int i10;
        int i11;
        File file = new File(uri.getPath());
        if (!file.exists()) {
            return -1.0f;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(fileInputStream, null, options);
                i10 = options.outWidth;
                i11 = options.outHeight;
            } finally {
            }
        } catch (IOException e10) {
            if (n.a()) {
                this.f7679c.a(this.f7678b, "Failed to calculate aspect ratio", e10);
            }
        }
        if (i10 <= 0 || i11 <= 0) {
            fileInputStream.close();
            return -1.0f;
        }
        float f10 = i10 / i11;
        fileInputStream.close();
        return f10;
    }

    private Uri b(Uri uri) {
        if (uri == null) {
            return null;
        }
        if (n.a()) {
            this.f7679c.a(this.f7678b, "Attempting to cache resource: " + uri);
        }
        String strA = this.f7677a.C().a(a(), uri.toString(), this.f7200g.getCachePrefix(), Collections.emptyList(), false, false, 1, (String) this.f7677a.a(l4.f5619d4));
        if (TextUtils.isEmpty(strA)) {
            if (n.a()) {
                this.f7679c.b(this.f7678b, "Unable to cache resource for uri: " + uri);
            }
            return null;
        }
        File fileA = this.f7677a.C().a(strA, a());
        if (fileA != null) {
            Uri uriFromFile = Uri.fromFile(fileA);
            if (uriFromFile != null) {
                return uriFromFile;
            }
            if (n.a()) {
                this.f7679c.b(this.f7678b, "Unable to extract Uri from image file");
            }
            return null;
        }
        if (n.a()) {
            this.f7679c.b(this.f7678b, "Unable to retrieve File from cached image filename = " + strA);
        }
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (n.a()) {
            this.f7679c.a(this.f7678b, "Begin caching ad #" + this.f7200g.getAdIdNumber() + "...");
        }
        Uri uriB = b(this.f7200g.getIconUri());
        if (uriB != null) {
            this.f7200g.setIconUri(uriB);
        }
        Uri uriB2 = b(this.f7200g.getMainImageUri());
        if (uriB2 != null) {
            this.f7200g.setMainImageUri(uriB2);
            float fA = a(uriB2);
            if (fA > 0.0f) {
                this.f7200g.setMainImageAspectRatio(fA);
            }
        }
        Uri uriB3 = b(this.f7200g.getPrivacyIconUri());
        if (uriB3 != null) {
            this.f7200g.setPrivacyIconUri(uriB3);
        }
        if (n.a()) {
            this.f7679c.a(this.f7678b, "Finished caching ad #" + this.f7200g.getAdIdNumber());
        }
        this.f7201h.a(this.f7200g);
    }
}
