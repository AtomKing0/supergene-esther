package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.LongPressTextDragObserverKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import androidx.profileinstaller.ProfileVerifier;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.r;
import v8.k0;
import v8.q;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: TextFieldSelectionManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSelectionManagerKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldSelectionManager.kt */
    @f(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$1", f = "TextFieldSelectionManager.kt", l = {818}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<PointerInputScope, d<? super k0>, Object> {
        final /* synthetic */ TextDragObserver $observer;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TextDragObserver textDragObserver, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$observer = textDragObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$observer, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass1) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                TextDragObserver textDragObserver = this.$observer;
                this.label = 1;
                if (LongPressTextDragObserverKt.detectDownAndDragGesturesWithObserver(pointerInputScope, textDragObserver, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$2, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldSelectionManager.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ ResolvedTextDirection $direction;
        final /* synthetic */ boolean $isStartHandle;
        final /* synthetic */ TextFieldSelectionManager $manager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(boolean z10, ResolvedTextDirection resolvedTextDirection, TextFieldSelectionManager textFieldSelectionManager, int i10) {
            super(2);
            this.$isStartHandle = z10;
            this.$direction = resolvedTextDirection;
            this.$manager = textFieldSelectionManager;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            TextFieldSelectionManagerKt.TextFieldSelectionHandle(this.$isStartHandle, this.$direction, this.$manager, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: compiled from: TextFieldSelectionManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            iArr[Handle.Cursor.ordinal()] = 1;
            iArr[Handle.SelectionStart.ordinal()] = 2;
            iArr[Handle.SelectionEnd.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TextFieldSelectionHandle(boolean z10, @NotNull ResolvedTextDirection direction, @NotNull TextFieldSelectionManager manager, @Nullable Composer composer, int i10) {
        t.i(direction, "direction");
        t.i(manager, "manager");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1344558920);
        Boolean boolValueOf = Boolean.valueOf(z10);
        composerStartRestartGroup.startReplaceableGroup(511388516);
        boolean zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(manager);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = manager.handleDragObserver$foundation_release(z10);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue;
        int i11 = i10 << 3;
        AndroidSelectionHandles_androidKt.m754SelectionHandle8fL75g(manager.m841getHandlePositiontuRUvjQ$foundation_release(z10), z10, direction, TextRange.m3334getReversedimpl(manager.getValue$foundation_release().m3510getSelectiond9O1mEE()), SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, textDragObserver, new AnonymousClass1(textDragObserver, null)), null, composerStartRestartGroup, (i11 & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11 & 896));
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(z10, direction, manager, i10));
    }

    /* JADX INFO: renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c, reason: not valid java name */
    public static final long m842calculateSelectionMagnifierCenterAndroidO0kMr_c(@NotNull TextFieldSelectionManager manager, long j10) {
        int iM3335getStartimpl;
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        LayoutCoordinates layoutCoordinates;
        TextLayoutResultProxy layoutResult2;
        LayoutCoordinates innerTextFieldCoordinates;
        t.i(manager, "manager");
        if (manager.getValue$foundation_release().getText().length() == 0) {
            return Offset.Companion.m1382getUnspecifiedF1C5BW0();
        }
        Handle draggingHandle = manager.getDraggingHandle();
        int i10 = draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
        if (i10 == -1) {
            return Offset.Companion.m1382getUnspecifiedF1C5BW0();
        }
        if (i10 == 1 || i10 == 2) {
            iM3335getStartimpl = TextRange.m3335getStartimpl(manager.getValue$foundation_release().m3510getSelectiond9O1mEE());
        } else {
            if (i10 != 3) {
                throw new q();
            }
            iM3335getStartimpl = TextRange.m3330getEndimpl(manager.getValue$foundation_release().m3510getSelectiond9O1mEE());
        }
        int iO = o.o(manager.getOffsetMapping$foundation_release().originalToTransformed(iM3335getStartimpl), r.X(manager.getValue$foundation_release().getText()));
        TextFieldState state$foundation_release = manager.getState$foundation_release();
        if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return Offset.Companion.m1382getUnspecifiedF1C5BW0();
        }
        long jM1397getCenterF1C5BW0 = value.getBoundingBox(iO).m1397getCenterF1C5BW0();
        TextFieldState state$foundation_release2 = manager.getState$foundation_release();
        if (state$foundation_release2 == null || (layoutCoordinates = state$foundation_release2.getLayoutCoordinates()) == null) {
            return Offset.Companion.m1382getUnspecifiedF1C5BW0();
        }
        TextFieldState state$foundation_release3 = manager.getState$foundation_release();
        if (state$foundation_release3 == null || (layoutResult2 = state$foundation_release3.getLayoutResult()) == null || (innerTextFieldCoordinates = layoutResult2.getInnerTextFieldCoordinates()) == null) {
            return Offset.Companion.m1382getUnspecifiedF1C5BW0();
        }
        Offset offsetM839getCurrentDragPosition_m7T9E = manager.m839getCurrentDragPosition_m7T9E();
        if (offsetM839getCurrentDragPosition_m7T9E == null) {
            return Offset.Companion.m1382getUnspecifiedF1C5BW0();
        }
        float fM1367getXimpl = Offset.m1367getXimpl(innerTextFieldCoordinates.mo2990localPositionOfR5De75A(layoutCoordinates, offsetM839getCurrentDragPosition_m7T9E.m1377unboximpl()));
        int lineForOffset = value.getLineForOffset(iO);
        int lineStart = value.getLineStart(lineForOffset);
        int lineEnd = value.getLineEnd(lineForOffset, true);
        boolean z10 = TextRange.m3335getStartimpl(manager.getValue$foundation_release().m3510getSelectiond9O1mEE()) > TextRange.m3330getEndimpl(manager.getValue$foundation_release().m3510getSelectiond9O1mEE());
        float horizontalPosition = TextSelectionDelegateKt.getHorizontalPosition(value, lineStart, true, z10);
        float horizontalPosition2 = TextSelectionDelegateKt.getHorizontalPosition(value, lineEnd, false, z10);
        float fM = o.m(fM1367getXimpl, Math.min(horizontalPosition, horizontalPosition2), Math.max(horizontalPosition, horizontalPosition2));
        return Math.abs(fM1367getXimpl - fM) > ((float) (IntSize.m3833getWidthimpl(j10) / 2)) ? Offset.Companion.m1382getUnspecifiedF1C5BW0() : layoutCoordinates.mo2990localPositionOfR5De75A(innerTextFieldCoordinates, OffsetKt.Offset(fM, Offset.m1368getYimpl(jM1397getCenterF1C5BW0)));
    }

    public static final boolean isSelectionHandleInVisibleBound(@NotNull TextFieldSelectionManager textFieldSelectionManager, boolean z10) {
        LayoutCoordinates layoutCoordinates;
        Rect rectVisibleBounds;
        t.i(textFieldSelectionManager, "<this>");
        TextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
        if (state$foundation_release == null || (layoutCoordinates = state$foundation_release.getLayoutCoordinates()) == null || (rectVisibleBounds = SelectionManagerKt.visibleBounds(layoutCoordinates)) == null) {
            return false;
        }
        return SelectionManagerKt.m817containsInclusiveUv8p0NA(rectVisibleBounds, textFieldSelectionManager.m841getHandlePositiontuRUvjQ$foundation_release(z10));
    }
}
