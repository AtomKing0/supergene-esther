package androidx.compose.foundation.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.layout.Placeable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RowColumnImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class AlignmentLineProvider {

    /* JADX INFO: compiled from: RowColumnImpl.kt */
    @StabilityInferred(parameters = 0)
    public static final class Block extends AlignmentLineProvider {
        public static final int $stable = 0;

        @NotNull
        private final h9.l<Measured, Integer> lineProviderBlock;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Block(@NotNull h9.l<? super Measured, Integer> lineProviderBlock) {
            super(null);
            t.i(lineProviderBlock, "lineProviderBlock");
            this.lineProviderBlock = lineProviderBlock;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Block copy$default(Block block, h9.l lVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                lVar = block.lineProviderBlock;
            }
            return block.copy(lVar);
        }

        @Override // androidx.compose.foundation.layout.AlignmentLineProvider
        public int calculateAlignmentLinePosition(@NotNull Placeable placeable) {
            t.i(placeable, "placeable");
            return this.lineProviderBlock.invoke(placeable).intValue();
        }

        @NotNull
        public final h9.l<Measured, Integer> component1() {
            return this.lineProviderBlock;
        }

        @NotNull
        public final Block copy(@NotNull h9.l<? super Measured, Integer> lineProviderBlock) {
            t.i(lineProviderBlock, "lineProviderBlock");
            return new Block(lineProviderBlock);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Block) && t.d(this.lineProviderBlock, ((Block) obj).lineProviderBlock);
        }

        @NotNull
        public final h9.l<Measured, Integer> getLineProviderBlock() {
            return this.lineProviderBlock;
        }

        public int hashCode() {
            return this.lineProviderBlock.hashCode();
        }

        @NotNull
        public String toString() {
            return "Block(lineProviderBlock=" + this.lineProviderBlock + ')';
        }
    }

    /* JADX INFO: compiled from: RowColumnImpl.kt */
    @StabilityInferred(parameters = 0)
    public static final class Value extends AlignmentLineProvider {
        public static final int $stable = 0;

        @NotNull
        private final AlignmentLine alignmentLine;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Value(@NotNull AlignmentLine alignmentLine) {
            super(null);
            t.i(alignmentLine, "alignmentLine");
            this.alignmentLine = alignmentLine;
        }

        public static /* synthetic */ Value copy$default(Value value, AlignmentLine alignmentLine, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                alignmentLine = value.alignmentLine;
            }
            return value.copy(alignmentLine);
        }

        @Override // androidx.compose.foundation.layout.AlignmentLineProvider
        public int calculateAlignmentLinePosition(@NotNull Placeable placeable) {
            t.i(placeable, "placeable");
            return placeable.get(this.alignmentLine);
        }

        @NotNull
        public final AlignmentLine component1() {
            return this.alignmentLine;
        }

        @NotNull
        public final Value copy(@NotNull AlignmentLine alignmentLine) {
            t.i(alignmentLine, "alignmentLine");
            return new Value(alignmentLine);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Value) && t.d(this.alignmentLine, ((Value) obj).alignmentLine);
        }

        @NotNull
        public final AlignmentLine getAlignmentLine() {
            return this.alignmentLine;
        }

        public int hashCode() {
            return this.alignmentLine.hashCode();
        }

        @NotNull
        public String toString() {
            return "Value(alignmentLine=" + this.alignmentLine + ')';
        }
    }

    private AlignmentLineProvider() {
    }

    public /* synthetic */ AlignmentLineProvider(kotlin.jvm.internal.k kVar) {
        this();
    }

    public abstract int calculateAlignmentLinePosition(@NotNull Placeable placeable);
}
