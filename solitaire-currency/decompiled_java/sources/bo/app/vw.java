package bo.app;

import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.events.IEventSubscriber;
import com.braze.events.NoMatchingTriggerEvent;
import com.braze.support.BrazeLogger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class vw implements v00 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final kw f4144i = new kw();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ka0 f4145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f4146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f4147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f4148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReentrantLock f4149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ReentrantLock f4150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ReentrantLock f4151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4152h;

    public /* synthetic */ vw(ka0 ka0Var) {
        this(ka0Var, false);
    }

    public final void a(Class cls, Object obj) {
        List list;
        ReentrantLock reentrantLock = this.f4151g;
        reentrantLock.lock();
        if (obj == null) {
            return;
        }
        try {
            if (!this.f4148d.containsKey(cls) || (list = (List) this.f4148d.get(cls)) == null) {
                this.f4148d.put(cls, kotlin.collections.v.q(obj));
            } else {
                list.add(obj);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void b(Class eventClass, Object obj) {
        l00 l00Var;
        kotlin.jvm.internal.t.i(eventClass, "eventClass");
        boolean z10 = (obj instanceof ca0) || (obj instanceof ia0) || ((obj instanceof tr) && (l00Var = ((tr) obj).f3968d) != null && ((tg) l00Var).e().f2428d) || (((obj instanceof w70) && ((tg) ((w70) obj).f4171a).e().f2428d) || (((obj instanceof v70) && ((tg) ((v70) obj).f4077a).e().f2428d) || ((obj instanceof es) && ((tg) ((es) obj).f2749a).e().f2428d)));
        if (this.f4145a.f3236a.getBoolean("appboy_sdk_disabled", false)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, (BrazeLogger.Priority) null, (Throwable) null, z10, new ow(eventClass, obj), 3, (Object) null);
            return;
        }
        if (obj == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, (BrazeLogger.Priority) null, (Throwable) null, z10, new pw(eventClass), 3, (Object) null);
            return;
        }
        if (!this.f4152h) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, (BrazeLogger.Priority) null, (Throwable) null, z10, new qw(eventClass, obj), 3, (Object) null);
            a(eventClass, obj);
            return;
        }
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, this, (BrazeLogger.Priority) null, (Throwable) null, z10, new rw(eventClass, obj), 3, (Object) null);
        HashSet hashSetA = kw.a(this.f4146b, eventClass, this.f4149e);
        kw kwVar = f4144i;
        kotlin.jvm.internal.t.g(hashSetA, "null cannot be cast to non-null type kotlin.collections.Set<com.braze.events.IEventSubscriber<T of com.braze.events.EventMessenger.Companion.getCastSubscriberSet>>");
        BrazeLogger.brazelog$default(brazeLogger, (Object) kwVar, (BrazeLogger.Priority) null, (Throwable) null, true, (h9.a) new jw(eventClass, hashSetA), 3, (Object) null);
        Iterator it = hashSetA.iterator();
        while (it.hasNext()) {
            kotlinx.coroutines.k.d(BrazeCoroutineScope.INSTANCE, null, null, new sw((IEventSubscriber) it.next(), obj, null), 3, null);
        }
        HashSet hashSetA2 = kw.a(this.f4147c, eventClass, this.f4150f);
        kw kwVar2 = f4144i;
        kotlin.jvm.internal.t.g(hashSetA2, "null cannot be cast to non-null type kotlin.collections.Set<com.braze.events.IEventSubscriber<T of com.braze.events.EventMessenger.Companion.getCastSubscriberSet>>");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) kwVar2, (BrazeLogger.Priority) null, (Throwable) null, true, (h9.a) new jw(eventClass, hashSetA2), 3, (Object) null);
        Iterator it2 = hashSetA2.iterator();
        while (it2.hasNext()) {
            ((IEventSubscriber) it2.next()).trigger(obj);
        }
        if (hashSetA2.isEmpty() && hashSetA.isEmpty()) {
            if (kotlin.jvm.internal.t.d(eventClass, NoMatchingTriggerEvent.class)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.I, (Throwable) null, z10, new tw(eventClass, this), 2, (Object) null);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.I, (Throwable) null, z10, new uw(eventClass, this), 2, (Object) null);
                a(eventClass, obj);
            }
        }
    }

    public final boolean c(IEventSubscriber subscriber, Class eventClass) {
        kotlin.jvm.internal.t.i(eventClass, "eventClass");
        kotlin.jvm.internal.t.i(subscriber, "subscriber");
        ReentrantLock reentrantLock = this.f4150f;
        reentrantLock.lock();
        try {
            ConcurrentHashMap concurrentHashMap = this.f4147c;
            CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) concurrentHashMap.get(eventClass);
            if (copyOnWriteArraySet == null) {
                copyOnWriteArraySet = new CopyOnWriteArraySet();
                CopyOnWriteArraySet copyOnWriteArraySet2 = (CopyOnWriteArraySet) concurrentHashMap.putIfAbsent(eventClass, copyOnWriteArraySet);
                if (copyOnWriteArraySet2 != null) {
                    copyOnWriteArraySet = copyOnWriteArraySet2;
                }
            }
            boolean zAdd = copyOnWriteArraySet.add(subscriber);
            a(eventClass);
            return zAdd;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void d(IEventSubscriber subscriber, Class eventClass) {
        kotlin.jvm.internal.t.i(eventClass, "eventClass");
        kotlin.jvm.internal.t.i(subscriber, "subscriber");
        ReentrantLock reentrantLock = this.f4149e;
        reentrantLock.lock();
        try {
            ConcurrentHashMap concurrentHashMap = this.f4146b;
            CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) concurrentHashMap.get(eventClass);
            if (copyOnWriteArraySet == null) {
                copyOnWriteArraySet = new CopyOnWriteArraySet();
                CopyOnWriteArraySet copyOnWriteArraySet2 = (CopyOnWriteArraySet) concurrentHashMap.putIfAbsent(eventClass, copyOnWriteArraySet);
                if (copyOnWriteArraySet2 != null) {
                    copyOnWriteArraySet = copyOnWriteArraySet2;
                }
            }
            copyOnWriteArraySet.add(subscriber);
            a(eventClass);
        } finally {
            reentrantLock.unlock();
        }
    }

    public vw(ka0 sdkEnablementProvider, boolean z10) {
        kotlin.jvm.internal.t.i(sdkEnablementProvider, "sdkEnablementProvider");
        this.f4145a = sdkEnablementProvider;
        this.f4146b = new ConcurrentHashMap();
        this.f4147c = new ConcurrentHashMap();
        this.f4148d = new ConcurrentHashMap();
        this.f4149e = new ReentrantLock();
        this.f4150f = new ReentrantLock();
        this.f4151g = new ReentrantLock();
        this.f4152h = !z10;
    }

    public final void a(Class cls) {
        if (!this.f4152h) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new mw(cls), 7, (Object) null);
            return;
        }
        ReentrantLock reentrantLock = this.f4151g;
        reentrantLock.lock();
        try {
            if (this.f4148d.containsKey(cls)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new nw(cls), 6, (Object) null);
                Object objRemove = this.f4148d.remove(cls);
                kotlin.jvm.internal.t.g(objRemove, "null cannot be cast to non-null type kotlin.collections.List<T of com.braze.events.EventMessenger.attemptPublishFromCache$lambda$13>");
                Iterator it = ((List) objRemove).iterator();
                while (it.hasNext()) {
                    b(cls, it.next());
                }
            }
            v8.k0 k0Var = v8.k0.f35197a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void a() {
        ReentrantLock reentrantLock = this.f4149e;
        reentrantLock.lock();
        try {
            this.f4146b.clear();
            v8.k0 k0Var = v8.k0.f35197a;
            reentrantLock.unlock();
            ReentrantLock reentrantLock2 = this.f4150f;
            reentrantLock2.lock();
            try {
                this.f4147c.clear();
            } finally {
                reentrantLock2.unlock();
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean a(IEventSubscriber subscriber, Class eventClass) {
        kotlin.jvm.internal.t.i(eventClass, "eventClass");
        kotlin.jvm.internal.t.i(subscriber, "subscriber");
        ReentrantLock reentrantLock = this.f4149e;
        reentrantLock.lock();
        try {
            CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) this.f4146b.get(eventClass);
            if (copyOnWriteArraySet != null) {
                return copyOnWriteArraySet.remove(subscriber);
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean b(IEventSubscriber subscriber, Class eventClass) {
        kotlin.jvm.internal.t.i(eventClass, "eventClass");
        kotlin.jvm.internal.t.i(subscriber, "subscriber");
        ReentrantLock reentrantLock = this.f4150f;
        reentrantLock.lock();
        try {
            CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) this.f4147c.get(eventClass);
            if (copyOnWriteArraySet != null) {
                return copyOnWriteArraySet.remove(subscriber);
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }
}
