package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.l;
import v8.n;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
final class Pending {
    private int groupIndex;

    @NotNull
    private final HashMap<Integer, GroupInfo> groupInfos;

    @NotNull
    private final List<KeyInfo> keyInfos;

    @NotNull
    private final l keyMap$delegate;
    private final int startIndex;

    @NotNull
    private final List<KeyInfo> usedKeys;

    public Pending(@NotNull List<KeyInfo> keyInfos, int i10) {
        t.i(keyInfos, "keyInfos");
        this.keyInfos = keyInfos;
        this.startIndex = i10;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException("Invalid start index".toString());
        }
        this.usedKeys = new ArrayList();
        HashMap<Integer, GroupInfo> map = new HashMap<>();
        int size = keyInfos.size();
        int nodes = 0;
        for (int i11 = 0; i11 < size; i11++) {
            KeyInfo keyInfo = this.keyInfos.get(i11);
            map.put(Integer.valueOf(keyInfo.getLocation()), new GroupInfo(i11, nodes, keyInfo.getNodes()));
            nodes += keyInfo.getNodes();
        }
        this.groupInfos = map;
        this.keyMap$delegate = n.a(new Pending$keyMap$2(this));
    }

    public final int getGroupIndex() {
        return this.groupIndex;
    }

    @NotNull
    public final List<KeyInfo> getKeyInfos() {
        return this.keyInfos;
    }

    @NotNull
    public final HashMap<Object, LinkedHashSet<KeyInfo>> getKeyMap() {
        return (HashMap) this.keyMap$delegate.getValue();
    }

    @Nullable
    public final KeyInfo getNext(int i10, @Nullable Object obj) {
        return (KeyInfo) ComposerKt.pop(getKeyMap(), obj != null ? new JoinedKey(Integer.valueOf(i10), obj) : Integer.valueOf(i10));
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    @NotNull
    public final List<KeyInfo> getUsed() {
        return this.usedKeys;
    }

    public final int nodePositionOf(@NotNull KeyInfo keyInfo) {
        t.i(keyInfo, "keyInfo");
        GroupInfo groupInfo = this.groupInfos.get(Integer.valueOf(keyInfo.getLocation()));
        if (groupInfo != null) {
            return groupInfo.getNodeIndex();
        }
        return -1;
    }

    public final boolean recordUsed(@NotNull KeyInfo keyInfo) {
        t.i(keyInfo, "keyInfo");
        return this.usedKeys.add(keyInfo);
    }

    public final void registerInsert(@NotNull KeyInfo keyInfo, int i10) {
        t.i(keyInfo, "keyInfo");
        this.groupInfos.put(Integer.valueOf(keyInfo.getLocation()), new GroupInfo(-1, i10, 0));
    }

    public final void registerMoveNode(int i10, int i11, int i12) {
        if (i10 > i11) {
            Collection<GroupInfo> collectionValues = this.groupInfos.values();
            t.h(collectionValues, "groupInfos.values");
            for (GroupInfo groupInfo : collectionValues) {
                int nodeIndex = groupInfo.getNodeIndex();
                if (i10 <= nodeIndex && nodeIndex < i10 + i12) {
                    groupInfo.setNodeIndex((nodeIndex - i10) + i11);
                } else if (i11 <= nodeIndex && nodeIndex < i10) {
                    groupInfo.setNodeIndex(nodeIndex + i12);
                }
            }
            return;
        }
        if (i11 > i10) {
            Collection<GroupInfo> collectionValues2 = this.groupInfos.values();
            t.h(collectionValues2, "groupInfos.values");
            for (GroupInfo groupInfo2 : collectionValues2) {
                int nodeIndex2 = groupInfo2.getNodeIndex();
                if (i10 <= nodeIndex2 && nodeIndex2 < i10 + i12) {
                    groupInfo2.setNodeIndex((nodeIndex2 - i10) + i11);
                } else if (i10 + 1 <= nodeIndex2 && nodeIndex2 < i11) {
                    groupInfo2.setNodeIndex(nodeIndex2 - i12);
                }
            }
        }
    }

    public final void registerMoveSlot(int i10, int i11) {
        if (i10 > i11) {
            Collection<GroupInfo> collectionValues = this.groupInfos.values();
            t.h(collectionValues, "groupInfos.values");
            for (GroupInfo groupInfo : collectionValues) {
                int slotIndex = groupInfo.getSlotIndex();
                if (slotIndex == i10) {
                    groupInfo.setSlotIndex(i11);
                } else if (i11 <= slotIndex && slotIndex < i10) {
                    groupInfo.setSlotIndex(slotIndex + 1);
                }
            }
            return;
        }
        if (i11 > i10) {
            Collection<GroupInfo> collectionValues2 = this.groupInfos.values();
            t.h(collectionValues2, "groupInfos.values");
            for (GroupInfo groupInfo2 : collectionValues2) {
                int slotIndex2 = groupInfo2.getSlotIndex();
                if (slotIndex2 == i10) {
                    groupInfo2.setSlotIndex(i11);
                } else if (i10 + 1 <= slotIndex2 && slotIndex2 < i11) {
                    groupInfo2.setSlotIndex(slotIndex2 - 1);
                }
            }
        }
    }

    public final void setGroupIndex(int i10) {
        this.groupIndex = i10;
    }

    public final int slotPositionOf(@NotNull KeyInfo keyInfo) {
        t.i(keyInfo, "keyInfo");
        GroupInfo groupInfo = this.groupInfos.get(Integer.valueOf(keyInfo.getLocation()));
        if (groupInfo != null) {
            return groupInfo.getSlotIndex();
        }
        return -1;
    }

    public final boolean updateNodeCount(int i10, int i11) {
        int nodeIndex;
        GroupInfo groupInfo = this.groupInfos.get(Integer.valueOf(i10));
        if (groupInfo == null) {
            return false;
        }
        int nodeIndex2 = groupInfo.getNodeIndex();
        int nodeCount = i11 - groupInfo.getNodeCount();
        groupInfo.setNodeCount(i11);
        if (nodeCount == 0) {
            return true;
        }
        Collection<GroupInfo> collectionValues = this.groupInfos.values();
        t.h(collectionValues, "groupInfos.values");
        for (GroupInfo groupInfo2 : collectionValues) {
            if (groupInfo2.getNodeIndex() >= nodeIndex2 && !t.d(groupInfo2, groupInfo) && (nodeIndex = groupInfo2.getNodeIndex() + nodeCount) >= 0) {
                groupInfo2.setNodeIndex(nodeIndex);
            }
        }
        return true;
    }

    public final int updatedNodeCountOf(@NotNull KeyInfo keyInfo) {
        t.i(keyInfo, "keyInfo");
        GroupInfo groupInfo = this.groupInfos.get(Integer.valueOf(keyInfo.getLocation()));
        return groupInfo != null ? groupInfo.getNodeCount() : keyInfo.getNodes();
    }
}
