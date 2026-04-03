package androidx.compose.ui.graphics.vector;

import androidx.compose.foundation.e;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImageVector.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class ImageVector {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean autoMirror;
    private final float defaultHeight;
    private final float defaultWidth;

    @NotNull
    private final String name;

    @NotNull
    private final VectorGroup root;
    private final int tintBlendMode;
    private final long tintColor;
    private final float viewportHeight;
    private final float viewportWidth;

    /* JADX INFO: compiled from: ImageVector.kt */
    @StabilityInferred(parameters = 0)
    public static final class Builder {
        public static final int $stable = 8;
        private final boolean autoMirror;
        private final float defaultHeight;
        private final float defaultWidth;
        private boolean isConsumed;

        @NotNull
        private final String name;

        @NotNull
        private final ArrayList<GroupParams> nodes;

        @NotNull
        private GroupParams root;
        private final int tintBlendMode;
        private final long tintColor;
        private final float viewportHeight;
        private final float viewportWidth;

        /* JADX INFO: compiled from: ImageVector.kt */
        private static final class GroupParams {

            @NotNull
            private List<VectorNode> children;

            @NotNull
            private List<? extends PathNode> clipPathData;

            @NotNull
            private String name;
            private float pivotX;
            private float pivotY;
            private float rotate;
            private float scaleX;
            private float scaleY;
            private float translationX;
            private float translationY;

            public GroupParams() {
                this(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 1023, null);
            }

            @NotNull
            public final List<VectorNode> getChildren() {
                return this.children;
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

            public final float getRotate() {
                return this.rotate;
            }

            public final float getScaleX() {
                return this.scaleX;
            }

            public final float getScaleY() {
                return this.scaleY;
            }

            public final float getTranslationX() {
                return this.translationX;
            }

            public final float getTranslationY() {
                return this.translationY;
            }

            public final void setChildren(@NotNull List<VectorNode> list) {
                t.i(list, "<set-?>");
                this.children = list;
            }

            public final void setClipPathData(@NotNull List<? extends PathNode> list) {
                t.i(list, "<set-?>");
                this.clipPathData = list;
            }

            public final void setName(@NotNull String str) {
                t.i(str, "<set-?>");
                this.name = str;
            }

            public final void setPivotX(float f10) {
                this.pivotX = f10;
            }

            public final void setPivotY(float f10) {
                this.pivotY = f10;
            }

            public final void setRotate(float f10) {
                this.rotate = f10;
            }

            public final void setScaleX(float f10) {
                this.scaleX = f10;
            }

            public final void setScaleY(float f10) {
                this.scaleY = f10;
            }

            public final void setTranslationX(float f10) {
                this.translationX = f10;
            }

            public final void setTranslationY(float f10) {
                this.translationY = f10;
            }

            public GroupParams(@NotNull String name, float f10, float f11, float f12, float f13, float f14, float f15, float f16, @NotNull List<? extends PathNode> clipPathData, @NotNull List<VectorNode> children) {
                t.i(name, "name");
                t.i(clipPathData, "clipPathData");
                t.i(children, "children");
                this.name = name;
                this.rotate = f10;
                this.pivotX = f11;
                this.pivotY = f12;
                this.scaleX = f13;
                this.scaleY = f14;
                this.translationX = f15;
                this.translationY = f16;
                this.clipPathData = clipPathData;
                this.children = children;
            }

            public /* synthetic */ GroupParams(String str, float f10, float f11, float f12, float f13, float f14, float f15, float f16, List list, List list2, int i10, k kVar) {
                this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? 0.0f : f10, (i10 & 4) != 0 ? 0.0f : f11, (i10 & 8) != 0 ? 0.0f : f12, (i10 & 16) != 0 ? 1.0f : f13, (i10 & 32) == 0 ? f14 : 1.0f, (i10 & 64) != 0 ? 0.0f : f15, (i10 & 128) == 0 ? f16 : 0.0f, (i10 & 256) != 0 ? VectorKt.getEmptyPath() : list, (i10 & 512) != 0 ? new ArrayList() : list2);
            }
        }

        public /* synthetic */ Builder(String str, float f10, float f11, float f12, float f13, long j10, int i10, k kVar) {
            this(str, f10, f11, f12, f13, j10, i10);
        }

        private final VectorGroup asVectorGroup(GroupParams groupParams) {
            return new VectorGroup(groupParams.getName(), groupParams.getRotate(), groupParams.getPivotX(), groupParams.getPivotY(), groupParams.getScaleX(), groupParams.getScaleY(), groupParams.getTranslationX(), groupParams.getTranslationY(), groupParams.getClipPathData(), groupParams.getChildren());
        }

        private final void ensureNotConsumed() {
            if (!(!this.isConsumed)) {
                throw new IllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector".toString());
            }
        }

        private final GroupParams getCurrentGroup() {
            return (GroupParams) Stack.m2118peekimpl(this.nodes);
        }

        @NotNull
        public final Builder addGroup(@NotNull String name, float f10, float f11, float f12, float f13, float f14, float f15, float f16, @NotNull List<? extends PathNode> clipPathData) {
            t.i(name, "name");
            t.i(clipPathData, "clipPathData");
            ensureNotConsumed();
            Stack.m2120pushimpl(this.nodes, new GroupParams(name, f10, f11, f12, f13, f14, f15, f16, clipPathData, null, 512, null));
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: addPath-oIyEayM, reason: not valid java name */
        public final Builder m2102addPathoIyEayM(@NotNull List<? extends PathNode> pathData, int i10, @NotNull String name, @Nullable Brush brush, float f10, @Nullable Brush brush2, float f11, float f12, int i11, int i12, float f13, float f14, float f15, float f16) {
            t.i(pathData, "pathData");
            t.i(name, "name");
            ensureNotConsumed();
            getCurrentGroup().getChildren().add(new VectorPath(name, pathData, i10, brush, f10, brush2, f11, f12, i11, i12, f13, f14, f15, f16, null));
            return this;
        }

        @NotNull
        public final ImageVector build() {
            ensureNotConsumed();
            while (Stack.m2116getSizeimpl(this.nodes) > 1) {
                clearGroup();
            }
            ImageVector imageVector = new ImageVector(this.name, this.defaultWidth, this.defaultHeight, this.viewportWidth, this.viewportHeight, asVectorGroup(this.root), this.tintColor, this.tintBlendMode, this.autoMirror, null);
            this.isConsumed = true;
            return imageVector;
        }

        @NotNull
        public final Builder clearGroup() {
            ensureNotConsumed();
            getCurrentGroup().getChildren().add(asVectorGroup((GroupParams) Stack.m2119popimpl(this.nodes)));
            return this;
        }

        public /* synthetic */ Builder(String str, float f10, float f11, float f12, float f13, long j10, int i10, boolean z10, k kVar) {
            this(str, f10, f11, f12, f13, j10, i10, z10);
        }

        private Builder(String str, float f10, float f11, float f12, float f13, long j10, int i10, boolean z10) {
            this.name = str;
            this.defaultWidth = f10;
            this.defaultHeight = f11;
            this.viewportWidth = f12;
            this.viewportHeight = f13;
            this.tintColor = j10;
            this.tintBlendMode = i10;
            this.autoMirror = z10;
            ArrayList<GroupParams> arrayListM2113constructorimpl$default = Stack.m2113constructorimpl$default(null, 1, null);
            this.nodes = arrayListM2113constructorimpl$default;
            GroupParams groupParams = new GroupParams(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 1023, null);
            this.root = groupParams;
            Stack.m2120pushimpl(arrayListM2113constructorimpl$default, groupParams);
        }

        public /* synthetic */ Builder(String str, float f10, float f11, float f12, float f13, long j10, int i10, boolean z10, int i11, k kVar) {
            this((i11 & 1) != 0 ? "" : str, f10, f11, f12, f13, (i11 & 32) != 0 ? Color.Companion.m1634getUnspecified0d7_KjU() : j10, (i11 & 64) != 0 ? BlendMode.Companion.m1546getSrcIn0nO6VwU() : i10, (i11 & 128) != 0 ? false : z10, (k) null);
        }

        public /* synthetic */ Builder(String str, float f10, float f11, float f12, float f13, long j10, int i10, int i11, k kVar) {
            this((i11 & 1) != 0 ? "" : str, f10, f11, f12, f13, (i11 & 32) != 0 ? Color.Companion.m1634getUnspecified0d7_KjU() : j10, (i11 & 64) != 0 ? BlendMode.Companion.m1546getSrcIn0nO6VwU() : i10, (k) null);
        }

        private Builder(String str, float f10, float f11, float f12, float f13, long j10, int i10) {
            this(str, f10, f11, f12, f13, j10, i10, false, (k) null);
        }
    }

    /* JADX INFO: compiled from: ImageVector.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    public /* synthetic */ ImageVector(String str, float f10, float f11, float f12, float f13, VectorGroup vectorGroup, long j10, int i10, boolean z10, k kVar) {
        this(str, f10, f11, f12, f13, vectorGroup, j10, i10, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageVector)) {
            return false;
        }
        ImageVector imageVector = (ImageVector) obj;
        if (!t.d(this.name, imageVector.name) || !Dp.m3678equalsimpl0(this.defaultWidth, imageVector.defaultWidth) || !Dp.m3678equalsimpl0(this.defaultHeight, imageVector.defaultHeight)) {
            return false;
        }
        if (this.viewportWidth == imageVector.viewportWidth) {
            return ((this.viewportHeight > imageVector.viewportHeight ? 1 : (this.viewportHeight == imageVector.viewportHeight ? 0 : -1)) == 0) && t.d(this.root, imageVector.root) && Color.m1599equalsimpl0(this.tintColor, imageVector.tintColor) && BlendMode.m1517equalsimpl0(this.tintBlendMode, imageVector.tintBlendMode) && this.autoMirror == imageVector.autoMirror;
        }
        return false;
    }

    public final boolean getAutoMirror() {
        return this.autoMirror;
    }

    /* JADX INFO: renamed from: getDefaultHeight-D9Ej5fM, reason: not valid java name */
    public final float m2097getDefaultHeightD9Ej5fM() {
        return this.defaultHeight;
    }

    /* JADX INFO: renamed from: getDefaultWidth-D9Ej5fM, reason: not valid java name */
    public final float m2098getDefaultWidthD9Ej5fM() {
        return this.defaultWidth;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final VectorGroup getRoot() {
        return this.root;
    }

    /* JADX INFO: renamed from: getTintBlendMode-0nO6VwU, reason: not valid java name */
    public final int m2099getTintBlendMode0nO6VwU() {
        return this.tintBlendMode;
    }

    /* JADX INFO: renamed from: getTintColor-0d7_KjU, reason: not valid java name */
    public final long m2100getTintColor0d7_KjU() {
        return this.tintColor;
    }

    public final float getViewportHeight() {
        return this.viewportHeight;
    }

    public final float getViewportWidth() {
        return this.viewportWidth;
    }

    public int hashCode() {
        return (((((((((((((((this.name.hashCode() * 31) + Dp.m3679hashCodeimpl(this.defaultWidth)) * 31) + Dp.m3679hashCodeimpl(this.defaultHeight)) * 31) + Float.floatToIntBits(this.viewportWidth)) * 31) + Float.floatToIntBits(this.viewportHeight)) * 31) + this.root.hashCode()) * 31) + Color.m1605hashCodeimpl(this.tintColor)) * 31) + BlendMode.m1518hashCodeimpl(this.tintBlendMode)) * 31) + e.a(this.autoMirror);
    }

    private ImageVector(String str, float f10, float f11, float f12, float f13, VectorGroup vectorGroup, long j10, int i10, boolean z10) {
        this.name = str;
        this.defaultWidth = f10;
        this.defaultHeight = f11;
        this.viewportWidth = f12;
        this.viewportHeight = f13;
        this.root = vectorGroup;
        this.tintColor = j10;
        this.tintBlendMode = i10;
        this.autoMirror = z10;
    }
}
