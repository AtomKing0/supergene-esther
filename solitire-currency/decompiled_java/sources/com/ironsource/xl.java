package com.ironsource;

import android.text.TextUtils;
import com.ironsource.l1;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.x1;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class xl extends l1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xl(@NotNull k1 adTools, @NotNull yl adUnitData, @NotNull zl listener) {
        String str;
        int iB;
        super(adTools, adUnitData, listener);
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        kotlin.jvm.internal.t.i(listener, "listener");
        Placement placementH = h();
        IronLog.INTERNAL.verbose("placement = " + placementH);
        if (placementH == null || TextUtils.isEmpty(placementH.getPlacementName())) {
            kotlin.jvm.internal.s0 s0Var = kotlin.jvm.internal.s0.f29840a;
            Object[] objArr = new Object[1];
            objArr[0] = placementH == null ? "placement is null" : "placement name is empty";
            str = String.format("can't load native ad - %s", Arrays.copyOf(objArr, 1));
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
        return new a0() { // from class: com.ironsource.l10
            @Override // com.ironsource.a0
            public final x a(y yVar) {
                return xl.a(this.f12952a, yVar);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x a(xl this$0, y adInstanceData) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInstanceData, "adInstanceData");
        return new pl(new p2(this$0.g(), x1.b.PROVIDER), adInstanceData, new l1.a());
    }
}
