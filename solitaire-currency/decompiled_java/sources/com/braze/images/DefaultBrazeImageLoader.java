package com.braze.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.LruCache;
import android.widget.ImageView;
import bo.app.dq;
import bo.app.eq;
import bo.app.fp;
import bo.app.fq;
import bo.app.gq;
import bo.app.ip;
import bo.app.jp;
import bo.app.kp;
import bo.app.lp;
import bo.app.mp;
import bo.app.np;
import bo.app.op;
import bo.app.pp;
import bo.app.qp;
import bo.app.u;
import bo.app.up;
import bo.app.vp;
import bo.app.wp;
import bo.app.xp;
import bo.app.yp;
import bo.app.z;
import bo.app.zp;
import com.braze.R$string;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.enums.BrazeViewBounds;
import com.braze.models.cards.Card;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeImageUtils;
import com.braze.support.BrazeLogger;
import h9.a;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import p9.q;
import p9.r;
import v8.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultBrazeImageLoader implements IBrazeImageLoader {
    public static final ip Companion = new ip();
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) DefaultBrazeImageLoader.class);
    private final ReentrantLock diskCacheLock;
    private z diskLruCache;
    private boolean isDiskCacheStarting;
    private boolean isOffline;
    private final LruCache<String, Bitmap> memoryCache;

    public DefaultBrazeImageLoader(Context context) {
        t.i(context, "context");
        this.diskCacheLock = new ReentrantLock();
        this.isDiskCacheStarting = true;
        this.memoryCache = new fp(BrazeImageUtils.getImageLoaderCacheSize());
        initDiskCacheTask(context);
    }

    private final void initDiskCacheTask(Context context) {
        k.d(BrazeCoroutineScope.INSTANCE, null, null, new up(context, this, null), 3, null);
    }

    private final Bitmap putBitmapIntoMemCache(String str, Bitmap bitmap) {
        return this.memoryCache.put(str, bitmap);
    }

    private final void renderUrlIntoView(Context context, String str, ImageView imageView, BrazeViewBounds brazeViewBounds) {
        if (q.z(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) yp.f4377a, 7, (Object) null);
            return;
        }
        try {
            renderUrlIntoViewTask$android_sdk_base_release(context, imageView, brazeViewBounds, str);
        } catch (Throwable th) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, th, false, (a) new zp(str), 4, (Object) null);
        }
    }

    public final u downloadBitmapFromUrl(Context context, Uri imageUri, BrazeViewBounds brazeViewBounds) {
        t.i(context, "context");
        t.i(imageUri, "imageUri");
        if (brazeViewBounds == null) {
            brazeViewBounds = BrazeViewBounds.NO_BOUNDS;
        }
        return BrazeImageUtils.getBitmap(context, imageUri, brazeViewBounds);
    }

    public final Bitmap getBitmapFromCache(String key) {
        t.i(key, "key");
        Bitmap bitmap = this.memoryCache.get(key);
        if (bitmap != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new jp(key, this), 6, (Object) null);
            return bitmap;
        }
        Bitmap bitmapFromDiskCache = getBitmapFromDiskCache(key);
        if (bitmapFromDiskCache == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new lp(key), 7, (Object) null);
            return null;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new kp(key), 6, (Object) null);
        putBitmapIntoMemCache(key, bitmapFromDiskCache);
        return bitmapFromDiskCache;
    }

    public final Bitmap getBitmapFromDiskCache(String key) {
        t.i(key, "key");
        ReentrantLock reentrantLock = this.diskCacheLock;
        reentrantLock.lock();
        try {
            z zVar = null;
            if (this.isDiskCacheStarting) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new mp(key), 6, (Object) null);
            } else {
                z zVar2 = this.diskLruCache;
                if (zVar2 == null) {
                    t.A("diskLruCache");
                    zVar2 = null;
                }
                if (zVar2.a(key)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new np(key), 6, (Object) null);
                    z zVar3 = this.diskLruCache;
                    if (zVar3 == null) {
                        t.A("diskLruCache");
                    } else {
                        zVar = zVar3;
                    }
                    return zVar.b(key);
                }
            }
            k0 k0Var = k0.f35197a;
            return null;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final Bitmap getBitmapFromMemCache(String key) {
        t.i(key, "key");
        return this.memoryCache.get(key);
    }

    public final Bitmap getBitmapFromUrl(Context context, String imageUrl, BrazeViewBounds brazeViewBounds) {
        Bitmap bitmapFromCache;
        t.i(context, "context");
        t.i(imageUrl, "imageUrl");
        if (q.z(imageUrl)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) op.f3576a, 7, (Object) null);
            return null;
        }
        try {
            bitmapFromCache = getBitmapFromCache(imageUrl);
        } catch (Throwable th) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, th, false, (a) new qp(imageUrl), 4, (Object) null);
        }
        if (bitmapFromCache != null) {
            return bitmapFromCache;
        }
        if (this.isOffline) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) pp.f3640a, 7, (Object) null);
        } else {
            Uri imageUri = Uri.parse(imageUrl);
            t.h(imageUri, "imageUri");
            u uVarDownloadBitmapFromUrl = downloadBitmapFromUrl(context, imageUri, brazeViewBounds);
            if (uVarDownloadBitmapFromUrl.f3977a != null) {
                if (!shouldSkipCaching(imageUri, uVarDownloadBitmapFromUrl.f3978b)) {
                    putBitmapIntoCache(imageUrl, uVarDownloadBitmapFromUrl.f3977a, BrazeFileUtils.isLocalUri(imageUri));
                }
                return uVarDownloadBitmapFromUrl.f3977a;
            }
        }
        return null;
    }

    @Override // com.braze.images.IBrazeImageLoader
    public Bitmap getInAppMessageBitmapFromUrl(Context context, IInAppMessage inAppMessage, String imageUrl, BrazeViewBounds brazeViewBounds) {
        t.i(context, "context");
        t.i(inAppMessage, "inAppMessage");
        t.i(imageUrl, "imageUrl");
        return getBitmapFromUrl(context, imageUrl, brazeViewBounds);
    }

    public final LruCache<String, Bitmap> getMemoryCache() {
        return this.memoryCache;
    }

    @Override // com.braze.images.IBrazeImageLoader
    public Bitmap getPushBitmapFromUrl(Context context, Bundle bundle, String imageUrl, BrazeViewBounds brazeViewBounds) {
        t.i(context, "context");
        t.i(imageUrl, "imageUrl");
        return getBitmapFromUrl(context, imageUrl, brazeViewBounds);
    }

    public final void putBitmapIntoCache(String key, Bitmap bitmap, boolean z10) {
        t.i(key, "key");
        t.i(bitmap, "bitmap");
        if (getBitmapFromMemCache(key) == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new vp(key), 7, (Object) null);
            this.memoryCache.put(key, bitmap);
        }
        if (z10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new wp(key), 7, (Object) null);
            return;
        }
        ReentrantLock reentrantLock = this.diskCacheLock;
        reentrantLock.lock();
        try {
            if (!this.isDiskCacheStarting) {
                z zVar = this.diskLruCache;
                z zVar2 = null;
                if (zVar == null) {
                    t.A("diskLruCache");
                    zVar = null;
                }
                if (!zVar.a(key)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new xp(key), 7, (Object) null);
                    z zVar3 = this.diskLruCache;
                    if (zVar3 == null) {
                        t.A("diskLruCache");
                    } else {
                        zVar2 = zVar3;
                    }
                    zVar2.a(key, bitmap);
                }
            }
            k0 k0Var = k0.f35197a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.braze.images.IBrazeImageLoader
    public void renderUrlIntoCardView(Context context, Card card, String imageUrl, ImageView imageView, BrazeViewBounds brazeViewBounds) {
        t.i(context, "context");
        t.i(card, "card");
        t.i(imageUrl, "imageUrl");
        t.i(imageView, "imageView");
        renderUrlIntoView(context, imageUrl, imageView, brazeViewBounds);
    }

    @Override // com.braze.images.IBrazeImageLoader
    public void renderUrlIntoInAppMessageView(Context context, IInAppMessage inAppMessage, String imageUrl, ImageView imageView, BrazeViewBounds brazeViewBounds) {
        t.i(context, "context");
        t.i(inAppMessage, "inAppMessage");
        t.i(imageUrl, "imageUrl");
        t.i(imageView, "imageView");
        renderUrlIntoView(context, imageUrl, imageView, brazeViewBounds);
    }

    public final void renderUrlIntoViewTask$android_sdk_base_release(Context context, ImageView imageView, BrazeViewBounds brazeViewBounds, String imageUrl) {
        t.i(context, "context");
        t.i(imageView, "imageView");
        t.i(imageUrl, "imageUrl");
        imageView.setTag(R$string.com_braze_image_lru_cache_image_url_key, imageUrl);
        k.d(BrazeCoroutineScope.INSTANCE, null, null, new dq(this, context, imageUrl, brazeViewBounds, imageView, null), 3, null);
    }

    @Override // com.braze.images.IBrazeImageLoader
    public void setOffline(boolean z10) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) new eq(z10), 6, (Object) null);
        this.isOffline = z10;
    }

    public final boolean shouldSkipCaching(Uri imageUri, Map<String, ? extends List<String>> map) {
        t.i(imageUri, "imageUri");
        if (!imageUri.getBooleanQueryParameter("cache", true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new fq(imageUri), 7, (Object) null);
            return true;
        }
        if (map == null) {
            return false;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends List<String>> entry : map.entrySet()) {
            if (q.x(entry.getKey(), "cache-control", true)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Iterable<String> iterable = (Iterable) entry2.getValue();
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                for (String str : iterable) {
                    if (r.N(str, "no-cache", true) || r.N(str, "max-age=0", true)) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new gq(entry2, imageUri), 7, (Object) null);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
