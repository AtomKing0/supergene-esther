package androidx.compose.ui.graphics.colorspace;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ColorSpace.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class ColorSpace {

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int MaxId = 63;
    public static final int MinId = -1;
    private final int id;
    private final long model;

    @NotNull
    private final String name;

    /* JADX INFO: compiled from: ColorSpace.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    public /* synthetic */ ColorSpace(String str, long j10, int i10, k kVar) {
        this(str, j10, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.d(o0.b(getClass()), o0.b(obj.getClass()))) {
            return false;
        }
        ColorSpace colorSpace = (ColorSpace) obj;
        if (this.id == colorSpace.id && t.d(this.name, colorSpace.name)) {
            return ColorModel.m1939equalsimpl0(this.model, colorSpace.model);
        }
        return false;
    }

    @NotNull
    public final float[] fromXyz(float f10, float f11, float f12) {
        float[] fArr = new float[ColorModel.m1940getComponentCountimpl(this.model)];
        fArr[0] = f10;
        fArr[1] = f11;
        fArr[2] = f12;
        return fromXyz(fArr);
    }

    @NotNull
    public abstract float[] fromXyz(@NotNull float[] fArr);

    public final int getComponentCount() {
        return ColorModel.m1940getComponentCountimpl(this.model);
    }

    public final int getId$ui_graphics_release() {
        return this.id;
    }

    public abstract float getMaxValue(int i10);

    public abstract float getMinValue(int i10);

    /* JADX INFO: renamed from: getModel-xdoWZVw, reason: not valid java name */
    public final long m1948getModelxdoWZVw() {
        return this.model;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + ColorModel.m1941hashCodeimpl(this.model)) * 31) + this.id;
    }

    public boolean isSrgb() {
        return false;
    }

    public abstract boolean isWideGamut();

    @NotNull
    public String toString() {
        return this.name + " (id=" + this.id + ", model=" + ((Object) ColorModel.m1942toStringimpl(this.model)) + ')';
    }

    @NotNull
    public final float[] toXyz(float f10, float f11, float f12) {
        return toXyz(new float[]{f10, f11, f12});
    }

    @NotNull
    public abstract float[] toXyz(@NotNull float[] fArr);

    public /* synthetic */ ColorSpace(String str, long j10, k kVar) {
        this(str, j10);
    }

    private ColorSpace(String str, long j10, int i10) {
        this.name = str;
        this.model = j10;
        this.id = i10;
        if (str.length() == 0) {
            throw new IllegalArgumentException("The name of a color space cannot be null and must contain at least 1 character");
        }
        if (i10 < -1 || i10 > 63) {
            throw new IllegalArgumentException("The id must be between -1 and 63");
        }
    }

    private ColorSpace(String str, long j10) {
        this(str, j10, -1, null);
    }
}
