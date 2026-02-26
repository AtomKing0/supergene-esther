package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import bo.app.a50;
import bo.app.ec0;
import bo.app.hc0;
import bo.app.xs;
import bo.app.ys;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.events.IEventSubscriber;
import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.b2;

/* JADX INFO: loaded from: classes2.dex */
public final class xs {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f4296f = TimeUnit.SECONDS.toMillis(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb0 f4297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v00 f4298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedPreferences f4299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fu f4300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b2 f4301e;

    public xs(Context context, vw internalPublisher, vb0 serverConfigStorageProvider, String str, String str2) {
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        kotlin.jvm.internal.t.i(internalPublisher, "internalPublisher");
        kotlin.jvm.internal.t.i(context, "context");
        this.f4297a = serverConfigStorageProvider;
        this.f4298b = internalPublisher;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.braze.managers.dust.metadata" + StringUtils.getCacheFileSuffix(context, str, str2), 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        this.f4299c = sharedPreferences;
        this.f4300d = new fu();
        internalPublisher.c(new IEventSubscriber() { // from class: i.m0
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) throws InterruptedException {
                xs.a(this.f26545a, (ec0) obj);
            }
        }, ec0.class);
        internalPublisher.c(new IEventSubscriber() { // from class: i.n0
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                xs.a(this.f26547a, (hc0) obj);
            }
        }, hc0.class);
        internalPublisher.c(new IEventSubscriber() { // from class: i.o0
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) throws InterruptedException {
                xs.a(this.f26549a, (a50) obj);
            }
        }, a50.class);
        internalPublisher.c(new IEventSubscriber() { // from class: i.p0
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) throws InterruptedException {
                xs.a(this.f26552a, (ys) obj);
            }
        }, ys.class);
    }

    public static final void a(xs this$0, ec0 it) throws InterruptedException {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) js.f3177a, 7, (Object) null);
        b2 b2Var = this$0.f4301e;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this$0.a(true);
    }

    public static final void a(xs this$0, hc0 it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) ks.f3280a, 7, (Object) null);
        this$0.f4301e = BrazeCoroutineScope.launchDelayed$default(BrazeCoroutineScope.INSTANCE, Long.valueOf(f4296f), null, new ms(this$0, null), 2, null);
    }

    public static final void a(xs this$0, a50 it) throws InterruptedException {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new ns(it), 7, (Object) null);
        z40 z40Var = it.f2352b;
        z40 z40Var2 = z40.NONE;
        if (z40Var == z40Var2) {
            this$0.a();
        } else if (it.f2351a == z40Var2) {
            this$0.a(true);
        }
    }

    public static final void a(xs this$0, ys it) throws InterruptedException {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) os.f3579a, 7, (Object) null);
        String string = this$0.f4299c.getString("mite", null);
        String str = it.f4381a;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new ts(str), 7, (Object) null);
        this$0.f4299c.edit().putString("mite", str).apply();
        this$0.a(kotlin.jvm.internal.t.d(string, it.f4381a));
    }

    public final void a() {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) qs.f3725a, 7, (Object) null);
        fu fuVar = this.f4300d;
        fuVar.getClass();
        BrazeLogger.brazelog$default(brazeLogger, (Object) fuVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new gt(fuVar), 7, (Object) null);
        b2 b2Var = fuVar.f2843a;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        fuVar.f2843a = null;
    }

    public final void a(boolean z10) throws InterruptedException {
        String string = this.f4299c.getString("mite", null);
        if (string != null && this.f4297a.x()) {
            String url = "https://dust.k8s.test-001.d-usw-2.braze.com/sse?mite=".concat(string);
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new vs(z10, string, url), 7, (Object) null);
            fu fuVar = this.f4300d;
            ws ingestor = new ws(this);
            fuVar.getClass();
            kotlin.jvm.internal.t.i(url, "url");
            kotlin.jvm.internal.t.i(ingestor, "ingestor");
            BrazeLogger.brazelog$default(brazeLogger, (Object) fuVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new st(url), 7, (Object) null);
            if (!z10 || fuVar.f2843a == null) {
                kotlinx.coroutines.j.b(null, new ut(fuVar, null), 1, null);
                fuVar.f2843a = kotlinx.coroutines.k.d(BrazeCoroutineScope.INSTANCE, null, null, new du(fuVar, ingestor, url, null), 3, null);
                BrazeLogger.brazelog$default(brazeLogger, (Object) fuVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new eu(fuVar), 7, (Object) null);
                return;
            }
            BrazeLogger.brazelog$default(brazeLogger, (Object) fuVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new tt(fuVar), 7, (Object) null);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new us(string, this), 7, (Object) null);
    }
}
