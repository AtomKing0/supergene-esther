package com.applovin.impl.sdk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.StrictMode;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.applovin.impl.k0;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.AppLovinSdkUtils;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class ImageViewUtils {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, final j jVar, final ImageView imageView, Uri uri) {
        try {
            InputStream inputStreamOpenStream = new URL(str).openStream();
            try {
                final Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenStream);
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageViewUtils.a(jVar, bitmapDecodeStream, imageView);
                    }
                });
                if (inputStreamOpenStream != null) {
                    inputStreamOpenStream.close();
                }
            } finally {
            }
        } catch (Throwable th) {
            jVar.I();
            if (n.a()) {
                jVar.I().a("ImageViewUtils", "Failed to fetch image: " + uri, th);
            }
            jVar.I().a("ImageViewUtils", th);
            jVar.A().a("ImageViewUtils", "setImageUri", th);
        }
    }

    public static void setAndDownscaleBitmap(final ImageView imageView, final Uri uri) {
        if (uri == null || imageView == null) {
            return;
        }
        j jVar = j.f7084v0;
        if (jVar == null) {
            n.h("ImageViewUtils", "SDK has not been initialized");
        } else {
            jVar.j0().b().execute(new Runnable() { // from class: com.applovin.impl.sdk.utils.a
                @Override // java.lang.Runnable
                public final void run() {
                    ImageViewUtils.a(uri, imageView);
                }
            });
        }
    }

    public static void setAndDownscaleImageUri(final ImageView imageView, final Uri uri) {
        if (uri == null || imageView == null) {
            return;
        }
        if (imageView.getHeight() <= 0 || imageView.getWidth() <= 0) {
            imageView.post(new Runnable() { // from class: com.applovin.impl.sdk.utils.b
                @Override // java.lang.Runnable
                public final void run() {
                    ImageViewUtils.setAndDownscaleBitmap(imageView, uri);
                }
            });
        } else {
            setAndDownscaleBitmap(imageView, uri);
        }
    }

    public static void setImageUri(final ImageView imageView, final Uri uri, final j jVar) {
        if (imageView == null || uri == null) {
            return;
        }
        final String string = uri.toString();
        if (URLUtil.isFileUrl(string) || URLUtil.isContentUrl(string)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.f
                @Override // java.lang.Runnable
                public final void run() {
                    ImageViewUtils.b(imageView, uri);
                }
            });
            return;
        }
        if (jVar == null) {
            return;
        }
        jVar.I();
        if (n.a()) {
            jVar.I().a("ImageViewUtils", "Fetching image: " + uri);
        }
        jVar.j0().b().execute(new Runnable() { // from class: com.applovin.impl.sdk.utils.e
            @Override // java.lang.Runnable
            public final void run() {
                ImageViewUtils.a(string, jVar, imageView, uri);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(ImageView imageView, Uri uri) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        imageView.setImageURI(uri);
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(j jVar, Bitmap bitmap, ImageView imageView) {
        jVar.I();
        if (n.a()) {
            jVar.I().a("ImageViewUtils", "Image fetched");
        }
        imageView.setImageDrawable(new BitmapDrawable(j.n().getResources(), bitmap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Uri uri, final ImageView imageView) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i10 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(uri.getPath(), options);
        int height = imageView.getHeight();
        int width = imageView.getWidth();
        if (height <= 0 || width <= 0) {
            Point pointB = k0.b(imageView.getContext());
            height = Math.min(pointB.x, pointB.y);
            width = height;
        }
        int i11 = options.outHeight;
        int i12 = options.outWidth;
        if (i11 > height || i12 > width) {
            while (true) {
                int i13 = i10 * 2;
                if (i11 / i13 < height && i12 / i13 < width) {
                    break;
                } else {
                    i10 = i13;
                }
            }
        }
        options.inSampleSize = i10;
        options.inJustDecodeBounds = false;
        j.f7084v0.I();
        if (n.a()) {
            j.f7084v0.I().a("ImageViewUtils", "Loading image: " + uri.getLastPathSegment() + "...");
        }
        final Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(uri.getPath(), options);
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.d
            @Override // java.lang.Runnable
            public final void run() {
                imageView.setImageBitmap(bitmapDecodeFile);
            }
        });
    }
}
