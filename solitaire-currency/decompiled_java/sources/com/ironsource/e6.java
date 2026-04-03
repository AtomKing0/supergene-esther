package com.ironsource;

import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.l1;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.x1;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class e6 extends l1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final WeakReference<h6> f11901h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final a f11902i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final f6 f11903j;

    private final class a extends l1.a implements s5 {
        public a() {
            super();
        }

        @Override // com.ironsource.s5
        public void a(@NotNull q5 instance) {
            kotlin.jvm.internal.t.i(instance, "instance");
            IronLog.INTERNAL.verbose(e6.this.a(instance.o()));
            h6 h6Var = (h6) e6.this.f11901h.get();
            if (h6Var != null) {
                h6Var.h(new p1(e6.this, instance.d()));
            }
        }

        @Override // com.ironsource.s5
        public void b(@NotNull q5 instance) {
            kotlin.jvm.internal.t.i(instance, "instance");
            IronLog.INTERNAL.verbose(e6.this.a(instance.o()));
            h6 h6Var = (h6) e6.this.f11901h.get();
            if (h6Var != null) {
                h6Var.c(new p1(e6.this, instance.d()));
            }
        }

        @Override // com.ironsource.s5
        public void c(@NotNull q5 instance) {
            kotlin.jvm.internal.t.i(instance, "instance");
            IronLog.INTERNAL.verbose(e6.this.a(instance.o()));
            h6 h6Var = (h6) e6.this.f11901h.get();
            if (h6Var != null) {
                h6Var.f(new p1(e6.this, instance.d()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e6(@NotNull k1 tools, @NotNull f6 adUnitData, @NotNull h6 listener) {
        String str;
        int iB;
        super(tools, adUnitData, listener);
        kotlin.jvm.internal.t.i(tools, "tools");
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        kotlin.jvm.internal.t.i(listener, "listener");
        this.f11901h = new WeakReference<>(listener);
        this.f11902i = new a();
        this.f11903j = adUnitData;
        Placement placementH = h();
        IronLog.INTERNAL.verbose("placement = " + placementH);
        if (placementH == null || TextUtils.isEmpty(placementH.getPlacementName())) {
            kotlin.jvm.internal.s0 s0Var = kotlin.jvm.internal.s0.f29840a;
            Object[] objArr = new Object[1];
            objArr[0] = placementH == null ? "placement is null" : "placement name is empty";
            str = String.format("can't load banner - %s", Arrays.copyOf(objArr, 1));
            kotlin.jvm.internal.t.h(str, "format(format, *args)");
            iB = t1.b(adUnitData.b().a());
        } else {
            str = null;
            iB = 510;
        }
        if (str != null) {
            IronLog.API.error(a(str));
            a(iB, str);
        }
    }

    @Override // com.ironsource.l1
    @NotNull
    protected a0 a() {
        return new a0() { // from class: com.ironsource.cw
            @Override // com.ironsource.a0
            public final x a(y yVar) {
                return e6.a(this.f11721a, yVar);
            }
        };
    }

    @Override // com.ironsource.l1
    @NotNull
    public n1 b() {
        return new l6(this.f11903j.b(), a(k()));
    }

    private final ISBannerSize a(ISBannerSize iSBannerSize) {
        return iSBannerSize.isSmart() ? AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()) ? com.ironsource.mediationsdk.l.a() : ISBannerSize.BANNER : iSBannerSize;
    }

    private final ISBannerSize k() {
        return g().a(this.f11903j.b().g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x a(e6 this$0, y instanceData) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(instanceData, "instanceData");
        return new q5(new p2(this$0.g(), x1.b.PROVIDER), instanceData, this$0.f11902i);
    }

    public final void a(@Nullable du duVar) {
        if (duVar != null) {
            a(new u5(duVar));
        }
    }
}
