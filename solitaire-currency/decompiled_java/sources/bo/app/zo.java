package bo.app;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import bo.app.ec0;
import bo.app.hc0;
import bo.app.zo;
import com.braze.Braze;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.events.IEventSubscriber;
import com.braze.support.BrazeLogger;
import kotlinx.coroutines.b2;

/* JADX INFO: loaded from: classes2.dex */
public final class zo {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f4455m = BrazeLogger.getBrazeLogTag((Class<?>) zo.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v00 f4457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ao f4458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final jo f4459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final fo f4460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4462g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f4463h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConnectivityManager f4464i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public z40 f4465j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b2 f4466k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f4467l;

    public zo(Context context, vw internalEventPublisher, ao dataSyncConfigurationProvider) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(internalEventPublisher, "internalEventPublisher");
        kotlin.jvm.internal.t.i(dataSyncConfigurationProvider, "dataSyncConfigurationProvider");
        this.f4456a = context;
        this.f4457b = internalEventPublisher;
        this.f4458c = dataSyncConfigurationProvider;
        this.f4461f = 2;
        this.f4462g = -1L;
        Object systemService = context.getSystemService("connectivity");
        kotlin.jvm.internal.t.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f4464i = (ConnectivityManager) systemService;
        this.f4465j = z40.GOOD;
        if (Build.VERSION.SDK_INT >= 30) {
            this.f4460e = new fo(this);
        } else {
            this.f4459d = new jo(this);
        }
        a(internalEventPublisher);
    }

    public final void a(vw eventManager) {
        kotlin.jvm.internal.t.i(eventManager, "eventManager");
        eventManager.c(new IEventSubscriber() { // from class: i.q0
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                zo.a(this.f26554a, (ec0) obj);
            }
        }, ec0.class);
        eventManager.c(new IEventSubscriber() { // from class: i.r0
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                zo.a(this.f26556a, (hc0) obj);
            }
        }, hc0.class);
    }

    public final synchronized void b() {
        if (this.f4463h) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) uo.f4033a, 7, (Object) null);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) vo.f4129a, 7, (Object) null);
        if (Build.VERSION.SDK_INT >= 30) {
            ConnectivityManager connectivityManager = this.f4464i;
            fo foVar = this.f4460e;
            if (foVar == null) {
                kotlin.jvm.internal.t.A("connectivityNetworkCallback");
                foVar = null;
            }
            connectivityManager.registerDefaultNetworkCallback(foVar);
            a(this.f4464i.getNetworkCapabilities(this.f4464i.getActiveNetwork()));
        } else {
            this.f4456a.registerReceiver(this.f4459d, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        a(this.f4462g);
        this.f4463h = true;
    }

    public final synchronized void c() {
        if (!this.f4463h) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) wo.f4222a, 7, (Object) null);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) xo.f4292a, 7, (Object) null);
        b2 b2Var = this.f4466k;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.f4466k = null;
        d();
        this.f4463h = false;
    }

    public final void d() {
        try {
            if (Build.VERSION.SDK_INT < 30) {
                this.f4456a.unregisterReceiver(this.f4459d);
                return;
            }
            ConnectivityManager connectivityManager = this.f4464i;
            fo foVar = this.f4460e;
            if (foVar == null) {
                kotlin.jvm.internal.t.A("connectivityNetworkCallback");
                foVar = null;
            }
            connectivityManager.unregisterNetworkCallback(foVar);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) yo.f4376a, 4, (Object) null);
        }
    }

    public static final void a(zo this$0, ec0 it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        this$0.f4461f = 1;
        this$0.a();
    }

    public static final void a(zo this$0, hc0 it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        this$0.f4461f = 2;
        this$0.a();
    }

    public final void a(NetworkCapabilities networkCapabilities) {
        z40 z40Var = this.f4465j;
        z40 z40VarA = com.braze.support.c.a(networkCapabilities);
        this.f4465j = z40VarA;
        if (z40Var != z40VarA) {
            ((vw) this.f4457b).b(a50.class, new a50(z40Var, z40VarA));
        }
        a();
    }

    public final void a(long j10) {
        b2 b2Var = this.f4466k;
        b2 b2VarD = null;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.f4466k = null;
        if (this.f4462g >= 1000) {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new to(j10), 7, (Object) null);
            if (this.f4462g >= 1000) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new ko(j10, this), 6, (Object) null);
                b2VarD = kotlinx.coroutines.k.d(BrazeCoroutineScope.INSTANCE, null, null, new mo(this, j10, null), 3, null);
            } else {
                Braze.Companion.getInstance(this.f4456a).requestImmediateDataFlush();
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new no(this), 7, (Object) null);
            }
            this.f4466k = b2VarD;
        }
    }

    public final synchronized void a(boolean z10) {
        this.f4467l = z10;
        a();
        if (z10) {
            c();
        } else {
            b();
        }
    }

    public final void a() {
        long j10;
        int intValue;
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) new po(this), 6, (Object) null);
        long j11 = this.f4462g;
        if (this.f4461f != 2 && !this.f4467l) {
            int iOrdinal = this.f4465j.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    intValue = this.f4458c.getIntValue("com_braze_data_flush_interval_bad_network", 60);
                } else if (iOrdinal == 2) {
                    intValue = this.f4458c.getIntValue("com_braze_data_flush_interval_good_network", 30);
                } else if (iOrdinal == 3) {
                    intValue = this.f4458c.getIntValue("com_braze_data_flush_interval_great_network", 10);
                } else {
                    throw new v8.q();
                }
                j10 = ((long) intValue) * 1000;
            } else {
                j10 = -1;
            }
            this.f4462g = j10;
            if (j10 != -1 && j10 < 1000) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new qo(this), 6, (Object) null);
                this.f4462g = 1000L;
            }
        } else {
            this.f4462g = -1L;
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) new ro(this), 6, (Object) null);
        if (j11 != this.f4462g) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new so(j11, this), 7, (Object) null);
            a(this.f4462g);
        }
    }
}
