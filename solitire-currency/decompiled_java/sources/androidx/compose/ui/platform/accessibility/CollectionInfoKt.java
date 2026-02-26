package androidx.compose.ui.platform.accessibility;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.CollectionItemInfo;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import h9.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CollectionInfo.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CollectionInfoKt {

    /* JADX INFO: renamed from: androidx.compose.ui.platform.accessibility.CollectionInfoKt$toAccessibilityCollectionItemInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollectionInfo.kt */
    static final class AnonymousClass1 extends v implements a<Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    private static final boolean calculateIfHorizontallyStacked(List<SemanticsNode> list) {
        List listL;
        long jM1377unboximpl;
        if (list.size() < 2) {
            return true;
        }
        if (list.size() == 0 || list.size() == 1) {
            listL = kotlin.collections.v.l();
        } else {
            listL = new ArrayList();
            SemanticsNode semanticsNode = list.get(0);
            int iM = kotlin.collections.v.m(list);
            int i10 = 0;
            while (i10 < iM) {
                i10++;
                SemanticsNode semanticsNode2 = list.get(i10);
                SemanticsNode semanticsNode3 = semanticsNode2;
                SemanticsNode semanticsNode4 = semanticsNode;
                listL.add(Offset.m1356boximpl(OffsetKt.Offset(Math.abs(Offset.m1367getXimpl(semanticsNode4.getBoundsInRoot().m1397getCenterF1C5BW0()) - Offset.m1367getXimpl(semanticsNode3.getBoundsInRoot().m1397getCenterF1C5BW0())), Math.abs(Offset.m1368getYimpl(semanticsNode4.getBoundsInRoot().m1397getCenterF1C5BW0()) - Offset.m1368getYimpl(semanticsNode3.getBoundsInRoot().m1397getCenterF1C5BW0())))));
                semanticsNode = semanticsNode2;
            }
        }
        if (listL.size() == 1) {
            jM1377unboximpl = ((Offset) d0.i0(listL)).m1377unboximpl();
        } else {
            if (listL.isEmpty()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object objI0 = d0.i0(listL);
            int iM2 = kotlin.collections.v.m(listL);
            if (1 <= iM2) {
                int i11 = 1;
                while (true) {
                    objI0 = Offset.m1356boximpl(Offset.m1372plusMKHz9U(((Offset) objI0).m1377unboximpl(), ((Offset) listL.get(i11)).m1377unboximpl()));
                    if (i11 == iM2) {
                        break;
                    }
                    i11++;
                }
            }
            jM1377unboximpl = ((Offset) objI0).m1377unboximpl();
        }
        return Offset.m1358component2impl(jM1377unboximpl) < Offset.m1357component1impl(jM1377unboximpl);
    }

    public static final boolean hasCollectionInfo(@NotNull SemanticsNode semanticsNode) {
        t.i(semanticsNode, "<this>");
        SemanticsConfiguration config = semanticsNode.getConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        return (SemanticsConfigurationKt.getOrNull(config, semanticsProperties.getCollectionInfo()) == null && SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), semanticsProperties.getSelectableGroup()) == null) ? false : true;
    }

    private static final boolean isLazyCollection(CollectionInfo collectionInfo) {
        return collectionInfo.getRowCount() < 0 || collectionInfo.getColumnCount() < 0;
    }

    public static final void setCollectionInfo(@NotNull SemanticsNode node, @NotNull AccessibilityNodeInfoCompat info) {
        t.i(node, "node");
        t.i(info, "info");
        SemanticsConfiguration config = node.getConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        CollectionInfo collectionInfo = (CollectionInfo) SemanticsConfigurationKt.getOrNull(config, semanticsProperties.getCollectionInfo());
        if (collectionInfo != null) {
            info.setCollectionInfo(toAccessibilityCollectionInfo(collectionInfo));
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (SemanticsConfigurationKt.getOrNull(node.getConfig(), semanticsProperties.getSelectableGroup()) != null) {
            List<SemanticsNode> replacedChildren$ui_release = node.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            for (int i10 = 0; i10 < size; i10++) {
                SemanticsNode semanticsNode = replacedChildren$ui_release.get(i10);
                if (semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
                    arrayList.add(semanticsNode);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            boolean zCalculateIfHorizontallyStacked = calculateIfHorizontallyStacked(arrayList);
            info.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(zCalculateIfHorizontallyStacked ? 1 : arrayList.size(), zCalculateIfHorizontallyStacked ? arrayList.size() : 1, false, 0));
        }
    }

    public static final void setCollectionItemInfo(@NotNull SemanticsNode node, @NotNull AccessibilityNodeInfoCompat info) {
        t.i(node, "node");
        t.i(info, "info");
        SemanticsConfiguration config = node.getConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        CollectionItemInfo collectionItemInfo = (CollectionItemInfo) SemanticsConfigurationKt.getOrNull(config, semanticsProperties.getCollectionItemInfo());
        if (collectionItemInfo != null) {
            info.setCollectionItemInfo(toAccessibilityCollectionItemInfo(collectionItemInfo, node));
        }
        SemanticsNode parent = node.getParent();
        if (parent == null || SemanticsConfigurationKt.getOrNull(parent.getConfig(), semanticsProperties.getSelectableGroup()) == null) {
            return;
        }
        CollectionInfo collectionInfo = (CollectionInfo) SemanticsConfigurationKt.getOrNull(parent.getConfig(), semanticsProperties.getCollectionInfo());
        if ((collectionInfo == null || !isLazyCollection(collectionInfo)) && node.getConfig().contains(semanticsProperties.getSelected())) {
            ArrayList arrayList = new ArrayList();
            List<SemanticsNode> replacedChildren$ui_release = parent.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            for (int i10 = 0; i10 < size; i10++) {
                SemanticsNode semanticsNode = replacedChildren$ui_release.get(i10);
                if (semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
                    arrayList.add(semanticsNode);
                }
            }
            if (!arrayList.isEmpty()) {
                boolean zCalculateIfHorizontallyStacked = calculateIfHorizontallyStacked(arrayList);
                int size2 = arrayList.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    SemanticsNode semanticsNode2 = (SemanticsNode) arrayList.get(i11);
                    if (semanticsNode2.getId() == node.getId()) {
                        AccessibilityNodeInfoCompat.CollectionItemInfoCompat collectionItemInfoCompatObtain = AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(zCalculateIfHorizontallyStacked ? 0 : i11, 1, zCalculateIfHorizontallyStacked ? i11 : 0, 1, false, ((Boolean) semanticsNode2.getConfig().getOrElse(SemanticsProperties.INSTANCE.getSelected(), CollectionInfoKt$setCollectionItemInfo$2$itemInfo$1.INSTANCE)).booleanValue());
                        if (collectionItemInfoCompatObtain != null) {
                            info.setCollectionItemInfo(collectionItemInfoCompatObtain);
                        }
                    }
                }
            }
        }
    }

    private static final AccessibilityNodeInfoCompat.CollectionInfoCompat toAccessibilityCollectionInfo(CollectionInfo collectionInfo) {
        return AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(collectionInfo.getRowCount(), collectionInfo.getColumnCount(), false, 0);
    }

    private static final AccessibilityNodeInfoCompat.CollectionItemInfoCompat toAccessibilityCollectionItemInfo(CollectionItemInfo collectionItemInfo, SemanticsNode semanticsNode) {
        return AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(collectionItemInfo.getRowIndex(), collectionItemInfo.getRowSpan(), collectionItemInfo.getColumnIndex(), collectionItemInfo.getColumnSpan(), false, ((Boolean) semanticsNode.getConfig().getOrElse(SemanticsProperties.INSTANCE.getSelected(), AnonymousClass1.INSTANCE)).booleanValue());
    }
}
