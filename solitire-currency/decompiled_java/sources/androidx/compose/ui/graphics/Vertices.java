package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Vertices.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Vertices {

    @NotNull
    private final int[] colors;

    @NotNull
    private final short[] indices;

    @NotNull
    private final float[] positions;

    @NotNull
    private final float[] textureCoordinates;
    private final int vertexMode;

    public /* synthetic */ Vertices(int i10, List list, List list2, List list3, List list4, kotlin.jvm.internal.k kVar) {
        this(i10, list, list2, list3, list4);
    }

    private final int[] encodeColorList(List<Color> list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = ColorKt.m1653toArgb8_81llA(list.get(i10).m1608unboximpl());
        }
        return iArr;
    }

    private final float[] encodePointList(List<Offset> list) {
        int size = list.size() * 2;
        float[] fArr = new float[size];
        for (int i10 = 0; i10 < size; i10++) {
            long jM1377unboximpl = list.get(i10 / 2).m1377unboximpl();
            fArr[i10] = i10 % 2 == 0 ? Offset.m1367getXimpl(jM1377unboximpl) : Offset.m1368getYimpl(jM1377unboximpl);
        }
        return fArr;
    }

    @NotNull
    public final int[] getColors() {
        return this.colors;
    }

    @NotNull
    public final short[] getIndices() {
        return this.indices;
    }

    @NotNull
    public final float[] getPositions() {
        return this.positions;
    }

    @NotNull
    public final float[] getTextureCoordinates() {
        return this.textureCoordinates;
    }

    /* JADX INFO: renamed from: getVertexMode-c2xauaI, reason: not valid java name */
    public final int m1934getVertexModec2xauaI() {
        return this.vertexMode;
    }

    private Vertices(int i10, List<Offset> list, List<Offset> list2, List<Color> list3, List<Integer> list4) {
        boolean z10;
        this.vertexMode = i10;
        Vertices$outOfBounds$1 vertices$outOfBounds$1 = new Vertices$outOfBounds$1(list);
        if (list2.size() != list.size()) {
            throw new IllegalArgumentException("positions and textureCoordinates lengths must match.");
        }
        if (list3.size() != list.size()) {
            throw new IllegalArgumentException("positions and colors lengths must match.");
        }
        int size = list4.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                z10 = false;
                break;
            } else {
                if (vertices$outOfBounds$1.invoke(list4.get(i11)).booleanValue()) {
                    z10 = true;
                    break;
                }
                i11++;
            }
        }
        if (z10) {
            throw new IllegalArgumentException("indices values must be valid indices in the positions list.");
        }
        this.positions = encodePointList(list);
        this.textureCoordinates = encodePointList(list2);
        this.colors = encodeColorList(list3);
        int size2 = list4.size();
        short[] sArr = new short[size2];
        for (int i12 = 0; i12 < size2; i12++) {
            sArr[i12] = (short) list4.get(i12).intValue();
        }
        this.indices = sArr;
    }
}
