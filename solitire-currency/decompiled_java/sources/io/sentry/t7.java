package io.sentry;

import io.sentry.protocol.SentryStackFrame;
import io.sentry.protocol.SentryStackTrace;
import io.sentry.protocol.SentryThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: compiled from: SentryThreadFactory.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class t7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final s7 f28251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final SentryOptions f28252b;

    public t7(@NotNull s7 s7Var, @NotNull SentryOptions sentryOptions) {
        this.f28251a = (s7) io.sentry.util.w.c(s7Var, "The SentryStackTraceFactory is required.");
        this.f28252b = (SentryOptions) io.sentry.util.w.c(sentryOptions, "The SentryOptions is required");
    }

    @NotNull
    private SentryThread d(boolean z10, @NotNull StackTraceElement[] stackTraceElementArr, @NotNull Thread thread) {
        SentryThread sentryThread = new SentryThread();
        sentryThread.setName(thread.getName());
        sentryThread.setPriority(Integer.valueOf(thread.getPriority()));
        sentryThread.setId(Long.valueOf(thread.getId()));
        sentryThread.setDaemon(Boolean.valueOf(thread.isDaemon()));
        sentryThread.setState(thread.getState().name());
        sentryThread.setCrashed(Boolean.valueOf(z10));
        List<SentryStackFrame> listA = this.f28251a.a(stackTraceElementArr, false);
        if (this.f28252b.isAttachStacktrace() && listA != null && !listA.isEmpty()) {
            SentryStackTrace sentryStackTrace = new SentryStackTrace(listA);
            sentryStackTrace.setSnapshot(Boolean.TRUE);
            sentryThread.setStacktrace(sentryStackTrace);
        }
        return sentryThread;
    }

    @Nullable
    List<SentryThread> a() {
        HashMap map = new HashMap();
        Thread threadCurrentThread = Thread.currentThread();
        map.put(threadCurrentThread, threadCurrentThread.getStackTrace());
        return c(map, null, false);
    }

    @Nullable
    List<SentryThread> b(@Nullable List<Long> list, boolean z10) {
        return c(Thread.getAllStackTraces(), list, z10);
    }

    @TestOnly
    @Nullable
    List<SentryThread> c(@NotNull Map<Thread, StackTraceElement[]> map, @Nullable List<Long> list, boolean z10) {
        Thread threadCurrentThread = Thread.currentThread();
        if (map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!map.containsKey(threadCurrentThread)) {
            map.put(threadCurrentThread, threadCurrentThread.getStackTrace());
        }
        for (Map.Entry<Thread, StackTraceElement[]> entry : map.entrySet()) {
            Thread key = entry.getKey();
            arrayList.add(d((key == threadCurrentThread && !z10) || !(list == null || !list.contains(Long.valueOf(key.getId())) || z10), entry.getValue(), entry.getKey()));
        }
        return arrayList;
    }
}
