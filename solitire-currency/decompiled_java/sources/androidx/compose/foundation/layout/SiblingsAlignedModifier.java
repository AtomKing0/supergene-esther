package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.AlignmentLineProvider;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: RowColumnImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class SiblingsAlignedModifier extends InspectorValueInfo implements ParentDataModifier {

    /* JADX INFO: compiled from: RowColumnImpl.kt */
    public static final class WithAlignmentLine extends SiblingsAlignedModifier {

        @NotNull
        private final AlignmentLine alignmentLine;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WithAlignmentLine(@NotNull AlignmentLine alignmentLine, @NotNull h9.l<? super InspectorInfo, k0> inspectorInfo) {
            super(inspectorInfo, null);
            t.i(alignmentLine, "alignmentLine");
            t.i(inspectorInfo, "inspectorInfo");
            this.alignmentLine = alignmentLine;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            WithAlignmentLine withAlignmentLine = obj instanceof WithAlignmentLine ? (WithAlignmentLine) obj : null;
            if (withAlignmentLine == null) {
                return false;
            }
            return t.d(this.alignmentLine, withAlignmentLine.alignmentLine);
        }

        @NotNull
        public final AlignmentLine getAlignmentLine() {
            return this.alignmentLine;
        }

        public int hashCode() {
            return this.alignmentLine.hashCode();
        }

        @Override // androidx.compose.foundation.layout.SiblingsAlignedModifier, androidx.compose.ui.layout.ParentDataModifier
        @NotNull
        public Object modifyParentData(@NotNull Density density, @Nullable Object obj) {
            t.i(density, "<this>");
            RowColumnParentData rowColumnParentData = obj instanceof RowColumnParentData ? (RowColumnParentData) obj : null;
            if (rowColumnParentData == null) {
                rowColumnParentData = new RowColumnParentData(0.0f, false, null, 7, null);
            }
            rowColumnParentData.setCrossAxisAlignment(CrossAxisAlignment.Companion.Relative$foundation_layout_release(new AlignmentLineProvider.Value(this.alignmentLine)));
            return rowColumnParentData;
        }

        @NotNull
        public String toString() {
            return "WithAlignmentLine(line=" + this.alignmentLine + ')';
        }
    }

    /* JADX INFO: compiled from: RowColumnImpl.kt */
    public static final class WithAlignmentLineBlock extends SiblingsAlignedModifier {

        @NotNull
        private final h9.l<Measured, Integer> block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public WithAlignmentLineBlock(@NotNull h9.l<? super Measured, Integer> block, @NotNull h9.l<? super InspectorInfo, k0> inspectorInfo) {
            super(inspectorInfo, null);
            t.i(block, "block");
            t.i(inspectorInfo, "inspectorInfo");
            this.block = block;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            WithAlignmentLineBlock withAlignmentLineBlock = obj instanceof WithAlignmentLineBlock ? (WithAlignmentLineBlock) obj : null;
            if (withAlignmentLineBlock == null) {
                return false;
            }
            return t.d(this.block, withAlignmentLineBlock.block);
        }

        @NotNull
        public final h9.l<Measured, Integer> getBlock() {
            return this.block;
        }

        public int hashCode() {
            return this.block.hashCode();
        }

        @Override // androidx.compose.foundation.layout.SiblingsAlignedModifier, androidx.compose.ui.layout.ParentDataModifier
        @NotNull
        public Object modifyParentData(@NotNull Density density, @Nullable Object obj) {
            t.i(density, "<this>");
            RowColumnParentData rowColumnParentData = obj instanceof RowColumnParentData ? (RowColumnParentData) obj : null;
            if (rowColumnParentData == null) {
                rowColumnParentData = new RowColumnParentData(0.0f, false, null, 7, null);
            }
            rowColumnParentData.setCrossAxisAlignment(CrossAxisAlignment.Companion.Relative$foundation_layout_release(new AlignmentLineProvider.Block(this.block)));
            return rowColumnParentData;
        }

        @NotNull
        public String toString() {
            return "WithAlignmentLineBlock(block=" + this.block + ')';
        }
    }

    public /* synthetic */ SiblingsAlignedModifier(h9.l lVar, kotlin.jvm.internal.k kVar) {
        this(lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(h9.l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(h9.l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    @Override // androidx.compose.ui.layout.ParentDataModifier
    @Nullable
    public abstract Object modifyParentData(@NotNull Density density, @Nullable Object obj);

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }

    private SiblingsAlignedModifier(h9.l<? super InspectorInfo, k0> lVar) {
        super(lVar);
    }
}
