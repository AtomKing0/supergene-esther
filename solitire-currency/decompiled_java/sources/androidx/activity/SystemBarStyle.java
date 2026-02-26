package androidx.activity;

import android.content.res.Resources;
import androidx.annotation.ColorInt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EdgeToEdge.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SystemBarStyle {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int darkScrim;

    @NotNull
    private final h9.l<Resources, Boolean> detectDarkMode;
    private final int lightScrim;
    private final int nightMode;

    /* JADX INFO: compiled from: EdgeToEdge.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SystemBarStyle auto$default(Companion companion, int i10, int i11, h9.l lVar, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                lVar = SystemBarStyle$Companion$auto$1.INSTANCE;
            }
            return companion.auto(i10, i11, lVar);
        }

        @NotNull
        public final SystemBarStyle auto(@ColorInt int i10, @ColorInt int i11) {
            return auto$default(this, i10, i11, null, 4, null);
        }

        @NotNull
        public final SystemBarStyle dark(@ColorInt int i10) {
            return new SystemBarStyle(i10, i10, 2, SystemBarStyle$Companion$dark$1.INSTANCE, null);
        }

        @NotNull
        public final SystemBarStyle light(@ColorInt int i10, @ColorInt int i11) {
            return new SystemBarStyle(i10, i11, 1, SystemBarStyle$Companion$light$1.INSTANCE, null);
        }

        @NotNull
        public final SystemBarStyle auto(@ColorInt int i10, @ColorInt int i11, @NotNull h9.l<? super Resources, Boolean> detectDarkMode) {
            t.i(detectDarkMode, "detectDarkMode");
            return new SystemBarStyle(i10, i11, 0, detectDarkMode, null);
        }
    }

    public /* synthetic */ SystemBarStyle(int i10, int i11, int i12, h9.l lVar, kotlin.jvm.internal.k kVar) {
        this(i10, i11, i12, lVar);
    }

    @NotNull
    public static final SystemBarStyle auto(@ColorInt int i10, @ColorInt int i11) {
        return Companion.auto(i10, i11);
    }

    @NotNull
    public static final SystemBarStyle dark(@ColorInt int i10) {
        return Companion.dark(i10);
    }

    @NotNull
    public static final SystemBarStyle light(@ColorInt int i10, @ColorInt int i11) {
        return Companion.light(i10, i11);
    }

    public final int getDarkScrim$activity_release() {
        return this.darkScrim;
    }

    @NotNull
    public final h9.l<Resources, Boolean> getDetectDarkMode$activity_release() {
        return this.detectDarkMode;
    }

    public final int getNightMode$activity_release() {
        return this.nightMode;
    }

    public final int getScrim$activity_release(boolean z10) {
        return z10 ? this.darkScrim : this.lightScrim;
    }

    public final int getScrimWithEnforcedContrast$activity_release(boolean z10) {
        if (this.nightMode == 0) {
            return 0;
        }
        return z10 ? this.darkScrim : this.lightScrim;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SystemBarStyle(int i10, int i11, int i12, h9.l<? super Resources, Boolean> lVar) {
        this.lightScrim = i10;
        this.darkScrim = i11;
        this.nightMode = i12;
        this.detectDarkMode = lVar;
    }

    @NotNull
    public static final SystemBarStyle auto(@ColorInt int i10, @ColorInt int i11, @NotNull h9.l<? super Resources, Boolean> lVar) {
        return Companion.auto(i10, i11, lVar);
    }
}
