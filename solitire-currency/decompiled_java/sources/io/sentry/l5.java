package io.sentry;

import io.sentry.Scope;
import io.sentry.SentryOptions;
import io.sentry.e8;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: compiled from: SentryClient.java */
/* JADX INFO: loaded from: classes5.dex */
public final class l5 implements i1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final SentryOptions f27979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final io.sentry.transport.r f27980c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final io.sentry.logger.b f27982e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final b f27981d = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f27978a = true;

    /* JADX INFO: compiled from: SentryClient.java */
    private static final class b implements Comparator<Breadcrumb> {
        private b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(@NotNull Breadcrumb breadcrumb, @NotNull Breadcrumb breadcrumb2) {
            return breadcrumb.getTimestamp().compareTo(breadcrumb2.getTimestamp());
        }
    }

    @ApiStatus.Internal
    public l5(@NotNull SentryOptions sentryOptions) {
        this.f27979b = (SentryOptions) io.sentry.util.w.c(sentryOptions, "SentryOptions is required.");
        r1 transportFactory = sentryOptions.getTransportFactory();
        if (transportFactory instanceof i3) {
            transportFactory = new io.sentry.a();
            sentryOptions.setTransportFactory(transportFactory);
        }
        this.f27980c = transportFactory.a(sentryOptions, new d4(sentryOptions).a());
        if (sentryOptions.getLogs().a()) {
            this.f27982e = new io.sentry.logger.e(sentryOptions, this);
        } else {
            this.f27982e = io.sentry.logger.g.a();
        }
    }

    @Nullable
    private SentryTransaction A(@NotNull SentryTransaction sentryTransaction, @NotNull l0 l0Var) {
        this.f27979b.getBeforeSendTransaction();
        return sentryTransaction;
    }

    @Nullable
    private List<io.sentry.b> B(@Nullable List<io.sentry.b> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (io.sentry.b bVar : list) {
            if (bVar.k()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    private void C(@NotNull c1 c1Var, @NotNull l0 l0Var) {
        p1 transaction = c1Var.getTransaction();
        if (transaction == null || !io.sentry.util.m.h(l0Var, io.sentry.hints.q.class)) {
            return;
        }
        Object objG = io.sentry.util.m.g(l0Var);
        if (!(objG instanceof io.sentry.hints.f)) {
            transaction.b(q8.ABORTED, false, null);
        } else {
            ((io.sentry.hints.f) objG).c(transaction.getEventId());
            transaction.b(q8.ABORTED, false, l0Var);
        }
    }

    @Nullable
    private List<io.sentry.b> D(@NotNull l0 l0Var) {
        List<io.sentry.b> listE = l0Var.e();
        io.sentry.b bVarF = l0Var.f();
        if (bVarF != null) {
            listE.add(bVarF);
        }
        io.sentry.b bVarH = l0Var.h();
        if (bVarH != null) {
            listE.add(bVarH);
        }
        io.sentry.b bVarG = l0Var.g();
        if (bVarG != null) {
            listE.add(bVarG);
        }
        return listE;
    }

    @Nullable
    private v8 E(@Nullable c1 c1Var, @NotNull l0 l0Var, @Nullable i5 i5Var, @Nullable String str) {
        if (io.sentry.util.m.h(l0Var, io.sentry.hints.c.class)) {
            if (i5Var != null) {
                return d.e(i5Var, str, this.f27979b).R();
            }
        } else if (c1Var != null) {
            p1 transaction = c1Var.getTransaction();
            return transaction != null ? transaction.i() : io.sentry.util.k0.p(c1Var, this.f27979b).k();
        }
        return null;
    }

    @Nullable
    private v8 F(@Nullable c1 c1Var, @NotNull l0 l0Var, @Nullable r6 r6Var) {
        return E(c1Var, l0Var, r6Var, r6Var != null ? r6Var.getTransaction() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(r6 r6Var, l0 l0Var, e8 e8Var) {
        if (e8Var == null) {
            this.f27979b.getLogger().c(SentryLevel.INFO, "Session is null on scope.withSession", new Object[0]);
            return;
        }
        String strH = null;
        e8.b bVar = r6Var.r() ? e8.b.Crashed : null;
        boolean z10 = e8.b.Crashed == bVar || r6Var.s();
        String str = (r6Var.getRequest() == null || r6Var.getRequest().getHeaders() == null || !r6Var.getRequest().getHeaders().containsKey("user-agent")) ? null : r6Var.getRequest().getHeaders().get("user-agent");
        Object objG = io.sentry.util.m.g(l0Var);
        if (objG instanceof io.sentry.hints.a) {
            strH = ((io.sentry.hints.a) objG).h();
            bVar = e8.b.Abnormal;
        }
        if (e8Var.q(bVar, str, z10, strH) && e8Var.m()) {
            e8Var.c();
        }
    }

    @Nullable
    private r6 I(@NotNull r6 r6Var, @NotNull l0 l0Var, @NotNull List<g0> list) {
        Iterator<g0> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            g0 next = it.next();
            try {
                boolean z10 = next instanceof c;
                boolean zH = io.sentry.util.m.h(l0Var, io.sentry.hints.c.class);
                if (zH && z10) {
                    r6Var = next.a(r6Var, l0Var);
                } else if (!zH && !z10) {
                    r6Var = next.a(r6Var, l0Var);
                }
            } catch (Throwable th) {
                this.f27979b.getLogger().a(SentryLevel.ERROR, th, "An exception occurred while processing event by processor: %s", next.getClass().getName());
            }
            if (r6Var == null) {
                this.f27979b.getLogger().c(SentryLevel.DEBUG, "Event was dropped by a processor: %s", next.getClass().getName());
                this.f27979b.getClientReportRecorder().a(io.sentry.clientreport.f.EVENT_PROCESSOR, m.Error);
                break;
            }
        }
        return r6Var;
    }

    @Nullable
    private r6 J(@NotNull r6 r6Var, @NotNull l0 l0Var, @NotNull List<g0> list) {
        Iterator<g0> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            g0 next = it.next();
            try {
                r6Var = next.a(r6Var, l0Var);
            } catch (Throwable th) {
                this.f27979b.getLogger().a(SentryLevel.ERROR, th, "An exception occurred while processing feedback event by processor: %s", next.getClass().getName());
            }
            if (r6Var == null) {
                this.f27979b.getLogger().c(SentryLevel.DEBUG, "Feedback event was dropped by a processor: %s", next.getClass().getName());
                this.f27979b.getClientReportRecorder().a(io.sentry.clientreport.f.EVENT_PROCESSOR, m.Feedback);
                break;
            }
        }
        return r6Var;
    }

    @Nullable
    private SentryTransaction K(@NotNull SentryTransaction sentryTransaction, @NotNull l0 l0Var, @NotNull List<g0> list) {
        Iterator<g0> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            g0 next = it.next();
            int size = sentryTransaction.getSpans().size();
            try {
                sentryTransaction = next.c(sentryTransaction, l0Var);
            } catch (Throwable th) {
                this.f27979b.getLogger().a(SentryLevel.ERROR, th, "An exception occurred while processing transaction by processor: %s", next.getClass().getName());
            }
            int size2 = sentryTransaction == null ? 0 : sentryTransaction.getSpans().size();
            if (sentryTransaction == null) {
                this.f27979b.getLogger().c(SentryLevel.DEBUG, "Transaction was dropped by a processor: %s", next.getClass().getName());
                io.sentry.clientreport.h clientReportRecorder = this.f27979b.getClientReportRecorder();
                io.sentry.clientreport.f fVar = io.sentry.clientreport.f.EVENT_PROCESSOR;
                clientReportRecorder.a(fVar, m.Transaction);
                this.f27979b.getClientReportRecorder().c(fVar, m.Span, size + 1);
                break;
            }
            if (size2 < size) {
                int i10 = size - size2;
                this.f27979b.getLogger().c(SentryLevel.DEBUG, "%d spans were dropped by a processor: %s", Integer.valueOf(i10), next.getClass().getName());
                this.f27979b.getClientReportRecorder().c(io.sentry.clientreport.f.EVENT_PROCESSOR, m.Span, i10);
            }
        }
        return sentryTransaction;
    }

    private boolean L() {
        io.sentry.util.z zVarA = this.f27979b.getSampleRate() == null ? null : io.sentry.util.b0.a();
        return this.f27979b.getSampleRate() == null || zVarA == null || this.f27979b.getSampleRate().doubleValue() >= zVarA.d();
    }

    @NotNull
    private SentryId M(@NotNull p5 p5Var, @Nullable l0 l0Var) throws IOException {
        SentryOptions.b beforeEnvelopeCallback = this.f27979b.getBeforeEnvelopeCallback();
        if (beforeEnvelopeCallback != null) {
            try {
                beforeEnvelopeCallback.a(p5Var, l0Var);
            } catch (Throwable th) {
                this.f27979b.getLogger().b(SentryLevel.ERROR, "The BeforeEnvelope callback threw an exception.", th);
            }
        }
        a7.d().c(this.f27979b.getLogger());
        if (l0Var == null) {
            this.f27980c.z0(p5Var);
        } else {
            this.f27980c.v(p5Var, l0Var);
        }
        SentryId sentryIdA = p5Var.b().a();
        return sentryIdA != null ? sentryIdA : SentryId.EMPTY_ID;
    }

    private boolean N(@NotNull i5 i5Var, @NotNull l0 l0Var) {
        if (io.sentry.util.m.u(l0Var)) {
            return true;
        }
        this.f27979b.getLogger().c(SentryLevel.DEBUG, "Event was cached so not applying scope: %s", i5Var.getEventId());
        return false;
    }

    private boolean O(@Nullable e8 e8Var, @Nullable e8 e8Var2) {
        if (e8Var2 == null) {
            return false;
        }
        if (e8Var == null) {
            return true;
        }
        e8.b bVarL = e8Var2.l();
        e8.b bVar = e8.b.Crashed;
        if (bVarL == bVar && e8Var.l() != bVar) {
            return true;
        }
        return e8Var2.e() > 0 && e8Var.e() <= 0;
    }

    private void P(@NotNull i5 i5Var, @NotNull Collection<Breadcrumb> collection) {
        List<Breadcrumb> breadcrumbs = i5Var.getBreadcrumbs();
        if (breadcrumbs == null || collection.isEmpty()) {
            return;
        }
        breadcrumbs.addAll(collection);
        Collections.sort(breadcrumbs, this.f27981d);
    }

    private void r(@Nullable c1 c1Var, @NotNull l0 l0Var) {
        if (c1Var != null) {
            l0Var.a(c1Var.getAttachments());
        }
    }

    @Nullable
    private r6 s(@NotNull r6 r6Var, @NotNull c1 c1Var, @NotNull l0 l0Var) {
        if (r6Var.getUser() == null) {
            r6Var.setUser(c1Var.getUser());
        }
        if (r6Var.getTags() == null) {
            r6Var.setTags(new HashMap(c1Var.getTags()));
        } else {
            for (Map.Entry<String, String> entry : c1Var.getTags().entrySet()) {
                if (!r6Var.getTags().containsKey(entry.getKey())) {
                    r6Var.getTags().put(entry.getKey(), entry.getValue());
                }
            }
        }
        Contexts contexts = r6Var.getContexts();
        for (Map.Entry<String, Object> entry2 : new Contexts(c1Var.getContexts()).entrySet()) {
            if (!contexts.containsKey(entry2.getKey())) {
                contexts.put(entry2.getKey(), entry2.getValue());
            }
        }
        n1 span = c1Var.getSpan();
        if (r6Var.getContexts().getTrace() == null) {
            if (span == null) {
                r6Var.getContexts().setTrace(y8.v(c1Var.getPropagationContext()));
            } else {
                r6Var.getContexts().setTrace(span.r());
            }
        }
        return J(r6Var, l0Var, c1Var.getEventProcessors());
    }

    @NotNull
    private <T extends i5> T t(@NotNull T t10, @Nullable c1 c1Var) {
        if (c1Var != null) {
            if (t10.getRequest() == null) {
                t10.setRequest(c1Var.getRequest());
            }
            if (t10.getUser() == null) {
                t10.setUser(c1Var.getUser());
            }
            if (t10.getTags() == null) {
                t10.setTags(new HashMap(c1Var.getTags()));
            } else {
                for (Map.Entry<String, String> entry : c1Var.getTags().entrySet()) {
                    if (!t10.getTags().containsKey(entry.getKey())) {
                        t10.getTags().put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (t10.getBreadcrumbs() == null) {
                t10.setBreadcrumbs(new ArrayList(c1Var.getBreadcrumbs()));
            } else {
                P(t10, c1Var.getBreadcrumbs());
            }
            if (t10.getExtras() == null) {
                t10.setExtras(new HashMap(c1Var.getExtras()));
            } else {
                for (Map.Entry<String, Object> entry2 : c1Var.getExtras().entrySet()) {
                    if (!t10.getExtras().containsKey(entry2.getKey())) {
                        t10.getExtras().put(entry2.getKey(), entry2.getValue());
                    }
                }
            }
            Contexts contexts = t10.getContexts();
            for (Map.Entry<String, Object> entry3 : new Contexts(c1Var.getContexts()).entrySet()) {
                if (!contexts.containsKey(entry3.getKey())) {
                    contexts.put(entry3.getKey(), entry3.getValue());
                }
            }
        }
        return t10;
    }

    @Nullable
    private r6 u(@NotNull r6 r6Var, @Nullable c1 c1Var, @NotNull l0 l0Var) {
        if (c1Var == null) {
            return r6Var;
        }
        t(r6Var, c1Var);
        if (r6Var.getTransaction() == null) {
            r6Var.A(c1Var.getTransactionName());
        }
        if (r6Var.k() == null) {
            r6Var.u(c1Var.getFingerprint());
        }
        if (c1Var.getLevel() != null) {
            r6Var.v(c1Var.getLevel());
        }
        n1 span = c1Var.getSpan();
        if (r6Var.getContexts().getTrace() == null) {
            if (span == null) {
                r6Var.getContexts().setTrace(y8.v(c1Var.getPropagationContext()));
            } else {
                r6Var.getContexts().setTrace(span.r());
            }
        }
        return I(r6Var, l0Var, c1Var.getEventProcessors());
    }

    @Nullable
    private p5 v(@Nullable i5 i5Var, @Nullable List<io.sentry.b> list, @Nullable e8 e8Var, @Nullable v8 v8Var, @Nullable x3 x3Var) throws IOException, io.sentry.exception.c {
        SentryId sentryId;
        ArrayList arrayList = new ArrayList();
        if (i5Var != null) {
            arrayList.add(p6.B(this.f27979b.getSerializer(), i5Var));
            sentryId = i5Var.getEventId();
        } else {
            sentryId = null;
        }
        if (e8Var != null) {
            arrayList.add(p6.F(this.f27979b.getSerializer(), e8Var));
        }
        if (x3Var != null) {
            arrayList.add(p6.E(x3Var, this.f27979b.getMaxTraceFileSize(), this.f27979b.getSerializer()));
            if (sentryId == null) {
                sentryId = new SentryId(x3Var.B());
            }
        }
        if (list != null) {
            Iterator<io.sentry.b> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(p6.z(this.f27979b.getSerializer(), this.f27979b.getLogger(), it.next(), this.f27979b.getMaxAttachmentSize()));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new p5(new q5(sentryId, this.f27979b.getSdkVersion(), v8Var), arrayList);
    }

    @NotNull
    private p5 w(@NotNull f7 f7Var) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(p6.C(this.f27979b.getSerializer(), f7Var));
        return new p5(new q5(null, this.f27979b.getSdkVersion(), null), arrayList);
    }

    @NotNull
    private p5 x(@NotNull c9 c9Var) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(p6.G(this.f27979b.getSerializer(), c9Var));
        return new p5(new q5(c9Var.a(), this.f27979b.getSdkVersion()), arrayList);
    }

    @Nullable
    private r6 y(@NotNull r6 r6Var, @NotNull l0 l0Var) {
        this.f27979b.getBeforeSend();
        return r6Var;
    }

    @Nullable
    private r6 z(@NotNull r6 r6Var, @NotNull l0 l0Var) {
        this.f27979b.getBeforeSendFeedback();
        return r6Var;
    }

    @TestOnly
    @Nullable
    e8 Q(@NotNull final r6 r6Var, @NotNull final l0 l0Var, @Nullable c1 c1Var) {
        if (io.sentry.util.m.u(l0Var)) {
            if (c1Var != null) {
                return c1Var.withSession(new Scope.b() { // from class: io.sentry.k5
                    @Override // io.sentry.Scope.b
                    public final void a(e8 e8Var) {
                        this.f27965a.H(r6Var, l0Var, e8Var);
                    }
                });
            }
            this.f27979b.getLogger().c(SentryLevel.INFO, "Scope is null on client.captureEvent", new Object[0]);
        }
        return null;
    }

    @Override // io.sentry.i1
    @NotNull
    public SentryId a(@NotNull SentryTransaction sentryTransaction, @Nullable v8 v8Var, @Nullable c1 c1Var, @Nullable l0 l0Var, @Nullable x3 x3Var) {
        SentryTransaction sentryTransactionK = sentryTransaction;
        io.sentry.util.w.c(sentryTransaction, "Transaction is required.");
        l0 l0Var2 = l0Var == null ? new l0() : l0Var;
        if (N(sentryTransaction, l0Var2)) {
            r(c1Var, l0Var2);
        }
        w0 logger = this.f27979b.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "Capturing transaction: %s", sentryTransaction.getEventId());
        if (io.sentry.util.k0.i(this.f27979b.getIgnoredTransactions(), sentryTransaction.getTransaction())) {
            this.f27979b.getLogger().c(sentryLevel, "Transaction was dropped as transaction name %s is ignored", sentryTransaction.getTransaction());
            io.sentry.clientreport.h clientReportRecorder = this.f27979b.getClientReportRecorder();
            io.sentry.clientreport.f fVar = io.sentry.clientreport.f.EVENT_PROCESSOR;
            clientReportRecorder.a(fVar, m.Transaction);
            this.f27979b.getClientReportRecorder().c(fVar, m.Span, sentryTransaction.getSpans().size() + 1);
            return SentryId.EMPTY_ID;
        }
        SentryId sentryId = SentryId.EMPTY_ID;
        SentryId eventId = sentryTransaction.getEventId() != null ? sentryTransaction.getEventId() : sentryId;
        if (N(sentryTransaction, l0Var2)) {
            sentryTransactionK = (SentryTransaction) t(sentryTransaction, c1Var);
            if (sentryTransactionK != null && c1Var != null) {
                sentryTransactionK = K(sentryTransactionK, l0Var2, c1Var.getEventProcessors());
            }
            if (sentryTransactionK == null) {
                this.f27979b.getLogger().c(sentryLevel, "Transaction was dropped by applyScope", new Object[0]);
            }
        }
        if (sentryTransactionK != null) {
            sentryTransactionK = K(sentryTransactionK, l0Var2, this.f27979b.getEventProcessors());
        }
        if (sentryTransactionK == null) {
            this.f27979b.getLogger().c(sentryLevel, "Transaction was dropped by Event processors.", new Object[0]);
            return sentryId;
        }
        int size = sentryTransactionK.getSpans().size();
        SentryTransaction sentryTransactionA = A(sentryTransactionK, l0Var2);
        int size2 = sentryTransactionA == null ? 0 : sentryTransactionA.getSpans().size();
        if (sentryTransactionA == null) {
            this.f27979b.getLogger().c(sentryLevel, "Transaction was dropped by beforeSendTransaction.", new Object[0]);
            io.sentry.clientreport.h clientReportRecorder2 = this.f27979b.getClientReportRecorder();
            io.sentry.clientreport.f fVar2 = io.sentry.clientreport.f.BEFORE_SEND;
            clientReportRecorder2.a(fVar2, m.Transaction);
            this.f27979b.getClientReportRecorder().c(fVar2, m.Span, size + 1);
            return sentryId;
        }
        if (size2 < size) {
            int i10 = size - size2;
            this.f27979b.getLogger().c(sentryLevel, "%d spans were dropped by beforeSendTransaction.", Integer.valueOf(i10));
            this.f27979b.getClientReportRecorder().c(io.sentry.clientreport.f.BEFORE_SEND, m.Span, i10);
        }
        try {
            p5 p5VarV = v(sentryTransactionA, B(D(l0Var2)), null, v8Var, x3Var);
            l0Var2.b();
            return p5VarV != null ? M(p5VarV, l0Var2) : eventId;
        } catch (io.sentry.exception.c | IOException e10) {
            this.f27979b.getLogger().a(SentryLevel.WARNING, e10, "Capturing transaction %s failed.", eventId);
            return SentryId.EMPTY_ID;
        }
    }

    @Override // io.sentry.i1
    public void b(boolean z10) {
        long shutdownTimeoutMillis;
        this.f27979b.getLogger().c(SentryLevel.INFO, "Closing SentryClient.", new Object[0]);
        if (z10) {
            shutdownTimeoutMillis = 0;
        } else {
            try {
                shutdownTimeoutMillis = this.f27979b.getShutdownTimeoutMillis();
            } catch (IOException e10) {
                this.f27979b.getLogger().b(SentryLevel.WARNING, "Failed to close the connection to the Sentry Server.", e10);
            }
        }
        f(shutdownTimeoutMillis);
        this.f27982e.b(z10);
        this.f27980c.b(z10);
        for (g0 g0Var : this.f27979b.getEventProcessors()) {
            if (g0Var instanceof Closeable) {
                try {
                    ((Closeable) g0Var).close();
                } catch (IOException e11) {
                    this.f27979b.getLogger().c(SentryLevel.WARNING, "Failed to close the event processor {}.", g0Var, e11);
                }
            }
        }
        this.f27978a = false;
    }

    @Override // io.sentry.i1
    public /* synthetic */ SentryId c(r6 r6Var, c1 c1Var) {
        return h1.a(this, r6Var, c1Var);
    }

    @Override // io.sentry.i1
    public boolean d() {
        return this.f27980c.d();
    }

    @Override // io.sentry.i1
    @Nullable
    public io.sentry.transport.b0 e() {
        return this.f27980c.e();
    }

    @Override // io.sentry.i1
    public void f(long j10) {
        this.f27980c.f(j10);
    }

    @Override // io.sentry.i1
    @ApiStatus.Internal
    public void g(@NotNull e8 e8Var, @Nullable l0 l0Var) {
        io.sentry.util.w.c(e8Var, "Session is required.");
        if (e8Var.h() == null || e8Var.h().isEmpty()) {
            this.f27979b.getLogger().c(SentryLevel.WARNING, "Sessions can't be captured without setting a release.", new Object[0]);
            return;
        }
        try {
            i(p5.a(this.f27979b.getSerializer(), e8Var, this.f27979b.getSdkVersion()), l0Var);
        } catch (IOException e10) {
            this.f27979b.getLogger().b(SentryLevel.ERROR, "Failed to capture session.", e10);
        }
    }

    @Override // io.sentry.i1
    @NotNull
    public SentryId h(@NotNull Feedback feedback, @Nullable l0 l0Var, @NotNull c1 c1Var) {
        r6 r6Var = new r6();
        r6Var.getContexts().setFeedback(feedback);
        l0 l0Var2 = l0Var == null ? new l0() : l0Var;
        if (feedback.getUrl() == null) {
            feedback.setUrl(c1Var.getScreen());
        }
        w0 logger = this.f27979b.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "Capturing feedback: %s", r6Var.getEventId());
        if (N(r6Var, l0Var2) && (r6Var = s(r6Var, c1Var, l0Var2)) == null) {
            this.f27979b.getLogger().c(sentryLevel, "Feedback was dropped by applyScope", new Object[0]);
            return SentryId.EMPTY_ID;
        }
        r6 r6VarJ = J(r6Var, l0Var2, this.f27979b.getEventProcessors());
        if (r6VarJ != null && (r6VarJ = z(r6VarJ, l0Var2)) == null) {
            this.f27979b.getLogger().c(sentryLevel, "Event was dropped by beforeSend", new Object[0]);
            this.f27979b.getClientReportRecorder().a(io.sentry.clientreport.f.BEFORE_SEND, m.Feedback);
        }
        if (r6VarJ == null) {
            return SentryId.EMPTY_ID;
        }
        SentryId sentryId = SentryId.EMPTY_ID;
        SentryId eventId = r6VarJ.getEventId() != null ? r6VarJ.getEventId() : sentryId;
        if (feedback.getReplayId() == null) {
            this.f27979b.getReplayController().a(Boolean.FALSE);
            SentryId replayId = c1Var.getReplayId();
            if (!replayId.equals(sentryId)) {
                feedback.setReplayId(replayId);
            }
        }
        try {
            p5 p5VarV = v(r6VarJ, D(l0Var2), null, F(c1Var, l0Var2, r6VarJ), null);
            l0Var2.b();
            return p5VarV != null ? M(p5VarV, l0Var2) : eventId;
        } catch (io.sentry.exception.c | IOException e10) {
            this.f27979b.getLogger().a(SentryLevel.WARNING, e10, "Capturing feedback %s failed.", eventId);
            return SentryId.EMPTY_ID;
        }
    }

    @Override // io.sentry.i1
    @ApiStatus.Internal
    @NotNull
    public SentryId i(@NotNull p5 p5Var, @Nullable l0 l0Var) {
        io.sentry.util.w.c(p5Var, "SentryEnvelope is required.");
        if (l0Var == null) {
            l0Var = new l0();
        }
        try {
            l0Var.b();
            return M(p5Var, l0Var);
        } catch (IOException e10) {
            this.f27979b.getLogger().b(SentryLevel.ERROR, "Failed to capture envelope.", e10);
            return SentryId.EMPTY_ID;
        }
    }

    @Override // io.sentry.i1
    public boolean isEnabled() {
        return this.f27978a;
    }

    @Override // io.sentry.i1
    public void j(@NotNull c9 c9Var) {
        io.sentry.util.w.c(c9Var, "SentryEvent is required.");
        if (SentryId.EMPTY_ID.equals(c9Var.a())) {
            this.f27979b.getLogger().c(SentryLevel.WARNING, "Capturing userFeedback without a Sentry Id.", new Object[0]);
            return;
        }
        this.f27979b.getLogger().c(SentryLevel.DEBUG, "Capturing userFeedback: %s", c9Var.a());
        try {
            M(x(c9Var), null);
        } catch (IOException e10) {
            this.f27979b.getLogger().a(SentryLevel.WARNING, e10, "Capturing user feedback %s failed.", c9Var.a());
        }
    }

    @Override // io.sentry.i1
    @ApiStatus.Internal
    public void k(@NotNull f7 f7Var) {
        try {
            M(w(f7Var), null);
        } catch (IOException e10) {
            this.f27979b.getLogger().a(SentryLevel.WARNING, e10, "Capturing log failed.", new Object[0]);
        }
    }

    @Override // io.sentry.i1
    @ApiStatus.Experimental
    @NotNull
    public SentryId l(@NotNull f fVar, @Nullable c1 c1Var, @Nullable l0 l0Var) {
        if (l0Var == null) {
            new l0();
        }
        throw null;
    }

    @Override // io.sentry.i1
    public /* synthetic */ SentryId m(String str, SentryLevel sentryLevel, c1 c1Var) {
        return h1.b(this, str, sentryLevel, c1Var);
    }

    @Override // io.sentry.i1
    @ApiStatus.Internal
    @NotNull
    public SentryId n(@NotNull t3 t3Var, @Nullable c1 c1Var) {
        io.sentry.util.w.c(t3Var, "profileChunk is required.");
        this.f27979b.getLogger().c(SentryLevel.DEBUG, "Capturing profile chunk: %s", t3Var.l());
        SentryId sentryIdL = t3Var.l();
        DebugMeta debugMetaBuildDebugMeta = DebugMeta.buildDebugMeta(t3Var.m(), this.f27979b);
        if (debugMetaBuildDebugMeta != null) {
            t3Var.p(debugMetaBuildDebugMeta);
        }
        try {
            return M(new p5(new q5(sentryIdL, this.f27979b.getSdkVersion(), null), Collections.singletonList(p6.D(t3Var, this.f27979b.getSerializer()))), null);
        } catch (io.sentry.exception.c | IOException e10) {
            this.f27979b.getLogger().a(SentryLevel.WARNING, e10, "Capturing profile chunk %s failed.", sentryIdL);
            return SentryId.EMPTY_ID;
        }
    }

    @Override // io.sentry.i1
    @NotNull
    public SentryId o(@NotNull r6 r6Var, @Nullable c1 c1Var, @Nullable l0 l0Var) {
        r6 r6Var2;
        io.sentry.util.w.c(r6Var, "SentryEvent is required.");
        if (l0Var == null) {
            l0Var = new l0();
        }
        if (N(r6Var, l0Var)) {
            r(c1Var, l0Var);
        }
        w0 logger = this.f27979b.getLogger();
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        logger.c(sentryLevel, "Capturing event: %s", r6Var.getEventId());
        Throwable throwable = r6Var.getThrowable();
        if (throwable != null && io.sentry.util.g.b(this.f27979b.getIgnoredExceptionsForType(), throwable)) {
            this.f27979b.getLogger().c(sentryLevel, "Event was dropped as the exception %s is ignored", throwable.getClass());
            this.f27979b.getClientReportRecorder().a(io.sentry.clientreport.f.EVENT_PROCESSOR, m.Error);
            return SentryId.EMPTY_ID;
        }
        if (io.sentry.util.e.a(this.f27979b.getIgnoredErrors(), r6Var)) {
            this.f27979b.getLogger().c(sentryLevel, "Event was dropped as it matched a string/pattern in ignoredErrors", r6Var.m());
            this.f27979b.getClientReportRecorder().a(io.sentry.clientreport.f.EVENT_PROCESSOR, m.Error);
            return SentryId.EMPTY_ID;
        }
        if (N(r6Var, l0Var) && (r6Var = u(r6Var, c1Var, l0Var)) == null) {
            this.f27979b.getLogger().c(sentryLevel, "Event was dropped by applyScope", new Object[0]);
            return SentryId.EMPTY_ID;
        }
        r6 r6VarI = I(r6Var, l0Var, this.f27979b.getEventProcessors());
        if (r6VarI != null && (r6VarI = y(r6VarI, l0Var)) == null) {
            this.f27979b.getLogger().c(sentryLevel, "Event was dropped by beforeSend", new Object[0]);
            this.f27979b.getClientReportRecorder().a(io.sentry.clientreport.f.BEFORE_SEND, m.Error);
        }
        if (r6VarI == null) {
            return SentryId.EMPTY_ID;
        }
        e8 e8VarWithSession = c1Var != null ? c1Var.withSession(new Scope.b() { // from class: io.sentry.j5
            @Override // io.sentry.Scope.b
            public final void a(e8 e8Var) {
                l5.G(e8Var);
            }
        }) : null;
        e8 e8VarQ = (e8VarWithSession == null || !e8VarWithSession.m()) ? Q(r6VarI, l0Var, c1Var) : null;
        if (L()) {
            r6Var2 = r6VarI;
        } else {
            this.f27979b.getLogger().c(sentryLevel, "Event %s was dropped due to sampling decision.", r6VarI.getEventId());
            this.f27979b.getClientReportRecorder().a(io.sentry.clientreport.f.SAMPLE_RATE, m.Error);
            r6Var2 = null;
        }
        boolean zO = O(e8VarWithSession, e8VarQ);
        if (r6Var2 == null && !zO) {
            this.f27979b.getLogger().c(sentryLevel, "Not sending session update for dropped event as it did not cause the session health to change.", new Object[0]);
            return SentryId.EMPTY_ID;
        }
        SentryId sentryIdM = SentryId.EMPTY_ID;
        if (r6Var2 != null && r6Var2.getEventId() != null) {
            sentryIdM = r6Var2.getEventId();
        }
        boolean zH = io.sentry.util.m.h(l0Var, io.sentry.hints.c.class);
        boolean z10 = io.sentry.util.m.h(l0Var, io.sentry.hints.e.class) && !io.sentry.util.m.h(l0Var, io.sentry.hints.b.class);
        if (r6Var2 != null && !zH && !z10 && (r6Var2.s() || r6Var2.r())) {
            this.f27979b.getReplayController().a(Boolean.valueOf(r6Var2.r()));
        }
        try {
            p5 p5VarV = v(r6Var2, r6Var2 != null ? D(l0Var) : null, e8VarQ, F(c1Var, l0Var, r6Var2), null);
            l0Var.b();
            if (p5VarV != null) {
                sentryIdM = M(p5VarV, l0Var);
            }
        } catch (io.sentry.exception.c | IOException e10) {
            this.f27979b.getLogger().a(SentryLevel.WARNING, e10, "Capturing event %s failed.", sentryIdM);
            sentryIdM = SentryId.EMPTY_ID;
        }
        if (c1Var != null) {
            C(c1Var, l0Var);
        }
        return sentryIdM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G(e8 e8Var) {
    }
}
