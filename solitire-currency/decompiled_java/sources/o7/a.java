package o7;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Demographic.kt */
/* JADX INFO: loaded from: classes4.dex */
public enum a {
    AGE_18_20(1, new n9.i(18, 20)),
    AGE_21_30(2, new n9.i(21, 30)),
    AGE_31_40(3, new n9.i(31, 40)),
    AGE_41_50(4, new n9.i(41, 50)),
    AGE_51_60(5, new n9.i(51, 60)),
    AGE_61_70(6, new n9.i(61, 70)),
    AGE_71_75(7, new n9.i(71, 75)),
    OTHERS(0, new n9.i(Integer.MIN_VALUE, Integer.MAX_VALUE));


    @NotNull
    public static final C0641a Companion = new C0641a(null);
    private final int id;

    @NotNull
    private final n9.i range;

    /* JADX INFO: renamed from: o7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Demographic.kt */
    public static final class C0641a {
        private C0641a() {
        }

        public /* synthetic */ C0641a(k kVar) {
            this();
        }

        @NotNull
        public final a fromAge$vungle_ads_release(int i10) {
            a aVar;
            a[] aVarArrValues = a.values();
            int length = aVarArrValues.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    aVar = null;
                    break;
                }
                aVar = aVarArrValues[i11];
                n9.i range = aVar.getRange();
                if (i10 <= range.e() && range.b() <= i10) {
                    break;
                }
                i11++;
            }
            return aVar == null ? a.OTHERS : aVar;
        }
    }

    a(int i10, n9.i iVar) {
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
