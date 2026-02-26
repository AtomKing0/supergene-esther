package androidx.compose.runtime;

import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Updater<T> {

    @NotNull
    private final Composer composer;

    private /* synthetic */ Updater(Composer composer) {
        this.composer = composer;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Updater m1257boximpl(Composer composer) {
        return new Updater(composer);
    }

    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> Composer m1258constructorimpl(@NotNull Composer composer) {
        t.i(composer, "composer");
        return composer;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1259equalsimpl(Composer composer, Object obj) {
        return (obj instanceof Updater) && t.d(composer, ((Updater) obj).m1269unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1260equalsimpl0(Composer composer, Composer composer2) {
        return t.d(composer, composer2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1261hashCodeimpl(Composer composer) {
        return composer.hashCode();
    }

    /* JADX INFO: renamed from: init-impl, reason: not valid java name */
    public static final void m1262initimpl(Composer composer, @NotNull l<? super T, k0> block) {
        t.i(block, "block");
        if (composer.getInserting()) {
            composer.apply(k0.f35197a, new Updater$init$1(block));
        }
    }

    /* JADX INFO: renamed from: reconcile-impl, reason: not valid java name */
    public static final void m1263reconcileimpl(Composer composer, @NotNull l<? super T, k0> block) {
        t.i(block, "block");
        composer.apply(k0.f35197a, new Updater$reconcile$1(block));
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m1264setimpl(Composer composer, int i10, @NotNull p<? super T, ? super Integer, k0> block) {
        t.i(block, "block");
        if (composer.getInserting() || !t.d(composer.rememberedValue(), Integer.valueOf(i10))) {
            composer.updateRememberedValue(Integer.valueOf(i10));
            composer.apply(Integer.valueOf(i10), block);
        }
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1266toStringimpl(Composer composer) {
        return "Updater(composer=" + composer + ')';
    }

    /* JADX INFO: renamed from: update-impl, reason: not valid java name */
    public static final void m1267updateimpl(Composer composer, int i10, @NotNull p<? super T, ? super Integer, k0> block) {
        t.i(block, "block");
        boolean inserting = composer.getInserting();
        if (inserting || !t.d(composer.rememberedValue(), Integer.valueOf(i10))) {
            composer.updateRememberedValue(Integer.valueOf(i10));
            if (inserting) {
                return;
            }
            composer.apply(Integer.valueOf(i10), block);
        }
    }

    public boolean equals(Object obj) {
        return m1259equalsimpl(this.composer, obj);
    }

    public int hashCode() {
        return m1261hashCodeimpl(this.composer);
    }

    public String toString() {
        return m1266toStringimpl(this.composer);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Composer m1269unboximpl() {
        return this.composer;
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final <V> void m1265setimpl(Composer composer, V v10, @NotNull p<? super T, ? super V, k0> block) {
        t.i(block, "block");
        if (composer.getInserting() || !t.d(composer.rememberedValue(), v10)) {
            composer.updateRememberedValue(v10);
            composer.apply(v10, block);
        }
    }

    /* JADX INFO: renamed from: update-impl, reason: not valid java name */
    public static final <V> void m1268updateimpl(Composer composer, V v10, @NotNull p<? super T, ? super V, k0> block) {
        t.i(block, "block");
        boolean inserting = composer.getInserting();
        if (inserting || !t.d(composer.rememberedValue(), v10)) {
            composer.updateRememberedValue(v10);
            if (inserting) {
                return;
            }
            composer.apply(v10, block);
        }
    }

    public static /* synthetic */ void getComposer$annotations() {
    }
}
