package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import h9.a;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalMaterialApi
public interface ExposedDropdownMenuBoxScope {

    /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0100  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x010d  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x014d  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0193  */
        /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
        @androidx.compose.runtime.Composable
        @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void ExposedDropdownMenu(@org.jetbrains.annotations.NotNull androidx.compose.material.ExposedDropdownMenuBoxScope r23, boolean r24, @org.jetbrains.annotations.NotNull h9.a<v8.k0> r25, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r26, @org.jetbrains.annotations.NotNull h9.q<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r27, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r28, int r29, int r30) {
            /*
                Method dump skipped, instruction units count: 425
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuBoxScope.DefaultImpls.ExposedDropdownMenu(androidx.compose.material.ExposedDropdownMenuBoxScope, boolean, h9.a, androidx.compose.ui.Modifier, h9.q, androidx.compose.runtime.Composer, int, int):void");
        }

        public static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
            }
            if ((i10 & 1) != 0) {
                z10 = true;
            }
            return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z10);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ q<ColumnScope, Composer, Integer, k0> $content;
        final /* synthetic */ MutableTransitionState<Boolean> $expandedStates;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ MutableState<TransformOrigin> $transformOriginState;
        final /* synthetic */ ExposedDropdownMenuBoxScope this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(MutableTransitionState<Boolean> mutableTransitionState, MutableState<TransformOrigin> mutableState, ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, q<? super ColumnScope, ? super Composer, ? super Integer, k0> qVar, int i10) {
            super(2);
            this.$expandedStates = mutableTransitionState;
            this.$transformOriginState = mutableState;
            this.this$0 = exposedDropdownMenuBoxScope;
            this.$modifier = modifier;
            this.$content = qVar;
            this.$$dirty = i10;
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
                MenuKt.DropdownMenuContent(this.$expandedStates, this.$transformOriginState, DefaultImpls.exposedDropdownSize$default(this.this$0, this.$modifier, false, 1, null), this.$content, composer, MutableTransitionState.$stable | 48 | (this.$$dirty & 7168), 0);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2, reason: invalid class name */
    /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ q<ColumnScope, Composer, Integer, k0> $content;
        final /* synthetic */ boolean $expanded;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ a<k0> $onDismissRequest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(boolean z10, a<k0> aVar, Modifier modifier, q<? super ColumnScope, ? super Composer, ? super Integer, k0> qVar, int i10, int i11) {
            super(2);
            this.$expanded = z10;
            this.$onDismissRequest = aVar;
            this.$modifier = modifier;
            this.$content = qVar;
            this.$$changed = i10;
            this.$$default = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            ExposedDropdownMenuBoxScope.this.ExposedDropdownMenu(this.$expanded, this.$onDismissRequest, this.$modifier, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    void ExposedDropdownMenu(boolean z10, @NotNull a<k0> aVar, @Nullable Modifier modifier, @NotNull q<? super ColumnScope, ? super Composer, ? super Integer, k0> qVar, @Nullable Composer composer, int i10, int i11);

    @NotNull
    Modifier exposedDropdownSize(@NotNull Modifier modifier, boolean z10);
}
