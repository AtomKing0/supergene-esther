package androidx.compose.foundation.text.selection;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import androidx.compose.foundation.MagnifierKt;
import androidx.compose.foundation.MagnifierStyle;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import h9.l;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SelectionManager.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionManager_androidKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1, reason: invalid class name */
    /* JADX INFO: compiled from: SelectionManager.android.kt */
    static final class AnonymousClass1 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ SelectionManager $manager;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SelectionManager.android.kt */
        static final class C00771 extends v implements h9.a<Offset> {
            final /* synthetic */ MutableState<IntSize> $magnifierSize$delegate;
            final /* synthetic */ SelectionManager $manager;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00771(SelectionManager selectionManager, MutableState<IntSize> mutableState) {
                super(0);
                this.$manager = selectionManager;
                this.$magnifierSize$delegate = mutableState;
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ Offset invoke() {
                return Offset.m1356boximpl(m823invokeF1C5BW0());
            }

            /* JADX INFO: renamed from: invoke-F1C5BW0, reason: not valid java name */
            public final long m823invokeF1C5BW0() {
                return SelectionManagerKt.m816calculateSelectionMagnifierCenterAndroidO0kMr_c(this.$manager, AnonymousClass1.m821invoke$lambda1(this.$magnifierSize$delegate));
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: SelectionManager.android.kt */
        static final class AnonymousClass2 extends v implements l<h9.a<? extends Offset>, Modifier> {
            final /* synthetic */ Density $density;
            final /* synthetic */ MutableState<IntSize> $magnifierSize$delegate;

            /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: SelectionManager.android.kt */
            static final class C00781 extends v implements l<Density, Offset> {
                final /* synthetic */ h9.a<Offset> $center;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00781(h9.a<Offset> aVar) {
                    super(1);
                    this.$center = aVar;
                }

                @Override // h9.l
                public /* bridge */ /* synthetic */ Offset invoke(Density density) {
                    return Offset.m1356boximpl(m824invoketuRUvjQ(density));
                }

                /* JADX INFO: renamed from: invoke-tuRUvjQ, reason: not valid java name */
                public final long m824invoketuRUvjQ(@NotNull Density magnifier) {
                    t.i(magnifier, "$this$magnifier");
                    return this.$center.invoke().m1377unboximpl();
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager_androidKt$selectionMagnifier$1$2$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: SelectionManager.android.kt */
            static final class C00792 extends v implements l<DpSize, k0> {
                final /* synthetic */ Density $density;
                final /* synthetic */ MutableState<IntSize> $magnifierSize$delegate;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00792(Density density, MutableState<IntSize> mutableState) {
                    super(1);
                    this.$density = density;
                    this.$magnifierSize$delegate = mutableState;
                }

                @Override // h9.l
                public /* bridge */ /* synthetic */ k0 invoke(DpSize dpSize) {
                    m825invokeEaSLcWc(dpSize.m3779unboximpl());
                    return k0.f35197a;
                }

                /* JADX INFO: renamed from: invoke-EaSLcWc, reason: not valid java name */
                public final void m825invokeEaSLcWc(long j10) {
                    MutableState<IntSize> mutableState = this.$magnifierSize$delegate;
                    Density density = this.$density;
                    AnonymousClass1.m822invoke$lambda2(mutableState, IntSizeKt.IntSize(density.mo290roundToPx0680j_4(DpSize.m3771getWidthD9Ej5fM(j10)), density.mo290roundToPx0680j_4(DpSize.m3769getHeightD9Ej5fM(j10))));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Density density, MutableState<IntSize> mutableState) {
                super(1);
                this.$density = density;
                this.$magnifierSize$delegate = mutableState;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ Modifier invoke(h9.a<? extends Offset> aVar) {
                return invoke2((h9.a<Offset>) aVar);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Modifier invoke2(@NotNull h9.a<Offset> center) {
                t.i(center, "center");
                return MagnifierKt.magnifier$default(Modifier.Companion, new C00781(center), null, 0.0f, MagnifierStyle.Companion.getTextDefault(), new C00792(this.$density, this.$magnifierSize$delegate), 6, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SelectionManager selectionManager) {
            super(3);
            this.$manager = selectionManager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-1, reason: not valid java name */
        public static final long m821invoke$lambda1(MutableState<IntSize> mutableState) {
            return mutableState.getValue().m3837unboximpl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-2, reason: not valid java name */
        public static final void m822invoke$lambda2(MutableState<IntSize> mutableState, long j10) {
            mutableState.setValue(IntSize.m3825boximpl(j10));
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-1914520728);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m3825boximpl(IntSize.Companion.m3838getZeroYbymL2g()), null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) objRememberedValue;
            Modifier modifierAnimatedSelectionMagnifier = SelectionMagnifierKt.animatedSelectionMagnifier(composed, new C00771(this.$manager, mutableState), new AnonymousClass2(density, mutableState));
            composer.endReplaceableGroup();
            return modifierAnimatedSelectionMagnifier;
        }
    }

    /* JADX INFO: renamed from: isCopyKeyEvent-ZmokQxo, reason: not valid java name */
    public static final boolean m818isCopyKeyEventZmokQxo(@NotNull KeyEvent keyEvent) {
        t.i(keyEvent, "keyEvent");
        return false;
    }

    @SuppressLint({"ModifierInspectorInfo"})
    @NotNull
    public static final Modifier selectionMagnifier(@NotNull Modifier modifier, @NotNull SelectionManager manager) {
        t.i(modifier, "<this>");
        t.i(manager, "manager");
        return !MagnifierStyle.Companion.getTextDefault().isSupported() ? modifier : ComposedModifierKt.composed$default(modifier, null, new AnonymousClass1(manager), 1, null);
    }
}
