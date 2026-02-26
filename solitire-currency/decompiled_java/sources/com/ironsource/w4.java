package com.ironsource;

import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class w4 implements on {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final p2 f15995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final com.ironsource.mediationsdk.e f15996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15997c;

    public w4(@NotNull p2 adTools, @NotNull com.ironsource.mediationsdk.e auctionHandler) {
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(auctionHandler, "auctionHandler");
        this.f15995a = adTools;
        this.f15996b = auctionHandler;
    }

    private final void a(lj ljVar, f5 f5Var, String str) {
        if (f5Var == null) {
            IronLog.INTERNAL.error(k1.a(this.f15995a, "reportImpressionDataToPublisher - no auctionResponseItem or listener", (String) null, 2, (Object) null));
            this.f15995a.e().g().f("reportImpressionDataToPublisher - no auctionResponseItem or listener");
            return;
        }
        final ImpressionData impressionDataA = f5Var.a(str);
        if (impressionDataA != null) {
            for (final ImpressionDataListener impressionDataListener : new HashSet(ljVar.a())) {
                this.f15995a.e(new Runnable() { // from class: com.ironsource.x00
                    @Override // java.lang.Runnable
                    public final void run() {
                        w4.a(this.f16099a, impressionDataListener, impressionDataA);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(w4 this$0, ImpressionDataListener listener, ImpressionData impressionData) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(listener, "$listener");
        IronLog.CALLBACK.info(k1.a(this$0.f15995a, "onImpressionSuccess " + listener.getClass().getSimpleName() + ": " + impressionData, (String) null, 2, (Object) null));
        listener.onImpressionSuccess(impressionData);
    }

    @Override // com.ironsource.on
    public void a(@NotNull x instance, @Nullable String str, @NotNull lj publisherDataHolder) {
        kotlin.jvm.internal.t.i(instance, "instance");
        kotlin.jvm.internal.t.i(publisherDataHolder, "publisherDataHolder");
        this.f15996b.a(instance.g(), instance.p(), instance.k(), str);
        a(publisherDataHolder, instance.g(), str);
    }

    @Override // com.ironsource.on
    public void a(@NotNull List<? extends x> waterfallInstances, @NotNull x winnerInstance) {
        kotlin.jvm.internal.t.i(waterfallInstances, "waterfallInstances");
        kotlin.jvm.internal.t.i(winnerInstance, "winnerInstance");
        if (this.f15997c) {
            return;
        }
        this.f15997c = true;
        f5 f5VarG = winnerInstance.g();
        this.f15996b.a(f5VarG, winnerInstance.p(), winnerInstance.k());
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, f5> concurrentHashMap = new ConcurrentHashMap<>();
        for (x xVar : waterfallInstances) {
            arrayList.add(xVar.n());
            concurrentHashMap.put(xVar.n(), xVar.g());
        }
        this.f15996b.a(arrayList, concurrentHashMap, winnerInstance.p(), winnerInstance.k(), f5VarG);
    }
}
