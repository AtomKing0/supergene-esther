package io.sentry.transport;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.k1;
import io.sentry.l0;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.util.m;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RateLimiter.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b0 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final p f28257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final SentryOptions f28258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Map<io.sentry.m, Date> f28259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<b> f28260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private Timer f28261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f28262f;

    /* JADX INFO: compiled from: RateLimiter.java */
    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            b0.this.i0();
        }
    }

    /* JADX INFO: compiled from: RateLimiter.java */
    public interface b {
        void a(@NotNull b0 b0Var);
    }

    public b0(@NotNull p pVar, @NotNull SentryOptions sentryOptions) {
        this.f28259c = new ConcurrentHashMap();
        this.f28260d = new CopyOnWriteArrayList();
        this.f28261e = null;
        this.f28262f = new io.sentry.util.a();
        this.f28257a = pVar;
        this.f28258b = sentryOptions;
    }

    @NotNull
    private io.sentry.m B(@NotNull String str) {
        str.hashCode();
        switch (str) {
            case "attachment":
                return io.sentry.m.Attachment;
            case "replay_video":
                return io.sentry.m.Replay;
            case "profile_chunk":
                return io.sentry.m.ProfileChunkUi;
            case "profile":
                return io.sentry.m.Profile;
            case "feedback":
                return io.sentry.m.Feedback;
            case "log":
                return io.sentry.m.LogItem;
            case "event":
                return io.sentry.m.Error;
            case "check_in":
                return io.sentry.m.Monitor;
            case "session":
                return io.sentry.m.Session;
            case "transaction":
                return io.sentry.m.Transaction;
            default:
                return io.sentry.m.Unknown;
        }
    }

    private long G0(@Nullable String str) {
        if (str != null) {
            try {
                return (long) (Double.parseDouble(str) * 1000.0d);
            } catch (NumberFormatException unused) {
            }
        }
        return 60000L;
    }

    private boolean O(@NotNull String str) {
        return J(B(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(io.sentry.hints.f fVar) {
        fVar.d();
        this.f28258b.getLogger().c(SentryLevel.DEBUG, "Disk flush envelope fired due to rate limit", new Object[0]);
    }

    private void h0(@NotNull l0 l0Var, final boolean z10) {
        io.sentry.util.m.o(l0Var, io.sentry.hints.p.class, new m.a() { // from class: io.sentry.transport.y
            @Override // io.sentry.util.m.a
            public final void accept(Object obj) {
                ((io.sentry.hints.p) obj).c(false);
            }
        });
        io.sentry.util.m.o(l0Var, io.sentry.hints.k.class, new m.a() { // from class: io.sentry.transport.z
            @Override // io.sentry.util.m.a
            public final void accept(Object obj) {
                ((io.sentry.hints.k) obj).d(z10);
            }
        });
        io.sentry.util.m.o(l0Var, io.sentry.hints.f.class, new m.a() { // from class: io.sentry.transport.a0
            @Override // io.sentry.util.m.a
            public final void accept(Object obj) {
                this.f28254a.W((io.sentry.hints.f) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        Iterator<b> it = this.f28260d.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void x(@NotNull io.sentry.m mVar, @NotNull Date date) {
        Date date2 = this.f28259c.get(mVar);
        if (date2 == null || date.after(date2)) {
            this.f28259c.put(mVar, date);
            i0();
            k1 k1VarA = this.f28262f.a();
            try {
                if (this.f28261e == null) {
                    this.f28261e = new Timer(true);
                }
                this.f28261e.schedule(new a(), date);
                if (k1VarA != null) {
                    k1VarA.close();
                }
            } catch (Throwable th) {
                if (k1VarA != null) {
                    try {
                        k1VarA.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    public void I0(@Nullable String str, @Nullable String str2, int i10) {
        if (str == null) {
            if (i10 == 429) {
                x(io.sentry.m.All, new Date(this.f28257a.a() + G0(str2)));
                return;
            }
            return;
        }
        int i11 = -1;
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        int i12 = 0;
        while (i12 < length) {
            String[] strArrSplit2 = strArrSplit[i12].replace(" ", "").split(":", i11);
            if (strArrSplit2.length > 0) {
                long jG0 = G0(strArrSplit2[0]);
                if (strArrSplit2.length > 1) {
                    String str3 = strArrSplit2[1];
                    Date date = new Date(this.f28257a.a() + jG0);
                    if (str3 == null || str3.isEmpty()) {
                        x(io.sentry.m.All, date);
                    } else {
                        for (String str4 : str3.split(";", i11)) {
                            io.sentry.m mVarValueOf = io.sentry.m.Unknown;
                            try {
                                String strB = io.sentry.util.d0.b(str4);
                                if (strB != null) {
                                    mVarValueOf = io.sentry.m.valueOf(strB);
                                } else {
                                    this.f28258b.getLogger().c(SentryLevel.ERROR, "Couldn't capitalize: %s", str4);
                                }
                            } catch (IllegalArgumentException e10) {
                                this.f28258b.getLogger().a(SentryLevel.INFO, e10, "Unknown category: %s", str4);
                            }
                            if (!io.sentry.m.Unknown.equals(mVarValueOf)) {
                                x(mVarValueOf, date);
                            }
                        }
                    }
                }
            }
            i12++;
            i11 = -1;
        }
    }

    public boolean J(@NotNull io.sentry.m mVar) {
        Date date;
        Date date2 = new Date(this.f28257a.a());
        Date date3 = this.f28259c.get(io.sentry.m.All);
        if (date3 != null && !date2.after(date3)) {
            return true;
        }
        if (io.sentry.m.Unknown.equals(mVar) || (date = this.f28259c.get(mVar)) == null) {
            return false;
        }
        return !date2.after(date);
    }

    public boolean L() {
        Date date = new Date(this.f28257a.a());
        Iterator<io.sentry.m> it = this.f28259c.keySet().iterator();
        while (it.hasNext()) {
            Date date2 = this.f28259c.get(it.next());
            if (date2 != null && !date.after(date2)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        k1 k1VarA = this.f28262f.a();
        try {
            Timer timer = this.f28261e;
            if (timer != null) {
                timer.cancel();
                this.f28261e = null;
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
            this.f28260d.clear();
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void q(@NotNull b bVar) {
        this.f28260d.add(bVar);
    }

    @Nullable
    public p5 z(@NotNull p5 p5Var, @NotNull l0 l0Var) {
        ArrayList arrayList = null;
        for (p6 p6Var : p5Var.c()) {
            if (O(p6Var.K().b().getItemType())) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(p6Var);
                this.f28258b.getClientReportRecorder().d(io.sentry.clientreport.f.RATELIMIT_BACKOFF, p6Var);
            }
        }
        if (arrayList == null) {
            return p5Var;
        }
        this.f28258b.getLogger().c(SentryLevel.WARNING, "%d envelope items will be dropped due rate limiting.", Integer.valueOf(arrayList.size()));
        ArrayList arrayList2 = new ArrayList();
        for (p6 p6Var2 : p5Var.c()) {
            if (!arrayList.contains(p6Var2)) {
                arrayList2.add(p6Var2);
            }
        }
        if (!arrayList2.isEmpty()) {
            return new p5(p5Var.b(), arrayList2);
        }
        this.f28258b.getLogger().c(SentryLevel.WARNING, "Envelope discarded due all items rate limited.", new Object[0]);
        h0(l0Var, false);
        return null;
    }

    public b0(@NotNull SentryOptions sentryOptions) {
        this(n.b(), sentryOptions);
    }
}
