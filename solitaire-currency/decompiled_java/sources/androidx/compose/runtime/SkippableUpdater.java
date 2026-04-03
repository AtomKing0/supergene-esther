package androidx.compose.runtime;

import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SkippableUpdater<T> {

    @NotNull
    private final Composer composer;

    private /* synthetic */ SkippableUpdater(Composer composer) {
        this.composer = composer;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SkippableUpdater m1248boximpl(Composer composer) {
        return new SkippableUpdater(composer);
    }

    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> Composer m1249constructorimpl(@NotNull Composer composer) {
        t.i(composer, "composer");
        return composer;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1250equalsimpl(Composer composer, Object obj) {
        return (obj instanceof SkippableUpdater) && t.d(composer, ((SkippableUpdater) obj).m1255unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1251equalsimpl0(Composer composer, Composer composer2) {
        return t.d(composer, composer2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1252hashCodeimpl(Composer composer) {
        return composer.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1253toStringimpl(Composer composer) {
        return "SkippableUpdater(composer=" + composer + ')';
    }

    /* JADX INFO: renamed from: update-impl, reason: not valid java name */
    public static final void m1254updateimpl(Composer composer, @NotNull l<? super Updater<T>, k0> block) {
        t.i(block, "block");
        composer.startReplaceableGroup(509942095);
        block.invoke(Updater.m1257boximpl(Updater.m1258constructorimpl(composer)));
        composer.endReplaceableGroup();
    }

    public boolean equals(Object obj) {
        return m1250equalsimpl(this.composer, obj);
    }

    public int hashCode() {
        return m1252hashCodeimpl(this.composer);
    }

    public String toString() {
        return m1253toStringimpl(this.composer);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Composer m1255unboximpl() {
        return this.composer;
    }

    public static /* synthetic */ void getComposer$annotations() {
    }
}
