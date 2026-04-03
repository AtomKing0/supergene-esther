package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import h9.p;
import h9.q;
import kotlin.collections.v;
import kotlin.jvm.internal.r0;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SuspendingPointerInputFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SuspendingPointerInputFilterKt {

    @NotNull
    private static final PointerEvent EmptyPointerEvent = new PointerEvent(v.l());

    @NotNull
    private static final String PointerInputModifierNoParamError = "Modifier.pointerInput must provide one or more 'key' parameters that define the identity of the modifier and determine when its previous input processing coroutine should be cancelled and a new effect launched for the new key.";

    /* JADX INFO: renamed from: androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$pointerInput$2, reason: invalid class name */
    /* JADX INFO: compiled from: SuspendingPointerInputFilter.kt */
    static final class AnonymousClass2 extends kotlin.jvm.internal.v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ p<PointerInputScope, z8.d<? super k0>, Object> $block;
        final /* synthetic */ Object $key1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Object obj, p<? super PointerInputScope, ? super z8.d<? super k0>, ? extends Object> pVar) {
            super(3);
            this.$key1 = obj;
            this.$block = pVar;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-906157935);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(density);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SuspendingPointerInputFilter(viewConfiguration, density);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            SuspendingPointerInputFilter suspendingPointerInputFilter = (SuspendingPointerInputFilter) objRememberedValue;
            EffectsKt.LaunchedEffect(suspendingPointerInputFilter, this.$key1, new SuspendingPointerInputFilterKt$pointerInput$2$2$1(suspendingPointerInputFilter, this.$block, null), composer, 64);
            composer.endReplaceableGroup();
            return suspendingPointerInputFilter;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$pointerInput$4, reason: invalid class name */
    /* JADX INFO: compiled from: SuspendingPointerInputFilter.kt */
    static final class AnonymousClass4 extends kotlin.jvm.internal.v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ p<PointerInputScope, z8.d<? super k0>, Object> $block;
        final /* synthetic */ Object $key1;
        final /* synthetic */ Object $key2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(Object obj, Object obj2, p<? super PointerInputScope, ? super z8.d<? super k0>, ? extends Object> pVar) {
            super(3);
            this.$key1 = obj;
            this.$key2 = obj2;
            this.$block = pVar;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(1175567217);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(density);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SuspendingPointerInputFilter(viewConfiguration, density);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            SuspendingPointerInputFilter suspendingPointerInputFilter = (SuspendingPointerInputFilter) objRememberedValue;
            EffectsKt.LaunchedEffect(suspendingPointerInputFilter, this.$key1, this.$key2, new SuspendingPointerInputFilterKt$pointerInput$4$2$1(suspendingPointerInputFilter, this.$block, null), composer, 576);
            composer.endReplaceableGroup();
            return suspendingPointerInputFilter;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$pointerInput$6, reason: invalid class name */
    /* JADX INFO: compiled from: SuspendingPointerInputFilter.kt */
    static final class AnonymousClass6 extends kotlin.jvm.internal.v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ p<PointerInputScope, z8.d<? super k0>, Object> $block;
        final /* synthetic */ Object[] $keys;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass6(Object[] objArr, p<? super PointerInputScope, ? super z8.d<? super k0>, ? extends Object> pVar) {
            super(3);
            this.$keys = objArr;
            this.$block = pVar;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(664422852);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(density);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SuspendingPointerInputFilter(viewConfiguration, density);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            Object[] objArr = this.$keys;
            p<PointerInputScope, z8.d<? super k0>, Object> pVar = this.$block;
            SuspendingPointerInputFilter suspendingPointerInputFilter = (SuspendingPointerInputFilter) objRememberedValue;
            r0 r0Var = new r0(2);
            r0Var.a(suspendingPointerInputFilter);
            r0Var.b(objArr);
            EffectsKt.LaunchedEffect(r0Var.d(new Object[r0Var.c()]), (p<? super o0, ? super z8.d<? super k0>, ? extends Object>) new SuspendingPointerInputFilterKt$pointerInput$6$2$1(suspendingPointerInputFilter, pVar, null), composer, 8);
            composer.endReplaceableGroup();
            return suspendingPointerInputFilter;
        }
    }

    @NotNull
    public static final Modifier pointerInput(@NotNull Modifier modifier, @NotNull p<? super PointerInputScope, ? super z8.d<? super k0>, ? extends Object> block) {
        t.i(modifier, "<this>");
        t.i(block, "block");
        throw new IllegalStateException(PointerInputModifierNoParamError.toString());
    }

    @NotNull
    public static final Modifier pointerInput(@NotNull Modifier modifier, @Nullable Object obj, @NotNull p<? super PointerInputScope, ? super z8.d<? super k0>, ? extends Object> block) {
        t.i(modifier, "<this>");
        t.i(block, "block");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SuspendingPointerInputFilterKt$pointerInput$$inlined$debugInspectorInfo$1(obj, block) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(obj, block));
    }

    @NotNull
    public static final Modifier pointerInput(@NotNull Modifier modifier, @Nullable Object obj, @Nullable Object obj2, @NotNull p<? super PointerInputScope, ? super z8.d<? super k0>, ? extends Object> block) {
        t.i(modifier, "<this>");
        t.i(block, "block");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SuspendingPointerInputFilterKt$pointerInput$$inlined$debugInspectorInfo$2(obj, obj2, block) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass4(obj, obj2, block));
    }

    @NotNull
    public static final Modifier pointerInput(@NotNull Modifier modifier, @NotNull Object[] keys, @NotNull p<? super PointerInputScope, ? super z8.d<? super k0>, ? extends Object> block) {
        t.i(modifier, "<this>");
        t.i(keys, "keys");
        t.i(block, "block");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SuspendingPointerInputFilterKt$pointerInput$$inlined$debugInspectorInfo$3(keys, block) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass6(keys, block));
    }
}
