package l;

import android.content.Context;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LocalImageLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: compiled from: LocalImageLoader.kt */
    static final class a extends v implements h9.a<j.e> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f30184g = new a();

        a() {
            super(0);
        }

        @Override // h9.a
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final j.e invoke() {
            return null;
        }
    }

    public static /* synthetic */ ProvidableCompositionLocal b(ProvidableCompositionLocal providableCompositionLocal, int i10, k kVar) {
        if ((i10 & 1) != 0) {
            providableCompositionLocal = CompositionLocalKt.staticCompositionLocalOf(a.f30184g);
        }
        return a(providableCompositionLocal);
    }

    @Composable
    @ReadOnlyComposable
    @NotNull
    public static final j.e c(ProvidableCompositionLocal<j.e> providableCompositionLocal, @Nullable Composer composer, int i10) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-617597678, i10, -1, "coil.compose.ImageLoaderProvidableCompositionLocal.<get-current> (LocalImageLoader.kt:49)");
        }
        j.e eVarA = (j.e) composer.consume(providableCompositionLocal);
        if (eVarA == null) {
            eVarA = j.a.a((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return eVarA;
    }

    @NotNull
    public static ProvidableCompositionLocal<j.e> a(@NotNull ProvidableCompositionLocal<j.e> providableCompositionLocal) {
        return providableCompositionLocal;
    }
}
