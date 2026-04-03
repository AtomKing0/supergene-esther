package bo.app;

import android.content.Context;
import com.braze.images.DefaultBrazeImageLoader;
import com.braze.support.BrazeLogger;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class up extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f4034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DefaultBrazeImageLoader f4035b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public up(Context context, DefaultBrazeImageLoader defaultBrazeImageLoader, z8.d dVar) {
        super(2, dVar);
        this.f4034a = context;
        this.f4035b = defaultBrazeImageLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new up(this.f4034a, this.f4035b, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new up(this.f4034a, this.f4035b, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        ip ipVar = DefaultBrazeImageLoader.Companion;
        Context context = this.f4034a;
        ipVar.getClass();
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i("appboy.imageloader.lru.cache", "uniqueName");
        StringBuilder sb = new StringBuilder();
        sb.append(context.getCacheDir().getPath());
        File file = new File(d1.a(sb, File.separator, "appboy.imageloader.lru.cache"));
        ReentrantLock reentrantLock = this.f4035b.diskCacheLock;
        DefaultBrazeImageLoader defaultBrazeImageLoader = this.f4035b;
        reentrantLock.lock();
        try {
            try {
                BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                BrazeLogger.brazelog$default(brazeLogger, DefaultBrazeImageLoader.TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) rp.f3799a, 14, (Object) null);
                defaultBrazeImageLoader.diskLruCache = new z(file);
                BrazeLogger.brazelog$default(brazeLogger, DefaultBrazeImageLoader.TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) sp.f3873a, 14, (Object) null);
                defaultBrazeImageLoader.isDiskCacheStarting = false;
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, DefaultBrazeImageLoader.TAG, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) tp.f3962a, 8, (Object) null);
            }
            return v8.k0.f35197a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
