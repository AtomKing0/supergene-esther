package bo.app;

import android.content.Context;
import bo.app.v70;
import bo.app.w90;
import bo.app.x90;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.events.IEventSubscriber;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.b2;

/* JADX INFO: loaded from: classes2.dex */
public final class w90 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final q90 f4175k = new q90();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb0 f4176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v00 f4177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r90 f4178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f4181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ReentrantLock f4183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b2 f4184i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicInteger f4185j;

    public w90(Context context, vw internalPublisher, vb0 serverConfigStorageProvider) {
        kotlin.jvm.internal.t.i(serverConfigStorageProvider, "serverConfigStorageProvider");
        kotlin.jvm.internal.t.i(internalPublisher, "internalPublisher");
        kotlin.jvm.internal.t.i(context, "context");
        this.f4176a = serverConfigStorageProvider;
        this.f4177b = internalPublisher;
        this.f4178c = new r90();
        this.f4179d = DateTimeUtils.nowInSeconds();
        this.f4181f = new ArrayList();
        this.f4183h = new ReentrantLock();
        this.f4185j = new AtomicInteger(0);
        if (c()) {
            b();
        }
        internalPublisher.c(new IEventSubscriber() { // from class: i.k0
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                w90.a(this.f26542a, (v70) obj);
            }
        }, v70.class);
        internalPublisher.c(new IEventSubscriber() { // from class: i.l0
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                w90.a(this.f26543a, (x90) obj);
            }
        }, x90.class);
    }

    public static final void a(w90 this$0, v70 it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        if (it.f4077a instanceof ha0) {
            this$0.f4185j.decrementAndGet();
            kotlinx.coroutines.k.d(BrazeCoroutineScope.INSTANCE, null, null, new l90(this$0, null), 3, null);
        }
    }

    public final void b() {
        BrazeLogger.INSTANCE.setSdkDebuggerCallback$android_sdk_base_release(new t90(this));
        ((vw) this.f4177b).b(ca0.class, new ca0());
    }

    public final boolean c() {
        this.f4178c.f3752a = this.f4176a.E();
        r90 r90Var = this.f4178c;
        if (r90Var.f3752a) {
            r90Var.f3754c = this.f4176a.r();
            this.f4178c.f3755d = this.f4176a.t();
            this.f4178c.f3756e = this.f4176a.u();
            this.f4178c.f3757f = this.f4176a.v();
            this.f4178c.f3753b = Long.valueOf(this.f4176a.s());
        }
        Long l10 = this.f4178c.f3753b;
        if (l10 != null) {
            if (DateTimeUtils.nowInSeconds() > l10.longValue()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) u90.f4001a, 7, (Object) null);
                this.f4178c = new r90();
            }
        }
        return this.f4178c.f3752a;
    }

    public final void d() {
        BrazeLogger.INSTANCE.setSdkDebuggerCallback$android_sdk_base_release(null);
        this.f4178c = new r90();
        ReentrantLock reentrantLock = this.f4183h;
        reentrantLock.lock();
        try {
            this.f4181f.clear();
            this.f4182g = 0;
            v8.k0 k0Var = v8.k0.f35197a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static final void a(w90 this$0, x90 newConfig) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(newConfig, "newConfig");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new m90(newConfig), 7, (Object) null);
        r90 r90Var = this$0.f4178c;
        r90 r90Var2 = newConfig.f4255a;
        if (r90Var2.f3753b == null) {
            r90Var2.f3753b = r90Var.f3753b;
        }
        if (r90Var2.f3754c == null) {
            r90Var2.f3754c = r90Var.f3754c;
        }
        this$0.f4178c = r90Var2;
        this$0.f4176a.a(r90Var2);
        boolean z10 = r90Var.f3752a;
        if (!z10 && this$0.f4178c.f3752a) {
            this$0.b();
        } else {
            if (!z10 || this$0.f4178c.f3752a) {
                return;
            }
            this$0.d();
        }
    }

    public final void a(String log) {
        kotlin.jvm.internal.t.i(log, "log");
        ea0 ea0Var = new ea0(log, DateTimeUtils.nowInMilliseconds());
        ReentrantLock reentrantLock = this.f4183h;
        reentrantLock.lock();
        try {
            this.f4181f.add(ea0Var);
            int length = this.f4182g + log.length();
            this.f4182g = length;
            if (length > 1048576) {
                while (this.f4182g > 838860) {
                    this.f4182g -= ((ea0) this.f4181f.remove(0)).f2718a.length();
                    this.f4180e++;
                }
            }
            v8.k0 k0Var = v8.k0.f35197a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final v8.k0 a() {
        Long l10;
        r90 r90Var = this.f4178c;
        if (r90Var.f3752a && r90Var.f3754c != null && (l10 = r90Var.f3753b) != null && l10.longValue() != 0 && this.f4185j.get() <= 0) {
            Long l11 = this.f4178c.f3753b;
            if (l11 != null) {
                if (DateTimeUtils.nowInSeconds() > l11.longValue()) {
                    d();
                    return v8.k0.f35197a;
                }
            }
            long jNowInSeconds = DateTimeUtils.nowInSeconds();
            long j10 = this.f4179d;
            r90 r90Var2 = this.f4178c;
            long j11 = j10 + r90Var2.f3756e;
            if (jNowInSeconds <= j11 && this.f4182g <= r90Var2.f3755d) {
                if (this.f4184i == null) {
                    this.f4184i = BrazeCoroutineScope.launchDelayed$default(BrazeCoroutineScope.INSTANCE, kotlin.coroutines.jvm.internal.b.e(TimeUnit.SECONDS.toMillis(j11 - DateTimeUtils.nowInSeconds())), null, new s90(this, null), 2, null);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                ReentrantLock reentrantLock = this.f4183h;
                reentrantLock.lock();
                try {
                    int length = 0;
                    int length2 = 0;
                    for (ea0 ea0Var : this.f4181f) {
                        if (this.f4180e != 0) {
                            String log = "Removed " + this.f4180e + " logs due to buffer overflow";
                            kotlin.jvm.internal.t.i(log, "log");
                            arrayList.add(new ea0(log, DateTimeUtils.nowInMilliseconds()));
                            this.f4180e = 0;
                            length2 += log.length();
                        }
                        int length3 = ea0Var.f2718a.length() + length2;
                        if (length3 <= this.f4178c.f3757f) {
                            arrayList.add(ea0Var);
                            length2 = length3;
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        this.f4181f.remove((ea0) it.next());
                    }
                    Iterator it2 = this.f4181f.iterator();
                    while (it2.hasNext()) {
                        length += ((ea0) it2.next()).f2718a.length();
                    }
                    this.f4182g = length;
                    this.f4179d = DateTimeUtils.nowInSeconds();
                    v8.k0 k0Var = v8.k0.f35197a;
                    reentrantLock.unlock();
                    b2 b2Var = this.f4184i;
                    if (b2Var != null) {
                        b2.a.a(b2Var, null, 1, null);
                    }
                    this.f4184i = null;
                    if (!arrayList.isEmpty()) {
                        this.f4185j.incrementAndGet();
                        ((vw) this.f4177b).b(ia0.class, new ia0(arrayList));
                    }
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            return v8.k0.f35197a;
        }
        return v8.k0.f35197a;
    }
}
