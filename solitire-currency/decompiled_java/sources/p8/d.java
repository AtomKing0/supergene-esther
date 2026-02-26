package p8;

import java.io.EOFException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    @NotNull
    public static final Void a(int i10, int i11) {
        throw new EOFException("Unable to discard " + i10 + " bytes: only " + i11 + " available for writing");
    }

    @NotNull
    public static final Void b(int i10, int i11) {
        throw new EOFException("Unable to discard " + i10 + " bytes: only " + i11 + " available for reading");
    }

    public static final void c(@NotNull a aVar, int i10) {
        t.i(aVar, "<this>");
        throw new IllegalArgumentException("End gap " + i10 + " is too big: capacity is " + aVar.e());
    }

    public static final void d(@NotNull a aVar, int i10) {
        t.i(aVar, "<this>");
        throw new IllegalArgumentException("Unable to reserve end gap " + i10 + ": there are already " + (aVar.j() - aVar.h()) + " content bytes at offset " + aVar.h());
    }

    public static final void e(@NotNull a aVar, int i10) {
        t.i(aVar, "<this>");
        throw new IllegalArgumentException("End gap " + i10 + " is too big: there are already " + aVar.i() + " bytes reserved in the beginning");
    }

    public static final void f(@NotNull a aVar, int i10) {
        t.i(aVar, "<this>");
        aVar.n(aVar.h() - i10);
    }

    @NotNull
    public static final Void g(@NotNull a aVar, int i10) {
        t.i(aVar, "<this>");
        throw new IllegalStateException("Unable to reserve " + i10 + " start gap: there are already " + (aVar.j() - aVar.h()) + " content bytes starting at offset " + aVar.h());
    }

    @NotNull
    public static final Void h(@NotNull a aVar, int i10) {
        t.i(aVar, "<this>");
        if (i10 > aVar.e()) {
            throw new IllegalArgumentException("Start gap " + i10 + " is bigger than the capacity " + aVar.e());
        }
        throw new IllegalStateException("Unable to reserve " + i10 + " start gap: there are already " + (aVar.e() - aVar.f()) + " bytes reserved in the end");
    }
}
