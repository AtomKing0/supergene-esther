package androidx.compose.ui.text.font;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.State;
import androidx.media3.common.C;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: FontFamily.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public abstract class FontFamily {
    private final boolean canLoadSynchronously;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final SystemFontFamily Default = new DefaultFontFamily();

    @NotNull
    private static final GenericFontFamily SansSerif = new GenericFontFamily(C.SANS_SERIF_NAME, "FontFamily.SansSerif");

    @NotNull
    private static final GenericFontFamily Serif = new GenericFontFamily(C.SERIF_NAME, "FontFamily.Serif");

    @NotNull
    private static final GenericFontFamily Monospace = new GenericFontFamily("monospace", "FontFamily.Monospace");

    @NotNull
    private static final GenericFontFamily Cursive = new GenericFontFamily("cursive", "FontFamily.Cursive");

    /* JADX INFO: compiled from: FontFamily.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final GenericFontFamily getCursive() {
            return FontFamily.Cursive;
        }

        @NotNull
        public final SystemFontFamily getDefault() {
            return FontFamily.Default;
        }

        @NotNull
        public final GenericFontFamily getMonospace() {
            return FontFamily.Monospace;
        }

        @NotNull
        public final GenericFontFamily getSansSerif() {
            return FontFamily.SansSerif;
        }

        @NotNull
        public final GenericFontFamily getSerif() {
            return FontFamily.Serif;
        }
    }

    /* JADX INFO: compiled from: FontFamily.kt */
    public interface Resolver {
        @Nullable
        Object preload(@NotNull FontFamily fontFamily, @NotNull z8.d<? super k0> dVar);

        @NotNull
        /* JADX INFO: renamed from: resolve-DPcqOEQ, reason: not valid java name */
        State<Object> mo3392resolveDPcqOEQ(@Nullable FontFamily fontFamily, @NotNull FontWeight fontWeight, int i10, int i11);
    }

    public /* synthetic */ FontFamily(boolean z10, k kVar) {
        this(z10);
    }

    public final boolean getCanLoadSynchronously() {
        return this.canLoadSynchronously;
    }

    private FontFamily(boolean z10) {
        this.canLoadSynchronously = z10;
    }

    public static /* synthetic */ void getCanLoadSynchronously$annotations() {
    }
}
