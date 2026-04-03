package bo.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.braze.events.SessionStateChangedEvent;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.IntentUtils;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.b2;

/* JADX INFO: loaded from: classes2.dex */
public final class ci {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f2534m = BrazeLogger.getBrazeLogTag((Class<?>) ci.class);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f2535n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f2536o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e10 f2538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v00 f2539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v00 f2540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AlarmManager f2541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f2543g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ReentrantLock f2544h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f2545i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final nh f2546j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b2 f2547k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public w40 f2548l;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f2535n = timeUnit.toMillis(10L);
        f2536o = timeUnit.toMillis(10L);
    }

    public ci(Context applicationContext, cv sessionStorageManager, vw internalEventPublisher, v00 externalEventPublisher, AlarmManager alarmManager, int i10, boolean z10) {
        kotlin.jvm.internal.t.i(applicationContext, "applicationContext");
        kotlin.jvm.internal.t.i(sessionStorageManager, "sessionStorageManager");
        kotlin.jvm.internal.t.i(internalEventPublisher, "internalEventPublisher");
        kotlin.jvm.internal.t.i(externalEventPublisher, "externalEventPublisher");
        kotlin.jvm.internal.t.i(alarmManager, "alarmManager");
        this.f2537a = applicationContext;
        this.f2538b = sessionStorageManager;
        this.f2539c = internalEventPublisher;
        this.f2540d = externalEventPublisher;
        this.f2541e = alarmManager;
        this.f2542f = i10;
        this.f2543g = z10;
        this.f2544h = new ReentrantLock();
        this.f2547k = kotlinx.coroutines.h2.b(null, 1, null);
        nh nhVar = new nh(this);
        this.f2546j = nhVar;
        String str = applicationContext.getPackageName() + ".intent.BRAZE_SESSION_SHOULD_SEAL";
        this.f2545i = str;
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                applicationContext.registerReceiver(nhVar, new IntentFilter(str), 2);
            } else {
                applicationContext.registerReceiver(nhVar, new IntentFilter(str));
            }
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new oh(this), 4, (Object) null);
            this.f2546j = null;
        }
    }

    public final void a() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) ph.f3630a, 7, (Object) null);
        try {
            Intent intent = new Intent(this.f2545i);
            intent.putExtra("session_id", String.valueOf(this.f2548l));
            this.f2541e.cancel(PendingIntent.getBroadcast(this.f2537a, 0, intent, IntentUtils.getImmutablePendingIntentFlags() | 1073741824));
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) qh.f3711a, 4, (Object) null);
        }
    }

    public final void b() {
        w40 mutableSession = this.f2548l;
        if (mutableSession != null) {
            int i10 = this.f2542f;
            boolean z10 = this.f2543g;
            kotlin.jvm.internal.t.i(mutableSession, "mutableSession");
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long millis = timeUnit.toMillis(i10);
            if (z10) {
                millis = Math.max(f2536o, (timeUnit.toMillis((long) mutableSession.f4422b) + millis) - DateTimeUtils.nowInMilliseconds());
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new rh(millis), 7, (Object) null);
            try {
                Intent intent = new Intent(this.f2545i);
                intent.putExtra("session_id", mutableSession.toString());
                this.f2541e.set(1, DateTimeUtils.nowInMilliseconds() + millis, PendingIntent.getBroadcast(this.f2537a, 0, intent, IntentUtils.getImmutablePendingIntentFlags() | 1073741824));
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) sh.f3859a, 4, (Object) null);
            }
        }
    }

    public final boolean c() {
        ReentrantLock reentrantLock = this.f2544h;
        reentrantLock.lock();
        try {
            f();
            w40 w40Var = this.f2548l;
            boolean z10 = true;
            if (w40Var == null || w40Var.f4424d) {
                e();
                if (w40Var != null && w40Var.f4424d) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new th(w40Var), 7, (Object) null);
                    this.f2538b.a(w40Var.f4421a.f2502b);
                }
            } else if (w40Var.f4423c != null) {
                w40Var.f4423c = null;
            } else {
                z10 = false;
            }
            return z10;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final cc0 d() {
        ReentrantLock reentrantLock = this.f2544h;
        reentrantLock.lock();
        try {
            f();
            w40 w40Var = this.f2548l;
            return w40Var != null ? w40Var.f4421a : null;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void e() {
        UUID uuidRandomUUID = UUID.randomUUID();
        kotlin.jvm.internal.t.h(uuidRandomUUID, "randomUUID()");
        cc0 cc0Var = new cc0(uuidRandomUUID);
        w40 w40Var = new w40(cc0Var, DateTimeUtils.nowInSecondsPrecise(), null, false);
        this.f2548l = w40Var;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new uh(w40Var), 6, (Object) null);
        ((vw) this.f2539c).b(ac0.class, new ac0(w40Var));
        ((vw) this.f2540d).b(SessionStateChangedEvent.class, new SessionStateChangedEvent(cc0Var.f2502b, SessionStateChangedEvent.ChangeType.SESSION_STARTED));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0098 A[Catch: all -> 0x00ab, TryCatch #0 {all -> 0x00ab, blocks: (B:3:0x0005, B:5:0x000a, B:7:0x001f, B:9:0x0031, B:10:0x0033, B:12:0x0037, B:14:0x004c, B:16:0x0050, B:18:0x0067, B:23:0x007f, B:25:0x0098, B:27:0x009c, B:21:0x0075, B:28:0x00a5), top: B:34:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            r15 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r15.f2544h
            r0.lock()
            bo.app.w40 r1 = r15.f2548l     // Catch: java.lang.Throwable -> Lab
            r2 = 0
            if (r1 != 0) goto L33
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch: java.lang.Throwable -> Lab
            r5 = 0
            r6 = 0
            r7 = 0
            bo.app.vh r8 = bo.app.vh.f4117a     // Catch: java.lang.Throwable -> Lab
            r9 = 7
            r10 = 0
            r4 = r15
            com.braze.support.BrazeLogger.brazelog$default(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Lab
            bo.app.e10 r1 = r15.f2538b     // Catch: java.lang.Throwable -> Lab
            bo.app.zb0 r1 = r1.a()     // Catch: java.lang.Throwable -> Lab
            if (r1 == 0) goto L30
            bo.app.w40 r9 = new bo.app.w40     // Catch: java.lang.Throwable -> Lab
            bo.app.cc0 r4 = r1.f4421a     // Catch: java.lang.Throwable -> Lab
            double r5 = r1.f4422b     // Catch: java.lang.Throwable -> Lab
            java.lang.Double r7 = r1.c()     // Catch: java.lang.Throwable -> Lab
            boolean r8 = r1.f4424d     // Catch: java.lang.Throwable -> Lab
            r3 = r9
            r3.<init>(r4, r5, r7, r8)     // Catch: java.lang.Throwable -> Lab
            goto L31
        L30:
            r9 = r2
        L31:
            r15.f2548l = r9     // Catch: java.lang.Throwable -> Lab
        L33:
            bo.app.w40 r1 = r15.f2548l     // Catch: java.lang.Throwable -> Lab
            if (r1 == 0) goto La7
            com.braze.support.BrazeLogger r11 = com.braze.support.BrazeLogger.INSTANCE     // Catch: java.lang.Throwable -> Lab
            r5 = 0
            r6 = 0
            r7 = 0
            bo.app.wh r8 = new bo.app.wh     // Catch: java.lang.Throwable -> Lab
            r8.<init>(r1)     // Catch: java.lang.Throwable -> Lab
            r9 = 7
            r10 = 0
            r3 = r11
            r4 = r15
            com.braze.support.BrazeLogger.brazelog$default(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Lab
            java.lang.Double r3 = r1.f4423c     // Catch: java.lang.Throwable -> Lab
            if (r3 == 0) goto La5
            boolean r4 = r1.f4424d     // Catch: java.lang.Throwable -> Lab
            if (r4 != 0) goto La5
            double r4 = r1.f4422b     // Catch: java.lang.Throwable -> Lab
            double r6 = r3.doubleValue()     // Catch: java.lang.Throwable -> Lab
            int r3 = r15.f2542f     // Catch: java.lang.Throwable -> Lab
            boolean r8 = r15.f2543g     // Catch: java.lang.Throwable -> Lab
            long r9 = com.braze.support.DateTimeUtils.nowInMilliseconds()     // Catch: java.lang.Throwable -> Lab
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> Lab
            long r13 = (long) r3     // Catch: java.lang.Throwable -> Lab
            long r13 = r12.toMillis(r13)     // Catch: java.lang.Throwable -> Lab
            if (r8 == 0) goto L75
            long r3 = (long) r4     // Catch: java.lang.Throwable -> Lab
            long r3 = r12.toMillis(r3)     // Catch: java.lang.Throwable -> Lab
            long r3 = r3 + r13
            long r5 = bo.app.ci.f2536o     // Catch: java.lang.Throwable -> Lab
            long r3 = r3 + r5
            int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r3 > 0) goto La5
            goto L7f
        L75:
            long r3 = (long) r6     // Catch: java.lang.Throwable -> Lab
            long r3 = r12.toMillis(r3)     // Catch: java.lang.Throwable -> Lab
            long r3 = r3 + r13
            int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r3 > 0) goto La5
        L7f:
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.I     // Catch: java.lang.Throwable -> Lab
            r6 = 0
            r7 = 0
            bo.app.xh r8 = new bo.app.xh     // Catch: java.lang.Throwable -> Lab
            r8.<init>(r1)     // Catch: java.lang.Throwable -> Lab
            r9 = 6
            r10 = 0
            r3 = r11
            r4 = r15
            com.braze.support.BrazeLogger.brazelog$default(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Lab
            r15.g()     // Catch: java.lang.Throwable -> Lab
            bo.app.e10 r1 = r15.f2538b     // Catch: java.lang.Throwable -> Lab
            bo.app.w40 r3 = r15.f2548l     // Catch: java.lang.Throwable -> Lab
            if (r3 == 0) goto L9b
            bo.app.cc0 r3 = r3.f4421a     // Catch: java.lang.Throwable -> Lab
            goto L9c
        L9b:
            r3 = r2
        L9c:
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> Lab
            r1.a(r3)     // Catch: java.lang.Throwable -> Lab
            r15.f2548l = r2     // Catch: java.lang.Throwable -> Lab
        La5:
            v8.k0 r1 = v8.k0.f35197a     // Catch: java.lang.Throwable -> Lab
        La7:
            r0.unlock()
            return
        Lab:
            r1 = move-exception
            r0.unlock()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.ci.f():void");
    }

    public final void g() {
        w40 w40Var = this.f2548l;
        if (w40Var != null) {
            ReentrantLock reentrantLock = this.f2544h;
            reentrantLock.lock();
            try {
                w40Var.f4424d = true;
                w40Var.f4423c = Double.valueOf(DateTimeUtils.nowInSecondsPrecise());
                this.f2538b.a(w40Var);
                ((vw) this.f2539c).b(dc0.class, new dc0(w40Var));
                ((vw) this.f2540d).b(SessionStateChangedEvent.class, new SessionStateChangedEvent(w40Var.f4421a.f2502b, SessionStateChangedEvent.ChangeType.SESSION_ENDED));
                v8.k0 k0Var = v8.k0.f35197a;
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
