package o7;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Demographic.kt */
/* JADX INFO: loaded from: classes4.dex */
public enum d {
    LESS_THAN_ONE_YEAR(0, new n9.i(Integer.MIN_VALUE, 0)),
    ONE_TO_FIVE_YEARS(1, new n9.i(1, 5)),
    SIX_TO_TEN_YEARS(2, new n9.i(6, 10)),
    ELEVEN_TO_TWENTY_YEARS(3, new n9.i(11, 20)),
    TWENTY_ONE_TO_THIRTY_YEARS(4, new n9.i(21, 30)),
    THIRTY_ONE_TO_FORTY_YEARS(5, new n9.i(31, 40)),
    FORTY_ONE_TO_FIFTY_YEARS(6, new n9.i(41, 50)),
    FIFTY_ONE_TO_SIXTY_YEARS(7, new n9.i(51, 60)),
    SIXTY_ONE_TO_SEVENTY_YEARS(8, new n9.i(61, 70)),
    OVER_SEVENTY_ONE_YEARS(9, new n9.i(71, Integer.MAX_VALUE));


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
        public final d fromYears$vungle_ads_release(int i10) {
            d dVar;
            d[] dVarArrValues = d.values();
            int length = dVarArrValues.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    dVar = null;
                    break;
                }
                dVar = dVarArrValues[i11];
                n9.i range = dVar.getRange();
                if (i10 <= range.e() && range.b() <= i10) {
                    break;
                }
                i11++;
            }
            return dVar == null ? d.LESS_THAN_ONE_YEAR : dVar;
        }
    }

    d(int i10, n9.i iVar) {
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
