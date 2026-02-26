package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import java.util.List;
import kotlin.collections.c;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ImmutableList.kt */
/* JADX INFO: loaded from: classes.dex */
public interface ImmutableList<E> extends List<E>, ImmutableCollection<E>, i9.a {

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ImmutableList.kt */
    static final class SubList<E> extends c<E> implements ImmutableList<E> {
        private int _size;
        private final int fromIndex;

        @NotNull
        private final ImmutableList<E> source;
        private final int toIndex;

        /* JADX WARN: Multi-variable type inference failed */
        public SubList(@NotNull ImmutableList<? extends E> source, int i10, int i11) {
            t.i(source, "source");
            this.source = source;
            this.fromIndex = i10;
            this.toIndex = i11;
            ListImplementation.checkRangeIndexes$runtime_release(i10, i11, source.size());
            this._size = i11 - i10;
        }

        @Override // kotlin.collections.c, java.util.List
        public E get(int i10) {
            ListImplementation.checkElementIndex$runtime_release(i10, this._size);
            return this.source.get(this.fromIndex + i10);
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int getSize() {
            return this._size;
        }

        @Override // kotlin.collections.c, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList
        @NotNull
        public ImmutableList<E> subList(int i10, int i11) {
            ListImplementation.checkRangeIndexes$runtime_release(i10, i11, this._size);
            ImmutableList<E> immutableList = this.source;
            int i12 = this.fromIndex;
            return new SubList(immutableList, i10 + i12, i12 + i11);
        }
    }

    @Override // java.util.List
    @NotNull
    ImmutableList<E> subList(int i10, int i11);

    @Override // java.util.List
    /* bridge */ /* synthetic */ List subList(int i10, int i11);
}
