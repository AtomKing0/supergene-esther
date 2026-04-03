package n8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MemoryJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final void a(@NotNull ByteBuffer copyTo, @NotNull ByteBuffer destination, int i10) {
        t.i(copyTo, "$this$copyTo");
        t.i(destination, "destination");
        int iRemaining = destination.remaining();
        if (copyTo.hasArray() && !copyTo.isReadOnly() && destination.hasArray() && !destination.isReadOnly()) {
            int iPosition = destination.position();
            System.arraycopy(copyTo.array(), copyTo.arrayOffset() + i10, destination.array(), destination.arrayOffset() + iPosition, iRemaining);
            destination.position(iPosition + iRemaining);
        } else {
            ByteBuffer byteBufferDuplicate = copyTo.duplicate();
            byteBufferDuplicate.limit(iRemaining + i10);
            byteBufferDuplicate.position(i10);
            destination.put(byteBufferDuplicate);
        }
    }

    public static final void b(@NotNull ByteBuffer copyTo, @NotNull byte[] destination, int i10, int i11, int i12) {
        t.i(copyTo, "$this$copyTo");
        t.i(destination, "destination");
        if (!copyTo.hasArray() || copyTo.isReadOnly()) {
            copyTo.duplicate().get(destination, i12, i11);
        } else {
            System.arraycopy(copyTo.array(), copyTo.arrayOffset() + i10, destination, i12, i11);
        }
    }

    public static final void c(@NotNull ByteBuffer copyTo, @NotNull ByteBuffer destination, int i10) {
        t.i(copyTo, "$this$copyTo");
        t.i(destination, "destination");
        if (!copyTo.hasArray() || copyTo.isReadOnly()) {
            d(destination, i10, copyTo.remaining()).put(copyTo);
            return;
        }
        byte[] bArrArray = copyTo.array();
        t.h(bArrArray, "array()");
        int iArrayOffset = copyTo.arrayOffset() + copyTo.position();
        int iRemaining = copyTo.remaining();
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArrArray, iArrayOffset, iRemaining).slice().order(ByteOrder.BIG_ENDIAN);
        t.h(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        c.c(c.b(byteBufferOrder), destination, 0, iRemaining, i10);
        copyTo.position(copyTo.limit());
    }

    @NotNull
    public static final ByteBuffer d(@NotNull ByteBuffer byteBuffer, int i10, int i11) {
        t.i(byteBuffer, "<this>");
        ByteBuffer myDuplicate$lambda$1 = byteBuffer.duplicate();
        t.h(myDuplicate$lambda$1, "myDuplicate$lambda$1");
        myDuplicate$lambda$1.position(i10);
        myDuplicate$lambda$1.limit(i10 + i11);
        ByteBuffer mySlice$lambda$2 = myDuplicate$lambda$1.slice();
        t.h(mySlice$lambda$2, "mySlice$lambda$2");
        return mySlice$lambda$2;
    }
}
