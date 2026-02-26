package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImageVector.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class VectorGroup extends VectorNode implements Iterable<VectorNode>, i9.a {

    @NotNull
    private final List<VectorNode> children;

    @NotNull
    private final List<PathNode> clipPathData;

    @NotNull
    private final String name;
    private final float pivotX;
    private final float pivotY;
    private final float rotation;
    private final float scaleX;
    private final float scaleY;
    private final float translationX;
    private final float translationY;

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.vector.VectorGroup$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: ImageVector.kt */
    public static final class AnonymousClass1 implements Iterator<VectorNode>, i9.a {

        @NotNull
        private final Iterator<VectorNode> it;

        AnonymousClass1(VectorGroup vectorGroup) {
            this.it = vectorGroup.children.iterator();
        }

        @NotNull
        public final Iterator<VectorNode> getIt() {
            return this.it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.it.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        @NotNull
        public VectorNode next() {
            return this.it.next();
        }
    }

    public VectorGroup() {
        this(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 1023, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VectorGroup)) {
            return false;
        }
        VectorGroup vectorGroup = (VectorGroup) obj;
        if (!t.d(this.name, vectorGroup.name)) {
            return false;
        }
        if (!(this.rotation == vectorGroup.rotation)) {
            return false;
        }
        if (!(this.pivotX == vectorGroup.pivotX)) {
            return false;
        }
        if (!(this.pivotY == vectorGroup.pivotY)) {
            return false;
        }
        if (!(this.scaleX == vectorGroup.scaleX)) {
            return false;
        }
        if (!(this.scaleY == vectorGroup.scaleY)) {
            return false;
        }
        if (this.translationX == vectorGroup.translationX) {
            return ((this.translationY > vectorGroup.translationY ? 1 : (this.translationY == vectorGroup.translationY ? 0 : -1)) == 0) && t.d(this.clipPathData, vectorGroup.clipPathData) && t.d(this.children, vectorGroup.children);
        }
        return false;
    }

    @NotNull
    public final VectorNode get(int i10) {
        return this.children.get(i10);
    }

    @NotNull
    public final List<PathNode> getClipPathData() {
        return this.clipPathData;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final float getPivotX() {
        return this.pivotX;
    }

    public final float getPivotY() {
        return this.pivotY;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final int getSize() {
        return this.children.size();
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public int hashCode() {
        return (((((((((((((((((this.name.hashCode() * 31) + Float.floatToIntBits(this.rotation)) * 31) + Float.floatToIntBits(this.pivotX)) * 31) + Float.floatToIntBits(this.pivotY)) * 31) + Float.floatToIntBits(this.scaleX)) * 31) + Float.floatToIntBits(this.scaleY)) * 31) + Float.floatToIntBits(this.translationX)) * 31) + Float.floatToIntBits(this.translationY)) * 31) + this.clipPathData.hashCode()) * 31) + this.children.hashCode();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<VectorNode> iterator() {
        return new AnonymousClass1(this);
    }

    public /* synthetic */ VectorGroup(String str, float f10, float f11, float f12, float f13, float f14, float f15, float f16, List list, List list2, int i10, k kVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? 0.0f : f10, (i10 & 4) != 0 ? 0.0f : f11, (i10 & 8) != 0 ? 0.0f : f12, (i10 & 16) != 0 ? 1.0f : f13, (i10 & 32) == 0 ? f14 : 1.0f, (i10 & 64) != 0 ? 0.0f : f15, (i10 & 128) == 0 ? f16 : 0.0f, (i10 & 256) != 0 ? VectorKt.getEmptyPath() : list, (i10 & 512) != 0 ? v.l() : list2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VectorGroup(@NotNull String name, float f10, float f11, float f12, float f13, float f14, float f15, float f16, @NotNull List<? extends PathNode> clipPathData, @NotNull List<? extends VectorNode> children) {
        super(null);
        t.i(name, "name");
        t.i(clipPathData, "clipPathData");
        t.i(children, "children");
        this.name = name;
        this.rotation = f10;
        this.pivotX = f11;
        this.pivotY = f12;
        this.scaleX = f13;
        this.scaleY = f14;
        this.translationX = f15;
        this.translationY = f16;
        this.clipPathData = clipPathData;
        this.children = children;
    }
}
