package com.ironsource;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public enum we {
    UnknownProvider(0),
    DeliverySonic(1),
    MarketPlaceISX(3);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f16032b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16037a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final we a(@Nullable Integer num) {
            we weVar;
            we[] weVarArrValues = we.values();
            int length = weVarArrValues.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    weVar = null;
                    break;
                }
                weVar = weVarArrValues[i10];
                if (num != null && weVar.b() == num.intValue()) {
                    break;
                }
                i10++;
            }
            return weVar == null ? we.UnknownProvider : weVar;
        }

        @NotNull
        public final we a(@NotNull String dynamicDemandSourceId) {
            kotlin.jvm.internal.t.i(dynamicDemandSourceId, "dynamicDemandSourceId");
            List listC0 = p9.r.C0(dynamicDemandSourceId, new String[]{"_"}, false, 0, 6, null);
            return listC0.size() < 2 ? we.UnknownProvider : a(p9.p.l((String) listC0.get(1)));
        }
    }

    we(int i10) {
        this.f16037a = i10;
    }

    public final int b() {
        return this.f16037a;
    }
}
