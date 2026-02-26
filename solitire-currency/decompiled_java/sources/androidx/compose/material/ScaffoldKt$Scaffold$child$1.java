package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class ScaffoldKt$Scaffold$child$1 extends v implements q<Modifier, Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ p<Composer, Integer, k0> $bottomBar;
    final /* synthetic */ q<PaddingValues, Composer, Integer, k0> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ p<Composer, Integer, k0> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ boolean $isFloatingActionButtonDocked;
    final /* synthetic */ ScaffoldState $scaffoldState;
    final /* synthetic */ q<SnackbarHostState, Composer, Integer, k0> $snackbarHost;
    final /* synthetic */ p<Composer, Integer, k0> $topBar;

    /* JADX INFO: renamed from: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Scaffold.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ p<Composer, Integer, k0> $bottomBar;
        final /* synthetic */ q<PaddingValues, Composer, Integer, k0> $content;
        final /* synthetic */ p<Composer, Integer, k0> $floatingActionButton;
        final /* synthetic */ int $floatingActionButtonPosition;
        final /* synthetic */ boolean $isFloatingActionButtonDocked;
        final /* synthetic */ ScaffoldState $scaffoldState;
        final /* synthetic */ q<SnackbarHostState, Composer, Integer, k0> $snackbarHost;
        final /* synthetic */ p<Composer, Integer, k0> $topBar;

        /* JADX INFO: renamed from: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Scaffold.kt */
        static final class C01021 extends v implements p<Composer, Integer, k0> {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ ScaffoldState $scaffoldState;
            final /* synthetic */ q<SnackbarHostState, Composer, Integer, k0> $snackbarHost;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01021(q<? super SnackbarHostState, ? super Composer, ? super Integer, k0> qVar, ScaffoldState scaffoldState, int i10) {
                super(2);
                this.$snackbarHost = qVar;
                this.$scaffoldState = scaffoldState;
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
                    this.$snackbarHost.invoke(this.$scaffoldState.getSnackbarHostState(), composer, Integer.valueOf((this.$$dirty >> 9) & 112));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(boolean z10, int i10, p<? super Composer, ? super Integer, k0> pVar, q<? super PaddingValues, ? super Composer, ? super Integer, k0> qVar, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, int i11, int i12, q<? super SnackbarHostState, ? super Composer, ? super Integer, k0> qVar2, ScaffoldState scaffoldState) {
            super(2);
            this.$isFloatingActionButtonDocked = z10;
            this.$floatingActionButtonPosition = i10;
            this.$topBar = pVar;
            this.$content = qVar;
            this.$floatingActionButton = pVar2;
            this.$bottomBar = pVar3;
            this.$$dirty = i11;
            this.$$dirty1 = i12;
            this.$snackbarHost = qVar2;
            this.$scaffoldState = scaffoldState;
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
                return;
            }
            boolean z10 = this.$isFloatingActionButtonDocked;
            int i11 = this.$floatingActionButtonPosition;
            p<Composer, Integer, k0> pVar = this.$topBar;
            q<PaddingValues, Composer, Integer, k0> qVar = this.$content;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 533782017, true, new C01021(this.$snackbarHost, this.$scaffoldState, this.$$dirty));
            p<Composer, Integer, k0> pVar2 = this.$floatingActionButton;
            p<Composer, Integer, k0> pVar3 = this.$bottomBar;
            int i12 = this.$$dirty;
            ScaffoldKt.m1119ScaffoldLayoutMDYNRJg(z10, i11, pVar, qVar, composableLambda, pVar2, pVar3, composer, ((i12 >> 21) & 14) | 24576 | ((i12 >> 15) & 112) | (i12 & 896) | ((this.$$dirty1 >> 12) & 7168) | (458752 & i12) | ((i12 << 9) & 3670016));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ScaffoldKt$Scaffold$child$1(long j10, long j11, int i10, boolean z10, int i11, p<? super Composer, ? super Integer, k0> pVar, q<? super PaddingValues, ? super Composer, ? super Integer, k0> qVar, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, int i12, q<? super SnackbarHostState, ? super Composer, ? super Integer, k0> qVar2, ScaffoldState scaffoldState) {
        super(3);
        this.$backgroundColor = j10;
        this.$contentColor = j11;
        this.$$dirty1 = i10;
        this.$isFloatingActionButtonDocked = z10;
        this.$floatingActionButtonPosition = i11;
        this.$topBar = pVar;
        this.$content = qVar;
        this.$floatingActionButton = pVar2;
        this.$bottomBar = pVar3;
        this.$$dirty = i12;
        this.$snackbarHost = qVar2;
        this.$scaffoldState = scaffoldState;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ k0 invoke(Modifier modifier, Composer composer, Integer num) {
        invoke(modifier, composer, num.intValue());
        return k0.f35197a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull Modifier childModifier, @Nullable Composer composer, int i10) {
        int i11;
        t.i(childModifier, "childModifier");
        if ((i10 & 14) == 0) {
            i11 = i10 | (composer.changed(childModifier) ? 4 : 2);
        } else {
            i11 = i10;
        }
        if ((i11 & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        long j10 = this.$backgroundColor;
        long j11 = this.$contentColor;
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -1128984656, true, new AnonymousClass1(this.$isFloatingActionButtonDocked, this.$floatingActionButtonPosition, this.$topBar, this.$content, this.$floatingActionButton, this.$bottomBar, this.$$dirty, this.$$dirty1, this.$snackbarHost, this.$scaffoldState));
        int i12 = 1572864 | (i11 & 14);
        int i13 = this.$$dirty1;
        SurfaceKt.m1147SurfaceFjzlyU(childModifier, null, j10, j11, null, 0.0f, composableLambda, composer, i12 | ((i13 >> 9) & 896) | ((i13 >> 9) & 7168), 50);
    }
}
