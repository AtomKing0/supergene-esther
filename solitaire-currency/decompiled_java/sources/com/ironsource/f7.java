package com.ironsource;

import android.app.Activity;
import com.ironsource.environment.ContextProvider;
import com.ironsource.g7;
import com.ironsource.h7;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.h;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f7<Smash extends g7<?>, Listener extends AdapterAdInteractionListener> extends h7<Smash, Listener> implements c2 {

    class a extends yp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f12079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Placement f12080b;

        a(Activity activity, Placement placement) {
            this.f12079a = activity;
            this.f12080b = placement;
        }

        @Override // com.ironsource.yp
        public void a() {
            f7.this.b(this.f12079a, this.f12080b);
        }
    }

    f7(me meVar, le leVar, q0 q0Var, lj ljVar, IronSourceSegment ironSourceSegment) {
        super(meVar, leVar, q0Var, ljVar, ironSourceSegment);
    }

    private String a(List<Smash> list) {
        StringBuilder sb = new StringBuilder();
        for (Smash smash : list) {
            if (smash.e() != null) {
                sb.append(smash.c());
                sb.append(":");
                sb.append(smash.e());
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(Activity activity, Placement placement) {
        g7 g7Var;
        IronSourceError ironSourceError;
        String strA;
        IronLog.INTERNAL.verbose(b("state = " + this.f12416p));
        synchronized (this.f12424x) {
            this.f12409i = placement;
            this.f12419s.f16111j.a(activity, n());
            h7.f fVar = this.f12416p;
            h7.f fVar2 = h7.f.SHOWING;
            g7Var = null;
            if (fVar == fVar2) {
                ironSourceError = new IronSourceError(t1.g(this.f12415o.b()), "can't show ad while an ad is already showing");
            } else if (fVar != h7.f.READY_TO_SHOW) {
                ironSourceError = new IronSourceError(509, "show called while no ads are available");
            } else if (placement == null) {
                ironSourceError = new IronSourceError(t1.b(this.f12415o.b()), "empty default placement");
            } else if (this.E.b(ContextProvider.getInstance().getApplicationContext(), placement, this.f12415o.b())) {
                ironSourceError = new IronSourceError(t1.f(this.f12415o.b()), "placement " + placement.getPlacementName() + " is capped");
            } else {
                ironSourceError = null;
            }
            if (ironSourceError != null) {
                IronLog.API.error(b(ironSourceError.getErrorMessage()));
                strA = "";
            } else {
                List listB = this.f12401a.b();
                tu tuVar = new tu(this.f12415o);
                g7Var = (g7) tuVar.c(listB);
                a(g7Var, (List<g7>) tuVar.b(listB));
                if (g7Var != null) {
                    a(fVar2);
                    i(g7Var);
                } else {
                    ironSourceError = ErrorBuilder.buildNoAdsToShowError(this.f12415o.b().toString());
                    strA = a(listB);
                }
            }
            a(ironSourceError, strA);
        }
        if (g7Var != null) {
            a(activity, (g7<?>) g7Var, this.f12409i);
        }
    }

    @Override // com.ironsource.c2
    public void c(g7<?> g7Var) {
        IronLog.INTERNAL.verbose(b(g7Var.k()));
        this.f12420t.a();
    }

    @Override // com.ironsource.c2
    public String d() {
        StringBuilder sb = new StringBuilder();
        if (this.f12416p == h7.f.READY_TO_SHOW) {
            for (g7 g7Var : this.f12401a.b()) {
                if (g7Var.y()) {
                    sb.append(g7Var.c());
                    sb.append(";");
                }
            }
        }
        return sb.toString();
    }

    @Override // com.ironsource.h7
    public boolean u() {
        if (!x()) {
            return false;
        }
        if (this.f12410j && !IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getApplicationContext())) {
            return false;
        }
        Iterator it = this.f12401a.b().iterator();
        while (it.hasNext()) {
            if (((g7) it.next()).B()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ironsource.h7
    protected boolean v() {
        return false;
    }

    protected f7(q0 q0Var, lj ljVar, IronSourceSegment ironSourceSegment) {
        super(q0Var, ljVar, ironSourceSegment);
    }

    private void a(Activity activity, g7<?> g7Var, Placement placement) {
        if (this.f12415o.i().e()) {
            this.f12418r.a();
        }
        g7Var.a(activity, placement);
    }

    @Override // com.ironsource.c2
    public void b(g7<?> g7Var) {
        IronLog.INTERNAL.verbose(b(g7Var.k()));
        this.f12420t.g(g7Var.f());
    }

    @Override // com.ironsource.c2
    public void d(g7<?> g7Var) {
        IronLog.INTERNAL.verbose(b(g7Var.k()));
        this.f12420t.b();
    }

    public void a(Activity activity, Placement placement) {
        if (c()) {
            a(new a(activity, placement));
        } else {
            b(activity, placement);
        }
    }

    @Override // com.ironsource.c2
    public void a(g7<?> g7Var) {
        IronLog.INTERNAL.verbose(b(g7Var.k()));
        if (this.f12416p == h7.f.SHOWING) {
            a(h7.f.READY_TO_LOAD);
        }
        this.f12417q.f();
        this.f12420t.a(g7Var.f());
    }

    private void a(@Nullable Smash smash, List<Smash> list) {
        for (Smash smash2 : list) {
            if (smash != null && smash2 == smash) {
                smash.b(true);
                return;
            }
            smash2.b(false);
            IronLog.INTERNAL.verbose(b(smash2.k() + " - not ready to show"));
        }
    }

    @Override // com.ironsource.c2
    public void a(IronSourceError ironSourceError, g7<?> g7Var) {
        IronLog.INTERNAL.verbose(b(g7Var.k() + " - error = " + ironSourceError));
        this.f12402b.put(g7Var.c(), h.a.ISAuctionPerformanceFailedToShow);
        a(h7.f.READY_TO_LOAD);
        a(ironSourceError, g7Var, "");
    }

    private void a(IronSourceError ironSourceError, g7<?> g7Var, String str) {
        this.f12419s.f16111j.a(n(), ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), str);
        this.f12417q.g();
        this.f12420t.a(ironSourceError, g7Var != null ? g7Var.f() : null);
        if (this.f12415o.i().e()) {
            b(false);
        }
    }

    private void a(IronSourceError ironSourceError, String str) {
        a(ironSourceError, (g7<?>) null, str);
    }
}
