package v0;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: LruBitmapPool.java */
/* JADX INFO: loaded from: classes2.dex */
public class j implements d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Bitmap.Config f35003k = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f35004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Bitmap.Config> f35005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f35006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f35007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f35008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f35009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f35010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f35011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f35012i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f35013j;

    /* JADX INFO: compiled from: LruBitmapPool.java */
    private interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    j(long j10, k kVar, Set<Bitmap.Config> set) {
        this.f35006c = j10;
        this.f35008e = j10;
        this.f35004a = kVar;
        this.f35005b = set;
        this.f35007d = new b();
    }

    @TargetApi(26)
    private static void f(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @NonNull
    private static Bitmap g(int i10, int i11, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f35003k;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    private void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    private void i() {
        Log.v("LruBitmapPool", "Hits=" + this.f35010g + ", misses=" + this.f35011h + ", puts=" + this.f35012i + ", evictions=" + this.f35013j + ", currentSize=" + this.f35009f + ", maxSize=" + this.f35008e + "\nStrategy=" + this.f35004a);
    }

    private void j() {
        q(this.f35008e);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i10 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i10 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static k l() {
        return new m();
    }

    @Nullable
    private synchronized Bitmap m(int i10, int i11, @Nullable Bitmap.Config config) {
        Bitmap bitmapD;
        f(config);
        bitmapD = this.f35004a.d(i10, i11, config != null ? config : f35003k);
        if (bitmapD == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f35004a.b(i10, i11, config));
            }
            this.f35011h++;
        } else {
            this.f35010g++;
            this.f35009f -= (long) this.f35004a.e(bitmapD);
            this.f35007d.a(bitmapD);
            p(bitmapD);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f35004a.b(i10, i11, config));
        }
        h();
        return bitmapD;
    }

    @TargetApi(19)
    private static void o(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    private static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }

    private synchronized void q(long j10) {
        while (this.f35009f > j10) {
            Bitmap bitmapRemoveLast = this.f35004a.removeLast();
            if (bitmapRemoveLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    i();
                }
                this.f35009f = 0L;
                return;
            }
            this.f35007d.a(bitmapRemoveLast);
            this.f35009f -= (long) this.f35004a.e(bitmapRemoveLast);
            this.f35013j++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f35004a.a(bitmapRemoveLast));
            }
            h();
            bitmapRemoveLast.recycle();
        }
    }

    @Override // v0.d
    @SuppressLint({"InlinedApi"})
    public void a(int i10) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i10);
        }
        if (i10 >= 40 || i10 >= 20) {
            b();
        } else if (i10 >= 20 || i10 == 15) {
            q(n() / 2);
        }
    }

    @Override // v0.d
    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        q(0L);
    }

    @Override // v0.d
    public synchronized void c(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.f35004a.e(bitmap) <= this.f35008e && this.f35005b.contains(bitmap.getConfig())) {
                int iE = this.f35004a.e(bitmap);
                this.f35004a.c(bitmap);
                this.f35007d.b(bitmap);
                this.f35012i++;
                this.f35009f += (long) iE;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f35004a.a(bitmap));
                }
                h();
                j();
                return;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f35004a.a(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f35005b.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // v0.d
    @NonNull
    public Bitmap d(int i10, int i11, Bitmap.Config config) {
        Bitmap bitmapM = m(i10, i11, config);
        if (bitmapM == null) {
            return g(i10, i11, config);
        }
        bitmapM.eraseColor(0);
        return bitmapM;
    }

    @Override // v0.d
    @NonNull
    public Bitmap e(int i10, int i11, Bitmap.Config config) {
        Bitmap bitmapM = m(i10, i11, config);
        return bitmapM == null ? g(i10, i11, config) : bitmapM;
    }

    public long n() {
        return this.f35008e;
    }

    public j(long j10) {
        this(j10, l(), k());
    }

    /* JADX INFO: compiled from: LruBitmapPool.java */
    private static final class b implements a {
        b() {
        }

        @Override // v0.j.a
        public void a(Bitmap bitmap) {
        }

        @Override // v0.j.a
        public void b(Bitmap bitmap) {
        }
    }
}
