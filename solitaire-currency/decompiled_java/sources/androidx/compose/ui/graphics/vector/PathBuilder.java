package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.vector.PathNode;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PathBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PathBuilder {

    @NotNull
    private final List<PathNode> nodes = new ArrayList();

    private final PathBuilder addNode(PathNode pathNode) {
        this.nodes.add(pathNode);
        return this;
    }

    @NotNull
    public final PathBuilder arcTo(float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14) {
        return addNode(new PathNode.ArcTo(f10, f11, f12, z10, z11, f13, f14));
    }

    @NotNull
    public final PathBuilder arcToRelative(float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14) {
        return addNode(new PathNode.RelativeArcTo(f10, f11, f12, z10, z11, f13, f14));
    }

    @NotNull
    public final PathBuilder close() {
        return addNode(PathNode.Close.INSTANCE);
    }

    @NotNull
    public final PathBuilder curveTo(float f10, float f11, float f12, float f13, float f14, float f15) {
        return addNode(new PathNode.CurveTo(f10, f11, f12, f13, f14, f15));
    }

    @NotNull
    public final PathBuilder curveToRelative(float f10, float f11, float f12, float f13, float f14, float f15) {
        return addNode(new PathNode.RelativeCurveTo(f10, f11, f12, f13, f14, f15));
    }

    @NotNull
    public final List<PathNode> getNodes() {
        return this.nodes;
    }

    @NotNull
    public final PathBuilder horizontalLineTo(float f10) {
        return addNode(new PathNode.HorizontalTo(f10));
    }

    @NotNull
    public final PathBuilder horizontalLineToRelative(float f10) {
        return addNode(new PathNode.RelativeHorizontalTo(f10));
    }

    @NotNull
    public final PathBuilder lineTo(float f10, float f11) {
        return addNode(new PathNode.LineTo(f10, f11));
    }

    @NotNull
    public final PathBuilder lineToRelative(float f10, float f11) {
        return addNode(new PathNode.RelativeLineTo(f10, f11));
    }

    @NotNull
    public final PathBuilder moveTo(float f10, float f11) {
        return addNode(new PathNode.MoveTo(f10, f11));
    }

    @NotNull
    public final PathBuilder moveToRelative(float f10, float f11) {
        return addNode(new PathNode.RelativeMoveTo(f10, f11));
    }

    @NotNull
    public final PathBuilder quadTo(float f10, float f11, float f12, float f13) {
        return addNode(new PathNode.QuadTo(f10, f11, f12, f13));
    }

    @NotNull
    public final PathBuilder quadToRelative(float f10, float f11, float f12, float f13) {
        return addNode(new PathNode.RelativeQuadTo(f10, f11, f12, f13));
    }

    @NotNull
    public final PathBuilder reflectiveCurveTo(float f10, float f11, float f12, float f13) {
        return addNode(new PathNode.ReflectiveCurveTo(f10, f11, f12, f13));
    }

    @NotNull
    public final PathBuilder reflectiveCurveToRelative(float f10, float f11, float f12, float f13) {
        return addNode(new PathNode.RelativeReflectiveCurveTo(f10, f11, f12, f13));
    }

    @NotNull
    public final PathBuilder reflectiveQuadTo(float f10, float f11) {
        return addNode(new PathNode.ReflectiveQuadTo(f10, f11));
    }

    @NotNull
    public final PathBuilder reflectiveQuadToRelative(float f10, float f11) {
        return addNode(new PathNode.RelativeReflectiveQuadTo(f10, f11));
    }

    @NotNull
    public final PathBuilder verticalLineTo(float f10) {
        return addNode(new PathNode.VerticalTo(f10));
    }

    @NotNull
    public final PathBuilder verticalLineToRelative(float f10) {
        return addNode(new PathNode.RelativeVerticalTo(f10));
    }
}
