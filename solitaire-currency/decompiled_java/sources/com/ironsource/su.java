package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class su {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f15334c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final k1 f15335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final on f15336b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final su a(@NotNull p2 adTools, @NotNull s1 adUnitData, @NotNull on outcomeReporter, @NotNull nu waterfallInstances, @NotNull d0 adInstanceLoadStrategy) {
            kotlin.jvm.internal.t.i(adTools, "adTools");
            kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
            kotlin.jvm.internal.t.i(outcomeReporter, "outcomeReporter");
            kotlin.jvm.internal.t.i(waterfallInstances, "waterfallInstances");
            kotlin.jvm.internal.t.i(adInstanceLoadStrategy, "adInstanceLoadStrategy");
            return adUnitData.r() ? new es(adTools, outcomeReporter, waterfallInstances, adInstanceLoadStrategy) : new x9(adTools, outcomeReporter, waterfallInstances);
        }
    }

    public su(@NotNull k1 adTools, @NotNull on outcomeReporter) {
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(outcomeReporter, "outcomeReporter");
        this.f15335a = adTools;
        this.f15336b = outcomeReporter;
    }

    private final void b(x xVar, List<? extends x> list) {
        for (x xVar2 : list) {
            if (xVar2 == xVar) {
                xVar.a(true);
                return;
            }
            xVar2.a(false);
            IronLog.INTERNAL.verbose(k1.a(this.f15335a, xVar2.o() + " - not ready to show", (String) null, 2, (Object) null));
        }
    }

    public abstract void a();

    public abstract void a(@NotNull x xVar);

    public final void a(@NotNull x instance, @Nullable String str, @NotNull lj publisherDataHolder) {
        kotlin.jvm.internal.t.i(instance, "instance");
        kotlin.jvm.internal.t.i(publisherDataHolder, "publisherDataHolder");
        this.f15336b.a(instance, str, publisherDataHolder);
    }

    public abstract void b(@NotNull x xVar);

    public abstract void c(@NotNull x xVar);

    public final void a(@NotNull x instanceToShow, @NotNull List<? extends x> orderedInstances) {
        kotlin.jvm.internal.t.i(instanceToShow, "instanceToShow");
        kotlin.jvm.internal.t.i(orderedInstances, "orderedInstances");
        b(instanceToShow, orderedInstances);
        c(instanceToShow);
    }
}
