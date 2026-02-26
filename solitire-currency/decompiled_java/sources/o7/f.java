package o7;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Demographic.kt */
/* JADX INFO: loaded from: classes4.dex */
public enum f {
    UNDER_100K(0, new n9.i(Integer.MIN_VALUE, 100000)),
    FROM_100K_TO_300K(1, new n9.i(100001, 300000)),
    FROM_300K_TO_500K(2, new n9.i(300001, 500000)),
    FROM_500K_TO_700K(3, new n9.i(500001, 700000)),
    FROM_700K_TO_900K(4, new n9.i(700001, 900000)),
    FROM_900K_TO_1M1(5, new n9.i(900001, 1100000)),
    FROM_1M1_TO_1M3(6, new n9.i(1100001, 1300000)),
    FROM_1M3_TO_1M5(7, new n9.i(1300001, 1500000)),
    FROM_1M5_TO_1M7(8, new n9.i(1500001, 1700000)),
    OVER_1M7(9, new n9.i(1700001, Integer.MAX_VALUE));


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
        public final f fromPrice$vungle_ads_release(int i10) {
            f fVar;
            f[] fVarArrValues = f.values();
            int length = fVarArrValues.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    fVar = null;
                    break;
                }
                fVar = fVarArrValues[i11];
                n9.i range = fVar.getRange();
                if (i10 <= range.e() && range.b() <= i10) {
                    break;
                }
                i11++;
            }
            return fVar == null ? f.UNDER_100K : fVar;
        }
    }

    f(int i10, n9.i iVar) {
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
