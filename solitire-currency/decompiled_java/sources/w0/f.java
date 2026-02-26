package w0;

import android.content.Context;
import java.io.File;
import w0.d;

/* JADX INFO: compiled from: InternalCacheDiskCacheFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends d {

    /* JADX INFO: compiled from: InternalCacheDiskCacheFactory.java */
    class a implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f35296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f35297b;

        a(Context context, String str) {
            this.f35296a = context;
            this.f35297b = str;
        }

        @Override // w0.d.a
        public File a() {
            File cacheDir = this.f35296a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f35297b != null ? new File(cacheDir, this.f35297b) : cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public f(Context context, String str, long j10) {
        super(new a(context, str), j10);
    }
}
