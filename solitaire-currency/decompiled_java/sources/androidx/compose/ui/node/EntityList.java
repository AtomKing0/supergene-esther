package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.semantics.SemanticsEntity;
import androidx.compose.ui.semantics.SemanticsModifier;
import h9.l;
import java.util.Arrays;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: EntityList.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EntityList {
    private static final int TypeCount = 6;

    @NotNull
    private final LayoutNodeEntity<?, ?>[] entities;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int DrawEntityType = EntityType.m3088constructorimpl(0);
    private static final int PointerInputEntityType = EntityType.m3088constructorimpl(1);
    private static final int SemanticsEntityType = EntityType.m3088constructorimpl(2);
    private static final int ParentDataEntityType = EntityType.m3088constructorimpl(3);
    private static final int OnPlacedEntityType = EntityType.m3088constructorimpl(4);
    private static final int RemeasureEntityType = EntityType.m3088constructorimpl(5);

    private /* synthetic */ EntityList(LayoutNodeEntity[] layoutNodeEntityArr) {
        this.entities = layoutNodeEntityArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: add-impl, reason: not valid java name */
    private static final <T extends LayoutNodeEntity<T, ?>> void m3063addimpl(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, T t10, int i10) {
        t10.setNext(layoutNodeEntityArr[i10]);
        layoutNodeEntityArr[i10] = t10;
    }

    /* JADX INFO: renamed from: addAfterLayoutModifier-impl, reason: not valid java name */
    public static final void m3064addAfterLayoutModifierimpl(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, @NotNull LayoutNodeWrapper layoutNodeWrapper, @NotNull Modifier modifier) {
        t.i(layoutNodeWrapper, "layoutNodeWrapper");
        t.i(modifier, "modifier");
        if (modifier instanceof OnPlacedModifier) {
            m3063addimpl(layoutNodeEntityArr, new SimpleEntity(layoutNodeWrapper, modifier), OnPlacedEntityType);
        }
        if (modifier instanceof OnRemeasuredModifier) {
            m3063addimpl(layoutNodeEntityArr, new SimpleEntity(layoutNodeWrapper, modifier), RemeasureEntityType);
        }
    }

    /* JADX INFO: renamed from: addBeforeLayoutModifier-impl, reason: not valid java name */
    public static final void m3065addBeforeLayoutModifierimpl(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, @NotNull LayoutNodeWrapper layoutNodeWrapper, @NotNull Modifier modifier) {
        t.i(layoutNodeWrapper, "layoutNodeWrapper");
        t.i(modifier, "modifier");
        if (modifier instanceof DrawModifier) {
            m3063addimpl(layoutNodeEntityArr, new DrawEntity(layoutNodeWrapper, (DrawModifier) modifier), DrawEntityType);
        }
        if (modifier instanceof PointerInputModifier) {
            m3063addimpl(layoutNodeEntityArr, new PointerInputEntity(layoutNodeWrapper, (PointerInputModifier) modifier), PointerInputEntityType);
        }
        if (modifier instanceof SemanticsModifier) {
            m3063addimpl(layoutNodeEntityArr, new SemanticsEntity(layoutNodeWrapper, (SemanticsModifier) modifier), SemanticsEntityType);
        }
        if (modifier instanceof ParentDataModifier) {
            m3063addimpl(layoutNodeEntityArr, new SimpleEntity(layoutNodeWrapper, modifier), ParentDataEntityType);
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ EntityList m3066boximpl(LayoutNodeEntity[] layoutNodeEntityArr) {
        return new EntityList(layoutNodeEntityArr);
    }

    /* JADX INFO: renamed from: clear-impl, reason: not valid java name */
    public static final void m3067clearimpl(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr) {
        for (LayoutNodeEntity<?, ?> next : layoutNodeEntityArr) {
            for (; next != null; next = next.getNext()) {
                if (next.isAttached()) {
                    next.onDetach();
                }
            }
        }
        int length = layoutNodeEntityArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            layoutNodeEntityArr[i10] = null;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static LayoutNodeEntity<?, ?>[] m3068constructorimpl(@NotNull LayoutNodeEntity<?, ?>[] entities) {
        t.i(entities, "entities");
        return entities;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ LayoutNodeEntity[] m3069constructorimpl$default(LayoutNodeEntity[] layoutNodeEntityArr, int i10, k kVar) {
        if ((i10 & 1) != 0) {
            layoutNodeEntityArr = new LayoutNodeEntity[6];
        }
        return m3068constructorimpl(layoutNodeEntityArr);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3070equalsimpl(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, Object obj) {
        return (obj instanceof EntityList) && t.d(layoutNodeEntityArr, ((EntityList) obj).m3079unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3071equalsimpl0(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, LayoutNodeEntity<?, ?>[] layoutNodeEntityArr2) {
        return t.d(layoutNodeEntityArr, layoutNodeEntityArr2);
    }

    /* JADX INFO: renamed from: forEach-9r0pUL4, reason: not valid java name */
    public static final <T extends LayoutNodeEntity<T, M>, M extends Modifier> void m3072forEach9r0pUL4(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, int i10, @NotNull l<? super T, k0> block) {
        t.i(block, "block");
        for (LayoutNodeEntity<?, ?> next = layoutNodeEntityArr[i10]; next != null; next = next.getNext()) {
            block.invoke(next);
        }
    }

    /* JADX INFO: renamed from: forEach-impl, reason: not valid java name */
    private static final <T extends LayoutNodeEntity<T, M>, M extends Modifier> void m3073forEachimpl(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, LayoutNodeEntity<?, ?> layoutNodeEntity, l<? super T, k0> lVar) {
        while (layoutNodeEntity != null) {
            lVar.invoke(layoutNodeEntity);
            layoutNodeEntity = layoutNodeEntity.getNext();
        }
    }

    /* JADX INFO: renamed from: has-0OSVbXo, reason: not valid java name */
    public static final boolean m3075has0OSVbXo(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, int i10) {
        return layoutNodeEntityArr[i10] != null;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3076hashCodeimpl(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr) {
        return Arrays.hashCode(layoutNodeEntityArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    /* JADX INFO: renamed from: head-0OSVbXo, reason: not valid java name */
    public static final <T extends LayoutNodeEntity<T, M>, M extends Modifier> T m3077head0OSVbXo(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, int i10) {
        return (T) layoutNodeEntityArr[i10];
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3078toStringimpl(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr) {
        return "EntityList(entities=" + Arrays.toString(layoutNodeEntityArr) + ')';
    }

    public boolean equals(Object obj) {
        return m3070equalsimpl(this.entities, obj);
    }

    @NotNull
    public final LayoutNodeEntity<?, ?>[] getEntities() {
        return this.entities;
    }

    public int hashCode() {
        return m3076hashCodeimpl(this.entities);
    }

    public String toString() {
        return m3078toStringimpl(this.entities);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ LayoutNodeEntity[] m3079unboximpl() {
        return this.entities;
    }

    /* JADX INFO: renamed from: forEach-impl, reason: not valid java name */
    public static final void m3074forEachimpl(LayoutNodeEntity<?, ?>[] layoutNodeEntityArr, @NotNull l<? super LayoutNodeEntity<?, ?>, k0> block) {
        t.i(block, "block");
        for (LayoutNodeEntity<?, ?> next : layoutNodeEntityArr) {
            for (; next != null; next = next.getNext()) {
                block.invoke(next);
            }
        }
    }

    /* JADX INFO: compiled from: EntityList.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getDrawEntityType-EEbPh1w, reason: not valid java name */
        public final int m3081getDrawEntityTypeEEbPh1w() {
            return EntityList.DrawEntityType;
        }

        /* JADX INFO: renamed from: getOnPlacedEntityType-EEbPh1w, reason: not valid java name */
        public final int m3082getOnPlacedEntityTypeEEbPh1w() {
            return EntityList.OnPlacedEntityType;
        }

        /* JADX INFO: renamed from: getParentDataEntityType-EEbPh1w, reason: not valid java name */
        public final int m3083getParentDataEntityTypeEEbPh1w() {
            return EntityList.ParentDataEntityType;
        }

        /* JADX INFO: renamed from: getPointerInputEntityType-EEbPh1w, reason: not valid java name */
        public final int m3084getPointerInputEntityTypeEEbPh1w() {
            return EntityList.PointerInputEntityType;
        }

        /* JADX INFO: renamed from: getRemeasureEntityType-EEbPh1w, reason: not valid java name */
        public final int m3085getRemeasureEntityTypeEEbPh1w() {
            return EntityList.RemeasureEntityType;
        }

        /* JADX INFO: renamed from: getSemanticsEntityType-EEbPh1w, reason: not valid java name */
        public final int m3086getSemanticsEntityTypeEEbPh1w() {
            return EntityList.SemanticsEntityType;
        }

        /* JADX INFO: renamed from: getOnPlacedEntityType-EEbPh1w$annotations, reason: not valid java name */
        public static /* synthetic */ void m3080getOnPlacedEntityTypeEEbPh1w$annotations() {
        }
    }

    /* JADX INFO: compiled from: EntityList.kt */
    public static final class EntityType<T extends LayoutNodeEntity<T, M>, M extends Modifier> {
        private final int index;

        private /* synthetic */ EntityType(int i10) {
            this.index = i10;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ EntityType m3087boximpl(int i10) {
            return new EntityType(i10);
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m3089equalsimpl(int i10, Object obj) {
            return (obj instanceof EntityType) && i10 == ((EntityType) obj).m3093unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m3090equalsimpl0(int i10, int i11) {
            return i10 == i11;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m3092toStringimpl(int i10) {
            return "EntityType(index=" + i10 + ')';
        }

        public boolean equals(Object obj) {
            return m3089equalsimpl(this.index, obj);
        }

        public final int getIndex() {
            return this.index;
        }

        public int hashCode() {
            return m3091hashCodeimpl(this.index);
        }

        public String toString() {
            return m3092toStringimpl(this.index);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m3093unboximpl() {
            return this.index;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static <T extends LayoutNodeEntity<T, M>, M extends Modifier> int m3088constructorimpl(int i10) {
            return i10;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m3091hashCodeimpl(int i10) {
            return i10;
        }
    }
}
