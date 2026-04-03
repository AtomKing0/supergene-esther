package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusRequesterModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import h9.l;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ComposedModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ComposedModifierKt {

    @NotNull
    private static final q<FocusEventModifier, Composer, Integer, Modifier> WrapFocusEventModifier = ComposedModifierKt$WrapFocusEventModifier$1.INSTANCE;

    @NotNull
    private static final q<FocusRequesterModifier, Composer, Integer, Modifier> WrapFocusRequesterModifier = ComposedModifierKt$WrapFocusRequesterModifier$1.INSTANCE;

    /* JADX INFO: renamed from: androidx.compose.ui.ComposedModifierKt$materialize$1, reason: invalid class name */
    /* JADX INFO: compiled from: ComposedModifier.kt */
    static final class AnonymousClass1 extends v implements l<Modifier.Element, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull Modifier.Element it) {
            t.i(it, "it");
            return Boolean.valueOf(((it instanceof ComposedModifier) || (it instanceof FocusEventModifier) || (it instanceof FocusRequesterModifier)) ? false : true);
        }
    }

    @NotNull
    public static final Modifier composed(@NotNull Modifier modifier, @NotNull l<? super InspectorInfo, k0> inspectorInfo, @NotNull q<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> factory) {
        t.i(modifier, "<this>");
        t.i(inspectorInfo, "inspectorInfo");
        t.i(factory, "factory");
        return modifier.then(new ComposedModifier(inspectorInfo, factory));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, l lVar, q qVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, lVar, qVar);
    }

    @NotNull
    public static final Modifier materialize(@NotNull Composer composer, @NotNull Modifier modifier) {
        t.i(composer, "<this>");
        t.i(modifier, "modifier");
        if (modifier.all(AnonymousClass1.INSTANCE)) {
            return modifier;
        }
        composer.startReplaceableGroup(1219399079);
        Modifier modifier2 = (Modifier) modifier.foldIn(Modifier.Companion, new ComposedModifierKt$materialize$result$1(composer));
        composer.endReplaceableGroup();
        return modifier2;
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier composed(@NotNull Modifier modifier, @NotNull String fullyQualifiedName, @Nullable Object obj, @NotNull l<? super InspectorInfo, k0> inspectorInfo, @NotNull q<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> factory) {
        t.i(modifier, "<this>");
        t.i(fullyQualifiedName, "fullyQualifiedName");
        t.i(inspectorInfo, "inspectorInfo");
        t.i(factory, "factory");
        return modifier.then(new KeyedComposedModifier1(fullyQualifiedName, obj, inspectorInfo, factory));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object obj, l lVar, q qVar, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            lVar = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, obj, (l<? super InspectorInfo, k0>) lVar, (q<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier>) qVar);
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier composed(@NotNull Modifier modifier, @NotNull String fullyQualifiedName, @Nullable Object obj, @Nullable Object obj2, @NotNull l<? super InspectorInfo, k0> inspectorInfo, @NotNull q<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> factory) {
        t.i(modifier, "<this>");
        t.i(fullyQualifiedName, "fullyQualifiedName");
        t.i(inspectorInfo, "inspectorInfo");
        t.i(factory, "factory");
        return modifier.then(new KeyedComposedModifier2(fullyQualifiedName, obj, obj2, inspectorInfo, factory));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object obj, Object obj2, l lVar, q qVar, int i10, Object obj3) {
        if ((i10 & 8) != 0) {
            lVar = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, obj, obj2, lVar, qVar);
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier composed(@NotNull Modifier modifier, @NotNull String fullyQualifiedName, @Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @NotNull l<? super InspectorInfo, k0> inspectorInfo, @NotNull q<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> factory) {
        t.i(modifier, "<this>");
        t.i(fullyQualifiedName, "fullyQualifiedName");
        t.i(inspectorInfo, "inspectorInfo");
        t.i(factory, "factory");
        return modifier.then(new KeyedComposedModifier3(fullyQualifiedName, obj, obj2, obj3, inspectorInfo, factory));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object obj, Object obj2, Object obj3, l lVar, q qVar, int i10, Object obj4) {
        if ((i10 & 16) != 0) {
            lVar = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, obj, obj2, obj3, lVar, qVar);
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier composed(@NotNull Modifier modifier, @NotNull String fullyQualifiedName, @NotNull Object[] keys, @NotNull l<? super InspectorInfo, k0> inspectorInfo, @NotNull q<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> factory) {
        t.i(modifier, "<this>");
        t.i(fullyQualifiedName, "fullyQualifiedName");
        t.i(keys, "keys");
        t.i(inspectorInfo, "inspectorInfo");
        t.i(factory, "factory");
        return modifier.then(new KeyedComposedModifierN(fullyQualifiedName, keys, inspectorInfo, factory));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object[] objArr, l lVar, q qVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            lVar = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, objArr, (l<? super InspectorInfo, k0>) lVar, (q<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier>) qVar);
    }
}
