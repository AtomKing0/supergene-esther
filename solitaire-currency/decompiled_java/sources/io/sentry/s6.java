package io.sentry;

import io.sentry.protocol.Mechanism;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryStackFrame;
import io.sentry.protocol.SentryStackTrace;
import io.sentry.protocol.SentryThread;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: compiled from: SentryExceptionFactory.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class s6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final s7 f28223a;

    public s6(@NotNull s7 s7Var) {
        this.f28223a = (s7) io.sentry.util.w.c(s7Var, "The SentryStackTraceFactory is required.");
    }

    @NotNull
    private SentryException c(@NotNull Throwable th, @Nullable Mechanism mechanism, @Nullable Long l10, @Nullable List<SentryStackFrame> list, boolean z10) {
        Package r02 = th.getClass().getPackage();
        String name = th.getClass().getName();
        SentryException sentryException = new SentryException();
        String message = th.getMessage();
        if (r02 != null) {
            name = name.replace(r02.getName() + ".", "");
        }
        String name2 = r02 != null ? r02.getName() : null;
        if (list != null && !list.isEmpty()) {
            SentryStackTrace sentryStackTrace = new SentryStackTrace(list);
            if (z10) {
                sentryStackTrace.setSnapshot(Boolean.TRUE);
            }
            sentryException.setStacktrace(sentryStackTrace);
        }
        sentryException.setThreadId(l10);
        sentryException.setType(name);
        sentryException.setMechanism(mechanism);
        sentryException.setModule(name2);
        sentryException.setValue(message);
        return sentryException;
    }

    @NotNull
    private List<SentryException> e(@NotNull Deque<SentryException> deque) {
        return new ArrayList(deque);
    }

    @TestOnly
    @NotNull
    Deque<SentryException> a(@NotNull Throwable th) {
        return b(th, new AtomicInteger(-1), new HashSet<>(), new ArrayDeque(), null);
    }

    Deque<SentryException> b(@NotNull Throwable th, @NotNull AtomicInteger atomicInteger, @NotNull HashSet<Throwable> hashSet, @NotNull Deque<SentryException> deque, @Nullable String str) {
        Mechanism mechanism;
        boolean zD;
        Throwable th2;
        Thread threadCurrentThread;
        String str2 = str;
        int i10 = atomicInteger.get();
        Throwable cause = th;
        while (cause != null && hashSet.add(cause)) {
            if (str2 == null) {
                str2 = "chained";
            }
            if (cause instanceof io.sentry.exception.a) {
                io.sentry.exception.a aVar = (io.sentry.exception.a) cause;
                mechanism = aVar.a();
                Throwable thC = aVar.c();
                Thread threadB = aVar.b();
                zD = aVar.d();
                threadCurrentThread = threadB;
                th2 = thC;
            } else {
                mechanism = new Mechanism();
                zD = false;
                th2 = cause;
                threadCurrentThread = Thread.currentThread();
            }
            deque.addFirst(c(th2, mechanism, Long.valueOf(threadCurrentThread.getId()), this.f28223a.a(th2.getStackTrace(), Boolean.FALSE.equals(mechanism.isHandled())), zD));
            if (mechanism.getType() == null) {
                mechanism.setType(str2);
            }
            if (atomicInteger.get() >= 0) {
                mechanism.setParentId(Integer.valueOf(i10));
            }
            int iIncrementAndGet = atomicInteger.incrementAndGet();
            mechanism.setExceptionId(Integer.valueOf(iIncrementAndGet));
            Throwable[] suppressed = th2.getSuppressed();
            if (suppressed != null && suppressed.length > 0) {
                for (Throwable th3 : suppressed) {
                    b(th3, atomicInteger, hashSet, deque, "suppressed");
                }
            }
            cause = th2.getCause();
            str2 = null;
            i10 = iIncrementAndGet;
        }
        return deque;
    }

    @NotNull
    public List<SentryException> d(@NotNull Throwable th) {
        return e(a(th));
    }

    @NotNull
    public List<SentryException> f(@NotNull SentryThread sentryThread, @NotNull Mechanism mechanism, @NotNull Throwable th) {
        SentryStackTrace stacktrace = sentryThread.getStacktrace();
        if (stacktrace == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(c(th, mechanism, sentryThread.getId(), stacktrace.getFrames(), true));
        return arrayList;
    }
}
