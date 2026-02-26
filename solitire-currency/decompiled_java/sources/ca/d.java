package ca;

import kotlin.jvm.internal.t;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.j;

/* JADX INFO: compiled from: Encoding.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface d {

    /* JADX INFO: compiled from: Encoding.kt */
    public static final class a {
        public static boolean a(@NotNull d dVar, @NotNull SerialDescriptor descriptor, int i10) {
            t.i(descriptor, "descriptor");
            return true;
        }
    }

    void C(@NotNull SerialDescriptor serialDescriptor, int i10, short s10);

    void D(@NotNull SerialDescriptor serialDescriptor, int i10, double d10);

    void F(@NotNull SerialDescriptor serialDescriptor, int i10, long j10);

    void c(@NotNull SerialDescriptor serialDescriptor);

    @NotNull
    Encoder e(@NotNull SerialDescriptor serialDescriptor, int i10);

    <T> void h(@NotNull SerialDescriptor serialDescriptor, int i10, @NotNull j<? super T> jVar, @Nullable T t10);

    <T> void j(@NotNull SerialDescriptor serialDescriptor, int i10, @NotNull j<? super T> jVar, T t10);

    void n(@NotNull SerialDescriptor serialDescriptor, int i10, char c10);

    void p(@NotNull SerialDescriptor serialDescriptor, int i10, byte b10);

    void s(@NotNull SerialDescriptor serialDescriptor, int i10, float f10);

    void w(@NotNull SerialDescriptor serialDescriptor, int i10, int i11);

    void x(@NotNull SerialDescriptor serialDescriptor, int i10, boolean z10);

    void y(@NotNull SerialDescriptor serialDescriptor, int i10, @NotNull String str);

    boolean z(@NotNull SerialDescriptor serialDescriptor, int i10);
}
