package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.geometry.Rect;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.q;

/* JADX INFO: compiled from: TwoDimensionalFocusSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TwoDimensionalFocusSearchKt {

    @NotNull
    private static final String InvalidFocusDirection = "This function should only be used for 2-D focus search";

    @NotNull
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    /* JADX INFO: compiled from: TwoDimensionalFocusSearch.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 2;
            iArr[FocusStateImpl.Active.ordinal()] = 3;
            iArr[FocusStateImpl.Captured.ordinal()] = 4;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final FocusModifier activeNode(FocusModifier focusModifier) {
        if (!(focusModifier.getFocusState() == FocusStateImpl.ActiveParent || focusModifier.getFocusState() == FocusStateImpl.DeactivatedParent)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        FocusModifier focusModifierFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusModifier);
        if (focusModifierFindActiveFocusNode != null) {
            return focusModifierFindActiveFocusNode;
        }
        throw new IllegalStateException(NoActiveChild.toString());
    }

    /* JADX INFO: renamed from: beamBeats-I7lrPNg, reason: not valid java name */
    private static final boolean m1326beamBeatsI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i10) {
        if (beamBeats_I7lrPNg$inSourceBeam(rect3, i10, rect) || !beamBeats_I7lrPNg$inSourceBeam(rect2, i10, rect)) {
            return false;
        }
        if (beamBeats_I7lrPNg$isInDirectionOfSearch(rect3, i10, rect)) {
            FocusDirection.Companion companion = FocusDirection.Companion;
            if (!FocusDirection.m1303equalsimpl0(i10, companion.m1311getLeftdhqQ8s()) && !FocusDirection.m1303equalsimpl0(i10, companion.m1315getRightdhqQ8s()) && m1327beamBeats_I7lrPNg$majorAxisDistance3(rect2, i10, rect) >= beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(rect3, i10, rect)) {
                return false;
            }
        }
        return true;
    }

    private static final boolean beamBeats_I7lrPNg$inSourceBeam(Rect rect, int i10, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (!(FocusDirection.m1303equalsimpl0(i10, companion.m1311getLeftdhqQ8s()) ? true : FocusDirection.m1303equalsimpl0(i10, companion.m1315getRightdhqQ8s()))) {
            if (!(FocusDirection.m1303equalsimpl0(i10, companion.m1316getUpdhqQ8s()) ? true : FocusDirection.m1303equalsimpl0(i10, companion.m1309getDowndhqQ8s()))) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            if (rect.getRight() > rect2.getLeft() && rect.getLeft() < rect2.getRight()) {
                return true;
            }
        } else if (rect.getBottom() > rect2.getTop() && rect.getTop() < rect2.getBottom()) {
            return true;
        }
        return false;
    }

    private static final boolean beamBeats_I7lrPNg$isInDirectionOfSearch(Rect rect, int i10, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m1303equalsimpl0(i10, companion.m1311getLeftdhqQ8s())) {
            if (rect2.getLeft() >= rect.getRight()) {
                return true;
            }
        } else if (FocusDirection.m1303equalsimpl0(i10, companion.m1315getRightdhqQ8s())) {
            if (rect2.getRight() <= rect.getLeft()) {
                return true;
            }
        } else if (FocusDirection.m1303equalsimpl0(i10, companion.m1316getUpdhqQ8s())) {
            if (rect2.getTop() >= rect.getBottom()) {
                return true;
            }
        } else {
            if (!FocusDirection.m1303equalsimpl0(i10, companion.m1309getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            if (rect2.getBottom() <= rect.getTop()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: beamBeats_I7lrPNg$majorAxisDistance-3, reason: not valid java name */
    private static final float m1327beamBeats_I7lrPNg$majorAxisDistance3(Rect rect, int i10, Rect rect2) {
        float top;
        float bottom;
        float top2;
        float bottom2;
        float f10;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (!FocusDirection.m1303equalsimpl0(i10, companion.m1311getLeftdhqQ8s())) {
            if (FocusDirection.m1303equalsimpl0(i10, companion.m1315getRightdhqQ8s())) {
                top = rect.getLeft();
                bottom = rect2.getRight();
            } else if (FocusDirection.m1303equalsimpl0(i10, companion.m1316getUpdhqQ8s())) {
                top2 = rect2.getTop();
                bottom2 = rect.getBottom();
            } else {
                if (!FocusDirection.m1303equalsimpl0(i10, companion.m1309getDowndhqQ8s())) {
                    throw new IllegalStateException(InvalidFocusDirection.toString());
                }
                top = rect.getTop();
                bottom = rect2.getBottom();
            }
            f10 = top - bottom;
            return Math.max(0.0f, f10);
        }
        top2 = rect2.getLeft();
        bottom2 = rect.getRight();
        f10 = top2 - bottom2;
        return Math.max(0.0f, f10);
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(Rect rect, int i10, Rect rect2) {
        float bottom;
        float bottom2;
        float top;
        float top2;
        float f10;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (!FocusDirection.m1303equalsimpl0(i10, companion.m1311getLeftdhqQ8s())) {
            if (FocusDirection.m1303equalsimpl0(i10, companion.m1315getRightdhqQ8s())) {
                bottom = rect.getRight();
                bottom2 = rect2.getRight();
            } else if (FocusDirection.m1303equalsimpl0(i10, companion.m1316getUpdhqQ8s())) {
                top = rect2.getTop();
                top2 = rect.getTop();
            } else {
                if (!FocusDirection.m1303equalsimpl0(i10, companion.m1309getDowndhqQ8s())) {
                    throw new IllegalStateException(InvalidFocusDirection.toString());
                }
                bottom = rect.getBottom();
                bottom2 = rect2.getBottom();
            }
            f10 = bottom - bottom2;
            return Math.max(1.0f, f10);
        }
        top = rect2.getLeft();
        top2 = rect.getLeft();
        f10 = top - top2;
        return Math.max(1.0f, f10);
    }

    private static final Rect bottomRight(Rect rect) {
        return new Rect(rect.getRight(), rect.getBottom(), rect.getRight(), rect.getBottom());
    }

    /* JADX INFO: renamed from: findBestCandidate-4WY_MpI, reason: not valid java name */
    private static final FocusModifier m1328findBestCandidate4WY_MpI(MutableVector<FocusModifier> mutableVector, Rect rect, int i10) {
        Rect rectTranslate;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m1303equalsimpl0(i10, companion.m1311getLeftdhqQ8s())) {
            rectTranslate = rect.translate(rect.getWidth() + 1, 0.0f);
        } else if (FocusDirection.m1303equalsimpl0(i10, companion.m1315getRightdhqQ8s())) {
            rectTranslate = rect.translate(-(rect.getWidth() + 1), 0.0f);
        } else if (FocusDirection.m1303equalsimpl0(i10, companion.m1316getUpdhqQ8s())) {
            rectTranslate = rect.translate(0.0f, rect.getHeight() + 1);
        } else {
            if (!FocusDirection.m1303equalsimpl0(i10, companion.m1309getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            rectTranslate = rect.translate(0.0f, -(rect.getHeight() + 1));
        }
        int size = mutableVector.getSize();
        FocusModifier focusModifier = null;
        if (size > 0) {
            FocusModifier[] content = mutableVector.getContent();
            int i11 = 0;
            do {
                FocusModifier focusModifier2 = content[i11];
                if (FocusTraversalKt.isEligibleForFocusSearch(focusModifier2)) {
                    Rect rectFocusRect = FocusTraversalKt.focusRect(focusModifier2);
                    if (m1330isBetterCandidateI7lrPNg(rectFocusRect, rectTranslate, rect, i10)) {
                        focusModifier = focusModifier2;
                        rectTranslate = rectFocusRect;
                    }
                }
                i11++;
            } while (i11 < size);
        }
        return focusModifier;
    }

    /* JADX INFO: renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    private static final boolean m1329generateAndSearchChildren4C6V_qg(FocusModifier focusModifier, FocusModifier focusModifier2, int i10, l<? super FocusModifier, Boolean> lVar) {
        if (m1331searchChildren4C6V_qg(focusModifier, focusModifier2, i10, lVar)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m1299searchBeyondBoundsOMvw8(focusModifier, i10, new TwoDimensionalFocusSearchKt$generateAndSearchChildren$1(focusModifier, focusModifier2, i10, lVar));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX INFO: renamed from: isBetterCandidate-I7lrPNg, reason: not valid java name */
    private static final boolean m1330isBetterCandidateI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i10) {
        if (isBetterCandidate_I7lrPNg$isCandidate(rect, i10, rect3)) {
            return !isBetterCandidate_I7lrPNg$isCandidate(rect2, i10, rect3) || m1326beamBeatsI7lrPNg(rect3, rect, rect2, i10) || (!m1326beamBeatsI7lrPNg(rect3, rect2, rect, i10) && isBetterCandidate_I7lrPNg$weightedDistance(i10, rect3, rect) < isBetterCandidate_I7lrPNg$weightedDistance(i10, rect3, rect2));
        }
        return false;
    }

    private static final boolean isBetterCandidate_I7lrPNg$isCandidate(Rect rect, int i10, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m1303equalsimpl0(i10, companion.m1311getLeftdhqQ8s())) {
            if ((rect2.getRight() > rect.getRight() || rect2.getLeft() >= rect.getRight()) && rect2.getLeft() > rect.getLeft()) {
                return true;
            }
        } else if (FocusDirection.m1303equalsimpl0(i10, companion.m1315getRightdhqQ8s())) {
            if ((rect2.getLeft() < rect.getLeft() || rect2.getRight() <= rect.getLeft()) && rect2.getRight() < rect.getRight()) {
                return true;
            }
        } else if (FocusDirection.m1303equalsimpl0(i10, companion.m1316getUpdhqQ8s())) {
            if ((rect2.getBottom() > rect.getBottom() || rect2.getTop() >= rect.getBottom()) && rect2.getTop() > rect.getTop()) {
                return true;
            }
        } else {
            if (!FocusDirection.m1303equalsimpl0(i10, companion.m1309getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            if ((rect2.getTop() < rect.getTop() || rect2.getBottom() <= rect.getTop()) && rect2.getBottom() < rect.getBottom()) {
                return true;
            }
        }
        return false;
    }

    private static final float isBetterCandidate_I7lrPNg$majorAxisDistance(Rect rect, int i10, Rect rect2) {
        float top;
        float bottom;
        float top2;
        float bottom2;
        float f10;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (!FocusDirection.m1303equalsimpl0(i10, companion.m1311getLeftdhqQ8s())) {
            if (FocusDirection.m1303equalsimpl0(i10, companion.m1315getRightdhqQ8s())) {
                top = rect.getLeft();
                bottom = rect2.getRight();
            } else if (FocusDirection.m1303equalsimpl0(i10, companion.m1316getUpdhqQ8s())) {
                top2 = rect2.getTop();
                bottom2 = rect.getBottom();
            } else {
                if (!FocusDirection.m1303equalsimpl0(i10, companion.m1309getDowndhqQ8s())) {
                    throw new IllegalStateException(InvalidFocusDirection.toString());
                }
                top = rect.getTop();
                bottom = rect2.getBottom();
            }
            f10 = top - bottom;
            return Math.max(0.0f, f10);
        }
        top2 = rect2.getLeft();
        bottom2 = rect.getRight();
        f10 = top2 - bottom2;
        return Math.max(0.0f, f10);
    }

    private static final float isBetterCandidate_I7lrPNg$minorAxisDistance(Rect rect, int i10, Rect rect2) {
        float f10;
        float left;
        float left2;
        float width;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m1303equalsimpl0(i10, companion.m1311getLeftdhqQ8s()) ? true : FocusDirection.m1303equalsimpl0(i10, companion.m1315getRightdhqQ8s())) {
            f10 = 2;
            left = rect2.getTop() + (rect2.getHeight() / f10);
            left2 = rect.getTop();
            width = rect.getHeight();
        } else {
            if (!(FocusDirection.m1303equalsimpl0(i10, companion.m1316getUpdhqQ8s()) ? true : FocusDirection.m1303equalsimpl0(i10, companion.m1309getDowndhqQ8s()))) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            f10 = 2;
            left = rect2.getLeft() + (rect2.getWidth() / f10);
            left2 = rect.getLeft();
            width = rect.getWidth();
        }
        return left - (left2 + (width / f10));
    }

    private static final long isBetterCandidate_I7lrPNg$weightedDistance(int i10, Rect rect, Rect rect2) {
        long jAbs = (long) Math.abs(isBetterCandidate_I7lrPNg$majorAxisDistance(rect2, i10, rect));
        long jAbs2 = (long) Math.abs(isBetterCandidate_I7lrPNg$minorAxisDistance(rect2, i10, rect));
        return (((long) 13) * jAbs * jAbs) + (jAbs2 * jAbs2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: searchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m1331searchChildren4C6V_qg(FocusModifier focusModifier, FocusModifier focusModifier2, int i10, l<? super FocusModifier, Boolean> lVar) {
        FocusModifier focusModifierM1328findBestCandidate4WY_MpI;
        MutableVector mutableVector = new MutableVector(new FocusModifier[focusModifier.getChildren().getSize()], 0);
        mutableVector.addAll(mutableVector.getSize(), focusModifier.getChildren());
        while (mutableVector.isNotEmpty() && (focusModifierM1328findBestCandidate4WY_MpI = m1328findBestCandidate4WY_MpI(mutableVector, FocusTraversalKt.focusRect(focusModifier2), i10)) != null) {
            if (!focusModifierM1328findBestCandidate4WY_MpI.getFocusState().isDeactivated()) {
                return lVar.invoke(focusModifierM1328findBestCandidate4WY_MpI).booleanValue();
            }
            if (m1329generateAndSearchChildren4C6V_qg(focusModifierM1328findBestCandidate4WY_MpI, focusModifier2, i10, lVar)) {
                return true;
            }
            mutableVector.remove(focusModifierM1328findBestCandidate4WY_MpI);
        }
        return false;
    }

    private static final Rect topLeft(Rect rect) {
        return new Rect(rect.getLeft(), rect.getTop(), rect.getLeft(), rect.getTop());
    }

    /* JADX INFO: renamed from: twoDimensionalFocusSearch--OM-vw8, reason: not valid java name */
    public static final boolean m1332twoDimensionalFocusSearchOMvw8(@NotNull FocusModifier twoDimensionalFocusSearch, int i10, @NotNull l<? super FocusModifier, Boolean> onFound) {
        Rect rectBottomRight;
        t.i(twoDimensionalFocusSearch, "$this$twoDimensionalFocusSearch");
        t.i(onFound, "onFound");
        FocusStateImpl focusState = twoDimensionalFocusSearch.getFocusState();
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        switch (iArr[focusState.ordinal()]) {
            case 1:
            case 2:
                FocusModifier focusedChild = twoDimensionalFocusSearch.getFocusedChild();
                if (focusedChild == null) {
                    throw new IllegalStateException(NoActiveChild.toString());
                }
                switch (iArr[focusedChild.getFocusState().ordinal()]) {
                    case 1:
                    case 2:
                        return m1332twoDimensionalFocusSearchOMvw8(focusedChild, i10, onFound) || m1329generateAndSearchChildren4C6V_qg(twoDimensionalFocusSearch, activeNode(focusedChild), i10, onFound);
                    case 3:
                    case 4:
                        return m1329generateAndSearchChildren4C6V_qg(twoDimensionalFocusSearch, focusedChild, i10, onFound);
                    case 5:
                    case 6:
                        throw new IllegalStateException(NoActiveChild.toString());
                    default:
                        throw new q();
                }
            case 3:
            case 4:
                MutableVector<FocusModifier> mutableVectorActivatedChildren = FocusTraversalKt.activatedChildren(twoDimensionalFocusSearch);
                if (mutableVectorActivatedChildren.getSize() <= 1) {
                    FocusModifier focusModifier = mutableVectorActivatedChildren.isEmpty() ? null : mutableVectorActivatedChildren.getContent()[0];
                    if (focusModifier != null) {
                        return onFound.invoke(focusModifier).booleanValue();
                    }
                    return false;
                }
                FocusDirection.Companion companion = FocusDirection.Companion;
                if (FocusDirection.m1303equalsimpl0(i10, companion.m1315getRightdhqQ8s()) ? true : FocusDirection.m1303equalsimpl0(i10, companion.m1309getDowndhqQ8s())) {
                    rectBottomRight = topLeft(FocusTraversalKt.focusRect(twoDimensionalFocusSearch));
                } else {
                    if (!(FocusDirection.m1303equalsimpl0(i10, companion.m1311getLeftdhqQ8s()) ? true : FocusDirection.m1303equalsimpl0(i10, companion.m1316getUpdhqQ8s()))) {
                        throw new IllegalStateException(InvalidFocusDirection.toString());
                    }
                    rectBottomRight = bottomRight(FocusTraversalKt.focusRect(twoDimensionalFocusSearch));
                }
                FocusModifier focusModifierM1328findBestCandidate4WY_MpI = m1328findBestCandidate4WY_MpI(mutableVectorActivatedChildren, rectBottomRight, i10);
                if (focusModifierM1328findBestCandidate4WY_MpI != null) {
                    return onFound.invoke(focusModifierM1328findBestCandidate4WY_MpI).booleanValue();
                }
                return false;
            case 5:
                return false;
            case 6:
                return onFound.invoke(twoDimensionalFocusSearch).booleanValue();
            default:
                throw new q();
        }
    }
}
