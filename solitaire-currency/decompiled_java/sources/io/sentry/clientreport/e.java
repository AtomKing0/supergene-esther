package io.sentry.clientreport;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.b7;
import io.sentry.m;
import io.sentry.n;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.protocol.SentryTransaction;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ClientReportRecorder.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final i f27726a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final SentryOptions f27727b;

    public e(@NotNull SentryOptions sentryOptions) {
        this.f27727b = sentryOptions;
    }

    private m f(b7 b7Var) {
        return b7.Event.equals(b7Var) ? m.Error : b7.Session.equals(b7Var) ? m.Session : b7.Transaction.equals(b7Var) ? m.Transaction : b7.UserFeedback.equals(b7Var) ? m.UserReport : b7.Feedback.equals(b7Var) ? m.Feedback : b7.Profile.equals(b7Var) ? m.Profile : b7.ProfileChunk.equals(b7Var) ? m.ProfileChunkUi : b7.Attachment.equals(b7Var) ? m.Attachment : b7.CheckIn.equals(b7Var) ? m.Monitor : b7.ReplayVideo.equals(b7Var) ? m.Replay : b7.Log.equals(b7Var) ? m.LogItem : m.Default;
    }

    private void g(@NotNull String str, @NotNull String str2, @NotNull Long l10) {
        this.f27726a.a(new d(str, str2), l10);
    }

    private void i(@Nullable c cVar) {
        if (cVar == null) {
            return;
        }
        for (g gVar : cVar.a()) {
            g(gVar.c(), gVar.a(), gVar.b());
        }
    }

    @Override // io.sentry.clientreport.h
    public void a(@NotNull f fVar, @NotNull m mVar) {
        c(fVar, mVar, 1L);
    }

    @Override // io.sentry.clientreport.h
    public void b(@NotNull f fVar, @Nullable p5 p5Var) {
        if (p5Var == null) {
            return;
        }
        try {
            Iterator<p6> it = p5Var.c().iterator();
            while (it.hasNext()) {
                d(fVar, it.next());
            }
        } catch (Throwable th) {
            this.f27727b.getLogger().a(SentryLevel.ERROR, th, "Unable to record lost envelope.", new Object[0]);
        }
    }

    @Override // io.sentry.clientreport.h
    public void c(@NotNull f fVar, @NotNull m mVar, long j10) {
        try {
            g(fVar.getReason(), mVar.getCategory(), Long.valueOf(j10));
        } catch (Throwable th) {
            this.f27727b.getLogger().a(SentryLevel.ERROR, th, "Unable to record lost event.", new Object[0]);
        }
    }

    @Override // io.sentry.clientreport.h
    public void d(@NotNull f fVar, @Nullable p6 p6Var) {
        SentryTransaction sentryTransactionL;
        if (p6Var == null) {
            return;
        }
        try {
            b7 b7VarB = p6Var.K().b();
            if (b7.ClientReport.equals(b7VarB)) {
                try {
                    i(p6Var.H(this.f27727b.getSerializer()));
                } catch (Exception unused) {
                    this.f27727b.getLogger().c(SentryLevel.ERROR, "Unable to restore counts from previous client report.", new Object[0]);
                }
            } else {
                m mVarF = f(b7VarB);
                if (mVarF.equals(m.Transaction) && (sentryTransactionL = p6Var.L(this.f27727b.getSerializer())) != null) {
                    g(fVar.getReason(), m.Span.getCategory(), Long.valueOf(((long) sentryTransactionL.getSpans().size()) + 1));
                }
                g(fVar.getReason(), mVarF.getCategory(), 1L);
            }
        } catch (Throwable th) {
            this.f27727b.getLogger().a(SentryLevel.ERROR, th, "Unable to record lost envelope item.", new Object[0]);
        }
    }

    @Override // io.sentry.clientreport.h
    @NotNull
    public p5 e(@NotNull p5 p5Var) {
        c cVarH = h();
        if (cVarH == null) {
            return p5Var;
        }
        try {
            this.f27727b.getLogger().c(SentryLevel.DEBUG, "Attaching client report to envelope.", new Object[0]);
            ArrayList arrayList = new ArrayList();
            Iterator<p6> it = p5Var.c().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            arrayList.add(p6.A(this.f27727b.getSerializer(), cVarH));
            return new p5(p5Var.b(), arrayList);
        } catch (Throwable th) {
            this.f27727b.getLogger().a(SentryLevel.ERROR, th, "Unable to attach client report to envelope.", new Object[0]);
            return p5Var;
        }
    }

    @Nullable
    c h() {
        Date dateD = n.d();
        List<g> listB = this.f27726a.b();
        if (listB.isEmpty()) {
            return null;
        }
        return new c(dateD, listB);
    }
}
