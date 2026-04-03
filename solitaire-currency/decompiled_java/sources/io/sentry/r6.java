package io.sentry;

import com.applovin.sdk.AppLovinEventTypes;
import io.sentry.SentryLevel;
import io.sentry.i5;
import io.sentry.protocol.Message;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryThread;
import io.sentry.protocol.SentryTransaction;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public final class r6 extends i5 implements h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private Date f28144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private Message f28145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private String f28146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private d8<SentryThread> f28147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private d8<SentryException> f28148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private SentryLevel f28149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private String f28150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private List<String> f28151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28152i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private Map<String, String> f28153j;

    /* JADX INFO: compiled from: SentryEvent.java */
    public static final class a implements x1<r6> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public r6 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            l3Var.h();
            r6 r6Var = new r6();
            i5.a aVar = new i5.a();
            ConcurrentHashMap concurrentHashMap = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "fingerprint":
                        List list = (List) l3Var.A0();
                        if (list == null) {
                            break;
                        } else {
                            r6Var.f28151h = list;
                            break;
                        }
                        break;
                    case "threads":
                        l3Var.h();
                        l3Var.C();
                        r6Var.f28147d = new d8(l3Var.D0(w0Var, new SentryThread.Deserializer()));
                        l3Var.k();
                        break;
                    case "logger":
                        r6Var.f28146c = l3Var.o0();
                        break;
                    case "timestamp":
                        Date dateF = l3Var.F(w0Var);
                        if (dateF == null) {
                            break;
                        } else {
                            r6Var.f28144a = dateF;
                            break;
                        }
                        break;
                    case "level":
                        r6Var.f28149f = (SentryLevel) l3Var.M(w0Var, new SentryLevel.a());
                        break;
                    case "message":
                        r6Var.f28145b = (Message) l3Var.M(w0Var, new Message.Deserializer());
                        break;
                    case "modules":
                        r6Var.f28153j = io.sentry.util.c.b((Map) l3Var.A0());
                        break;
                    case "exception":
                        l3Var.h();
                        l3Var.C();
                        r6Var.f28148e = new d8(l3Var.D0(w0Var, new SentryException.Deserializer()));
                        l3Var.k();
                        break;
                    case "transaction":
                        r6Var.f28150g = l3Var.o0();
                        break;
                    default:
                        if (!aVar.a(r6Var, strC, l3Var, w0Var)) {
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            l3Var.r0(w0Var, concurrentHashMap, strC);
                            break;
                        } else {
                            break;
                        }
                        break;
                }
            }
            r6Var.setUnknown(concurrentHashMap);
            l3Var.k();
            return r6Var;
        }
    }

    r6(@NotNull SentryId sentryId, @NotNull Date date) {
        super(sentryId);
        this.f28144a = date;
    }

    public void A(@Nullable String str) {
        this.f28150g = str;
    }

    @Nullable
    public String getTransaction() {
        return this.f28150g;
    }

    @Nullable
    public List<SentryException> j() {
        d8<SentryException> d8Var = this.f28148e;
        if (d8Var == null) {
            return null;
        }
        return d8Var.a();
    }

    @Nullable
    public List<String> k() {
        return this.f28151h;
    }

    @Nullable
    public SentryLevel l() {
        return this.f28149f;
    }

    @Nullable
    public Message m() {
        return this.f28145b;
    }

    @Nullable
    Map<String, String> n() {
        return this.f28153j;
    }

    @Nullable
    public List<SentryThread> o() {
        d8<SentryThread> d8Var = this.f28147d;
        if (d8Var != null) {
            return d8Var.a();
        }
        return null;
    }

    public Date p() {
        return (Date) this.f28144a.clone();
    }

    @Nullable
    public SentryException q() {
        d8<SentryException> d8Var = this.f28148e;
        if (d8Var == null) {
            return null;
        }
        for (SentryException sentryException : d8Var.a()) {
            if (sentryException.getMechanism() != null && sentryException.getMechanism().isHandled() != null && !sentryException.getMechanism().isHandled().booleanValue()) {
                return sentryException;
            }
        }
        return null;
    }

    public boolean r() {
        return q() != null;
    }

    public boolean s() {
        d8<SentryException> d8Var = this.f28148e;
        return (d8Var == null || d8Var.a().isEmpty()) ? false : true;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        m3Var.e("timestamp").o(w0Var, this.f28144a);
        if (this.f28145b != null) {
            m3Var.e("message").o(w0Var, this.f28145b);
        }
        if (this.f28146c != null) {
            m3Var.e("logger").g(this.f28146c);
        }
        d8<SentryThread> d8Var = this.f28147d;
        if (d8Var != null && !d8Var.a().isEmpty()) {
            m3Var.e("threads");
            m3Var.h();
            m3Var.e("values").o(w0Var, this.f28147d.a());
            m3Var.k();
        }
        d8<SentryException> d8Var2 = this.f28148e;
        if (d8Var2 != null && !d8Var2.a().isEmpty()) {
            m3Var.e("exception");
            m3Var.h();
            m3Var.e("values").o(w0Var, this.f28148e.a());
            m3Var.k();
        }
        if (this.f28149f != null) {
            m3Var.e(AppLovinEventTypes.USER_COMPLETED_LEVEL).o(w0Var, this.f28149f);
        }
        if (this.f28150g != null) {
            m3Var.e(SentryTransaction.JsonKeys.TRANSACTION).g(this.f28150g);
        }
        if (this.f28151h != null) {
            m3Var.e("fingerprint").o(w0Var, this.f28151h);
        }
        if (this.f28153j != null) {
            m3Var.e("modules").o(w0Var, this.f28153j);
        }
        new i5.b().a(this, m3Var, w0Var);
        Map<String, Object> map = this.f28152i;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28152i.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    public void setUnknown(@Nullable Map<String, Object> map) {
        this.f28152i = map;
    }

    public void t(@Nullable List<SentryException> list) {
        this.f28148e = new d8<>(list);
    }

    public void u(@Nullable List<String> list) {
        this.f28151h = list != null ? new ArrayList(list) : null;
    }

    public void v(@Nullable SentryLevel sentryLevel) {
        this.f28149f = sentryLevel;
    }

    public void w(@Nullable Message message) {
        this.f28145b = message;
    }

    public void x(@Nullable Map<String, String> map) {
        this.f28153j = io.sentry.util.c.c(map);
    }

    public void y(@Nullable List<SentryThread> list) {
        this.f28147d = new d8<>(list);
    }

    public void z(@NotNull Date date) {
        this.f28144a = date;
    }

    public r6(@Nullable Throwable th) {
        this();
        this.throwable = th;
    }

    public r6() {
        this(new SentryId(), n.d());
    }
}
