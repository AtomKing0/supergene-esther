package androidx.compose.material;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.extractor.WavUtil;
import com.google.android.gms.drive.DriveFile;
import h9.a;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Snackbar.kt */
/* JADX INFO: loaded from: classes.dex */
final class SnackbarKt$Snackbar$actionComposable$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ long $actionColor;
    final /* synthetic */ String $actionLabel;
    final /* synthetic */ SnackbarData $snackbarData;

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Snackbar.kt */
    static final class AnonymousClass1 extends v implements a<k0> {
        final /* synthetic */ SnackbarData $snackbarData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SnackbarData snackbarData) {
            super(0);
            this.$snackbarData = snackbarData;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$snackbarData.performAction();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: Snackbar.kt */
    static final class AnonymousClass2 extends v implements q<RowScope, Composer, Integer, k0> {
        final /* synthetic */ String $actionLabel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str) {
            super(3);
            this.$actionLabel = str;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return k0.f35197a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(@NotNull RowScope TextButton, @Nullable Composer composer, int i10) {
            t.i(TextButton, "$this$TextButton");
            if ((i10 & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                TextKt.m1218TextfLXpl1I(this.$actionLabel, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer, 0, 0, WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnackbarKt$Snackbar$actionComposable$1(long j10, int i10, SnackbarData snackbarData, String str) {
        super(2);
        this.$actionColor = j10;
        this.$$dirty = i10;
        this.$snackbarData = snackbarData;
        this.$actionLabel = str;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i10) {
        if ((i10 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            ButtonKt.TextButton(new AnonymousClass1(this.$snackbarData), null, false, null, null, null, null, ButtonDefaults.INSTANCE.m910textButtonColorsRGew2ao(0L, this.$actionColor, 0L, composer, ((this.$$dirty >> 15) & 112) | 3072, 5), null, ComposableLambdaKt.composableLambda(composer, -929149933, true, new AnonymousClass2(this.$actionLabel)), composer, DriveFile.MODE_READ_WRITE, 382);
        }
    }
}
