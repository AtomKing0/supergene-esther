package androidx.compose.ui.focus;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import h9.l;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: FocusModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FocusModifierKt {

    @NotNull
    private static final ProvidableModifierLocal<FocusModifier> ModifierLocalParentFocusModifier = ModifierLocalKt.modifierLocalOf(FocusModifierKt$ModifierLocalParentFocusModifier$1.INSTANCE);

    @NotNull
    private static final Modifier ResetFocusModifierLocals = Modifier.Companion.then(new ModifierLocalProvider<FocusPropertiesModifier>() { // from class: androidx.compose.ui.focus.FocusModifierKt$ResetFocusModifierLocals$1
        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ boolean all(l lVar) {
            return androidx.compose.ui.b.a(this, lVar);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ boolean any(l lVar) {
            return androidx.compose.ui.b.b(this, lVar);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ Object foldIn(Object obj, p pVar) {
            return androidx.compose.ui.b.c(this, obj, pVar);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ Object foldOut(Object obj, p pVar) {
            return androidx.compose.ui.b.d(this, obj, pVar);
        }

        @Override // androidx.compose.ui.modifier.ModifierLocalProvider
        @NotNull
        public ProvidableModifierLocal<FocusPropertiesModifier> getKey() {
            return FocusPropertiesKt.getModifierLocalFocusProperties();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.compose.ui.modifier.ModifierLocalProvider
        @Nullable
        /* JADX INFO: renamed from: getValue */
        public FocusPropertiesModifier getValue2() {
            return null;
        }

        @Override // androidx.compose.ui.Modifier
        public /* synthetic */ Modifier then(Modifier modifier) {
            return androidx.compose.ui.a.a(this, modifier);
        }
    }).then(new ModifierLocalProvider<FocusEventModifierLocal>() { // from class: androidx.compose.ui.focus.FocusModifierKt$ResetFocusModifierLocals$2
        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ boolean all(l lVar) {
            return androidx.compose.ui.b.a(this, lVar);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ boolean any(l lVar) {
            return androidx.compose.ui.b.b(this, lVar);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ Object foldIn(Object obj, p pVar) {
            return androidx.compose.ui.b.c(this, obj, pVar);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ Object foldOut(Object obj, p pVar) {
            return androidx.compose.ui.b.d(this, obj, pVar);
        }

        @Override // androidx.compose.ui.modifier.ModifierLocalProvider
        @NotNull
        public ProvidableModifierLocal<FocusEventModifierLocal> getKey() {
            return FocusEventModifierKt.getModifierLocalFocusEvent();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.compose.ui.modifier.ModifierLocalProvider
        @Nullable
        /* JADX INFO: renamed from: getValue */
        public FocusEventModifierLocal getValue2() {
            return null;
        }

        @Override // androidx.compose.ui.Modifier
        public /* synthetic */ Modifier then(Modifier modifier) {
            return androidx.compose.ui.a.a(this, modifier);
        }
    }).then(new ModifierLocalProvider<FocusRequesterModifierLocal>() { // from class: androidx.compose.ui.focus.FocusModifierKt$ResetFocusModifierLocals$3
        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ boolean all(l lVar) {
            return androidx.compose.ui.b.a(this, lVar);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ boolean any(l lVar) {
            return androidx.compose.ui.b.b(this, lVar);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ Object foldIn(Object obj, p pVar) {
            return androidx.compose.ui.b.c(this, obj, pVar);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ Object foldOut(Object obj, p pVar) {
            return androidx.compose.ui.b.d(this, obj, pVar);
        }

        @Override // androidx.compose.ui.modifier.ModifierLocalProvider
        @NotNull
        public ProvidableModifierLocal<FocusRequesterModifierLocal> getKey() {
            return FocusRequesterModifierKt.getModifierLocalFocusRequester();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.compose.ui.modifier.ModifierLocalProvider
        @Nullable
        /* JADX INFO: renamed from: getValue */
        public FocusRequesterModifierLocal getValue2() {
            return null;
        }

        @Override // androidx.compose.ui.Modifier
        public /* synthetic */ Modifier then(Modifier modifier) {
            return androidx.compose.ui.a.a(this, modifier);
        }
    });

    /* JADX INFO: renamed from: androidx.compose.ui.focus.FocusModifierKt$focusModifier$2, reason: invalid class name */
    /* JADX INFO: compiled from: FocusModifier.kt */
    static final class AnonymousClass2 extends v implements q<Modifier, Composer, Integer, Modifier> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        /* JADX INFO: renamed from: androidx.compose.ui.focus.FocusModifierKt$focusModifier$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: FocusModifier.kt */
        static final class AnonymousClass1 extends v implements h9.a<k0> {
            final /* synthetic */ FocusModifier $focusModifier;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(FocusModifier focusModifier) {
                super(0);
                this.$focusModifier = focusModifier;
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                invoke2();
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FocusTransactionsKt.sendOnFocusEvent(this.$focusModifier);
            }
        }

        AnonymousClass2() {
            super(3);
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-1810534337);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new FocusModifier(FocusStateImpl.Inactive, null, 2, 0 == true ? 1 : 0);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            FocusModifier focusModifier = (FocusModifier) objRememberedValue;
            EffectsKt.SideEffect(new AnonymousClass1(focusModifier), composer, 0);
            Modifier modifierFocusTarget = FocusModifierKt.focusTarget(composed, focusModifier);
            composer.endReplaceableGroup();
            return modifierFocusTarget;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.focus.FocusModifierKt$focusTarget$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FocusModifier.kt */
    static final class C09952 extends v implements q<Modifier, Composer, Integer, Modifier> {
        public static final C09952 INSTANCE = new C09952();

        /* JADX INFO: renamed from: androidx.compose.ui.focus.FocusModifierKt$focusTarget$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: FocusModifier.kt */
        static final class AnonymousClass1 extends v implements h9.a<k0> {
            final /* synthetic */ FocusModifier $focusModifier;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(FocusModifier focusModifier) {
                super(0);
                this.$focusModifier = focusModifier;
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                invoke2();
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FocusTransactionsKt.sendOnFocusEvent(this.$focusModifier);
            }
        }

        C09952() {
            super(3);
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-326009031);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new FocusModifier(FocusStateImpl.Inactive, null, 2, 0 == true ? 1 : 0);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            FocusModifier focusModifier = (FocusModifier) objRememberedValue;
            EffectsKt.SideEffect(new AnonymousClass1(focusModifier), composer, 0);
            Modifier modifierFocusTarget = FocusModifierKt.focusTarget(composed, focusModifier);
            composer.endReplaceableGroup();
            return modifierFocusTarget;
        }
    }

    @NotNull
    public static final Modifier focusModifier(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusModifierKt$focusModifier$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), AnonymousClass2.INSTANCE);
    }

    @NotNull
    public static final Modifier focusTarget(@NotNull Modifier modifier, @NotNull FocusModifier focusModifier) {
        t.i(modifier, "<this>");
        t.i(focusModifier, "focusModifier");
        return modifier.then(focusModifier).then(ResetFocusModifierLocals);
    }

    @NotNull
    public static final ProvidableModifierLocal<FocusModifier> getModifierLocalParentFocusModifier() {
        return ModifierLocalParentFocusModifier;
    }

    @NotNull
    public static final Modifier getResetFocusModifierLocals() {
        return ResetFocusModifierLocals;
    }

    @NotNull
    public static final Modifier focusTarget(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusModifierKt$focusTarget$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), C09952.INSTANCE);
    }
}
