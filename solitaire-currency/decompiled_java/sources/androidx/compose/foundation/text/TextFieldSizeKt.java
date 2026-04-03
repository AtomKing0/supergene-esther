package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import h9.l;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.o;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: TextFieldSize.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSizeKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldSize.kt */
    static final class AnonymousClass1 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ TextStyle $style;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TextFieldSize.kt */
        static final class C00681 extends v implements q<MeasureScope, Measurable, Constraints, MeasureResult> {
            final /* synthetic */ TextFieldSize $minSizeState;

            /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TextFieldSize.kt */
            static final class C00691 extends v implements l<Placeable.PlacementScope, k0> {
                final /* synthetic */ Placeable $measured;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00691(Placeable placeable) {
                    super(1);
                    this.$measured = placeable;
                }

                @Override // h9.l
                public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return k0.f35197a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Placeable.PlacementScope layout) {
                    t.i(layout, "$this$layout");
                    Placeable.PlacementScope.placeRelative$default(layout, this.$measured, 0, 0, 0.0f, 4, null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00681(TextFieldSize textFieldSize) {
                super(3);
                this.$minSizeState = textFieldSize;
            }

            @Override // h9.q
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m738invoke3p2s80s(measureScope, measurable, constraints.m3647unboximpl());
            }

            @NotNull
            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m738invoke3p2s80s(@NotNull MeasureScope layout, @NotNull Measurable measurable, long j10) {
                t.i(layout, "$this$layout");
                t.i(measurable, "measurable");
                SizeKt.m425defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, 0.0f, 3, null);
                long jM736getMinSizeYbymL2g = this.$minSizeState.m736getMinSizeYbymL2g();
                Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(Constraints.m3632copyZbe2FdA$default(j10, o.n(IntSize.m3833getWidthimpl(jM736getMinSizeYbymL2g), Constraints.m3643getMinWidthimpl(j10), Constraints.m3641getMaxWidthimpl(j10)), 0, o.n(IntSize.m3832getHeightimpl(jM736getMinSizeYbymL2g), Constraints.m3642getMinHeightimpl(j10), Constraints.m3640getMaxHeightimpl(j10)), 0, 10, null));
                return MeasureScope.CC.p(layout, placeableMo2987measureBRTryo0.getWidth(), placeableMo2987measureBRTryo0.getHeight(), null, new C00691(placeableMo2987measureBRTryo0), 4, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TextStyle textStyle) {
            super(3);
            this.$style = textStyle;
        }

        /* JADX INFO: renamed from: invoke$lambda-2, reason: not valid java name */
        private static final Object m737invoke$lambda2(State<? extends Object> state) {
            return state.getValue();
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r9v2 ??, still in use, count: 1, list:
              (r9v2 ?? I:java.lang.Object) from 0x00d0: INVOKE (r12v0 ?? I:androidx.compose.runtime.Composer), (r9v2 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:35)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
            	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
            */
        @androidx.compose.runtime.Composable
        @org.jetbrains.annotations.NotNull
        public final androidx.compose.ui.Modifier invoke(
        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r9v2 ??, still in use, count: 1, list:
              (r9v2 ?? I:java.lang.Object) from 0x00d0: INVOKE (r12v0 ?? I:androidx.compose.runtime.Composer), (r9v2 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:35)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
            */
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r11v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            */
    }

    @NotNull
    public static final Modifier textFieldMinSize(@NotNull Modifier modifier, @NotNull TextStyle style) {
        t.i(modifier, "<this>");
        t.i(style, "style");
        return ComposedModifierKt.composed$default(modifier, null, new AnonymousClass1(style), 1, null);
    }
}
