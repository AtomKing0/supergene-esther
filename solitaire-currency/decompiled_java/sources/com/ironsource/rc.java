package com.ironsource;

import android.app.Activity;
import com.ironsource.l1;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.x1;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class rc extends l1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final WeakReference<tc> f14676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final b f14677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private WeakReference<o2> f14678j;

    public static final class a {
        @NotNull
        public final rc a(@NotNull k1 tools, @NotNull b1 adProperties, boolean z10, @NotNull tc listener, @Nullable ak akVar) {
            kotlin.jvm.internal.t.i(tools, "tools");
            kotlin.jvm.internal.t.i(adProperties, "adProperties");
            kotlin.jvm.internal.t.i(listener, "listener");
            IronLog.INTERNAL.verbose();
            return new rc(tools, di.A.a(adProperties, akVar, z10), listener);
        }
    }

    private final class b extends l1.a implements pc {
        public b() {
            super();
        }

        @Override // com.ironsource.pc
        public void a(@NotNull IronSourceError error, @NotNull oc fullscreenInstance) {
            kotlin.jvm.internal.t.i(error, "error");
            kotlin.jvm.internal.t.i(fullscreenInstance, "fullscreenInstance");
            IronLog.INTERNAL.verbose(rc.this.a(fullscreenInstance.o() + " - error = " + error));
            rc.this.a(error, fullscreenInstance);
        }

        @Override // com.ironsource.pc
        public void b(@NotNull oc fullscreenInstance) {
            kotlin.jvm.internal.t.i(fullscreenInstance, "fullscreenInstance");
            IronLog.INTERNAL.verbose(rc.this.a(fullscreenInstance.o()));
            rc.this.g().e().a().l(rc.this.i());
            rc.this.n();
            rc.this.m();
            rc.this.l();
            WeakReference weakReference = rc.this.f14678j;
            if (weakReference == null) {
                kotlin.jvm.internal.t.A("showListener");
                weakReference = null;
            }
            o2 o2Var = (o2) weakReference.get();
            if (o2Var != null) {
                o2Var.d(new p1(rc.this, fullscreenInstance.d()));
            }
        }

        @Override // com.ironsource.pc
        public void c(@NotNull oc fullscreenInstance) {
            kotlin.jvm.internal.t.i(fullscreenInstance, "fullscreenInstance");
            IronLog.INTERNAL.verbose(rc.this.a(fullscreenInstance.o()));
            rc.this.g().e().a().b(rc.this.i());
            tc tcVar = (tc) rc.this.f14676h.get();
            if (tcVar != null) {
                tcVar.a(new p1(rc.this, fullscreenInstance.d()));
            }
        }

        @Override // com.ironsource.pc
        public void a(@NotNull oc fullscreenInstance) {
            kotlin.jvm.internal.t.i(fullscreenInstance, "fullscreenInstance");
            IronLog.INTERNAL.verbose(rc.this.a(fullscreenInstance.o()));
            tc tcVar = (tc) rc.this.f14676h.get();
            if (tcVar != null) {
                tcVar.n(new p1(rc.this, fullscreenInstance.d()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rc(@NotNull k1 adTools, @NotNull s1 adUnitData, @NotNull tc listener) {
        super(adTools, adUnitData, listener);
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        kotlin.jvm.internal.t.i(listener, "listener");
        this.f14676h = new WeakReference<>(listener);
        this.f14677i = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        if (i().length() == 0) {
            return;
        }
        f8 f8VarA = el.f11917p.d().w().a(i(), f().b().c());
        if (f8VarA.d()) {
            g().e().a().b(i(), f8VarA.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        el.f11917p.a().u().b(f().b().b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        if (i().length() > 0) {
            el.f11917p.a().a().b(i(), f().b().c());
        }
    }

    private final IronSourceError o() {
        IronSourceError ironSourceError;
        if (!super.e().a()) {
            return new IronSourceError(509, "show called while ad unit is not ready to show");
        }
        if ((i().length() > 0) && el.f11917p.d().w().a(i(), f().b().c()).d()) {
            ironSourceError = new IronSourceError(IronSourceError.ERROR_PLACEMENT_CAPPED, "placement " + i() + " is capped");
        } else {
            if (!el.f11917p.d().s().a(f().b().b()).d()) {
                return null;
            }
            ironSourceError = new IronSourceError(IronSourceError.ERROR_AD_UNIT_CAPPED, "adUnitId " + f().b().b() + " is capped");
        }
        return ironSourceError;
    }

    @Override // com.ironsource.l1
    @NotNull
    protected a0 a() {
        return new a0() { // from class: com.ironsource.j00
            @Override // com.ironsource.a0
            public final x a(y yVar) {
                return rc.a(this.f12682a, yVar);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x a(rc this$0, y instanceData) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(instanceData, "instanceData");
        return new oc(new p2(this$0.g(), x1.b.PROVIDER), instanceData, this$0.f14677i);
    }

    private final LevelPlayAdInfo k() {
        Map mapG = kotlin.collections.r0.g();
        if (i().length() > 0) {
            mapG = kotlin.collections.q0.e(v8.y.a("placement", i()));
        }
        return new LevelPlayAdInfo(f().b().b(), f().b().c().getValue(), new ImpressionData(new JSONObject(mapG)), null, 8, null);
    }

    public final void a(@NotNull Activity activity, @NotNull o2 showListener) {
        kotlin.jvm.internal.t.i(activity, "activity");
        kotlin.jvm.internal.t.i(showListener, "showListener");
        this.f14678j = new WeakReference<>(showListener);
        IronLog.INTERNAL.verbose(a("showAd called"));
        g().e().a().a(activity, i());
        IronSourceError ironSourceErrorO = o();
        if (ironSourceErrorO == null) {
            a(new qc(activity));
        } else {
            IronLog.API.error(a(ironSourceErrorO.getErrorMessage()));
            a(ironSourceErrorO);
        }
    }

    private final void a(IronSourceError ironSourceError) {
        g().e().a().a(i(), ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), "");
        WeakReference<o2> weakReference = this.f14678j;
        if (weakReference == null) {
            kotlin.jvm.internal.t.A("showListener");
            weakReference = null;
        }
        o2 o2Var = weakReference.get();
        if (o2Var != null) {
            o2Var.b(new p1(this, k()), ironSourceError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(IronSourceError ironSourceError, oc ocVar) {
        g().e().a().a(i(), ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), "");
        WeakReference<o2> weakReference = this.f14678j;
        if (weakReference == null) {
            kotlin.jvm.internal.t.A("showListener");
            weakReference = null;
        }
        o2 o2Var = weakReference.get();
        if (o2Var != null) {
            o2Var.b(new p1(this, ocVar != null ? ocVar.d() : null), ironSourceError);
        }
    }

    static /* synthetic */ void a(rc rcVar, IronSourceError ironSourceError, oc ocVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            ocVar = null;
        }
        rcVar.a(ironSourceError, ocVar);
    }
}
