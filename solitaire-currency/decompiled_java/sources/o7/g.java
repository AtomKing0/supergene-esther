package o7;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Demographic.kt */
/* JADX INFO: loaded from: classes4.dex */
public enum g {
    UNDER_500(0, new n9.i(Integer.MIN_VALUE, 500)),
    FROM_500_TO_1000(1, new n9.i(501, 1000)),
    FROM_1000_TO_1500(2, new n9.i(1001, 1500)),
    FROM_1500_TO_2000(3, new n9.i(1501, 2000)),
    FROM_2000_TO_2500(4, new n9.i(2001, 2500)),
    FROM_2500_TO_3000(5, new n9.i(2501, 3000)),
    FROM_3000_TO_3500(6, new n9.i(3001, IronSourceConstants.BN_AUCTION_REQUEST)),
    FROM_3500_TO_4000(7, new n9.i(IronSourceConstants.BN_AUCTION_FAILED, 4000)),
    FROM_4000_TO_4500(8, new n9.i(4001, IronSourceConstants.NT_AUCTION_REQUEST)),
    OVER_4500(9, new n9.i(IronSourceConstants.NT_AUCTION_FAILED, Integer.MAX_VALUE));


    @NotNull
    public static final a Companion = new a(null);
    private final int id;

    @NotNull
    private final n9.i range;

    /* JADX INFO: compiled from: Demographic.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        @NotNull
        public final g fromCost$vungle_ads_release(int i10) {
            g gVar;
            g[] gVarArrValues = g.values();
            int length = gVarArrValues.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    gVar = null;
                    break;
                }
                gVar = gVarArrValues[i11];
                n9.i range = gVar.getRange();
                if (i10 <= range.e() && range.b() <= i10) {
                    break;
                }
                i11++;
            }
            return gVar == null ? g.UNDER_500 : gVar;
        }
    }

    g(int i10, n9.i iVar) {
        this.id = i10;
        this.range = iVar;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final n9.i getRange() {
        return this.range;
    }
}
