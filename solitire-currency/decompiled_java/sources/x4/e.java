package x4;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: CutCornerTreatment.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f36083a = -1.0f;

    @Override // x4.d
    public void a(@NonNull m mVar, float f10, float f11, float f12) {
        mVar.o(0.0f, f12 * f11, 180.0f, 180.0f - f10);
        double d10 = f12;
        double d11 = f11;
        mVar.m((float) (Math.sin(Math.toRadians(f10)) * d10 * d11), (float) (Math.sin(Math.toRadians(90.0f - f10)) * d10 * d11));
    }
}
